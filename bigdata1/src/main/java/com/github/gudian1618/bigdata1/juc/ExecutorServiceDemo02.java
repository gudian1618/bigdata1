package com.github.gudian1618.bigdata1.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/10/25 7:24 下午
 */

public class ExecutorServiceDemo02 {
    public static void main(String[] args) {
        // 预定义线程池
        // 适用于大池子小队列
        // ExecutorService es = Executors.newCachedThreadPool();
        // 适用于小池子大队列,并发低,长任务场景
        ExecutorService es = Executors.newFixedThreadPool(5);
    }
}
