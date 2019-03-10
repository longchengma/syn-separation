package com.home.mybatis.mapper;

import com.home.mybatis.bean.User;

public interface UserMapper {
   User getUserById(String id);
}