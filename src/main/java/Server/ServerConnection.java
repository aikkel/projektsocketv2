package Server;

import java.io.*;
import java.net.*;

public class ServerConnection {
    public static void main(String[] args) {
        int serverPort = 8080; //Port number the server will listen on

        try {
            ServerSocket serverSocket = new ServerSocket(serverPort);
            System.out.println("Server is listening on port " + serverPort);

            while (true) {
                //Accept incoming client connections
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

                //Create input and output streams for reading and writing data
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                //Read data from the client
                String clientMessage = in.readLine();
                System.out.println("Received from client: " + clientMessage);

                //Send a response back to the client
                out.println("Hello, Client!");

                //Close the client socket
                clientSocket.close();
                System.out.println("Client disconnected");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
