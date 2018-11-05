package com.home.spring.profile;

import com.home.spring.bean.model.Bussiness;
import com.home.spring.profile.ProfileModel.ProfileModel;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Properties;

/**
 * Created by li.ma on 2018/9/21.
 */
public class SpringProfileDemo {
    public static void main(String[] args) {
        Properties pp = System.getProperties();
        pp.put("test", "new");

        // 通常为BeanDefinitionRegistry的实现类，这里以DeFaultListabeBeanFactory为例
        BeanDefinitionRegistry beanRegistry = new DefaultListableBeanFactory();
// XmlBeanDefinitionReader实现了BeanDefinitionReader接口，用于解析XML文件
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanRegistry);
// 加载配置文件
        beanDefinitionReader.loadBeanDefinitions("classpath:spring-bean.xml");
// 从容器中获取bean实例
        BeanFactory container = (BeanFactory)beanRegistry;
        Bussiness business = (Bussiness)container.getBean("beanName");

        System.out.println(business.toString());

        ProfileModel profileModel = container.getBean("profileModel", ProfileModel.class);

        profileModel.operateEnvironment();
    }
}
