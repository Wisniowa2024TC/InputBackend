package io.github.wisniowa2024tc.input.backend.objects;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

@Getter @Entity @Table(name = "access_code")
@RequiredArgsConstructor @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccessCode extends Identified {
    @Nonnull private String code;
    private Instant createdOn;
}
