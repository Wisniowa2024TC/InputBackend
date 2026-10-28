package io.github.wisniowa2024tc.input.backend.services;

import io.github.wisniowa2024tc.input.backend.objects.Parcel;
import io.github.wisniowa2024tc.input.backend.repositories.ParcelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParcelService {
	@Autowired
	private ParcelRepo parcelRepo;
	
	public Parcel createParcel(Parcel parcel) {
		return parcelRepo.save(parcel);
	}
}
