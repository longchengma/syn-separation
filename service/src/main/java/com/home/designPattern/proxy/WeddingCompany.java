package com.home.designPattern.proxy;

/**
 * Created by li.ma on 2019/3/4.
 */
public class WeddingCompany implements ProxyInterface{
    private ProxyInterface proxyInterface;

    public WeddingCompany(ProxyInterface proxyInterface) {
        this.proxyInterface = proxyInterface;
    }

    @Override
    public void marry() {
        System.out.println("可以开始结婚了");
        proxyInterface.marry();
        System.out.println("完毕，我们需要做后续处理，你们可以回家了，其余的事情我们公司来做");
    }
}
