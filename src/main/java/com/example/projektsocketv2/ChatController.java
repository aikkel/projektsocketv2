package com.example.projektsocketv2;

import javafx.application.Application;
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
    @FXML private TextField chatInput;
    @FXML private TextArea chatBox;
    @FXML private Button sendKnap;
    @FXML private Button lukKnap;

    public String name = LoginController.getName();

    public void onButtonSend() {
        String input = chatInput.getText();
        chatBox.appendText(name + "> " + input + "\n");
        chatInput.clear();
    }

    public void onButtonLuk() {
        System.exit(0);
    }


    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

}