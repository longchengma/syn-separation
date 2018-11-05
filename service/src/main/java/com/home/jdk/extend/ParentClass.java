package com.home.jdk.extend;

/**
 * Created by li.ma on 2018/8/2.
 */
public class ParentClass {
    public void say() {
        System.out.println("parent say");
        this.talk();
    }

    public void talk(){
        System.out.println("parent talk");
    }
}
