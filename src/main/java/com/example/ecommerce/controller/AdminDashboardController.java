package com.example.ecommerce.controller;

import com.example.ecommerce.model.Order;
import com.example.ecommerce.util.FileManager;
import com.example.ecommerce.util.SceneSwitcher;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AdminDashboardController {

    @FXML private TableView<Order> orderTable;
    @FXML private TableColumn<Order, String> usernameCol;
    @FXML private TableColumn<Order, String> productCol;
    @FXML private TableColumn<Order, Double> priceCol;
    @FXML private TableColumn<Order, Integer> quantityCol;
    @FXML private TableColumn<Order, String> dateCol;

    public void initialize() {
        usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        productCol.setCellValueFactory(new PropertyValueFactory<>("productName"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        orderTable.getItems().addAll(FileManager.loadAllOrders());
    }

    public void handleLogout() {
        SceneSwitcher.switchTo("login.fxml");
    }
}
