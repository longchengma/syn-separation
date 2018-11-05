package com.home.nio;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by li.ma on 2018/8/23.
 *
 * 使用直接内存 读取文件
 */
public class MapperByteBufferDemo {

    public static void main(String[] args) throws IOException {
        test();

        test1();
    }

    // 直接内存读取大文件
    public static void test1() throws IOException {

    }

    // 直接内存读取文件
    public static void test () throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:/brand_name.txt");
        FileChannel channel = fileInputStream.getChannel();
        MappedByteBuffer mappedBuf = channel.map(FileChannel.MapMode.READ_ONLY, 0 , channel.size());   // 直接内存申请

        boolean end = false;
        do {
            int limit = mappedBuf.limit();
            int position = mappedBuf.position();
            if (position >= limit) {
                end = true;
            }

            int maxSize = 2048;
            if (limit - position < maxSize) {
                maxSize = limit - position;
            }

            byte[] array = new byte[maxSize];
            mappedBuf.get(array);
            System.out.print(new String(array, "UTF-8"));

        } while (!end);

        mappedBuf.clear();
        IOUtils.closeQuietly(channel);
        IOUtils.closeQuietly(fileInputStream);
    }
}
