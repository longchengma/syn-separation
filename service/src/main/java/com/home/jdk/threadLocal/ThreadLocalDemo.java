package com.home.jdk.threadLocal;

/**
 * Created by li.ma on 2018/7/20.
 */
public class ThreadLocalDemo {

    private static ThreadLocal<String> localStr = new ThreadLocal<String>();

    private static ThreadLocal<String> localStrEx = new ThreadLocal<String>();

    public static void main(String[] args) {
        localStr.set("this local string");

        localStr.get();
    }
}
