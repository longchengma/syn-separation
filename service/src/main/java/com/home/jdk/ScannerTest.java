package com.home.jdk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by li.ma on 2018/6/12.
 */
public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner("AAAA,BBBBB,CCC ,kkk");

        scanner.useDelimiter(",");

        List<String> matches = new ArrayList<String>();

        while(scanner.hasNext()) {
            matches.add(scanner.next().trim());
        }

        System.out.println(matches);
    }
}
