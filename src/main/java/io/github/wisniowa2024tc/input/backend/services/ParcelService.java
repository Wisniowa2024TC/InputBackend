package io.github.wisniowa2024tc.input.backend.services;

import io.github.wisniowa2024tc.input.backend.objects.AccessCode;
import io.github.wisniowa2024tc.input.backend.objects.Parcel;
import io.github.wisniowa2024tc.input.backend.objects.ParcelLocation;
import io.github.wisniowa2024tc.input.backend.objects.location.ParcelLocker;
import io.github.wisniowa2024tc.input.backend.objects.location.ParcelMachine;
import io.github.wisniowa2024tc.input.backend.repositories.*;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParcelService {
	@Autowired private ParcelRepo parcelRepo;
	@Autowired private AccessCodeRepo accessCodeRepo;
	@Autowired private ParcelMachineRepo parcelMachineRepo;
	@Autowired private ParcelLockerRepo parcelLockerRepo;
	@Autowired private ParcelLocationRepo parcelLocationRepo;

	private final SecureRandom random = new SecureRandom();
	
	public Parcel createParcel(Optional<String> name, Optional<String> desc, Optional<Parcel.Type> type, UUID locationID) {
		return parcelRepo.save(new Parcel(
			name.orElse(null),
			desc.orElse(null),
			type.orElse(Parcel.Type.MACHINE_PICKUP),
			parcelLocationRepo.getReferenceById(locationID)
		));
	}

	public AccessCode requestAccessCode(UUID locker) {
		String code = String.format("%06d", random.nextInt(1000000));
		AccessCode accessCode = new AccessCode(code, Instant.now(), parcelLockerRepo.getReferenceById(locker));
		return accessCodeRepo.save(accessCode);
	}

	// Outer is empty -> Machine not found
	// Inner is empty -> Parcel not found / parcel not found in machine
	public Optional<Optional<ParcelLocker>> checkCode(String code, Optional<UUID> forMachine) {
        Optional<ParcelLocker> locker = accessCodeRepo.getByCode(code).map(AccessCode::getLocker);
		if (locker.isPresent() && forMachine.isPresent()) {
			Optional<ParcelMachine> machine = parcelMachineRepo.getParcelMachineByUuid(forMachine.get());
			if (machine.isEmpty()) return Optional.empty();
			if (locker.get().getMachine() != machine.get()) {
				return Optional.of(Optional.empty());
			}
		}
		return Optional.of(locker);
	}

	public void testSetup() {
		val machine = parcelMachineRepo.save(new ParcelMachine("Wiśniowa 69"));
		ArrayList<ParcelLocker> parcelLockers = new ArrayList<>(10);
		for (int i = 0; i < 10; i++)
			parcelLockers.add(parcelLockerRepo.save(new ParcelLocker(machine, "locker" + i)));
	}

	public Optional<Optional<Parcel>> getLockerContents(UUID lockerId) {
		val locker = parcelLockerRepo.getReferenceById(lockerId);
		return Optional.empty();
	}
}
