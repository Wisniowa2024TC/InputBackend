package io.github.wisniowa2024tc.input.backend.objects.location;

import io.github.wisniowa2024tc.input.backend.objects.ParcelLocation;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter @Entity @Table(name = "intermediate_location")
@AllArgsConstructor @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class IntermediateLocation extends ParcelLocation {
    private String address;
}
