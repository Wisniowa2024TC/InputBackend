package io.github.wisniowa2024tc.input.backend.rest;

import io.github.wisniowa2024tc.input.backend.objects.AccessCode;
import io.github.wisniowa2024tc.input.backend.objects.Parcel;
import io.github.wisniowa2024tc.input.backend.objects.location.ParcelLocker;
import io.github.wisniowa2024tc.input.backend.rest.responces.CodeCheckResponse;
import io.github.wisniowa2024tc.input.backend.services.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/")
public class ParcelController {
	@Autowired private ParcelService parcelService;

	@PostMapping(path = "testSetup")
	public ResponseEntity<Integer> testSetup() {
		parcelService.testSetup();
		return ResponseEntity.ok(67);
	}
	
	@PostMapping(path = "createParcel")
	public ResponseEntity<Parcel> createParcel(@RequestBody Parcel parcel) {
		Parcel savedParcel = parcelService.createParcel(parcel);
		return ResponseEntity.ok(savedParcel);
	}

	@PostMapping(path = "requestCode")
	public ResponseEntity<String> requestCode(@RequestBody UUID locker) {
		AccessCode accessCode = parcelService.requestAccessCode(locker);
		return ResponseEntity.ok(accessCode.getCode());
	}

	@GetMapping(path = "checkCode")
	public ResponseEntity<CodeCheckResponse> checkCode(
		@RequestParam String code, @RequestParam Optional<UUID> parcelMachine
	) {
		Optional<ParcelLocker> locker = parcelService.checkCode(code, parcelMachine);
		return ResponseEntity.of(locker.map(parcelLocker -> new CodeCheckResponse(
			parcelLocker.getInternalCode(), parcelLocker.getMachine().getUuid()
		)));
	}
}
