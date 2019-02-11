package com.client;
import com.client.Controller.TestRunnableClientTester;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    static String host = "localhost";
    static int port = 3345;

    public static void main(String[] args) throws IOException, InterruptedException {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        exec.execute(new TestRunnableClientTester(host,port));
    }
}