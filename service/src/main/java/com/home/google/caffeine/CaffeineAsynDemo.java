package com.home.google.caffeine;

import com.github.benmanes.caffeine.cache.AsyncLoadingCache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by li.ma on 2018/9/23.
 */
public class CaffeineAsynDemo {
    public static void main(String[] args) {
        AsyncLoadingCache<String, Object> asyncLoadingCache = Caffeine.newBuilder()
                .maximumSize(10_000)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                        // Either: Build with a synchronous computation that is wrapped as asynchronous
                .buildAsync(key -> createExpensiveGraph(key));
        // Or: Build with a asynchronous computation that returns a future
        // .buildAsync((key, executor) -> createExpensiveGraphAsync(key, executor));

        String key = "name1";

// 查询并在缺失的情况下使用异步的方式来构建缓存
        CompletableFuture<Object> graph = asyncLoadingCache.get(key);
// 查询一组缓存并在缺失的情况下使用异步的方式来构建缓存

        List<String> keys = new ArrayList<>();
        keys.add(key);
        CompletableFuture<Map<String, Object>> graphs = asyncLoadingCache.getAll(keys);
// 异步转同步
        LoadingCache loadingCache = asyncLoadingCache.synchronous();

    }

    private static Object createExpensiveGraph(String key) {
        return "test-------------";
    }
}
