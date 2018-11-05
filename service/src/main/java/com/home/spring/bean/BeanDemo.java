package com.home.spring.bean;



import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by li.ma on 2018/7/21.
 */
public class BeanDemo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("");

        context.getBean("");

        context.getBeanDefinitionNames();


        BeanFactory factory = context.getParentBeanFactory();


    }
}
