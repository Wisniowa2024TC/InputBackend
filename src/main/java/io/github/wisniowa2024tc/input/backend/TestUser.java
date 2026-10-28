package io.github.wisniowa2024tc.input.backend;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Table(name = "test_user")
@ToString
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TestUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Setter @NonNull
    private String name;
    @Setter
    private int age;
}
