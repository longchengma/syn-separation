package com.home.jdk.queue;

import java.util.concurrent.SynchronousQueue;

/**
 * Created by li.ma on 2018/6/26.
 * SynchronousQueue 是一个普通用户不怎么常用的队列，通常在创建无界线程池（Executors.newCachedThreadPool()）的时候使用，
 * 也就是那个非常危险的线程池 ^_^。

 它是一个非常特殊的阻塞队列，他的模式是：在 offer的时候，如果没有另一个线程在 take 或者 poll 的话，就会失败，
 反之，如果在 take或者 poll的时候，没有线程在offer ，则也会失败，

 而这种特性，则非常适合用来做高响应并且线程不固定的线程池的Queue。所以，在很多高性能服务器中，
 如果并发很高，这时候，普通的 LinkedQueue就会成为瓶颈，性能就会出现毛刺，当换上 SynchronousQueue后，性能就会好很多。
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        SynchronousQueue queue = new SynchronousQueue();

        try {
            queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
