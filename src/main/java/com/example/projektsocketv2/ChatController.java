package com.example.projektsocketv2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ChatController {
    @FXML
    private TextField chatInput;
    @FXML
    private TextArea chatBox;
    @FXML
    private Button sendKnap;
    @FXML
    private Button lukKnap;

    private Stage primaryStage;
    private String name;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void onButtonSend() {
        String input = chatInput.getText();
        chatBox.appendText(name + "> " + input + "\n");
        chatInput.clear();
    }

    public void onButtonLuk() {
        System.exit(0);
    }

    public void switchToScene1() {
        try {
            // Load login-box.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login-box.fxml"));
            Parent root = loader.load();

            // Set the controller for login-box
            LoginController loginController = loader.getController();
            loginController.setPrimaryStage(primaryStage); // Pass the primaryStage reference

            primaryStage.setTitle("Login");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Tilbage(ActionEvent actionEvent) {
        switchToScene1();
    }
}
