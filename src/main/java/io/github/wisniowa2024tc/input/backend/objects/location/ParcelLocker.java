package io.github.wisniowa2024tc.input.backend.objects.location;

import io.github.wisniowa2024tc.input.backend.objects.ParcelLocation;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Setter @Getter
@Entity @Table(name = "locker")
@AllArgsConstructor @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ParcelLocker extends ParcelLocation {
    @ManyToOne @JoinColumn(name = "machine_uuid")
    private ParcelMachine machine;
}
