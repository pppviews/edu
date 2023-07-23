package org.example.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DataGramSocketB {
    public static void main(String[] args) throws IOException {
        DatagramPacket datagramPacket;
        try (DatagramSocket datagramSocket = new DatagramSocket(9911)) {
            datagramPacket = new DatagramPacket(new byte[1024], 1024);
            while (true) {
                datagramSocket.receive(datagramPacket);
                byte[] data = datagramPacket.getData();
                System.out.println(new String(data, 0, datagramPacket.getLength()));
            }
        }
    }
}
