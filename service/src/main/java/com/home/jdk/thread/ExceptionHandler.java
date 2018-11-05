package com.home.jdk.thread;

/**
 * Created by li.ma on 2018/7/23.
 */
public class ExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(t.getName());

        System.out.println(e.getMessage());
    }
}



