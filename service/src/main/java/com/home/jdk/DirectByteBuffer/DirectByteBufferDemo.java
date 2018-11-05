package com.home.jdk.DirectByteBuffer;

import java.nio.ByteBuffer;

/**
 * Created by li.ma on 2018/8/8.
 *
 *
 * -XX:MaxDirectMemorySize=1G
 */
public class DirectByteBufferDemo {
    public static void main(String[] args) {
        ByteBuffer allocate = ByteBuffer.allocate(1024);   // 申请堆内内存


        allocate.put(0, (byte)2);
        allocate.put(1, (byte)4);
        allocate.put(2, (byte)5);
        allocate.put(3, (byte)6);

        allocate.flip();

        System.out.println(allocate.get(1));

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);  // 申请堆外内存

        //allocate.
        byteBuffer.put((byte)12);

        byteBuffer.flip();
        byte b = byteBuffer.get();
        System.out.println(b);
    }
}
