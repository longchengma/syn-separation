package com.home.spring.aop;

/**
 * Created by li.ma on 2018/8/8.
 */
public class HelloWorldAspect {
    public void beforeAdvice() {
        System.out.println("===========before advice");
    }

    //后置最终通知
    public void afterFinallyAdvice() {
        System.out.println("===========after finally advice");
    }
}
