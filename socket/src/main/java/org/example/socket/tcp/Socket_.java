package org.example.socket.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Socket_ {
    public static void main(String[] args) throws IOException {
        connect(9090, 9091);
    }

    public static void connect(int port, int localPort) throws IOException {
        InetAddress localHost = InetAddress.getLocalHost();
        Scanner scanner = new Scanner(System.in);
        try (Socket socket = new Socket(localHost, port, localHost, localPort)) {
            OutputStream outputStream = socket.getOutputStream();
            String msg;
            while (!("close".equalsIgnoreCase(msg = scanner.next()))) {
                outputStream.write(msg.getBytes());
                outputStream.flush();
            }
        }
    }
}
