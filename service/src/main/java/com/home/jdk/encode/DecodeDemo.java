package com.home.jdk.encode;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by li.ma on 2019/3/5.
 */
public class DecodeDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = URLDecoder.decode("dubbo%3A%2F%2F172.16.6.51%3A20880%2Fcom.home.alibaba.dubbo.ProductService%3Fanyhost%3Dtrue%26application%3Ddubbo-provider%26dubbo%3D2.5.3%26interface%3Dcom.home.alibaba.dubbo.ProductService%26methods%3DfindById%26pid%3D6388%26retries%3D0%26side%3Dprovider%26timeout%3D6000%26timestamp%3D1551750352119", "GBK");
        System.out.println(str);
    }
}
