package com.home.alibaba.dubbo.consumer.main;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;

/**
 * Created by li.ma on 2019/3/4.
 */
//@ConfigurationProperties(prefix = "consumer.dubbo", ignoreUnknownFields = true)
public class ServerProperties implements EmbeddedServletContainerCustomizer, EnvironmentAware, Ordered {

    /**
     * Server HTTP port.
     */
    private Integer port;

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        if (getPort() != null) {
            container.setPort(getPort());
        }
    }

    @Override
    public void setEnvironment(Environment environment) {

    }

    @Override
    public int getOrder() {
        return 0;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
