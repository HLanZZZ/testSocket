package com.example.testSocket.testUrlAndUrlConnection;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class TestURLConnection {


    public static void main(String[] args) throws IOException {

        URL url = new URL("http://jenkov.com");
        URLConnection urlConnection = url.openConnection();
        //调用这个方法 主要是为了 发送POST请求
        urlConnection.setDoOutput(true);
        // 输出流还需要再理解一下  具体在IO流里面补习一下
        OutputStream outputStream =urlConnection.getOutputStream();
        outputStream.write(12);
        outputStream.close();
    }

}
