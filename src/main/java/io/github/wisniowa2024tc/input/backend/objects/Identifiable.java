package io.github.wisniowa2024tc.input.backend.objects;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Identifiable {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
}
