package com.github.gudian1618.bigdata1.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/10/9 10:21 上午
 */

public class Client {

    public static void main(String[] args) throws IOException {
        // 开启客户端通知
        SocketChannel sc = SocketChannel.open();
        // 设置为非阻塞
        sc.configureBlocking(false);
        // 发起连接
        sc.connect(new InetSocketAddress("localhost", 8098));
        // 判断连接是否建立
        while (!sc.isConnected()) {
            // 如果没有建立连接,那么试图再次建立这个连接
            // 无法连接的原因有很多,地址错误,服务器故障,网络问题...
            // finishConnect底层会根据当前网络条件进行自动技术
            // 如果多次连接还是失败,会自动抛出异常
            sc.finishConnect();
        }

        // 建立缓冲区
        ByteBuffer buffer = ByteBuffer.wrap("hello server".getBytes());
        // 写数据
        sc.write(buffer);
        // 关流
        sc.close();
    }

}
