package com.home.jdk.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by li.ma on 2018/11/2.
 */
public class FutureDemo {

    public static void main (String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(10);

        Future<Integer> f = es.submit(() -> {
            // 长时间的任务计算
            Thread.sleep(10000);
            // 返回结果
            return 100;
        });

// 做一些其他操作

// ....
        Integer result = f.get();
        System.out.println(result);
//        while (f.isDone()) {

//            System.out.println(result);

//        }


    }
}
