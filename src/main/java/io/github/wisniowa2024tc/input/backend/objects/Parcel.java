package io.github.wisniowa2024tc.input.backend.objects;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Table(name = "parcel")
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Parcel {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Setter @Nullable private String name; // Nazwa paczki, opcjonalna
    @Setter @Nullable private String description; // Opis, opcjonalny
    @Setter @Nonnull @NonNull private Type type; // Co to za typ paczki
    @Setter @Nonnull @NonNull private State state; // Co się dzieje z tą paczką

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
