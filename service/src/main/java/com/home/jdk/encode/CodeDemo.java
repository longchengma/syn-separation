package com.home.jdk.encode;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by li.ma on 2018/8/22.
 */
public class CodeDemo {
    public static void main(String[] args) {
        // 最多可以导出5000个SKN
        String message = "\\346\\234\\200\\345\\244\\232\\345\\217\\257\\344\\273\\245\\345\\257\\274\\345\\207\\2725000\\344\\270\\252SKN";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(message.getBytes());
        int read = -1;
        byte[] byte3 = new byte[3];
        while ((read = inputStream.read()) > -1) {
            if (read == '\\') {
                try {
                    inputStream.read(byte3);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                outputStream.write(Integer.parseInt(new String(byte3),8));
            }
            else {
                outputStream.write(read);
            }
        }
        String decodeMessage = null;
        try {
            decodeMessage = new String(outputStream.toByteArray(),"utf-8");
        } catch (UnsupportedEncodingException e) {

        }
        System.out.println(decodeMessage);
    }
}
