package com.github.gudian1618.bigdata1.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/10/9 12:10 下午
 */

public class Client {

    public static void main(String[] args) throws IOException {
        // 开启客户端通道
        SocketChannel sc = SocketChannel.open();
        // 发起连接
        sc.connect(new InetSocketAddress("localhost",8097));
        // 写出数据
        sc.write(ByteBuffer.wrap("hello bigdata".getBytes()));
        // 接收数据
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        sc.read(buffer);
        // 解析数据
        byte[] array = buffer.array();
        System.out.println(new String(array, 0, buffer.position()));
        // 关流
        sc.close();
    }

}
