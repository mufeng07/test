package com.mufeng.test.base.nio;

import org.junit.Test;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Auther: mufeng
 * @Date: 2018/12/29 11:27
 */
public class TestSelector {
    @Test
    public void testSelector() throws Exception{
        //获取选择器
        Selector selector=Selector.open();
        System.out.println("selector:"+selector.isOpen());
        //获取server socket通道和注册正在使用选择器
        ServerSocketChannel ss=ServerSocketChannel.open();
        InetSocketAddress hostAddress=new InetSocketAddress("localhost",8088);
        ss.bind(hostAddress);
        ss.configureBlocking(false);
        int ops=ss.validOps();
        SelectionKey register = ss.register(selector, ops, null);
        for(;;){
            System.out.println("....");
            int select = selector.select();
            System.out.println("selected key num:"+select);
            Set selectedKeys = selector.selectedKeys();
            Iterator itr = selectedKeys.iterator();
            while (itr.hasNext()) {
                SelectionKey ky = (SelectionKey) itr.next();
                if (ky.isAcceptable()) {
                    // The new client connection is accepted
                    SocketChannel client = ss.accept();
                    client.configureBlocking(false);
                    // The new connection is added to a selector
                    client.register(selector, SelectionKey.OP_READ);
                    System.out.println("The new connection is accepted from the client: " + client);
                } else if (ky.isReadable()) {
                    // Data is read from the client
                    SocketChannel client = (SocketChannel) ky.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(256);
                    client.read(buffer);
                    String output = new String(buffer.array()).trim();
                    System.out.println("Message read from client: " + output);
                    if (output.equals("Bye Bye")) {
                        client.close();
                        System.out.println("The Client messages are complete; close the session.");
                    }
                }
                itr.remove();
            } // end of while loop
        }
        //
    }
}
