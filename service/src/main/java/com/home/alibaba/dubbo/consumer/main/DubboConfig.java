package com.home.alibaba.dubbo.consumer.main;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by li.ma on 2019/3/4.
 */
@Configuration
@PropertySource("classpath:dubbo/consumer/dubbo.properties")
@ImportResource({ "classpath:dubbo/consumer/*.xml" })
public class DubboConfig {
}
