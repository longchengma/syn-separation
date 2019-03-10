package com.home.jdk.bug;

import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by li.ma on 2019/2/21.
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        JSONArray arr = new JSONArray(); //com.alibaba.fastjson.JSONArray
        arr.add("s");

        //List<Long> list = new ArrayList<>(arr);
        //list.get(0); //Exception cannot cast String to Long
    }
}
