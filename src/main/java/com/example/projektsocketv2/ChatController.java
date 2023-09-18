package com.example.projektsocketv2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ChatController {
    @FXML private TextField chatInput;
    @FXML private TextArea chatBox;
    @FXML private Button sendKnap;
    @FXML private Button lukKnap;

    public void onButtonSend() {
        String input = chatInput.getText();
        chatBox.appendText(input + "\n");
        chatInput.clear();
    }

    public void onButtonLuk() {
        System.exit(0);
    }
}
