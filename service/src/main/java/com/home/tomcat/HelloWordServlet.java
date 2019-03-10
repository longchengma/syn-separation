package com.home.tomcat;

import java.io.IOException;

/**
 * Created by li.ma on 2018/12/15.
 */
public class HelloWordServlet extends MyServlet {
    @Override
    public void doGet(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("get word....");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("post word....");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
