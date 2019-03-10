package com.home.mybatis.config;

import java.lang.reflect.Proxy;

public class MySqlsession {
    private Excutor excutor= new MyExcutor();

    private MyConfiguration myConfiguration = new MyConfiguration();

    public <T> T selectOne(String statement, Object parameter) {
        return excutor.query(statement, parameter);
    }

    public <T> T getMapper(Class<T> clazz) {
        return (T)Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new MyMapperProxy(myConfiguration, this));
    }
}