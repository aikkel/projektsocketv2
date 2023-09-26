package com.example.projektsocketv2;

import Server.Server;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.HashSet;
import java.util.concurrent.locks.Condition;

public class LoginController {

    @FXML
    private Label tryAgain;
    @FXML
    private TextField nameInput;
    @FXML
    private Button lukButton;
    @FXML
    private Button acceptKnap;

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

            primaryStage.setTitle("Chat");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    HashSet<String> nc = new HashSet<String>();


    public boolean addName(String name) {
        // Check if the name already exists
        if (nc.contains(name)) {
            System.out.println("Name already exists: " + name);
            tryAgain();
            return false;
        }
        else
            nc.add(name);
        System.out.println("Name added: " + name);
        return true;
    }
    public boolean removeNameFromSession() {
        if (nc.contains(name)) {
            nc.remove(name);
            System.out.println("Name removed from the current session: " + name);
            return true;
        } else {
            System.out.println("Name not found in the current session: " + name);
            return false;
        }
    }

    @FXML
    public void buttonLukClick(ActionEvent event) {
        String nameToRemove = nameInput.getText();
        boolean removed = removeNameFromSession();
        removeNameFromSession();
        // You can add additional logic here based on whether the name was removed successfully
        /*if (removed) {
            // Name was removed successfully
        } else {
            // Name was not found in the current session
        }

         */
    }

    public void acceptButtonClick(ActionEvent actionEvent) {
        String nameToAdd = nameInput.getText();
        boolean added = addName(nameToAdd);

        // You can add additional logic here based on whether the name was added successfully
        if (added) {
            setName(nameInput.getText());
            System.out.println(nameInput.getText());
            System.out.println(getName());
            tryAgain.setVisible(false);
            switchToScene2();
            // Name was added successfully
        } else {
            // Name already exists
        }
    }



}