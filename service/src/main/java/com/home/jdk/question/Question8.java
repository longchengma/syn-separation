package com.home.jdk.question;

/**
 * Created by li.ma on 2018/8/24.
 */
public class Question8 {
    public static final int MAX = Integer.MAX_VALUE;

    public static final int START = MAX - 100;

    public static void main(String[] args) {
        int j = 0;

        System.out.println(MAX); // 2147483647
        System.out.println(START);

        for (int i = START; i <= MAX; i++) {   // 当i增加到MAX_VALUE 则再增加一的时候就是负数，肯定小于MAX
            j++;

            //System.out.println(j);
        }

        System.out.println(j);
    }
}
