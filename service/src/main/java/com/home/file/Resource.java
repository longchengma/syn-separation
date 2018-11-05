package com.home.file;

import java.io.File;
import java.io.IOException;

/**
 * Created by li.ma on 2018/8/3.
 */
public class Resource {
    public static void main(String[] args) throws IOException {
        System.out.println(new File("D://brand_name.txt").getCanonicalFile());

        System.out.println(new File("D://brand_name.txt").getAbsolutePath());

        System.out.println(new File("D://brand_name.txt").getPath());


        File file1 = new File("..\\file\\ResourceTest.class");
        System.out.println(file1.getPath());
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getCanonicalFile());
    }
}
