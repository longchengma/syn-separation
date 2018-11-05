package com.home.jdk.file;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Paths;

/**
 * Created by li.ma on 2018/8/14.
 */
public class FileChannelDemo {
    public static void main(String[] args) throws IOException {
        FileChannel channel = FileChannel.open(Paths.get("D:/brand_name.txt"));

        FileLock lock = channel.lock();


        FileLock fileLock = channel.tryLock(0, Integer.MAX_VALUE, false);

        System.out.println(fileLock.isShared());
    }
}
