package com.example.projektsocketv2;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LoginController {
    private static String name;
    @FXML private TextField nameInput;
    @FXML private Button lukButton;
    @FXML private Button acceptKnap;

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        LoginController.name = name;
    }




    @FXML
    protected void buttonLukClick() {
        Platform.exit();
    }

    public void switchToChatBox() {
        ChatBox ctc = new ChatBox();
        Stage primaryStage = ctc.getPrimaryStage();
        try {
            Scene scene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("chat-box.fxml"))));
            primaryStage.setScene(scene);
            primaryStage.show();
            System.out.println(primaryStage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void acceptButtonClick() {
        setName(nameInput.getText());
        acceptKnap.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                switchToChatBox();
            }
        });
    }
}
