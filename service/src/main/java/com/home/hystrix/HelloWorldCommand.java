package com.home.hystrix;

import com.netflix.hystrix.*;

public class HelloWorldCommand extends HystrixCommand<String> {
    private final String name;

    public HelloWorldCommand(String name) {

        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))                // //最少配置:指定命令组名(CommandGroup)
                .andCommandKey(HystrixCommandKey.Factory.asKey("query"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("ExampleThreadPool"))
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(20))             //服务线程池数量
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withCircuitBreakerErrorThresholdPercentage(60)             //熔断器关闭到打开阈值
                        .withCircuitBreakerSleepWindowInMilliseconds(3000)          //熔断器打开到关闭的时间窗长度
                        .withCircuitBreakerForceOpen(false)
                ));

        //circuitBreakerForceOpen
        this.name = name;
    }

    @Override
    protected String run() {         // 依赖逻辑封装在run()方法中

        return "Hello " + name + ", thread: " + Thread.currentThread().getName();
    }
}
