package com.home.spring.aop;

/**
 * Created by li.ma on 2018/8/8.
 */
public class HelloWorldService  implements IHelloWorldService {
    @Override
    public void sayHello() {
        System.out.println("============Hello World!");
    }
}
