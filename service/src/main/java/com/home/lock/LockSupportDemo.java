package com.home.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by li.ma on 2018/6/12.
 */
public class LockSupportDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                //LockSupport.park();



                //LockSupport.parkNanos(this, 4000000000L);

                //LockSupport.parkNanos(4000000000L);    // 毫秒、微秒、纳秒    这个时间是相对时间，而下面一行方法参数是绝对时间
                LockSupport.parkUntil(1529574837000L);  // 在deadline时刻线程自动执行（这个毫秒就是自1970年1月1号0时起的毫秒数）

                System.out.println(Thread.currentThread().getName());
            }
        }, "thread0");

        thread.start();

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                LockSupport.park();
                System.out.println(Thread.currentThread().getName());
            }
        }, "thread1");

        thread1.start();
        TimeUnit.SECONDS.sleep(100);
        thread.interrupt();

        TimeUnit.SECONDS.sleep(200);

        LockSupport.unpark(thread1);

        LockSupport.unpark(thread);
    }
}
