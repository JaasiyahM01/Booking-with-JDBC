package com.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {
    private final String url = "jdbc:sqlite:hair_booking.db";

    public void addClient(Client client) {
        String sql = "INSERT INTO clients(name, hair_service, appointment_date, phone_number, address) VALUES(?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, client.getName());
            pstmt.setString(2, client.getHairService());
            pstmt.setString(3, client.getAppointmentDate());
            pstmt.setString(4, client.getPhoneNumber());
            pstmt.setString(5, client.getAddress());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM clients";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Client client = new Client();
                client.setId(rs.getInt("id"));
                client.setName(rs.getString("name"));
                client.setHairService(rs.getString("hair_service"));
                client.setAppointmentDate(rs.getString("appointment_date"));
                client.setPhoneNumber(rs.getString("phone_number"));
                client.setAddress(rs.getString("address"));
                clients.add(client);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return clients;
    }
}

    
}
