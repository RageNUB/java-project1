package com.example.ecommerce.controller;

import com.example.ecommerce.model.Product;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ProductController {
    @FXML
    private Label productName;

    @FXML
    private Label productPrice;

    public void initialize() {
        Product product = new Product("Wireless Mouse", 25.99, "image.png", "Electronics");
        productName.setText(product.getName());
        productPrice.setText("$" + product.getPrice());
    }
}
