package com.home.OkHttp;

import okhttp3.*;

import java.io.IOException;

/**
 * Created by li.ma on 2018/8/17.
 *
 *
 *
 * https://www.jianshu.com/p/3214ef86a52d
 */
public class OkHttpDemo {


    public static void main(String[] args) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                                        .url("http://www.baidu.com")
                                        .build();
        Call call = okHttpClient.newCall(request);

        call.enqueue(new Callback() {                      //1.异步请求，通过接口回调告知用户 http 的异步执行结果
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println(e.getMessage());
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    System.out.println(response.body().string());
                }
            }
        });

        System.out.println("异常执行*******************************************************************");
        //2.同步请求
        //Response response = call.execute();
        //if (response.isSuccessful()) {
        //    System.out.println(response.body().string());
        //}
        //链接：https://www.jianshu.com/p/3214ef86a52d
    }



    public static void testSynchronize() throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url("http://www.baidu.com").build();
        Call call = okHttpClient.newCall(request);
        Response response = call.execute();
        if (response.isSuccessful()) {
            System.out.println(response.body().string());
        }
    }
}
