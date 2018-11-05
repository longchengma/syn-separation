package com.home.spring.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by li.ma on 2018/10/25.
 */
@Service
public class BarConsumerService {
    private RestTemplate restTemplate;


    @Autowired
    public BarConsumerService(RestTemplateBuilder restTemplateBuilder) {
        RestTemplate restTemplate = restTemplateBuilder
                .errorHandler(new RestTemplateResponseErrorHandler())
                .build();
    }

    public Bar fetchBarById(String barId) {
        return restTemplate.getForObject("/bars/4242",  Bar.class);
    }
}
