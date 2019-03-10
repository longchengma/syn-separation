package com.home.alibaba.dubbo.consumer.main.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.home.alibaba.dubbo.ProductService;
import com.home.alibaba.dubbo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by li.ma on 2019/3/5.
 */
@Service
public class ProductServiceWapper {
    @Autowired
    private ProductService productService;

    public Product findById(String s) {


        return productService.findById(s);
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}
