package io.github.wisniowa2024tc.input.backend.rest.messages;

import io.github.wisniowa2024tc.input.backend.objects.Parcel;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;
import java.util.UUID;

@Setter @Getter
@AllArgsConstructor
public class ParcelCreationMessage {
    @Nullable String name;
    @Nullable String desc;
    @Nullable Parcel.Type type;
    @Nonnull UUID locationID;
}
