package com.example.testSocket.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {
    static Socket s;
    static Socket[] soc;
    static String[] name;
    static int k = 5,i =0,j;
    public static void main(String[] args){

        Server ser = new Server();
        try{
            ServerSocket ss = new ServerSocket(3000);


            soc = new Socket[k];
            name = new String[k];
            while(true){
                s = ss.accept();
                soc[i]= s;
                j=i;
                i++;
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());

                DataInputStream dis = new DataInputStream(s.getInputStream());
                name[j] = dis.readUTF();
                System.out.println(name[j]+"已进入群聊！");
                dos.writeUTF("欢迎你，"+name[j]);
                new Ser1().start();

            }
        }catch(ConnectException e){
            System.out.println("连接异常！！");

        }catch(IOException e){
            e.printStackTrace();
        }

    }

}

class Ser1 extends Thread{

    public int j;

    public void run(){
        try{
            DataInputStream read = new DataInputStream((Server.soc[Server.j]).getInputStream());
            j=Server.j;
            while(true){
                String con = read.readUTF();

                if(con!=null){

                    System.out.println("该线程j为"+j);
                    for(int i = 0;i<Server.soc.length;i++){
                        if((i!=j)&&(Server.soc[i]!=null)){
                            DataOutputStream dos = new DataOutputStream((Server.soc[i]).getOutputStream());
                            dos.writeUTF(Server.name[Server.j]+"发送于 "+(new Date()));
                            dos.writeUTF(con);
                        }
                    }
                }else{break;}
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }



}
