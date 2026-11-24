package io.github.wisniowa2024tc.input.backend.objects;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Setter @Getter
@Entity @Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends Identified {
    @NonNull @Nonnull private String username;
    @NonNull @Nonnull private String password;
}
