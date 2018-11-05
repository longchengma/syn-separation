package com.home.servlet.syn;

/**
 * Created by li.ma on 2018/7/30.
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * 测试SpringBoot使用Servlet的启动类
 * 在Main程序中注册Servlet
 * @author chengxi
 */
@SpringBootApplication
public class ServletApp {
    @Bean
    public ServletRegistrationBean MyServlet1(){
        return new ServletRegistrationBean(new MyServlet(), "/myserv/*");
    }


    public static void main(String[] args){
        SpringApplication.run(ServletApp.class, args);
    }
}