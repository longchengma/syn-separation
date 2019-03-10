package com.home.alibaba.dubbo;

import com.home.alibaba.dubbo.model.Product;

/**
 * Created by li.ma on 2019/2/28.
 */
public interface ProductService {
    Product findById(String id);
}
