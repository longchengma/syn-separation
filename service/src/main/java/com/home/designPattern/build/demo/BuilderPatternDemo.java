package com.home.designPattern.build.demo;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by li.ma on 2018/7/21.
 */
public class BuilderPatternDemo {
    private String name;

    private int age;

    public BuilderPatternDemo(Builder builder) {
        this.setName(builder.name);
        this.setAge(builder.age);
    }

    public BuilderPatternDemo setAge(int age) {
        this.age = age;
        return this;
    }

    public BuilderPatternDemo setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public static class Builder {
        private String name;

        private int age;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public BuilderPatternDemo build() {
            return new BuilderPatternDemo(this);
        }
    }

    public static void main(String[] args) {
        BuilderPatternDemo builderPatternDemo = new BuilderPatternDemo.Builder().setAge(2).setName("name").build();

        System.out.println(builderPatternDemo);
    }
}
