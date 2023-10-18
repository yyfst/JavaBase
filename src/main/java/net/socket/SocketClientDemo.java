package net.socket;

import lombok.extern.slf4j.Slf4j;
import util.ThreadUtil;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

@Slf4j
public class SocketClientDemo {
    public static void main(String[] args) {
        while (true) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test(Thread.currentThread());
                }
            }).start();
//            ThreadUtil.sleep(200);
        }

    }

    private static void test(Thread thread) {
        Socket clientSocket = null;
        try {
            clientSocket = new Socket("localhost", 9008);
//            log.info("{} create new socket.", thread.getName());
            while (true) {
                OutputStream outputStream = clientSocket.getOutputStream();
                PrintWriter writer = new PrintWriter(outputStream, true);
                writer.println(" : ." + thread.getName());


                InputStream inputStream = clientSocket.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line = bufferedReader.readLine();
                log.info("{} : {}", thread.getName(), line);
            }

        } catch (IOException e) {
            int port = -1;
            if (clientSocket != null) {
                port = clientSocket.getPort();
            }
            log.error("socket client port:{}, thread:{}, error:{}", port, thread.getName(), e.getMessage());

            e.printStackTrace();


        }
    }
}
