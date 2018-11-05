package com.home.file;


import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.context.support.ServletContextResource;

import java.io.File;
import java.io.IOException;

public class ResourceTest

{

     public static void main(String[] args) throws IOException

     {
          //Class.getResource()的资源获取如果以 / 开头，则从根路径开始搜索资源。
          //Class.getResource()的资源获取如果不以 / 开头，则从当前类所在的路径开始搜索资源。
          //ClassLoader.getResource()的资源获取不能以 / 开头，统一从根路径开始搜索资源
          // 1、通过Class的getResource方法

          String a1 = ResourceTest.class.getResource("/com/home/file/Resource.class").getPath();

          String a2 = ResourceTest.class.getResource("Resource.class").getPath();

          System.out.println(a1 + "----" + a2);

          String a3 = ResourceTest.class.getResource("/request.xml").getPath();

          String a4 = ResourceTest.class.getResource("../../../request.xml").getPath();

          String a5 = ResourceTest.class.getResource("/conf/sysConf.json").getPath();

          String a6 = ResourceTest.class.getResource("../../../conf/sysConf.json").getPath();

          // 2、通过本类的ClassLoader的getResource方法

          String b1 = ResourceTest.class.getClassLoader().getResource("com/home/file/Resource.class").getPath();

          String b2 = ResourceTest.class.getClassLoader().getResource("request.xml").getPath();

          String b3 = ResourceTest.class.getClassLoader().getResource("conf/sysConf.json").getPath();

          // 3、通过ClassLoader的getSystemResource方法

          String c1 = ClassLoader.getSystemClassLoader().getResource("com/home/file/Resource.class").getPath();

          String c2 = ClassLoader.getSystemClassLoader().getResource("request.xml").getPath();

          String c3 = ClassLoader.getSystemClassLoader().getResource("conf/sysConf.json").getPath();

          // 4、通过ClassLoader的getSystemResource方法

          String d1 = ClassLoader.getSystemResource("com/home/file/Resource.class").getPath();

          String d2 = ClassLoader.getSystemResource("request.xml").getPath();

          String d3 = ClassLoader.getSystemResource("conf/sysConf.json").getPath();

          // 5、通过Thread方式

          String e1 = Thread.currentThread().getContextClassLoader().getResource("com/home/file/Resource.class").getPath();

          String e2 = Thread.currentThread().getContextClassLoader().getResource("request.xml").getPath();

          String e3 = Thread.currentThread().getContextClassLoader().getResource("conf/sysConf.json").getPath();


          // 1、文件系统资源
          org.springframework.core.io.Resource res1 = new FileSystemResource("/Users/benjamin/Desktop/a.txt");
          // 2、类路径下的资源
          org.springframework.core.io.Resource res2 = new ClassPathResource("conf/a.txt");
          // 3、web应用资源
          org.springframework.core.io.Resource res3 = new ServletContextResource(null, "/WEB-INF/classes/conf/a.txt");



     }
}