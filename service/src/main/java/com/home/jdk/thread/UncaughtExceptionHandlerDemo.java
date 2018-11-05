package com.home.jdk.thread;

/**
 * Created by li.ma on 2018/7/23.
 */
public class UncaughtExceptionHandlerDemo {

    public static void main(String[] args) {
        UncaughtExceptionHandlerThread thread = new UncaughtExceptionHandlerThread();

        thread.setUncaughtExceptionHandler(new ExceptionHandler());

        thread.start();
    }
}
