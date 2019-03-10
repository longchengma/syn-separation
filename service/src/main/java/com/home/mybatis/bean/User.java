package com.home.mybatis.bean;


import com.alibaba.fastjson.JSONObject;

public class User {
   private String id;
   private String username;
   private String password;
   //省略get set toString方法...

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }


   @Override
   public String toString() {
      return JSONObject.toJSONString(this);
   }
}