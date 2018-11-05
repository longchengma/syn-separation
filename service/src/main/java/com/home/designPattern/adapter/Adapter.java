package com.home.designPattern.adapter;

/**
 * Created by li.ma on 2018/7/21.
 */
public class Adapter extends BeAdapted implements TargetInterface {
    @Override
    public void method2() {
        System.out.println("method2");
    }
}
