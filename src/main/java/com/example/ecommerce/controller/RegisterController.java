package com.example.ecommerce.controller;

import com.example.ecommerce.model.User;
import com.example.ecommerce.util.FileManager;
import com.example.ecommerce.util.SceneSwitcher;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;

public class RegisterController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private PasswordField confirmPasswordField;

    public void handleRegister() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            showAlert("Fields cannot be empty");
            return;
        }

        if (!password.equals(confirmPassword)) {
            showAlert("Passwords do not match");
            return;
        }
        if (FileManager.userExists(username)) {
            showAlert("Username already exists");
            return;
        }

        User newUser = new User(username, password, "user");
        FileManager.saveUser(newUser);
        showAlert("Registration successful. Please login.");
        SceneSwitcher.switchTo("login.fxml");
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(msg);
        alert.show();
    }

    public void goToLogin() {
        SceneSwitcher.switchTo("login.fxml");
    }
}
