package com.home.spring.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by li.ma on 2019/2/1.
 */
@RestController
public class HelloWordController {

    @RequestMapping("/hello")
    public String say() {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                System.err.print("jvm haved end!!!!!!");
            }
        }));

        return "SUCCESS";
    }
}
