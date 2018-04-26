package com.sun.jojo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
    public static void main(String[] agrs) throws IOException {


        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress(9090));
        ByteBuffer byteBuffer =ByteBuffer.allocate(1024);
        socketChannel.read(byteBuffer);
        byte[] reads = new byte[byteBuffer.remaining()];
        System.out.println(new String(reads));

    }
}
