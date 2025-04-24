package com.example.ecommerce.model;

public class Order {
    private String username;
    private String productName;
    private double price;
    private int quantity;
    private String date;

    public Order(String username, String productName, double price, int quantity, String date) {
        this.username = username;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.date = date;
    }

    public String getUsername() { return username; }
    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public String getDate() { return date; }
}
