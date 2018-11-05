package com.home.jdk.future;

import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * Created by li.ma on 2018/11/2.
 * begin:1541165361111
 开始耗时计算:1541165361112
 end:1541165361112
 结束耗时计算:1541165364113
 计算结果:100
 */
public class NettyFutureDemo {
    public static void main (String[] args) throws InterruptedException {
        EventExecutorGroup group = new DefaultEventExecutorGroup(4); // 4 threads
        System.out.println("begin:" + new Date().getTime());
        Future<Integer> f = group.submit(
                new  Callable<Integer>() {
                        @Override
                        public Integer call() throws Exception {
                            System.out.println("开始耗时计算:" + new Date().getTime());
                            Thread.sleep(3000);
                            System.out.println("结束耗时计算:" + new Date().getTime());
                            return 100;
                        }
                });

        f.addListener(new FutureListener<Object>(){
                @Override
                public void operationComplete(Future<Object> objectFuture)  throws Exception {
                    System.out.println("计算结果:" + objectFuture.get());
                }
        });

        System.out.println("end:" + new Date().getTime());
        new CountDownLatch(1).await(); //不让守护线程退出
    }
}
