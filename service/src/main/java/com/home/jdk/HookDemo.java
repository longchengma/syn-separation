package com.home.jdk;

/**
 * Created by li.ma on 2019/1/23.
 */
public class HookDemo {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                System.out.println("Hook begin run");
            }
        }, "DubboShutdownHook"));
    }
}
