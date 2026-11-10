package io.github.wisniowa2024tc.input.backend.repositories;

import io.github.wisniowa2024tc.input.backend.objects.location.ParcelLocker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ParcelLockerRepo extends JpaRepository<ParcelLocker, UUID> {}
