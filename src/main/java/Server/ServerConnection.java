package Server;

import Client.ClientController;

import java.io.*;
import java.net.*;
import java.util.*;

public class ServerConnection {
    public static void main(String[] args) {
        int serverPort = 8080; // Port number the server will listen on

        try {
            ServerSocket serverSocket = new ServerSocket(serverPort);
            System.out.println("Server is listening on port " + serverPort);

            List<ClientController> clients = new ArrayList<>();

            while (true) {
                // Accept incoming client connections
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

                // Create a new ClientController to handle the client
                ClientController clientController = new ClientController(clientSocket);
                Thread thread = new Thread(clientController);
                thread.start();
                clients.add(clientController);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
