package com.example; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:mydatabase.db"; 

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void main(String[] args) {
        try (Connection conn = getConnection()) {
            if (conn != null) {
                System.out.println("Connection to SQLite has been established.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
