package io.github.wisniowa2024tc.input.backend.objects;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

@Setter @Getter @Entity
@Table(name = "parcel_box")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
/// Pojemnik na paczkę w paczkomacie
public class ParcelBox extends ParcelLocation {
    /// Paczkomat, w którym jest ta komora
    @ManyToOne @JoinColumn(name = "machine_id")
    private ParcelMachine machine;

    /// Opis, jeśli istnieje
    @Nullable private String description;

    /// Id do przekazania do firmware w celu otwarcia, jeśli paczkomat ma > 1 pojemnik
    @Nullable private String firmwareId;
}
