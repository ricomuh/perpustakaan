package com.ricomuh.perpustakaan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnggotaDAO {
    public List<Anggota> getAllAnggota() throws SQLException {
        List<Anggota> anggotaList = new ArrayList<>();
        String query = "SELECT * FROM Anggota";
        
        try (Connection conn = DatabaseConnector.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                Anggota anggota = new Anggota();
                anggota.setId(rs.getInt("id"));
                anggota.setNama(rs.getString("nama"));
                anggota.setAlamat(rs.getString("alamat"));
                anggota.setTelepon(rs.getString("telepon"));
                anggotaList.add(anggota);
            }
        }
        return anggotaList;
    }

    public void addAnggota(Anggota anggota) throws SQLException {
        String query = "INSERT INTO Anggota (nama, alamat, telepon) VALUES (?, ?, ?)";
        
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, anggota.getNama());
            pstmt.setString(2, anggota.getAlamat());
            pstmt.setString(3, anggota.getTelepon());
            pstmt.executeUpdate();
        }
    }

    public void updateAnggota(Anggota anggota) throws SQLException {
        String query = "UPDATE Anggota SET nama = ?, alamat = ?, telepon = ? WHERE id = ?";
        
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, anggota.getNama());
            pstmt.setString(2, anggota.getAlamat());
            pstmt.setString(3, anggota.getTelepon());
            pstmt.setInt(4, anggota.getId());
            pstmt.executeUpdate();
        }
    }

    public void deleteAnggota(int id) throws SQLException {
        String query = "DELETE FROM Anggota WHERE id = ?";
        
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}
