package com.home.mybatis;

import com.home.mybatis.bean.User;
import com.home.mybatis.config.MySqlsession;
import com.home.mybatis.mapper.UserMapper;

/**
 * Created by li.ma on 2018/6/8.
 */
//@SPI("dubbo")
public class MybatisTest {
    public static void main(String[] args) {
        MySqlsession sqlSession = new MySqlsession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById("1");
        System.out.println(user);
    }
}
