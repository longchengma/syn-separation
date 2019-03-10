package com.home.mybatis.config;

import com.home.mybatis.mapperBean.Function;
import com.home.mybatis.mapperBean.MapperBean;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

public class MyMapperProxy implements InvocationHandler{
 
    private MySqlsession mySqlsession;
 
    private MyConfiguration myConfiguration;
    
    public MyMapperProxy(MyConfiguration myConfiguration,MySqlsession mySqlsession) {
        this.myConfiguration = myConfiguration;
        this.mySqlsession = mySqlsession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MapperBean readMapper = myConfiguration.readMapper("mybatis/userMapper.xml");

        if (!method.getDeclaringClass().getName().equals(readMapper.getInterfaceName())){ //是否是xml文件对应的接口
            return null;
        }
        List<Function> list = readMapper.getList();
        if(null != list || 0 != list.size()){
            for (Function function : list) {
                if(method.getName().equals(function.getFuncName())){  //id是否和接口方法名一样
                   return mySqlsession.selectOne(function.getSql(), String.valueOf(args[0]));
                }
            }
        }
        return null;
    }
}