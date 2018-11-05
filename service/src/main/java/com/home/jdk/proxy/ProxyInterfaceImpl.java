package com.home.jdk.proxy;

/**
 * Created by li.ma on 2018/7/30.
 */
public class ProxyInterfaceImpl implements  ProxyInterface{

    @Override
    public void say(String name) {
        System.out.println(name);
    }
}
