package com.home.jdk;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by li.ma on 2018/6/20.
 */
public class IntegerDemo {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        int i = 5;

        System.out.println(Integer.numberOfLeadingZeros(i));

        /*System.out.println(Unsafe.getUnsafe());*/

        Field field =  Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe)field.get(null);

        //System.out.println(method.invoke(null, null));

        System.out.println(unsafe.arrayIndexScale(int[].class));
    }
}
