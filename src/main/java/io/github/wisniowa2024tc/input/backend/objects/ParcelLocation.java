package io.github.wisniowa2024tc.input.backend.objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ParcelLocation extends Identified {}
