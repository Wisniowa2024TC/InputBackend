package io.github.wisniowa2024tc.input.backend.repositories;

import io.github.wisniowa2024tc.input.backend.objects.location.ParcelMachine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ParcelMachineRepo extends JpaRepository<ParcelMachine, UUID> {
}
