package com.server.Controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadServer {
    private static ExecutorService executeIt = Executors.newFixedThreadPool(2);

    public void StartServer(int port) {
        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server socket created, waiting for client...");

            while (!server.isClosed()) {
                Socket client = server.accept();
                executeIt.execute(new MonoThreadClientHandler(client));
                System.out.print("Connection accepted.");
            }
            executeIt.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}