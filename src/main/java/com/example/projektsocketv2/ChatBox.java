package com.example.projektsocketv2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ChatBox extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            // Load login-box.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login-box.fxml"));
            Parent root = loader.load();

            // Set the controller for login-box
            LoginController loginController = loader.getController();
            loginController.setPrimaryStage(primaryStage);

            primaryStage.setTitle("Login");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}