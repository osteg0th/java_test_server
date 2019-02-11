package com.server;

import com.server.Controller.MultiThreadServer;

public class Main {
    private static final int port = 3345;

    public static void main(String[] args) {
        MultiThreadServer server = new MultiThreadServer();
        server.StartServer(port);
    }
}
