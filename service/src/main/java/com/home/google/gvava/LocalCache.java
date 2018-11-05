package com.home.google.gvava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocalCache {
    private static final Logger logger = LoggerFactory.getLogger(LocalCache.class);
    private LoadingCache<String, Object> localCache = null;

    public LocalCache() {
    }

    public void init(String name, int refreshTime, TimeUnit unit, final LocalCacheCallback callback) {
        logger.info("local cache init finish, sevice name:{}, refresh time:{}, time unit:{} ", new Object[]{name, Integer.valueOf(refreshTime), unit});
        ThreadFactory threadFactory = (new ThreadFactoryBuilder()).setNameFormat(name + "-cache-reload-pool-%d").setDaemon(true).build();
        ExecutorService parentExecutor = Executors.newSingleThreadExecutor(threadFactory);
        final ListeningExecutorService executorService = MoreExecutors.listeningDecorator(parentExecutor);
        this.localCache = CacheBuilder.newBuilder().refreshAfterWrite((long)refreshTime, unit).build(new CacheLoader<String, Object>() {
            public Object load(String key) throws Exception {
                LocalCache.logger.info("init load cache, key : {} ", key);

                try {
                    return callback.load(key, null);
                } catch (Exception var3) {
                    LocalCache.logger.error("exception happend when init load cache failed, key:{}, ex:{} ", key, var3);
                    throw var3;
                }
            }

            public ListenableFuture reload(final String key, final Object oldvalue) throws Exception {
                return executorService.submit(new Callable<Object>() {
                    public Object call() throws Exception {
                        LocalCache.logger.info("reload for cache refresh, key : {} ", key);

                        try {
                            return callback.load(key, oldvalue);
                        } catch (Exception var2) {
                            LocalCache.logger.error("exception happend when reload for cache refresh, key:{}, ex:{} ", key, var2);
                            throw var2;
                        }
                    }
                });
            }
        });
        logger.info("local cache init finish, sevice name:{}, refresh time:{}, time unit:{} ", new Object[]{name, Integer.valueOf(refreshTime), unit});
    }

    public Object get(String key) {
        try {
            return this.localCache.get(key);
        } catch (Exception var3) {
            logger.error("exception happend when query local cache, key:{}, ex:{} ", key, var3);
            return null;
        }
    }
}


interface LocalCacheCallback {
    Object load(String var1, Object var2) throws Exception;
}
