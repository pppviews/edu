package org.example.socket.tcp;

import java.io.IOException;

public class Socket_B {
    public static void main(String[] args) throws IOException {
        Socket_.connect(9090, 9092);
    }
}
