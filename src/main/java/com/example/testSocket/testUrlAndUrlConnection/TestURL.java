package com.example.testSocket.testUrlAndUrlConnection;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class TestURL {

    public static void main(String[] args) throws IOException {

        //creat a connection with http:jenkov.com
//        URL url = new URL("http://jenkov.com");
        URL url = new URL("http://baidu.com");
        //open  the url
        URLConnection urlConnection =url.openConnection();

        System.out.println("port"+url.getPort());
        // get InputStream
        InputStream inputStream = urlConnection.getInputStream();
        // Pass the obtained data to data
        int data = inputStream.read();

        System.out.println("+++++++"+inputStream.read());
        while(data != -1){

            System.out.println((char) data);
            data =inputStream.read();
        }
        inputStream.close();
    }
}
