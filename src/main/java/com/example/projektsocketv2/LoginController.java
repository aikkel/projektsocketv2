package com.example.projektsocketv2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class LoginController {
    @FXML
    private Label tryAgain;
    @FXML
    private TextField nameInput;
    private Stage primaryStage;

    // Static list to store connected names
    //  private static List<String> connectedNames = new CopyOnWriteArrayList<>();

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Socket socketConnecter() {
        try {
            Socket socket = new Socket("127.0.0.1", 8080); // Establish the socket connection
            return socket;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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



    private boolean isNameTaken(String name) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(socketConnecter().getInputStream()));
        PrintWriter out = new PrintWriter(socketConnecter().getOutputStream(), true); // Assuming 'socket' is your established connection
        String nameToSend = nameInput.getText();
        out.println(nameToSend);
        String response = in.readLine();
        if (response != null) {
            if (response.equals("true")) {
                System.out.println("Name added successfully.");
            }
        } else {
            System.out.println("Duplicate name: " + response);
        }

        return false;
    }
    @FXML
    public void buttonLukClick(ActionEvent event) throws IOException {
        PrintWriter out = new PrintWriter(socketConnecter().getOutputStream(), true);
        out.println(nameInput);
        System.exit(0);
    }

    @FXML
    public void acceptButtonClick (ActionEvent actionEvent) throws IOException {
        String nameToAdd = nameInput.getText();
        if (!isNameTaken(nameToAdd)) {
            tryAgain.setVisible(false);
            switchToScene2();
        } else {
            tryAgain.setVisible(true);
            System.out.println("The name you entered has already been taken, please try again!");
        }
    }
}

