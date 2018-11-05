package com.home.spring.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

/**
 * Created by li.ma on 2018/9/5.
 */
@Configuration
@ComponentScan
public class SpringComponentScanApp {

    private static ApplicationContext applicationContext;

    // bean的名称默认是方法名
    @Bean
    //@Import(value = {"com/test/dao/dao-${test}.xml"})
    public ExampleBean exampleBean() {
        return new ExampleBean();
    }

    public static void main(String[] args)
    {
        applicationContext = new AnnotationConfigApplicationContext(SpringComponentScanApp.class);
        for (String beanName : applicationContext.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
    }
}


class ExampleBean {

}
