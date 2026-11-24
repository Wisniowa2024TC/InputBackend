package io.github.wisniowa2024tc.input.backend.rest.responces;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter @Getter
@AllArgsConstructor
public class CodeCheckResponse {
    @Nullable private String internalCode;
    @Nonnull private UUID machineID;
}
