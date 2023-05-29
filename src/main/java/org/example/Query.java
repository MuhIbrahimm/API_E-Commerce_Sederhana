package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Query {
    public static Connection connect() {
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
        return connection;
    }

    public void inputAddresses(int user, String type, String line1, String line2, String city, String province, String postcode) {
        String sql = "INSERT INTO addresses(user, type, line1, line2, city, province, postcode) VALUES(?,?,?,?,?,?,?)";
        try{
            Connection connection = this.connect();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, user );
            pstmt.setString(2, type );
            pstmt.setString(3, line1 );
            pstmt.setString(4, line2 );
            pstmt.setString(5, city);
            pstmt.setString(6, province);
            pstmt.setString(7, postcode);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void inputOrderDetails(int id, int productId, int quantity, int price) {
        String sql = "INSERT INTO order_details(orderId, productId, quantity, price) VALUES(?,?,?,?)";
        try{
            Connection connection = this.connect();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id );
            pstmt.setInt(2, productId );
            pstmt.setInt(3, quantity );
            pstmt.setInt(4, price );
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void inputOrders(int id, int buyer, int note, int total, int discount, String is_paid) {
        String sql = "INSERT INTO orders(id, buyer, note, total, discount, is_paid) VALUES(?,?,?,?,?,?)";
        try{
            Connection connection = this.connect();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id );
            pstmt.setInt(2, buyer );
            pstmt.setInt(3, note );
            pstmt.setInt(4, total );
            pstmt.setInt(5, discount);
            pstmt.setString(6, is_paid);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void inputProducts(int id, int seller, String title, String description, String price, int stock) {
        String sql = "INSERT INTO products(id, seller, title, description, price, stock) VALUES(?,?,?,?,?,?)";
        try{
            Connection connection = this.connect();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id );
            pstmt.setInt(2, seller );
            pstmt.setString(3, title );
            pstmt.setString(4, description );
            pstmt.setString(5, price );
            pstmt.setInt(6, stock );
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void inputReviews(int order, int star, String description) {
        String sql = "INSERT INTO reviews(order, star, description) VALUES(?,?,?)";
        try{
            Connection connection = this.connect();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, order );
            pstmt.setInt(2, star );
            pstmt.setString(3, description );
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void users(int id, String first_name, String last_name, String email, String phone_number, String type) {
        String sql = "INSERT INTO users(id, first_name, last_name, email, phone_number, type) VALUES(?,?,?,?,?,?)";
        try{
            Connection connection = this.connect();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id );
            pstmt.setString(2, first_name );
            pstmt.setString(3, last_name );
            pstmt.setString(4, email );
            pstmt.setString(5, phone_number );
            pstmt.setString(6, type );
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
