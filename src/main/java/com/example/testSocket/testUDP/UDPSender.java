package com.example.testSocket.testUDP;


import java.io.IOException;
import java.net.*;

public class UDPSender {

    public static void main(String[] args) throws IOException {

        // 创建数据包对象，封装要发送的数据，接收端IP，端口
        byte[] date = "你好UDP".getBytes();
        //创建InetAdress对象，封装自己的IP地址
        InetAddress inet = InetAddress.getByName("127.0.0.1");
        DatagramPacket dp = new DatagramPacket(date, date.length, inet,60000);
        //创建DatagramSocket对象，数据包的发送和接收对象
        DatagramSocket ds = new DatagramSocket();
        //调用ds对象的方法send，发送数据包
        ds.send(dp);
        ds.close();
    }
}
