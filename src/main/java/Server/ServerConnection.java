package Server;

import java.io.*;
import java.net.*;
import java.util.*;

public class ServerConnection {
    private static List<ClientController> clients = new ArrayList<>();
    private static Set<String> connectedNames = new HashSet<>();

    public static void main(String[] args) {
        int serverPort = 8080;

        try {
            ServerSocket serverSocket = new ServerSocket(serverPort);
            System.out.println("Server is listening on port " + serverPort);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

                ClientController clientController = new ClientController(clientSocket);
                String clientName = clientController.getClientName();

                // Check if the username is already connected
                if (isUsernameConnected(clientName)) {
                    // Send a message to the client indicating that the username is taken
                    clientController.sendMessage("Username '" + clientName + "' is already connected. Please choose a different name.");
                    // Close the connection with the duplicate username
                    clientSocket.close();
                } else {
                    // Add the client to the list of connected clients
                    clients.add(clientController);
                    // Add the username to the list of connected usernames
                    connectedNames.add(clientName);

                    Thread thread = new Thread(clientController);
                    thread.start();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void broadcastMessage(String message) {
        for (ClientController client : clients) {
            client.sendMessage(message);
        }
    }

    private static boolean isUsernameConnected(String username) {
        return connectedNames.contains(username);
    }
}
