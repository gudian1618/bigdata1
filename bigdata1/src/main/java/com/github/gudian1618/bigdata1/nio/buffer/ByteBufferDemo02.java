package com.github.gudian1618.bigdata1.nio.buffer;

import java.nio.ByteBuffer;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/10/9 10:04 上午
 */

public class ByteBufferDemo02 {

    public static void main(String[] args) {
        // 构建缓冲区
        // 先构建缓冲区,然后再通过put去填充数据
        // 这种方式适合于数据未知的情况
        // 如果数据已知
        // ByteBuffer buffer = ByteBuffer.wrap("hello bigdata".getBytes());
        // 获取position位置,无论哪种方式,只要没有get/put操作,position的位置就是0默认
        // System.out.println(buffer.position());
        // 获取缓冲区中的数据,可以转换成字节数组
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put("hello".getBytes());
        buffer.put("bigdata".getBytes());

        byte[] array = buffer.array();
        // 在转化的时候,会打印多余的空字节,需要限制位置
        // System.out.println(new String(array, 0, buffer.position()));
        buffer.flip();
        System.out.println(new String(array, 0, buffer.limit()));
    }
}
