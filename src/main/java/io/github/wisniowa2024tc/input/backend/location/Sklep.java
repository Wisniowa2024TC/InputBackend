package io.github.wisniowa2024tc.input.backend.location;

import io.github.wisniowa2024tc.input.backend.BasicDBObject;
import io.github.wisniowa2024tc.input.backend.Parcel;

public class Sklep extends BasicDBObject implements Location {
    private String name; // Nazwa sklepu

    public Sklep(int id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
