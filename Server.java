package MultiServer;

import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;


public class Server {

    public static void main(String[] args) {
        int portNumber = 1234;
        try {
            // create server to handles all client sockets
            ServerSocket serverSocket = new ServerSocket(portNumber);

            // loop forever waiting for clients
            while (true) {
                Socket clientSocket = serverSocket.accept();
                ServerThread thread = new ServerThread(clientSocket);
                thread.start();
            }

        } catch (IOException e) {
            System.out.println("exception on port " + portNumber);
            System.out.println(e.getMessage());
        }
    }
}
