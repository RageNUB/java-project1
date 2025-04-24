package com.example.ecommerce.controller;

import com.example.ecommerce.util.SceneSwitcher;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

public class LoginController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;

    public void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // TODO: Validate from file (users.json)
        if (username.equals("admin") && password.equals("admin")) {
            SceneSwitcher.switchTo("dashboard.fxml");
        } else {
            SceneSwitcher.switchTo("products.fxml");
        }
    }

    public void goToRegister() {
        SceneSwitcher.switchTo("register.fxml");
    }
}
