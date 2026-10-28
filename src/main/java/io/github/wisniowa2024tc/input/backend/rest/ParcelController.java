package io.github.wisniowa2024tc.input.backend.rest;

import io.github.wisniowa2024tc.input.backend.objects.Parcel;
import io.github.wisniowa2024tc.input.backend.services.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/parcels")
public class ParcelController {
	@Autowired private ParcelService parcelService;
	
	@PostMapping
	public ResponseEntity<Parcel> createParcel(@RequestBody Parcel parcel) {
		Parcel savedParcel = parcelService.createParcel(parcel);
		return new ResponseEntity<>(savedParcel, HttpStatus.CREATED);
	}
}
