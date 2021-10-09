package com.github.gudian1618.bigdata1.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/10/9 10:21 上午
 */

public class Server {

    public static void main(String[] args) throws IOException {
        // 开启服务端通道
        ServerSocketChannel ssc = ServerSocketChannel.open();
        // 设置为非阻塞
        ssc.configureBlocking(false);
        // 绑定要监听的端口
        ssc.bind(new InetSocketAddress(8098));
        // 接收连接
        SocketChannel sc = ssc.accept();
        // 判断是否建立连接
        while (sc==null) {
            sc = ssc.accept();
        }
        // 构建一个buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        sc.read(buffer);
        // 解析数据
        byte[] array = buffer.array();
        System.out.println(new String(array, 0, buffer.position()));
        // 关流
        ssc.close();
    }

}
