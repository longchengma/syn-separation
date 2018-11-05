package com.home.designPattern.adapter;

/**
 * Created by li.ma on 2018/7/21.
 */
public class AdapterEx implements TargetInterface {
    BeAdapted adapted;   // Adapter与BeAdapted是委托关系，即为对象适配器模式

    public AdapterEx(BeAdapted adapted){    // 构造方法，接收一个BeAdapted引用作为参数
        this.adapted = adapted;
    }

    @Override
    public void method1() {
        adapted.method1();
    }

    @Override
    public void method2() {
        System.out.println("method2");
    }
}
