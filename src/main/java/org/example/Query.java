package org.example;

import org.json.JSONObject;

import java.sql.*;
import java.util.ArrayList;

public class Query {
    public static Connection connect() {
        Connection connection = null;
        String rootPath = System.getProperty("user.dir");
        String url = "jdbc:sqlite:" + rootPath + "/e-commerce.db";
        try {
            connection = DriverManager.getConnection(url);
            System.out.println("Anda Berhasil Terhubung");
        } catch (SQLException e) {
            System.err.println("Terjadi kesalahan saat menghubungkan ke database: " + e.getMessage());
        }
        return connection;
    }


    public void inputAddresses(int user, String type, String line1, String line2, String city, String province, String postcode) {
        String sql = "INSERT INTO addresses(user, type, line1, line2, city, province, postcode) VALUES(?,?,?,?,?,?,?)" + ";";
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
            System.out.println("Terdapat kesalahan: " + e.getMessage());
        }
    }

    public void inputOrderDetails(int order, int product, int quantity, int price) {
        String sql = "INSERT INTO order_details(order, product, quantity, price) VALUES(?,?,?,?)" + ";";
        try{
            Connection connection = this.connect();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, order );
            pstmt.setInt(2, product );
            pstmt.setInt(3, quantity );
            pstmt.setInt(4, price );
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Terdapat kesalahan: " + e.getMessage());
        }
    }

    public void inputOrders(int id, int buyer, int note, int total, int discount, String is_paid) {
        String sql = "INSERT INTO orders(id, buyer, note, total, discount, is_paid) VALUES(?,?,?,?,?,?)" + ";";
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
            System.out.println("Terdapat kesalahan: " + e.getMessage());
        }
    }

    public void inputProducts(int id, int seller, String title, String description, String price, int stock) {
        String sql = "INSERT INTO products(id, seller, title, description, price, stock) VALUES(?,?,?,?,?,?)" + ";";
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
            System.out.println("Terdapat kesalahan: " + e.getMessage());
        }
    }

    public void inputReviews(int order, int star, String description) {
        String sql = "INSERT INTO reviews(order, star, description) VALUES(?,?,?)" + ";";
        try{
            Connection connection = this.connect();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, order );
            pstmt.setInt(2, star );
            pstmt.setString(3, description );
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Terdapat kesalahan: " + e.getMessage());
        }
    }

    public void inputUsers(int id, String first_name, String last_name, String email, String phone_number, String type) {
        String sql = "INSERT INTO users(id, first_name, last_name, email, phone_number, type) VALUES(?,?,?,?,?,?)" + ";";
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
            System.out.println("Terdapat kesalahan: " + e.getMessage());
        }
    }

    public void selectAll(String table){
        String sql = "SELECT * FROM " + table + ";";
        ArrayList<JSONObject> result = new ArrayList<>();
        try {
            Connection connection = this.connect();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if (table.equals("addresses")){
                result.add(Structure.addresses(resultSet.getInt("users"), resultSet.getString("type"), resultSet.getString("line1"), resultSet.getString("line2"), resultSet.getString("city"), resultSet.getString("province"), resultSet.getString("postcode")));
            } else if (table.equals("order_details")){
                result.add(Structure.order_detail(resultSet.getInt("order"), resultSet.getInt("product"), resultSet.getInt("quantity"), resultSet.getInt("price")));
            } else if (table.equals("orders")){
                result.add(Structure.orders(resultSet.getInt("id"), resultSet.getInt("buyer"), resultSet.getInt("note"), resultSet.getInt("total"), resultSet.getInt("discount"), resultSet.getString("is_paid")));
            } else if (table.equals("products")){
                result.add(Structure.products(resultSet.getInt("id"), resultSet.getInt("seller"), resultSet.getString("title"), resultSet.getString("description"), resultSet.getString("price"), resultSet.getInt("stock")));
            } else if (table.equals("reviews")){
                result.add(Structure.reviews(resultSet.getInt("order"), resultSet.getInt("star"), resultSet.getString("description")));
            } else if(table.equals("users")){
                result.add(Structure.users(resultSet.getInt("id"), resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("email"), resultSet.getString("phone_number"), resultSet.getString("type")));
            }
        } catch (SQLException e) {
            System.out.println("Terdapat kesalahan: " + e.getMessage());
        }
    }

    public static String getAllUsers() {
        StringBuilder builder = new StringBuilder();
        try {
            Connection connection = connect();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String phone_number = resultSet.getString("phone_number");
                String type = resultSet.getString("type");
                builder.append("User ID: ").append(id).append("\n");
                builder.append("First Name: ").append(first_name).append("\n");
                builder.append("Last Name: ").append(last_name).append("\n");
                builder.append("Email: ").append(email).append("\n");
                builder.append("Email: ").append(phone_number).append("\n");
                builder.append("Address: ").append(type).append("\n\n");
            }

            // Menutup statement dan resultSet
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return builder.toString();
    }
}
