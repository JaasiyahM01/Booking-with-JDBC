package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void main(String[] args) {
        String url = "jdbc:sqlite:hair_booking.db";

        String sql = "CREATE TABLE IF NOT EXISTS clients (\n"
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " name TEXT NOT NULL,\n"
                + " hair_service TEXT NOT NULL,\n"
                + " appointment_date TEXT NOT NULL,\n"
                + " phone_number TEXT NOT NULL,\n"
                + " address TEXT NOT NULL\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Database initialized.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
