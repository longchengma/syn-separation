package com.home.jdk;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by li.ma on 2018/6/25.
 */
public class MathDemo {
    public static void main(String[] args) {
        System.out.println(ctlOf(4, 3));

        System.out.println(Integer.toBinaryString(ctl.get() & CAPACITY));//1011 二进制


        System.out.println(ctl.get());

    }

    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

    private static final int RUNNING    = -1 << COUNT_BITS;



    private final static AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));


    private static int ctlOf(int rs, int wc) { return rs | wc; }


    private static int runStateOf(int c)     { return c & ~CAPACITY; }
}
