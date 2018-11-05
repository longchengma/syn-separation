package com.home.threadpool;

import java.util.concurrent.*;

/**
 * Created by li.ma on 2018/6/25.
 */
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,
        2,
        2,
        TimeUnit.SECONDS,
        new ArrayBlockingQueue<>(2)){
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("method beforeExecute excute");;
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<?> submit = executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        submit.get();


        Future<?>  future = executor.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Future<?>  future1 = executor.submit(() -> {
            try {
                TimeUnit.MINUTES.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        Future<?>  future2 = executor.submit(() -> {
            try {
                TimeUnit.MINUTES.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Future<?>  future3 = executor.submit(() -> {
            try {
                TimeUnit.MINUTES.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        ScheduledFuture<?> schedule = scheduledExecutorService.schedule(() -> {
        }, 2, TimeUnit.SECONDS);

        schedule.get();
    }
}
