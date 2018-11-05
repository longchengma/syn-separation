package com.home.spring.bean;

import com.home.spring.bean.model.Bussiness;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Properties;

/**
 * Created by li.ma on 2018/9/8.
 */
public class BeanRegisterDemo {
    public static void main(String[] args) {
        Properties pp = System.getProperties();
        pp.put("test", "new");

        // 通常为BeanDefinitionRegistry的实现类，这里以DeFaultListabeBeanFactory为例
        BeanDefinitionRegistry  beanRegistry = new DefaultListableBeanFactory();
// XmlBeanDefinitionReader实现了BeanDefinitionReader接口，用于解析XML文件
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanRegistry);
// 加载配置文件
        beanDefinitionReader.loadBeanDefinitions("classpath:spring-bean.xml");
// 从容器中获取bean实例
        BeanFactory container = (BeanFactory)beanRegistry;
        Bussiness business = (Bussiness)container.getBean("beanName");

        System.out.println(business.toString());
    }
}
