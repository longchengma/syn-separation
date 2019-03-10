package com.home.jdk.optional;

import java.util.Optional;

/**
 * Created by li.ma on 2018/11/25.
 */
public class OptionalDemo {
    public static void main(String[] args) {
        Test4 test4 = null;

        Optional.ofNullable(test4).flatMap(Test4::getTest3).flatMap(Test3::getTest2).map(Test2::getInfo).orElse("");



    }
}
