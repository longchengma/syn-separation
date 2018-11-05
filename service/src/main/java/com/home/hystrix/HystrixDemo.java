package com.home.hystrix;

import com.alibaba.fastjson.JSON;
import com.netflix.hystrix.HystrixCommand;
import org.apache.commons.lang.math.RandomUtils;
import rx.Observable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by li.ma on 2018/6/29.
 */
public class HystrixDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        //每个Command对象只能调用一次,不可以重复调用
        HelloWorldCommand helloWorldCommand = new HelloWorldCommand("Synchronous-hystrix");

        //使用execute()同步调用代码,效果等同于:helloWorldCommand.queue().get();
        String result = helloWorldCommand.execute();
        System.out.println("result = " + result);

        helloWorldCommand = new HelloWorldCommand("Asynchronous-hystrix");
        //异步调用,可自由控制获取结果时机,
        Future<String> future = helloWorldCommand.queue();

        future.isDone();

        //get操作不能超过command定义的超时时间,默认:1秒
        result = future.get(100, TimeUnit.MILLISECONDS);
        System.out.println("result = " + result);
        System.out.println("mainThread = " + Thread.currentThread().getName());
    }

    /*public void timeWindowTest() throws Exception {
        Observable<Integer> source = Observable.interval(50, TimeUnit.MILLISECONDS).map(i -> RandomUtils.nextInt(2));
        source.window(1, TimeUnit.SECONDS).subscribe(window -> {
            int[] metrics = new int[2];
            window.subscribe(i -> metrics[i]++,
                    //InternalObservableUtils.ERROR_NOT_IMPLEMENTED,
                    null,
                    () -> System.out.println("窗口Metrics:" + JSON.toJSONString(metrics)));
        });
        TimeUnit.SECONDS.sleep(3);
    }*/
}
