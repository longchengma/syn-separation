package com.home.alibaba.dubbo.consumer.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by li.ma on 2019/2/28.
 */
@SpringBootApplication
public class BootDubboConsumerApplication {
    private static final Logger logger = LoggerFactory.getLogger(BootDubboConsumerApplication.class);

    public static void main(String[] args) {
        logger.info("### Spring boot DubboProviderApplication starter ...");
        SpringApplication.run(BootDubboConsumerApplication.class, args);
    }
}
