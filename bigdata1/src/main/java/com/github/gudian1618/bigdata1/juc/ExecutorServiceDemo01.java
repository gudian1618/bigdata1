package com.github.gudian1618.bigdata1.juc;

import java.util.concurrent.*;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/10/25 5:58 下午
 */

public class ExecutorServiceDemo01 {

    public static void main(String[] args) {
        // 构建线程池
        ExecutorService es = new ThreadPoolExecutor(5, 15, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(5),
            new RejectedExecutionHandler() {
                @Override
                public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                    // 指定拒绝流程
                    System.out.println("拒绝执行线程: " + r);
                }
            });
        // 提交任务执行线程
        // new Thread(new ESThread()).start();
        // 利用线程池创建线程
        for (int i = 0; i <22; i++) {
            es.execute(new ESThread());
        }
        // 如果线程池用过万,选择关闭
        es.shutdown();
    }

}

class ESThread implements Runnable {

    @Override
    public void run() {
        System.out.println("start");
        // 模拟线程执行时间
        try {
            Thread.sleep(1500);
            System.out.println("finish");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
