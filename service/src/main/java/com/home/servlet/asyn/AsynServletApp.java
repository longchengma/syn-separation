package com.home.servlet.asyn;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Created by li.ma on 2018/7/31.
 */
@SpringBootApplication
@ServletComponentScan
@EnableAsync
public class AsynServletApp {
   /* @Bean
    public ServletRegistrationBean MyServlet1(){
        return new ServletRegistrationBean(new AsyncServlet(), "/myasynserv*//*");
    }*/


    public static void main(String[] args){
        SpringApplication.run(AsynServletApp.class, args);
    }
}
