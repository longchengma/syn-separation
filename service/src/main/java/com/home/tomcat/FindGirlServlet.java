package com.home.tomcat;

import java.io.IOException;

/**
 * Created by li.ma on 2018/12/15.
 */
public class FindGirlServlet extends MyServlet {

    @Override
    public void doGet(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("get girl....");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("post girl....");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
