package com.home.alibaba.dubbo.provider.main;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by li.ma on 2019/3/4.
 */
@Configuration
@PropertySource("classpath:dubbo/provider/dubbo.properties")
@ImportResource({ "classpath:dubbo/provider/*.xml" })
public class DubboConfig {
}
