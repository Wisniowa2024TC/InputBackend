package io.github.wisniowa2024tc.input.backend.objects;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

@Setter @Getter
@Entity @Table(name = "parcel")
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Parcel extends Identified {
    @Nullable private String name; // Nazwa paczki, opcjonalna
    @Nullable private String description; // Opis, opcjonalny
    @Nonnull @NonNull private Type type; // Co to za typ paczki
    @ManyToOne @JoinColumn(name = "location_uuid")
    @Nonnull @NonNull private ParcelLocation location; // Gdzie jest paczka


    public enum Type {
        MACHINE_PICKUP, // Paczka do odbioru z paczkomatu
        MACHINE_DELIVERY, // Paczka do dostarczenia za pośrednictwem paczkomatu
        DIRECT_DELIVERY; // Dostawa bez paczkomatu
    }
}
