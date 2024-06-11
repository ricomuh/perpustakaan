package com.ricomuh.perpustakaan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BukuDAO {
    public List<Buku> getAllBuku() throws SQLException {
        List<Buku> bukuList = new ArrayList<>();
        String query = "SELECT * FROM Buku";
        
        try (Connection conn = DatabaseConnector.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                Buku buku = new Buku();
                buku.setId(rs.getInt("id"));
                buku.setJudul(rs.getString("judul"));
                buku.setPenulis(rs.getString("penulis"));
                buku.setTahunTerbit(rs.getInt("tahun_terbit"));
                bukuList.add(buku);
            }
        }
        return bukuList;
    }

    public void addBuku(Buku buku) throws SQLException {
        String query = "INSERT INTO Buku (judul, penulis, tahun_terbit) VALUES (?, ?, ?)";
        
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, buku.getJudul());
            pstmt.setString(2, buku.getPenulis());
            pstmt.setInt(3, buku.getTahunTerbit());
            pstmt.executeUpdate();
        }
    }

    public void updateBuku(Buku buku) throws SQLException {
        String query = "UPDATE Buku SET judul = ?, penulis = ?, tahun_terbit = ? WHERE id = ?";
        
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, buku.getJudul());
            pstmt.setString(2, buku.getPenulis());
            pstmt.setInt(3, buku.getTahunTerbit());
            pstmt.setInt(4, buku.getId());
            pstmt.executeUpdate();
        }
    }

    public void deleteBuku(int id) throws SQLException {
        String query = "DELETE FROM Buku WHERE id = ?";
        
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}
