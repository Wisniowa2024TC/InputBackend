package io.github.wisniowa2024tc.input.backend.services;

import io.github.wisniowa2024tc.input.backend.objects.AccessCode;
import io.github.wisniowa2024tc.input.backend.objects.Parcel;
import io.github.wisniowa2024tc.input.backend.objects.location.ParcelLocker;
import io.github.wisniowa2024tc.input.backend.objects.location.ParcelMachine;
import io.github.wisniowa2024tc.input.backend.repositories.AccessCodeRepo;
import io.github.wisniowa2024tc.input.backend.repositories.ParcelLockerRepo;
import io.github.wisniowa2024tc.input.backend.repositories.ParcelMachineRepo;
import io.github.wisniowa2024tc.input.backend.repositories.ParcelRepo;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParcelService {
	@Autowired private ParcelRepo parcelRepo;
	@Autowired private AccessCodeRepo accessCodeRepo;
	@Autowired private ParcelMachineRepo parcelMachineRepo;
	@Autowired private ParcelLockerRepo parcelLockerRepo;

	private final SecureRandom random = new SecureRandom();
	
	public Parcel createParcel(Parcel parcel) {
		return parcelRepo.save(parcel);
	}

	public AccessCode requestAccessCode(UUID locker) {
		String code = String.format("%06d", random.nextInt(1000000));
		AccessCode accessCode = new AccessCode(code, Instant.now(), parcelLockerRepo.getReferenceById(locker));
		return accessCodeRepo.save(accessCode);
	}

	public Optional<ParcelLocker> checkCode(String code, Optional<UUID> forMachine) {
        Optional<ParcelLocker> locker = accessCodeRepo.getByCode(code).map(AccessCode::getLocker);
		if (forMachine.isPresent() && locker.isPresent()) {
			ParcelMachine machine = parcelMachineRepo.getReferenceById(forMachine.get());
			if (locker.get().getMachine() != machine) {
				return Optional.empty();
			}
		}
		return locker;
	}
}
