package com.example.projektsocketv2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    @FXML private TextField nameInput;
    @FXML private Button lukButton;
    @FXML private Button acceptKnap;

    private static String name;

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        LoginController.name = name;
    }

    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void switchToScene2() {
        try {
            // Load chat-box.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("chat-box.fxml"));
            Parent root = loader.load();

            // Set the controller for chat-box
            ChatController chatController = loader.getController();

            primaryStage.setTitle("Chat");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void buttonLukClick(ActionEvent event) {
        // Your event handling code here
    }

    public void acceptButtonClick(ActionEvent actionEvent) {
        setName(nameInput.getText());
        System.out.println(nameInput.getText());
        System.out.println(getName());
        switchToScene2();
    }
}