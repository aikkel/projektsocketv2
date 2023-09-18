package com.example.projektsocketv2;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class ChatController {
    @FXML private TextField chatInput;
    @FXML private TextArea chatBox;
    @FXML private Button sendKnap;
    @FXML private Button lukKnap;
    public String name = LoginController.getName();

    @FXML
    protected void onButtonSend() {
        String input = chatInput.getText();
        chatBox.appendText( name + "> " + input + "\n");
        chatInput.setText("");
    }

    @FXML
    protected void onButtonLuk() {
        Platform.exit();
    }
}
