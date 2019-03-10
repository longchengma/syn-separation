package com.home.jdk.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * Created by li.ma on 2019/2/19.
 */
public class InterruptDemo {

    private static Object lock = new Object();

    public static void main(String[] args) {
        Thread tt = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (lock) {
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    System.out.println("printStackTrace begin");
                    e.printStackTrace();
                    System.out.println("printStackTrace end");
                }
                System.out.println("interrupt end");

            }
        });

        tt.start();


        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tt.interrupt();
    }

}
