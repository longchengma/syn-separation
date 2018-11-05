package com.home.nio;

import org.apache.commons.io.IOUtils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by li.ma on 2018/8/23.
 */
public class BufferISDemo {

    public static void main(String[] args) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("D:/brand_name.txt"), 8192);

        int bytes = -1;

        do {
            byte[] tempArray = new byte[8192];

            bytes = bufferedInputStream.read(tempArray);

            if (bytes != -1) {
                System.out.println(new String(tempArray, "UTF-8"));

            }
        } while (bytes > 0);


        IOUtils.closeQuietly(bufferedInputStream);
    }
}
