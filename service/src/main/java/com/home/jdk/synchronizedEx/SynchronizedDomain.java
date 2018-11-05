package com.home.jdk.synchronizedEx;

import java.util.concurrent.TimeUnit;

/**
 * Created by li.ma on 2018/8/28.
 */
public class SynchronizedDomain extends  Thread{
    public synchronized void say() throws InterruptedException {
        TimeUnit.SECONDS.sleep(20);
    }

    public synchronized void talk() throws InterruptedException {
        TimeUnit.SECONDS.sleep(20);
    }

    @Override
    public void run() {

    }
}
