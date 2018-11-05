package com.home.spring.resource;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;

/**
 * Created by li.ma on 2018/8/3.
 */
public class PathMatchingResourcePatternResolverDemo {

    public static void main(String[] args) throws IOException {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        //resolver.setPathMatcher();


        Resource resource = resolver.getResource("classpath:request.xml");

        System.out.println(resource.getDescription());

        Resource[] resources = resolver.getResources("classpath:*.xml");

        for (Resource resource1 : resources) {
            System.out.println(resource1.getDescription());
        }
    }
}
