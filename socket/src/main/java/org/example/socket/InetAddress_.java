package org.example.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetAddress_ {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        byte[] address = localHost.getAddress();
        System.out.println("address = " + Arrays.toString(address));
        String hostAddress = localHost.getHostAddress();
        System.out.println("hostAddress = " + hostAddress);
        InetAddress[] allByName = InetAddress.getAllByName("www.google.com");
        for (InetAddress inetAddress : allByName) {
            System.out.println("inetAddress = " + inetAddress);
        }
        InetAddress byName = InetAddress.getByName("172.217.163.36");
        System.out.println("byName = " + byName);
    }
}
