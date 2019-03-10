package com.home.designPattern.proxy;

/**
 * Created by li.ma on 2019/3/4.
 */
public class ProxyDemo {
    public static void main(String[] args) {
        ProxyInterface proxyInterface = new WeddingCompany(new NormalHome());
        proxyInterface.marry();
    }
}
