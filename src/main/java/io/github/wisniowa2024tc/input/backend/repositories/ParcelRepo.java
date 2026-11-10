package io.github.wisniowa2024tc.input.backend.repositories;

import io.github.wisniowa2024tc.input.backend.objects.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ParcelRepo extends JpaRepository<Parcel, UUID> {
}
