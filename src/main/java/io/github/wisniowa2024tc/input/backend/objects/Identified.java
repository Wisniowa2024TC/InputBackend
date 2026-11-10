package io.github.wisniowa2024tc.input.backend.objects;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;

@Getter @Entity @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Identified {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
}
