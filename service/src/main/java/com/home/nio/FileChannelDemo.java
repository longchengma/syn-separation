package com.home.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by li.ma on 2018/8/16.
 */
public class FileChannelDemo {
    public static void main(String[] args) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("D:/brand_name.txt", "rw");

        FileChannel channel = aFile.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        int read = channel.read(buffer);


    }
}
