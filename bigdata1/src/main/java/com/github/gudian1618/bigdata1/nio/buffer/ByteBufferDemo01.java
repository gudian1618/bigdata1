package com.github.gudian1618.bigdata1.nio.buffer;

import java.nio.ByteBuffer;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/10/9 9:16 上午
 */

public class ByteBufferDemo01 {

    public static void main(String[] args) {
        // 构建ByteBuffer对象
        // 参数capacity表示容量位,表示的就是字节数组的容量大小
        // 容量指定好之后,不能修改不可变
        ByteBuffer buffer = ByteBuffer.allocate(10);
        // 获取缓冲区的容量位
        System.out.println(buffer.capacity());
        // 存储数据
        buffer.put("abc".getBytes());
        buffer.put("def".getBytes());
        // 获取操作位
        System.out.println(buffer.position());
        // 获取数据
        // 将挪动操作位移动回0位
        // buffer.position(0);
        // 遍历数据
        // 首先将Limit移动到position的位置
        // buffer.limit(buffer.position());
        // buffer.position(0);
        // 下面方法等价于上述两句话
        buffer.flip();
        // while (buffer.position() < buffer.limit()) {
        // 等价于
        while (buffer.hasRemaining()) {
            // 每次get一次,position会自动向后移动一位
            byte b = buffer.get();
            System.out.println((char) b);

        }

    }

}
