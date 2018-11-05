package com.home.jdk.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Created by li.ma on 2018/9/19.
 */
public class ServiceLoaderDemo {
    public static void main(String[] args) {
        ServiceLoader<Developer> serviceloader = ServiceLoader.load(Developer.class);


        Iterator<Developer> iterator = serviceloader.iterator();
        while (iterator.hasNext()) {
            Developer next = iterator.next();

            System.out.println(next.getClass().getName());
        }
    }
}
