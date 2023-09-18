package com.example.projektsocketv2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ChatBox extends Application {
    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ChatBox.class.getResource("login-box.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Login-Box");
        stage.setScene(scene);
        stage.show();

        setPrimaryStage(stage);

        System.out.println(getPrimaryStage());
    }

    /*public void switchToChatBox() {
        try {
            Scene scene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("chat-box.fxml"))));
            primaryStage.setScene(scene);
            primaryStage.show();
            System.out.println(primaryStage);
            System.out.println(getPrimaryStage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    } */

    public static void main(String[] args) {
        launch();
    }
}
