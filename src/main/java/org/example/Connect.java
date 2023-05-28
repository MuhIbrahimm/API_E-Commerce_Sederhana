package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    public static void connect() {
        Connection connection = null;
        String rootPath = System.getProperty("user.dir");
        try {
            String url = "jdbc:sqlite" + rootPath + "/e-commerce.db";
            connection = DriverManager.getConnection(url);
            System.out.println("Anda Berhasil Terhubung");
        } catch (SQLException e) {
            System.err.println("Terjadi kesalahan saat menghubungkan ke database: " + e.getMessage());
        } finally {
            // Menutup koneksi dan sumber daya lainnya
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Terjadi kesalahan saat menutup koneksi: " + e.getMessage());
            }
        }
    }
}
