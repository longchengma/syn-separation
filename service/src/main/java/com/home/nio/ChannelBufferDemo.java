package com.home.nio;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by li.ma on 2018/8/23.
 */
public class ChannelBufferDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:/brand_name.txt");

        ByteBuffer byteBuffer = ByteBuffer.allocate(8192);

        FileChannel channel = fileInputStream.getChannel();

        int reads = -1;

        do {
            reads = channel.read(byteBuffer);
            if (reads != -1) {
                byteBuffer.flip();
                byte[] array = new byte[reads];
                byteBuffer.get(array);
                byteBuffer.clear();

                System.out.println(new String(array, "UTF-8"));
            }

        } while (reads > 0);

        byteBuffer.clear();
        IOUtils.closeQuietly(channel);
        IOUtils.closeQuietly(fileInputStream);
    }
}
