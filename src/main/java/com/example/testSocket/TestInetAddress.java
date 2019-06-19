package com.example.testSocket;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Controller
public class TestInetAddress {


    @RequestMapping("/testInetAddress")
    public void testInetAddress(){

        InetAddress address = null;
        try {
//            address = InetAddress.getByName("www.baidu.com");
//            address = InetAddress.getByAddress(new byte[]{(byte) 163, (byte) 177, (byte) 151, (byte) 110});
            address=InetAddress.getLocalHost();
//            address = InetAddress.getByAddress("wwww.baidu.com",)
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
//        System.out.println(address);
        System.out.println(address.getCanonicalHostName());

    }

    //www.baidu.com/163.177.151.110  address one
    //可能是地址不准确还是怎么 具体还得测试  address two
    //GZCDC101330/10.202.162.144  address three  主机别名  和 ip地址

    //GZCDC101330.dir.svc.accenture.com   address.getCanonicalHostName();  远程主机名

}
