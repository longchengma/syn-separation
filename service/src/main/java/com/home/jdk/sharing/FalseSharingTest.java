package com.home.jdk.sharing;

/**
 * Created by li.ma on 2018/8/9.
 *
 * Java与CPU缓存是如何亲密接触的
 * https://mp.weixin.qq.com/s/ODJqoiHYwAhRCMnVjunsbQ
 *
 *
 * CPU缓存   注解见类  SharingLong
 */
public class FalseSharingTest {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            benchmark();
        }
    }

    public static void benchmark() throws InterruptedException {
        int size = Runtime.getRuntime().availableProcessors();
        System.out.println(size);
        SharingLong[] shares = new SharingLong[size];
        for (int i = 0; i < size; i++) {
            shares[i] = new SharingLong();
        }

        Thread[] threads = new Thread[size];
        for (int i = 0; i < size; i++) {
            threads[i] = new LingThread(shares, i);
        }

        for (Thread t : threads) {
            t.start();
        }

        long start = System.currentTimeMillis();
        for (Thread t : threads) {
            t.join();
        }
        long end = System.currentTimeMillis();
        System.out.printf("total costs %dms\n", end - start);
    }
}
