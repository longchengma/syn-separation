package com.home.alibaba.dubbo.model;

import java.io.Serializable;

/**
 * Created by li.ma on 2019/2/28.
 */
public class Product implements Serializable {
    private static final long serialVersionUID = -7442539232954496779L;

    private String id;
    private String name;
    private Double price;

    private String category;
    private String brand;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + ", category=" + category + ", brand="
                + brand + "]";
    }
}
