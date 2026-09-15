package io.github.wisniowa2024tc.input.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBController {
    public Connection connection;

    private static final String DB = "InputBackend";
    private static final String USER = "IBUser";
    private static final String PASSWORD = "PleaseDontUse";

    public DBController() {
        try {
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/" + DB + "?user=" + USER + "&password=" + PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to connect to database", e);
        }
    }
}
