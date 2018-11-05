package com.home.jdk.thread;

/**
 * Created by li.ma on 2018/7/23.
 */
public class UncaughtExceptionHandlerThread extends Thread{
    @Override
    public void run() {
        String j = null;

        j.toUpperCase();
    }
}
