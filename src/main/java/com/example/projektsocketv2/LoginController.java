package com.example.projektsocketv2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class LoginController {
    @FXML
    private Label tryAgain;
    @FXML
    private TextField nameInput;
    private Stage primaryStage;
    private List<String> connectedNames;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setConnectedNamesList(List<String> connectedNames) {
        this.connectedNames = connectedNames;
    }

    public void tryAgain() {
        // Your condition here
        boolean condition = false; // Change this condition as needed

        // Use an if statement to show or hide the label
        if (condition) {
            tryAgain.setVisible(true); // Show the label
        } else {
            tryAgain.setVisible(false); // Hide the label
        }
    }

    public void switchToScene2() {
        try {
            // Load chat-box.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("chat-box.fxml"));
            Parent root = loader.load();

            // Set the controller for chat-box
            ChatController chatController = loader.getController();
            chatController.setPrimaryStage(primaryStage); // Pass the primaryStage reference
            chatController.setName(nameInput.getText()); // Pass the name

            primaryStage.setTitle("Chat");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void buttonLukClick(ActionEvent event) {
        System.out.println(connectedNames);
        System.exit(0);
    }

    @FXML
    public void acceptButtonClick(ActionEvent actionEvent) {
        String nameToAdd = nameInput.getText();
        if (!isNameTaken(nameToAdd)) {
            connectedNames.add(nameToAdd);
            tryAgain.setVisible(false);
            System.out.println(connectedNames);
            switchToScene2();
        } else {
            tryAgain.setVisible(true); // Show the "tryagain" label
            System.out.println("The name you entered has already been taken, please try again!");
        }
    }

    private boolean isNameTaken(String name) {
        // Modify this method to check if the name is already in connectedNames list
        return connectedNames.contains(name);
    }
}
