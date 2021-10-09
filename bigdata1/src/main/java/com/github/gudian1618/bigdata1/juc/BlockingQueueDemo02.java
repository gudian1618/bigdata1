package com.github.gudian1618.bigdata1.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/10/9 4:15 下午
 */

public class BlockingQueueDemo02 {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(5);
        // 队列为空
        // 抛出异常
        // queue.remove();
        // 返回值
        // System.out.println(queue.poll());
        // 永久阻塞
        // System.out.println(queue.take());
        // 定时阻塞
        System.out.println(queue.poll(3, TimeUnit.SECONDS));
    }

}
