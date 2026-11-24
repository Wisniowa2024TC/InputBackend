package io.github.wisniowa2024tc.input.backend.objects;

import io.github.wisniowa2024tc.input.backend.objects.location.ParcelLocker;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.time.Instant;

@Getter @Entity @Table(name = "access_code")
@RequiredArgsConstructor @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccessCode extends Identified {
    @Nonnull private String code;
    @Nonnull private Instant createdOn;
    @ManyToOne @JoinColumn(name = "locker_uuid")
    @Nonnull private ParcelLocker locker;
}
