package com.home.alibaba.dubbo.provider.service;

import com.home.alibaba.dubbo.ProductService;
import com.home.alibaba.dubbo.model.Product;
import org.springframework.stereotype.Service;

/**
 * Created by li.ma on 2019/2/28.
 */
//@Service(version="1.0.0")
    // dubbo://172.16.6.51:20880/com.home.alibaba.dubbo.ProductService?anyhost=true&application=dubbo-provider&dubbo=2.5.3
// &interface=com.home.alibaba.dubbo.ProductService&methods=findById&pid=6388&retries=0&side=provider&timeout=6000&timestamp=1551750352119
public class ProductServiceImpl implements ProductService {
    @Override
    public Product findById(String id) {
        Product product = new Product();
        product.setId(id);
        product.setBrand("HUAWEI");
        product.setCategory("TEL");
        product.setName("Honor V10");
        product.setPrice(2499D);
        return product;
    }
}
