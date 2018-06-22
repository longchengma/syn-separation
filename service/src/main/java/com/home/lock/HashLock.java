package com.home.lock;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by li.ma on 2018/6/8.
 */
public class HashLock<T> {
    private boolean isFair = false;

    private final SegmentLock<T> segmentLock = new SegmentLock();

    private final ConcurrentHashMap<T, LockInfo> lockMap = new ConcurrentHashMap<T, LockInfo>();

    public HashLock(){}

    public HashLock(boolean fair) {
        this.isFair = fair;
    }

    public void lock(T key) {
        LockInfo lockInfo;

        segmentLock.lock(key);

        try {
            lockInfo = lockMap.get(key);

            if (lockInfo == null) {
                lockInfo = new LockInfo(isFair);
                lockMap.put(key, lockInfo);
            } else {
                lockInfo.count.incrementAndGet();
            }
        } finally {
            segmentLock.unlock(key);
        }
        lockInfo.lock();
    }

    public void unlock(T key) {
        LockInfo lockInfo = lockMap.get(key);

        if (lockInfo.count.get() == 1) {
            segmentLock.lock(key);

            try {
                if (lockInfo.count.get()== 1) {
                    lockMap.remove(key);
                }
            } finally {
                segmentLock.unlock(key);
            }
        }
        lockInfo.count.decrementAndGet();
        lockInfo.unlock();
    }

    public static class LockInfo {
        public ReentrantLock lock;

        public AtomicInteger count = new AtomicInteger(1);

        private LockInfo(boolean fair){
            this.lock = new ReentrantLock(fair);
        }

        public void lock() {
            this.lock.lock();
        }

        public void unlock() {
            this.lock.unlock();
        }
    }
}
