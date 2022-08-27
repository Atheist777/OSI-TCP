package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class ServerApp {
    public static void main(String[] args) {
        int port = 8090;

        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket socket = serverSocket.accept();
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println("New connection accepted");

            String name = in.readLine();

            out.println(String.format("Hi %s, your port is %d", name));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
