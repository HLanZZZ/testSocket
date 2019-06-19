package com.example.testSocket.testFileUploadAndDownload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileDownload extends Thread{
    // 文件的保存路径
    private String fileDir;
    // socket 服务器端口
    private int port;
    //判断是否停止
    private boolean stop;

    public String getFileDir() {
        return fileDir;
    }

    public void setFileDir(String fileDir) {
        this.fileDir = fileDir;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public static void main(String[] args) {

        FileDownload download = new FileDownload();
        download.setFileDir("C:\\Users\\hui.c.zhu\\tmp\\");
        download.setPort(9005);
        download.start();
    }


    @Override
    public void run() {
        // 创建一个Socket
        Socket socket = null;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            do {
                //建立Socket连接
                socket = serverSocket.accept();

                DataInputStream inputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

                int bufferSize = 8192;
                byte[] buf = new byte[bufferSize];
                long passedlen = 0;
                long len =0;

                //获取文件名  原来这句话还设置文件上传路径  --
                String file = fileDir + inputStream.readUTF();
//                String file = inputStream.readUTF();  这样获得的就是单纯的file 名


                DataOutputStream fileOut = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
                len = inputStream.readLong();

                System.out.println("文件的长度为:"+len);
                System.out.println("开始接收文件！");

                while (true){
                    int read = 0;
                    if (inputStream != null){
                        read = inputStream.read(buf);
                    }
                    passedlen += read;
                    if (read == -1){
                        break;
                    }
                    System.out.println("文件接收了"+passedlen*100/len);
                    //off: 数据中的起始偏移量。 buf: 字节大小 read : 要写的字节数
                    fileOut.write(buf,0,read);
                }
                System.out.println("接收完成，文件为"+file);
                fileOut.close();
            }while (!stop);
        } catch (IOException e) {
            System.out.println("消息接收错误");
            e.printStackTrace();
            return;
        }

//文件的长度为:12
//开始接收文件！
//文件接收了100
//接收完成，文件为testData.txt

    }
}
