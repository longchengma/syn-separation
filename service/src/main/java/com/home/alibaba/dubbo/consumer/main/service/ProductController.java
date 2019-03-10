package com.home.alibaba.dubbo.consumer.main.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.home.alibaba.dubbo.ProductService;
import com.home.alibaba.dubbo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by li.ma on 2019/2/28.
 * http://127.0.0.1:8081/products/10001
 */
@RestController
public class ProductController {
    @Autowired
    private ProductServiceWapper productServiceWapper;

    @RequestMapping(value="/products/{id}", method= RequestMethod.GET)
    public Product findById(@PathVariable(value="id") String id) {
        Product product = productServiceWapper.findById("10001");
        return product;
    }

    public void setProductServiceWapper(ProductServiceWapper productServiceWapper) {
        this.productServiceWapper = productServiceWapper;
    }
}
