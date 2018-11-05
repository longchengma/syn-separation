package com.home.google.gvava.eventBus;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.util.concurrent.Executors;

/**
 * Created by li.ma on 2018/8/27.
 */
public class EventBusDemo {
    public static void main(String[] args) {
        testEventBus();

        //testAsyncEventBus();
    }

    /**
     * ThreadLocal<Queue<EventAndHandler>>
     *
     * 1、register 注册一个类似map的结构，键值为方法参数类型、值为Event对象和反射方法的封装对象
     *
     * 2、post 则通过方法参数类型找相应的封装对象
     *
     * 3、通过封装对象，反射方法的同步执行
     */
    public static void testEventBus() {
        EventBus eventBus = new EventBus();
        eventBus.register(new Event());
        eventBus.register(new Event());
        eventBus.post("I am you");
    }

    /**
     * 并发队列存储发布者，线程池来消费
     *
     * 和上述方法的区别就是，
     */
    public static void testAsyncEventBus() {
        AsyncEventBus asyncEventBus = new AsyncEventBus(Executors.newFixedThreadPool(3));

        asyncEventBus.register(new Event());

        asyncEventBus.post("async   yes");

        System.out.println("---------------------------------");
    }

    /**
     * Event @subscribe 的方法参数和post方法的参数类型不一致，则无法消费
     */
    public static void testDeadEvent() {
        EventBus eventBus = new EventBus();

        eventBus.register(new Event());

        eventBus.post(23333);
    }
}
