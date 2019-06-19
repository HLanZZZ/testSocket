package com.example.testSocket.testUrlAndUrlConnection;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class TestUrls {

    // 从本地获取数据
    public static void main(String[] args) throws IOException {

        URL url = new URL("file:/C:/Users/hui.c.zhu/data/testData.txt");
        URLConnection urlConnection = url.openConnection();
        InputStream input = urlConnection.getInputStream();
        int data = input.read();
        while(data != -1){
            System.out.print((char) data);
            data = input.read();
        }
        input.close();
        //能获取到
        //Peace & Love
    }

}
