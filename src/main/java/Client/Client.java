package Client;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.*;
import java.net.*;
//todo mangler skriv navn, kalde navnetjekker og kalde navne sletter, multiconnect threading chat. kombabilet med FXML, connect kode til GUI
public class Client {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1"; // Replace with the actual IP address or hostname of the server
        int serverPort = 8080; // Replace with the port number the server is listening on

        try {
            Socket socket = new Socket(serverAddress, serverPort);

            // Create input and output streams for reading and writing data.
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Send data to the server
            out.println("Hello, Server!");

            try {
                // Receive data from the server
                String response = in.readLine();
                System.out.println("Server Response: " + response);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                // Close the socket when done.
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
