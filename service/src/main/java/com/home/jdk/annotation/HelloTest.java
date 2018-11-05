package com.home.jdk.annotation;


import java.lang.reflect.Method;

/**
 * Created by li.ma on 2018/9/16.
 */
public class HelloTest {
    @Hello("hello")
    public static void main(String[] args) throws NoSuchMethodException {
        Class<?> helloTest = com.home.jdk.annotation.HelloTest.class;

        Method main = helloTest.getMethod("main", String[].class);

        Hello annotation = main.getAnnotation(Hello.class);   // AnnotationInvocationHandler

        System.out.println(annotation.value());
    }
}
