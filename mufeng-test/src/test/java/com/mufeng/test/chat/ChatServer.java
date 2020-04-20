package com.mufeng.test.chat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static void main(String[] args) {
        //是否成功启动服务端
        Boolean isStart=false;
        ServerSocket ss=null;
        // 客户端socket
        Socket socket = null;
        // 服务端读取客户端数据输入流
        DataInputStream dataInputStream = null;
        try {
            ss=new ServerSocket(8080);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("端口在使用中");
            System.exit(0);
        }
        try {
            isStart=true;
            while (isStart){
                boolean isConnection=false;
                socket=ss.accept();
                System.out.println("one client");
                isConnection=true;
//                while (isConnection){
//                    dataInputStream=new DataInputStream(socket.getInputStream());
//                    System.out.println(dataInputStream.readUTF());
//                }
            }
        } catch (IOException e) { e.printStackTrace();
        }finally {
            try {
                socket.close();
                dataInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
