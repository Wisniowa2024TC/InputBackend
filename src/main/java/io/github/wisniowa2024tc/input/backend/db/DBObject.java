package io.github.wisniowa2024tc.input.backend.db;

import io.github.wisniowa2024tc.input.backend.db.errors.ObjectMissing;

/**
 * Obiekt możliwy do zapisania w bazie danych, zwykle pochodzi z bazy danych
 */
public interface DBObject {
    int getID();

    /**
     * Zapisuje zmiany w bazie danych
     */
    void saveToDB(DBController db);

    void refreshFromDB(DBController db) throws ObjectMissing; // Odśwież dane z bazy danych
    void refreshOrSave(DBController db);
    boolean isDirty(); // Czy coś się zmieniło w obiekcie
}
