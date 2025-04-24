package com.example.ecommerce.util;

import com.example.ecommerce.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class SceneSwitcher {
    public static void switchTo(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("/fxml/" + fxml));
            Scene scene = new Scene(loader.load());
            scene.getStylesheets().add(App.class.getResource("/styles/style.css").toExternalForm());
            App.stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
