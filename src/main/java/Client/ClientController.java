package Client;

import java.io.*;
import java.net.*;

public class ClientController implements Runnable {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public ClientController(Socket clientSocket) {
        this.clientSocket = clientSocket;
        try {
            // Create output stream to send data to the server
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Create input stream to receive data from the server
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            // Implement the run method to handle client interactions here

            String message;
            while ((message = in.readLine()) != null) {
                // Print server responses to the console
                System.out.println("Server Response: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void sendMessage(String message) {
        // Send a message to the server
        out.println(message);
    }

    public void closeConnection() {
        try {
            // Close the client socket when done
            if (clientSocket != null) {
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
