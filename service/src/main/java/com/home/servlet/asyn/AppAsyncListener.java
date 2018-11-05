package com.home.servlet.asyn;

/**
 * Created by li.ma on 2018/7/31.
 */
import javax.servlet.*;
//import javax.servlet.AsyncListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.io.PrintWriter;

//   org.springframework.boot.web.servlet.ServletListenerRegistrationBean.isSupportedType()
// 必须要实现ServletContextListener接口，否则上面的接口断言就会异常
@WebListener
public class AppAsyncListener implements AsyncListener, ServletContextListener {
    @Override
    public void onComplete(AsyncEvent event) throws IOException {
        System.out.println("AppAsyncListener complete");
    }

    @Override
    public void onTimeout(AsyncEvent event) throws IOException {
        ServletResponse response = event.getAsyncContext().getResponse();
        PrintWriter out = response.getWriter();
        out.write("TimeOut Error in Processing");
        out.flush();
        out.close();

    }

    @Override
    public void onError(AsyncEvent event) throws IOException {
        System.out.println("AppAsyncListener error");
        ServletResponse response = event.getAsyncContext().getResponse();
        PrintWriter out = response.getWriter();
        out.write("error on processing");
        out.flush();
        out.close();
    }

    @Override
    public void onStartAsync(AsyncEvent event) throws IOException {
        System.out.println("AppAsyncListener start");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
