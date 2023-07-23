package org.example.socket.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerSocket_ {
    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        try (ServerSocket serverSocket = new ServerSocket(9090)) {
            while (true) {
                System.out.println("serverSocket = " + serverSocket);
                Socket accept = serverSocket.accept();
                System.out.println("accept = " + accept);
                executorService.submit(() -> readMessage(accept));
            }
        }
    }

    private static void readMessage(Socket socket) {
        try {
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int read;
            while ((read = inputStream.read(bytes)) != -1) {
                System.out.println(Thread.currentThread()
                        + "接收到消息: "
                        + new String(bytes, 0, read));
            }
            System.out.println("socket = " + socket + "已关闭");
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
