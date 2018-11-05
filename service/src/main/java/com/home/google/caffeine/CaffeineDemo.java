package com.home.google.caffeine;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by li.ma on 2018/9/22.
 */
public class CaffeineDemo {
    public static void main(String[] args) {
        Cache<String, Object> manualCache = Caffeine.newBuilder()
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .maximumSize(10_000)
                .build();

        String key = "name1";
// 根据key查询一个缓存，如果没有返回NULL
        Object graph = manualCache.getIfPresent(key);


        System.out.println(graph);

// 根据Key查询一个缓存，如果没有调用createExpensiveGraph方法，并将返回值保存到缓存。
// 如果该方法返回Null则manualCache.get返回null，如果该方法抛出异常则manualCache.get抛出异常
        graph = manualCache.get(key, k -> createExpensiveGraph(k));
// 将一个值放入缓存，如果以前有值就覆盖以前的值
        manualCache.put(key, graph);

        System.out.println(manualCache.asMap());

// 删除一个缓存
        manualCache.invalidate(key);

        ConcurrentMap<String, Object> map = manualCache.asMap();

        System.out.println(map);
    }

    private static Object createExpensiveGraph(String k) {
        return "jiajia";
    }
}
