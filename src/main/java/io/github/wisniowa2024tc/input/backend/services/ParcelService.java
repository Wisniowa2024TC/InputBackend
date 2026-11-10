package io.github.wisniowa2024tc.input.backend.services;

import io.github.wisniowa2024tc.input.backend.objects.AccessCode;
import io.github.wisniowa2024tc.input.backend.objects.Parcel;
import io.github.wisniowa2024tc.input.backend.repositories.AccessCodeRepo;
import io.github.wisniowa2024tc.input.backend.repositories.ParcelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class ParcelService {
	@Autowired private ParcelRepo parcelRepo;
	@Autowired private AccessCodeRepo accessCodeRepo;

	private final SecureRandom random = new SecureRandom();
	
	public Parcel createParcel(Parcel parcel) {
		return parcelRepo.save(parcel);
	}

	public AccessCode requestAccessCode() {
		String code = String.format("%06d", random.nextInt(1000000));
		AccessCode accessCode = new AccessCode(code);
		return accessCodeRepo.save(accessCode);
	}
}
