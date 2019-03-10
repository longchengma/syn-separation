package com.home.jdk.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by li.ma on 2019/2/19.
 */
public class CompleteFutrueDemo {
    public static void main(String[] args) {
        ExecutorService executor0 = Executors.newWorkStealingPool();

        ExecutorService executor1 = Executors.newWorkStealingPool();

        // 当这两个 future 完成时结束
        CompletableFuture<String> waitingForAll = CompletableFuture.allOf(CompletableFuture.supplyAsync(() -> "first"), CompletableFuture.supplyAsync(() -> "second", executor1))
                                                                    .thenApply(ignored -> " is completed.");

        CompletableFuture<Void> future = CompletableFuture.supplyAsync(()->"Concurrency Refcard" , executor0 )// 使用同一个 executor
                                                            .thenApply(result -> "Java " + result)// 使用不同的 executor
                                                            .thenApplyAsync(result -> "Dzone " + result, executor1)// 当前与其他 future 完成后结束
                                                            .thenCombine(waitingForAll, (first, second) -> first + second)// 默认使用 ForkJoinPool#commonPool 作为 executor
                                                            .thenAcceptAsync(result ->
                                                                System.out.println("Result is '" + result + "'.")
                                                            )// 通用处理
                                                            .whenComplete((ignored, exception) -> {
                                                                if (exception != null) exception.printStackTrace();
                                                            });  // 第一个阻塞调用：在 future 完成前保持阻塞

        future.join();
        // 在当前线程(main)中执行
        future.thenRun(() -> System.out.println("Current thread is '" + Thread.currentThread().getName() + "'."))  // 默认使用 ForkJoinPool#commonPool 作为 executor
                .thenRunAsync(()->System.out.println("Current thread is '"+Thread.currentThread().getName() + "'."));
    }
}
