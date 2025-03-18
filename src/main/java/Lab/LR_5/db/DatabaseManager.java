package Lab.LR_5.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String URL = "jdbc:sqlite:src/main/resources/database/students.db";  // Ensure the path is correct

    // Method to connect to the database
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
