package com.home.jdk.stream;

import com.home.jdk.memoryLeak.Person;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

/**
 * Created by li.ma on 2018/8/8.
 */
public class StreamDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aaa bbb ccc");
        list.add("ddd eee fff");
        list.add("ggg hhh iii");

        list = list.stream().map(s -> s.split(" ")).flatMap(Arrays::stream).collect(Collectors.toList());

        System.out.println(list);

        Set<Person> set = new HashSet<>();
        Person p1 = new Person("唐僧","pwd1",25);
        Person p2 = new Person("孙悟空","pwd2",26);
        Person p3 = new Person("猪八戒","pwd3",27);
        Person p4 = new Person("沙和尚","pwd4",27);
        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);
        //Map<Integer, Person> map = set.stream().collect(toMap(Person::getAge, p -> p));

        //System.out.println(map);


        Map<Integer, List<Person>> mapEx = set.stream().collect(groupingBy(Person::getAge));

        System.out.println(mapEx);
    }
}
