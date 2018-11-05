package com.home.jdk.classLoader;

/**
 * Created by li.ma on 2018/8/3.
 */
public class ClassLoaderDemo {
    public static void main(String[] args) {
        Thread thread = new Thread();

        thread.setContextClassLoader(ClassLoader.getSystemClassLoader());  // 线程设置单独的类加载器


    }
}
