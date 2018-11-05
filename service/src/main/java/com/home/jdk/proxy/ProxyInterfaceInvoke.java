package com.home.jdk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by li.ma on 2018/7/30.
 */
public class ProxyInterfaceInvoke implements InvocationHandler {
    private Object target;

    public ProxyInterfaceInvoke(Object target) {
        this.target = target;
    }


    public Object getIntance() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), this.target.getClass().getInterfaces(), this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before");

        Object result = method.invoke(target, args);

        System.out.println("after");

        return result;
    }


    public static void main(String[] args) {

        ProxyInterfaceInvoke interfaceInvoke = new ProxyInterfaceInvoke(new ProxyInterfaceImpl());


        ProxyInterface proxy = (ProxyInterface)interfaceInvoke.getIntance();

        proxy.say("say method");
    }
}
