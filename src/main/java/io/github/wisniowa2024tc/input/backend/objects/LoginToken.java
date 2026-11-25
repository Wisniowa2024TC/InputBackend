package io.github.wisniowa2024tc.input.backend.objects;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.*;

@Getter @Entity @Table(name = "login_token")
@RequiredArgsConstructor @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LoginToken extends Identified {
    @ManyToOne
    @Nonnull private User user;
}
