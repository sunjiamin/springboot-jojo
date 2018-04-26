package com.sun.jojo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Server {
    public static void main(String[] agrs) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.bind(new InetSocketAddress(9090));
        while(true){
            SocketChannel socketChannel = serverSocketChannel.accept();
            if(socketChannel != null){
                System.out.println("收到一个请求");
                ByteBuffer byteBuffer =ByteBuffer.allocate(1024);
                byteBuffer.put("hello".getBytes());
                socketChannel.write(byteBuffer);
            }
        }

    }
}
