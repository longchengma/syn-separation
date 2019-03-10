package com.home.designPattern.proxy;

/**
 * Created by li.ma on 2019/3/4.
 */
public class NormalHome implements ProxyInterface {
    @Override
    public void marry() {
        System.out.println("我们结婚啦～");
    }
}
