package com.home.jdk.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by li.ma on 2018/6/28.
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(2);

                    countDownLatch.countDown();

                    System.out.println("不用等待，继续执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }).start();


        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);

                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);

                countDownLatch.countDown();


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        try {
            countDownLatch.await();

            System.out.println("结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
