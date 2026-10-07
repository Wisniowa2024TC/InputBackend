package io.github.wisniowa2024tc.input.backend;

import io.github.wisniowa2024tc.input.backend.db.DBObject;

/**
 * Basic database stored object, with an ID
 */
public abstract class BasicDBObject implements DBObject {
    private final int id;

    protected BasicDBObject(int id) {
        this.id = id;
    }

    @Override
    public int getID() {
        return id;
    }
}
