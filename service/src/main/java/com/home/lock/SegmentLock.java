package com.home.lock;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by li.ma on 2018/6/8.
 */
public class SegmentLock<T> {
    private Integer segments = 16;

    private final HashMap<Integer, ReentrantLock> lockMap = new HashMap();


    public SegmentLock() {
        init(null, false);
    }

    public SegmentLock(Integer count, boolean fair) {
        init(count, false);
    }

    private void init(Integer count, boolean fair) {
        if(count != null) {
            segments = count;
        }

        for (int i = 0; i < segments; i++) {
            lockMap.put(i, new ReentrantLock(fair));
        }
    }



    public void lock(T key) {
        ReentrantLock lock = lockMap.get(key.hashCode() % segments);

        lock.lock();
    }

    public void unlock(T key) {
        ReentrantLock lock = lockMap.get(key.hashCode() % segments);

        lock.unlock();
    }
}
