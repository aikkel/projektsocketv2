package com.example.projektsocketv2;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
}