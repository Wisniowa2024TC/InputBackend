package io.github.wisniowa2024tc.input.backend.objects;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

@Setter @Getter @Entity
@Table(name = "parcel")
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Parcel extends Identifiable {
    /// Nazwa paczki, jeśli istnieje
    @Nullable private String name;
    /// Opis, jeśli istnieje
    @Nullable private String description;
    /// Typ paczki, jak ma być obsłużona
    @Nonnull @NonNull private Type type;
    /// Stan paczki, co się z nią dzieje
    @Nonnull @NonNull private State state;

    /// Lokalizacja paczki
    @ManyToOne @JoinColumn(name = "location_id") @Nullable
    private ParcelLocation location;

    public enum Type {
        MACHINE_PICKUP, // Paczka do odbioru z paczkomatu
        MACHINE_DELIVERY, // Paczka do dostarczenia za pośrednictwem paczkomatu
        DIRECT_DELIVERY; // Dostawa bez paczkomatu
    }

    public enum State {
        PREPARED, // Paczka przygotowana przez sklep; znajduje się w sklepie
        IN_TRANSIT_TO_MACHINE, // Paczka odebrana ze sklepu, jeszcze niedostarczona do paczkomatu
        IN_MACHINE, // Paczka w paczkomacie; gotowa do odebrania
        IN_TRANSIT_FROM_MACHINE; // Paczka
    }
}
