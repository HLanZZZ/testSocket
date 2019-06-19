package com.example.testSocket.testFileUploadAndDownload;


import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class FileUpload {

    private String filePath;

    private String host;

    private int port;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public static void main(String[] args) {
        FileUpload fileUpload = new FileUpload();
        fileUpload.setHost("127.0.0.1");
        fileUpload.setPort(9005);
        fileUpload.setFilePath("C:\\Users\\hui.c.zhu\\data\\");
        fileUpload.uploadFile("testData.txt");
    }


    /**
     * 客户端文件上传
     * @param fileName
     */
    public void uploadFile(String fileName){

        //首先 初始化一个Socket
        Socket socket = null;
        try {
            //创建一个socket 对象
            socket = new Socket(host,port);

            File file = new File(filePath + fileName);
            System.out.println("文件长度："+file.length());
            // 创建一个输入流 ---
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(filePath+fileName));
            //创建一个输出流 --
            DataOutputStream dataOutputStream =new DataOutputStream(socket.getOutputStream());

            dataOutputStream.writeUTF(file.getName());
            dataOutputStream.flush();
            dataOutputStream.writeLong(file.length());
            dataOutputStream.flush();
            //创建一个缓冲区并设置缓冲区大小
            int bufferSize = 8192;
            byte[] buf = new byte[bufferSize];

            while (true){
                int read =0;
                if (dataInputStream != null){
                    read = dataInputStream.read(buf);
                }
                if (read == -1){
                    break;
                }
                dataOutputStream.write(buf,0,read);
            }

            dataOutputStream.flush();
            dataInputStream.close();
            socket.close();

            System.out.println("文件传输完成");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//文件长度：12
//文件传输完成

}
