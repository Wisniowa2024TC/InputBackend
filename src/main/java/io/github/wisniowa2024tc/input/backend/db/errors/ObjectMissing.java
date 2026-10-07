package io.github.wisniowa2024tc.input.backend.db.errors;

/**
 * Obiekt nie istnieje w bazie danych, możliwe, że został usunięty w trakcie pracy
 */
public class ObjectMissing extends RuntimeException {
    public ObjectMissing(String message) {
        super(message);
    }
}
