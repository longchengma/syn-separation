package com.home.spring.profile;

import com.home.spring.profile.ProfileModel.ProfileModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by li.ma on 2018/9/21.
 */
@SpringBootApplication
@ImportResource(locations = {"classpath:spring-bean.xml"})
public class SpringProfileDemoOne {



    public static void main(String[] args) {
        System.getProperties().put("test", "new");

        ConfigurableApplicationContext run = SpringApplication.run(SpringProfileDemoOne.class);

        ProfileModel bean = run.getBean(ProfileModel.class);
        bean.operateEnvironment();
    }
}
