package com.example.testSocket;


import com.example.testSocket.client.Client;
import com.example.testSocket.server.SocketServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Scanner;

@Controller
public class TestSocketAIO {

    //测试主方法
    @SuppressWarnings("resource")
    @RequestMapping("/testSocketAio")
    public void testSocketAio() {

        //运行服务器
        SocketServer.start();

    }
            //避免客户端先于服务器启动前执行代码
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//            //运行客户端
//            Client.start();
//            System.out.println("请输入请求消息：");
//            Scanner scanner = new Scanner(System.in);
//            while(true) {
//                try {
//                    if (!Client.sendMsg(scanner.nextLine()))
//                        break;
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//    }

    }
