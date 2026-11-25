package io.github.wisniowa2024tc.input.backend.rest.messages;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter @Getter
@AllArgsConstructor
public class LockerContentMessage {
    @Nullable private String internalCode;
    @Nonnull private UUID machineID;
}
