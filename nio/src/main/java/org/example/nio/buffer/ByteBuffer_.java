package org.example.nio.buffer;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ByteBuffer_ {
    public static void main(String[] args) throws IOException {
        URL resource = ByteBuffer_.class.getClassLoader().getResource("README.md");
        try (RandomAccessFile file = new RandomAccessFile(resource.getFile(), "rw")) {
            FileChannel channel = file.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(5);
            int length;
            while ((length = channel.read(byteBuffer)) != -1) {
                System.out.println("length = " + length);
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    System.out.println("byteBuffer.get() = " + ((char) byteBuffer.get()));
                }
                byteBuffer.clear();
            }
        }

    }
}
