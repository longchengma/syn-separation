package com.home.google.gvava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.concurrent.*;

/**
 * Created by li.ma on 2018/6/15.
 */
public class CacheBuilderDemo {
    private static final int CONCURRENT_NUM = 10;  // 并发数

    private volatile static int value = 1;

    private static LoadingCache<String, String> cache = CacheBuilder.newBuilder().maximumSize(1000)
            .expireAfterWrite(5, TimeUnit.SECONDS)
            .refreshAfterWrite(1, TimeUnit.SECONDS)
            .build(new CacheLoader<String, String>() {
                @Override
                public String load(String key) throws Exception {
                    System.out.println("load by " + Thread.currentThread().getName());
                    return createValue(key);
                }

                public ListenableFuture<String> reload(String key, String oldValue) throws Exception {
                    System.out.println("reload by " + Thread.currentThread().getName());
                    return Futures.immediateFuture(createValue(key));
                }
            });

    private static String createValue(String key) throws InterruptedException {
        Thread.sleep(1000L);
        return String.valueOf(value++);
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CyclicBarrier barrier = new CyclicBarrier(CONCURRENT_NUM);
        CountDownLatch latch = new CountDownLatch(CONCURRENT_NUM);

        for (int i = 0; i < CONCURRENT_NUM; i++) {
            final ClientRunnable runnable = new ClientRunnable(barrier, latch);

            Thread thread = new Thread(runnable, "client-" + i);

            thread.start();
        }

        latch.await();

        Thread.sleep(5100L);

        System.out.println( "\n超过expire时间未读之后...");
        System.out.println(Thread.currentThread().getName() + ",val:"+ cache.get("key"));
    }


    static class ClientRunnable implements Runnable {
        CyclicBarrier barrier;
        CountDownLatch latch;

        public ClientRunnable(CyclicBarrier barrier, CountDownLatch latch) {
            this.barrier = barrier;
            this.latch = latch;
        }

        public void run () {
            try {
                barrier.await();

                Thread.sleep((long) Math.random() * 4000);
                System.out.println(Thread.currentThread().getName() + ", val : " + cache.get("key"));

                latch.countDown();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
