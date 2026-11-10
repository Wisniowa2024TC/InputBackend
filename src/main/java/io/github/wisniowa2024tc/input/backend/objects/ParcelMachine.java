package io.github.wisniowa2024tc.input.backend.objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter @Entity @Table(name = "parcel_machine")
@AllArgsConstructor @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ParcelMachine extends Identified {
    private String address;
}
