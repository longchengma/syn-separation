package com.home.jdk.enumDemo;

/**
 * Created by li.ma on 2018/8/2.
 */
public class EnumTest {
    public static void main(String[] args) {
        T t = T.AUTUMN;

        System.out.println(t.name());

        t = T.valueOf("WINTER");

        System.out.println(T.values().length);

        System.out.println(t.name());
    }
}
