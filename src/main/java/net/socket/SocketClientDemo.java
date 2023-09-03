package net.socket;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

@Slf4j
public class SocketClientDemo {
    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("localhost", 9008);
            while (true) {
                OutputStream outputStream = clientSocket.getOutputStream();
                PrintWriter writer = new PrintWriter(outputStream, true);
                writer.println("hello, I am client.");


                InputStream inputStream = clientSocket.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line = bufferedReader.readLine();
                log.info("received msg from server:{}", line);
            }

        } catch (IOException e) {
            log.error("socket client error:{}", e.getMessage());
        }
    }
}
