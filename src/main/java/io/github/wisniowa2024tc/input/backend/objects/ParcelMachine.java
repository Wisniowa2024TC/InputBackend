package io.github.wisniowa2024tc.input.backend.objects;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.net.URL;

@Setter @Getter @Entity
@Table(name = "parcel_machine")
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
/// Paczkomat, zawiera komory na paczki
public class ParcelMachine extends Identifiable {
    /// Bazowy URL do komunikacji z backendem
    @Nonnull @NonNull private URL connectionAddress;

    /// Opis, jeśli istnieje
    @Nullable private String description;
}
