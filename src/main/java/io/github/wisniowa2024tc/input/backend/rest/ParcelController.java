package io.github.wisniowa2024tc.input.backend.rest;

import io.github.wisniowa2024tc.input.backend.objects.AccessCode;
import io.github.wisniowa2024tc.input.backend.objects.Parcel;
import io.github.wisniowa2024tc.input.backend.services.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class ParcelController {
	@Autowired private ParcelService parcelService;
	
	@PostMapping(path = "createParcel")
	public ResponseEntity<Parcel> createParcel(@RequestBody Parcel parcel) {
		Parcel savedParcel = parcelService.createParcel(parcel);
		return new ResponseEntity<>(savedParcel, HttpStatus.CREATED);
	}

	@PostMapping(path = "requestCode")
	public ResponseEntity<AccessCode> requestCode() {
		AccessCode accessCode = parcelService.requestAccessCode();
		return new ResponseEntity<>(accessCode, HttpStatus.CREATED);
	}
}
