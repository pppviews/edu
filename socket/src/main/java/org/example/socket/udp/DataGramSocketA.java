package org.example.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class DataGramSocketA {
    public static void main(String[] args) throws IOException {
        try (DatagramSocket datagramSocket = new DatagramSocket(9900)) {
            InetSocketAddress inetSocketAddress = new InetSocketAddress(InetAddress.getLocalHost(), 9911);
            Scanner scanner = new Scanner(System.in);
            String str;
            while (!("close").equalsIgnoreCase(str = scanner.next())) {
                byte[] bytes = str.getBytes();
                DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, inetSocketAddress);
                datagramSocket.send(datagramPacket);
                System.out.println("datagramPacket = " + datagramPacket + "发送成功");
            }
        }
//        String str = "你好";
//        byte[] bytes = str.getBytes();
//        System.out.println("bytes.length = " + bytes.length);   // 6
//        System.out.println("str.length() = " + str.length());   // 2
    }
}
