package net.socket;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

@Slf4j
public class SocketServerDemo {
    public static void main(String[] args) throws InterruptedException {
        try {
            // 创建服务端socket对象，并指定监听端口号
            ServerSocket serverSocket = new ServerSocket(9008);
            while (true) {
                // 监听客户端连接请求
                Socket acceptSocket = serverSocket.accept();
//                Thread.sleep(100);
                InputStream inputStream = acceptSocket.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line = bufferedReader.readLine();
                log.info("received client:{}, port:{}", line, acceptSocket.getPort());


                OutputStream outputStream = acceptSocket.getOutputStream();
                PrintWriter writer = new PrintWriter(outputStream, true);
                writer.println(" ");
            }

//            acceptSocket.close();
//            serverSocket.close();
        } catch (IOException e) {
            log.error("socket server error:{}", e.getMessage());
        }
    }
}
