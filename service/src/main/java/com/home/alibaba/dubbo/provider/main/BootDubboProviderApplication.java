package com.home.alibaba.dubbo.provider.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by li.ma on 2019/2/28.
 */
@SpringBootApplication
public class BootDubboProviderApplication implements CommandLineRunner {


    private static final Logger logger = LoggerFactory.getLogger(BootDubboProviderApplication.class);

    public static void main(String[] args) {
        logger.info("### Spring boot DubboProviderApplication starter ...");
        SpringApplication.run(BootDubboProviderApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        logger.info("### Spring boot Dubbo provider start ok!");
    }
}
