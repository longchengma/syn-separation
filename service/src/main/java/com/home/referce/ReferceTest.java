package com.home.referce;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * Created by li.ma on 2018/6/8.
 */
public class ReferceTest {
    public static void main(String[] args) throws InterruptedException {
        ReferenceQueue queue = new ReferenceQueue();

        WeakReference reference = new WeakReference(new String("2222"), queue);
        System.out.println(reference);
        System.out.println(reference.get());
        System.gc();

        System.out.println(reference.get());

        Reference reference1 = queue.remove();
        System.out.println(reference1);
    }
}
