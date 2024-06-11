package com.ricomuh.perpustakaan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/Perpustakaan";
    private static final String USER = "root";  // ganti dengan username MySQL Anda
    private static final String PASSWORD = "password";  // ganti dengan password MySQL Anda

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
