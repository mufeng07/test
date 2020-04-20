package com.mufeng.test.chat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) {
       Socket socket;
        DataOutputStream dataOutputStream;
        try {
            socket = new Socket("127.0.0.1", 8888);
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            System.out.println("连上服务端");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
