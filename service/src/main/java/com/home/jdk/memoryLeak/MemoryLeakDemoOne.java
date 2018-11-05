package com.home.jdk.memoryLeak;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by li.ma on 2018/8/10.
 */
public class MemoryLeakDemoOne {
    public static void main(String[] args)
    {
        Set<Person> set = new HashSet<>();
        Person p1 = new Person("唐僧","pwd1",25);
        Person p2 = new Person("孙悟空","pwd2",26);
        Person p3 = new Person("猪八戒","pwd3",27);
        set.add(p1);
        set.add(p2);
        set.add(p3);
        System.out.println("总共有:"+set.size()+" 个元素!"); //结果：总共有:3 个元素!
        p3.setAge(2); //修改p3的年龄,此时p3元素对应的hashcode值发生改变
                      // 导致新的hashcode  和旧的hashcode 对应的hashset数组位置是不一样的

        set.remove(p3); //此时remove不掉，造成内存泄漏

        System.out.println("总共有:"+set.size()+" 个元素!"); //结果：总共有:3 个元素!


        set.add(p3); //重新添加，居然添加成功
        System.out.println("总共有:"+set.size()+" 个元素!"); //结果：总共有:3 个元素!
        for (Person person : set)
        {
            System.out.println(person);
        }



    }
}
