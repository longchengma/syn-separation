package com.home.jdk.file;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;

/**
 * Created by li.ma on 2018/8/14.
 */
public class FileChannelDemoEx {
    public static void main(String[] args) throws IOException {
        FileChannel channel = FileChannel.open(Paths.get("D:/brand_name.txt"));

        //channel.lock();
        channel.tryLock(0, Integer.MAX_VALUE, true);

        System.out.println("lock complete! ");
    }
}
