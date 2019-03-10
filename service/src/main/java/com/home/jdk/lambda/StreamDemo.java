package com.home.jdk.lambda;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by li.ma on 2019/2/27.
 */
public class StreamDemo {
    public static void main(String[] args) {
        List<String> list = Stream.of("11", "22", "33").collect(Collectors.toList());

        System.out.println(list.stream().reduce((a,b)->a + "," + b).toString());
    }
}
