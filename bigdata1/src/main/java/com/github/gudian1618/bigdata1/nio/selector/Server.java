package com.github.gudian1618.bigdata1.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/10/9 12:09 下午
 * 需要将selector注册到服务器端
 */

public class Server {

    public static void main(String[] args) throws IOException {
        // 需要开启服务端通道
        ServerSocketChannel ssc = ServerSocketChannel.open();
        // 绑定要监听的端口号
        ssc.bind(new InetSocketAddress(8097));
        // 设置通道为非阻塞
        ssc.configureBlocking(false);
        // 设置选择器,开启
        Selector selc = Selector.open();
        // 将ssc绑定到selector上
        // 绑定需要让selector过滤时间
        ssc.register(selc, SelectionKey.OP_ACCEPT);
        // 服务器一旦开启应该不关闭的
        while (true) {
            // 服务器一旦运行就会接收大量请求
            // 这些连接有些事连续的,有些事无用连接
            // 筛选掉无用连接
            selc.select();
            // 有用连接 accept/read/write
            // 但不意味会触发所有操作,需要确定到底触发的是什么操作
            Set<SelectionKey> selectedKeys = selc.selectedKeys();
            // 遍历集合,然后根据不同的时间类型进行处理
            Iterator<SelectionKey> it = selectedKeys.iterator();
            while (it.hasNext()) {
                SelectionKey key = it.next();
                // 如果是可接受时间
                if (key.isAcceptable()) {
                    // 从事件当中获取对应的通道
                    ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                    // 接收连接
                    SocketChannel sc = channel.accept();
                    // 设置为非阻塞
                    sc.configureBlocking(false);
                    // 如果是可读事件,就注册可读事件
                    sc.register(selc, SelectionKey.OP_READ);
                    // 如果是可写时间,就注册可写事件
                    sc.register(selc, SelectionKey.OP_WRITE);
                    // 如果既要督又要写
                    sc.register(selc, SelectionKey.OP_READ + SelectionKey.OP_WRITE);
                }
                // 如果是可读时间
                if (key.isReadable()) {
                    // 从事件中获取对应的通道
                    SocketChannel sc = (SocketChannel) key.channel();
                    // 准备字节缓冲区
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    // 读取数据
                    sc.read(buffer);
                    // 解析数据
                    byte[] array = buffer.array();
                    System.out.println(new String(array, 0, buffer.position()));
                    // read事件已经处理完,如果通道继续保留这个read事件,那么下一次会被继续处理
                    // 移除read事件
                    sc.register(selc, key.interestOps() - SelectionKey.OP_READ);
                }
                // 如果是可写时间
                if (key.isWritable()) {
                    SocketChannel sc = (SocketChannel) key.channel();
                    // 准备字节缓冲区用于写出数据
                    ByteBuffer buffer = ByteBuffer.wrap("hello client".getBytes());
                    // 写出数据
                    sc.write(buffer);
                    //
                }
                it.remove();
            }


        }


    }

}
