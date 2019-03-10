package com.home.tomcat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by li.ma on 2018/12/15.
 */
public class ServletMappingConfig {
    public static List<ServletMapping> servletMappingList = new ArrayList<>();

    static {
        servletMappingList.add(new ServletMapping("findGirl", "/girl", "com.home.tomcat.FindGirlServlet"));
        servletMappingList.add(new ServletMapping("findWord", "/word", "com.home.tomcat.HelloWordServlet"));
    }
}
