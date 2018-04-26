package com.sun.jojo.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class BufferDemo {
    public static void main(String[] agrs) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("/Users/sunjiamin/Desktop/笔记.txt","rw");
        FileChannel inChannel = randomAccessFile.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(1024);
        Charset.forName("UTF-8").newDecoder().decode(buf).toString();
        buf.flip();
        int byteRead = inChannel.read(buf);
        System.out.println(randomAccessFile.length());

        while( byteRead != -1 ){
            //缓冲区从写模式切换到读模式
            buf.flip();
            //( hasRemaining() )Tells whether there are any elements between the current position and the limit.
            //while( buf.hasRemaining() ){
              //  System.out.print((char) buf.get());
            //}
            byte[] reads = new byte[buf.remaining()];
            buf.get(reads);
            System.out.println(" " + new String(reads));
            buf.clear();
            byteRead = inChannel.read(buf);

        }
        randomAccessFile.close();

    }

}
