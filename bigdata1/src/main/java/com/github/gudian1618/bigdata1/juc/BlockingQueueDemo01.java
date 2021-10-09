package com.github.gudian1618.bigdata1.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/10/9 4:04 下午
 */

public class BlockingQueueDemo01 {

    public static void main(String[] args) throws InterruptedException {
        // 容量一旦指定就不能再更改了
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(5);
        // 添加元素,三种方法队列没满时没有区别,add抛出异常,put永久阻塞,offer返回值和定时阻塞
        // queue.add("a");
        // queue.offer("b");
        // queue.put("c");
        queue.put("a");
        queue.put("a");
        queue.put("a");
        queue.put("a");
        queue.put("a");
        queue.offer("b");
        System.out.println(queue);

    }

}
