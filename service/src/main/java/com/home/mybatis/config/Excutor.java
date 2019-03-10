package com.home.mybatis.config;

public interface Excutor {
 public <T> T query(String statement,Object parameter);  
}