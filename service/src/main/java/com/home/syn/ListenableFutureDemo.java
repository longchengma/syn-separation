package com.home.syn;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by li.ma on 2018/6/22.
 */
public class ListenableFutureDemo {
    public static void main(String[] args) {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("111-cache-reload-pool-%d").setDaemon(false).build();
        ExecutorService parentExecutor = Executors.newSingleThreadExecutor(threadFactory);
        final ListeningExecutorService executorService = MoreExecutors.listeningDecorator(parentExecutor);



        ListenableFuture listenableFuture = executorService.submit(() -> {
            System.out.println("任务开始执行");
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("任务执行完成");
        });


        listenableFuture.addListener(()->{
            System.out.println("listener has already run");
        }, parentExecutor);




    }
}
