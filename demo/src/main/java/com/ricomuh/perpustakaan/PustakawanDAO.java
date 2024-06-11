package com.ricomuh.perpustakaan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PustakawanDAO {
    public List<Pustakawan> getAllPustakawan() throws SQLException {
        List<Pustakawan> pustakawanList = new ArrayList<>();
        String query = "SELECT * FROM Pustakawan";
        
        try (Connection conn = DatabaseConnector.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                Pustakawan pustakawan = new Pustakawan();
                pustakawan.setId(rs.getInt("id"));
                pustakawan.setNama(rs.getString("nama"));
                pustakawan.setAlamat(rs.getString("alamat"));
                pustakawan.setTelepon(rs.getString("telepon"));
                pustakawanList.add(pustakawan);
            }
        }
        return pustakawanList;
    }

    public void addPustakawan(Pustakawan pustakawan) throws SQLException {
        String query = "INSERT INTO Pustakawan (nama, alamat, telepon) VALUES (?, ?, ?)";
        
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, pustakawan.getNama());
            pstmt.setString(2, pustakawan.getAlamat());
            pstmt.setString(3, pustakawan.getTelepon());
            pstmt.executeUpdate();
        }
    }

    public void updatePustakawan(Pustakawan pustakawan) throws SQLException {
        String query = "UPDATE Pustakawan SET nama = ?, alamat = ?, telepon = ? WHERE id = ?";
        
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, pustakawan.getNama());
            pstmt.setString(2, pustakawan.getAlamat());
            pstmt.setString(3, pustakawan.getTelepon());
            pstmt.setInt(4, pustakawan.getId());
            pstmt.executeUpdate();
        }
    }

    public void deletePustakawan(int id) throws SQLException {
        String query = "DELETE FROM Pustakawan WHERE id = ?";
        
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}
