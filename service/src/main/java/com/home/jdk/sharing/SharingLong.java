package com.home.jdk.sharing;

/**
 * Created by li.ma on 2018/8/9.
 *
 *
 *
 * 首先我们来计算一下SharingLong对象占用的内存空间，我们不考虑64位的情景，
 * Java的对象都有一个2个word的头部，第一个word存储对象的hashcode和一些特殊的位标志，如GC的分代年龄、偏向锁标记等，
 * 第二个word存储对象的指针地址，一个word就是32位。
 * 然后加上v和6个p变量，
 *
 * 总共就是8个long的长度，也就是64字节。   正好对应现代CPU的缓存行
 */
public class SharingLong {
    volatile long v;
    long p1, p2, p3, p4, p5, p6;   // 加上这六个long型变量，则会时间效率增长一个数量级   空间换取的时间              ------缓存行填充


    // 所以现代的CPU缓存一般是分行存储的，最小处理单位是一个行，这个行的长度一般来说就是上文提到的64字节，我们称之为【缓存行】

    // 同一个缓存行是存在竞争的，不同的缓存行是不存在竞争的
}
