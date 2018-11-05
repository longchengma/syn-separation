package com.home.threadpool.forkJoinPool;

import java.math.BigInteger;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * Created by li.ma on 2018/8/15.
 */
public class ForkJoinPoolDemo {
    public static void main(String[] args) {
        ForkJoinPool pool = ForkJoinPool.commonPool();

        BigInteger result = pool.invoke(new FactorialTask(100));

        /*ForkJoinTask<?> submit = pool.submit(() -> {
            System.out.println("");
        });
        submit.isDone();*/
    }
}