package com.example.app.controller;

import com.example.app.model.Product;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ProductController {
    @FXML
    private Label productName;

    @FXML
    private Label productPrice;

    public void initialize() {
        Product product = new Product("Wireless Mouse", 25.99);
        productName.setText(product.getName());
        productPrice.setText("$" + product.getPrice());
    }
}
