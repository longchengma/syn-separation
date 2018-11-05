package com.home.spring.profile.ProfileModel;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

/**
 * Created by li.ma on 2018/9/21.
 */
public class ProfileModel implements EnvironmentAware {
    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public void operateEnvironment() {

        System.out.println(this.environment.getDefaultProfiles()[0] + "------------------------------------------------");
    }
}
