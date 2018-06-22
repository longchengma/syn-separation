package com.home.jdk;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by li.ma on 2018/6/12.
 */
public class AtomicIntegerTest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(2);

        System.out.println(atomicInteger.get());


        //atomicInteger.decrementAndGet();

        //atomicInteger.addAndGet(2);

        System.out.println(atomicInteger.getAndAdd(4));

        System.out.println(atomicInteger.get());
    }
}
