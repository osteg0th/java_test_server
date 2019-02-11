package com.client.Controller;

import com.client.Model.MyData;
import com.client.View.View;

import java.io.*;
import java.net.Socket;

public class TestRunnableClientTester implements Runnable {

    private static Socket socket;
    public TestRunnableClientTester(String host, int port) {
            try {
            // создаём сокет общения на стороне клиента в конструкторе объекта
            socket = new Socket(host, port);
            System.out.println("Client connected to socket");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                DataOutputStream oos = new DataOutputStream(socket.getOutputStream());
                DataInputStream ois = new DataInputStream(socket.getInputStream()))
        {
            System.out.println("Client DataOutputStream & DataInputStream initialized");
            MyData myData = new MyData();
            View view = new View();
            while(!socket.isOutputShutdown()){
                view.PrintMenu();
                String clientCommand = br.readLine();
                oos.writeUTF(clientCommand);
                oos.flush();
                myData.setData(ois.readUTF());
                view.PrintResult(myData.getData());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}