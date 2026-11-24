package io.github.wisniowa2024tc.input.backend.rest;

import io.github.wisniowa2024tc.input.backend.objects.AccessCode;
import io.github.wisniowa2024tc.input.backend.objects.Parcel;
import io.github.wisniowa2024tc.input.backend.objects.location.ParcelLocker;
import io.github.wisniowa2024tc.input.backend.rest.messages.CodeCheckMessage;
import io.github.wisniowa2024tc.input.backend.rest.messages.ParcelCreationMessage;
import io.github.wisniowa2024tc.input.backend.services.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/parcel")
public class ParcelController {
	@Autowired private ParcelService parcelService;

	@PostMapping(path = "testSetup")
	public ResponseEntity<Integer> testSetup() {
		parcelService.testSetup();
		return ResponseEntity.ok(67);
	}
	
	@PostMapping(path = "createParcel")
	public ResponseEntity<Parcel> createParcel(@RequestBody ParcelCreationMessage parcel) {
		Parcel savedParcel = parcelService.createParcel(
			Optional.ofNullable(parcel.getName()),
			Optional.ofNullable(parcel.getDesc()),
			Optional.ofNullable(parcel.getType()),
			parcel.getLocationID()
		);
		return ResponseEntity.ok(savedParcel);
	}

	@PostMapping(path = "requestCode")
	public ResponseEntity<String> requestCode(@RequestBody UUID locker) {
		AccessCode accessCode = parcelService.requestAccessCode(locker);
		return ResponseEntity.ok(accessCode.getCode());
	}

	@GetMapping(path = "checkCode")
	public ResponseEntity<CodeCheckMessage> checkCode(
		@RequestParam String code, @RequestParam Optional<UUID> parcelMachine
	) {
		Optional<ParcelLocker> locker = parcelService.checkCode(code, parcelMachine);
		return ResponseEntity.of(locker.map(parcelLocker -> new CodeCheckMessage(
			parcelLocker.getInternalCode(), parcelLocker.getMachine().getUuid()
		)));
	}
}
