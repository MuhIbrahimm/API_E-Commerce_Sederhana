package org.example;

import org.json.JSONObject;

public class Structure {
    public static JSONObject addresses(int users, String type, String line1, String line2, String city, String province, String postcode) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user", users);
        jsonObject.put("type", type);
        jsonObject.put("line1", line1);
        jsonObject.put("line2", line2);
        jsonObject.put("city", city);
        jsonObject.put("province", province);
        jsonObject.put("postcode", postcode);
        return jsonObject;
    }

    public static JSONObject order_detail(int order, int product, int quantity, int price) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("order", order);
        jsonObject.put("product", product);
        jsonObject.put("quantity", quantity);
        jsonObject.put("price", price);
        return jsonObject;
    }

    public static JSONObject orders(int id, int buyer, int note, int total, int discount, String is_paid) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", id);
        jsonObject.put("buyer", buyer);
        jsonObject.put("note", note);
        jsonObject.put("total", total);
        jsonObject.put("discount", discount);
        jsonObject.put("is_paid", is_paid);
        return jsonObject;
    }

    public static JSONObject products(int id, int seller, String title, String description, String price, int stock) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", id);
        jsonObject.put("seller", seller);
        jsonObject.put("title", title);
        jsonObject.put("description", description);
        jsonObject.put("price", price);
        jsonObject.put("stock", stock);
        return jsonObject;
    }

    public static JSONObject reviews(int order, int star, String description) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("order", order);
        jsonObject.put("star", star);
        jsonObject.put("description", description);
        return jsonObject;
    }

    public static JSONObject users(int id, String first_name, String last_name, String email, String phone_number, String type) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", id);
        jsonObject.put("first_name", first_name);
        jsonObject.put("last_name", last_name);
        jsonObject.put("email", email);
        jsonObject.put("phone_number", phone_number);
        jsonObject.put("type", type);
        return jsonObject;
    }
}
