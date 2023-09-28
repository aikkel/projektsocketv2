package com.example.projektsocketv2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class LoginController {
    @FXML
    private Label tryAgain;
    @FXML
    private TextField nameInput;
    private Stage primaryStage;

    // Static list to store connected names
    private static List<String> connectedNames = new CopyOnWriteArrayList<>();

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
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

    private boolean isNameTaken(String name) {
        return connectedNames.contains(name);
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
            tryAgain.setVisible(true);
            System.out.println("The name you entered has already been taken, please try again!");
        }
    }
}
