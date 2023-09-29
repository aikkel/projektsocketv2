package Server;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    private static List<String> connectedNames = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws IOException {
        int serverPort = 8080;
        ServerSocket serverSocket = new ServerSocket(serverPort);

        System.out.println("Server is listening on port " + serverPort);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

            // Handle the client in a separate thread
            ClientHandler clientHandler = new ClientHandler(clientSocket);
            Thread clientThread = new Thread(clientHandler);
            clientThread.start();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try (
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
            ) {
                String clientName = in.readLine();

                if (clientName != null) {
                    if (!connectedNames.contains(clientName)) {
                        connectedNames.add(clientName);
                        out.println("Name added successfully");
                    } else {
                        out.println("Duplicate name: " + clientName);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
