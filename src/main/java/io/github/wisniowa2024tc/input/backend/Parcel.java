package io.github.wisniowa2024tc.input.backend;

import io.github.wisniowa2024tc.input.backend.location.Location;

import java.util.Objects;

public record Parcel(String name, String description, Location location) {
    public enum Type {
        MACHINE_PICKUP, // Paczka do odbioru z paczkomatu
        MACHINE_DELIVERY, // Paczka do dostarczenia za pośrednictwem paczkomatu
        DIRECT_DELIVERY; // Dostawa bez paczkomatu
    }

    public enum State {
        PREPARED, // Paczka przygotowana przez sklep; znajduje się w sklepie
        IN_TRANSIT_TO_MACHINE, // Paczka odebrana ze sklepu, jeszcze niedostarczona do paczkomatu
        IN_MACHINE, // Paczka w paczkomacie; gotowa do odebrania
        IN_TRANSIT_FROM_MACHINE; // Paczka
    }
}
