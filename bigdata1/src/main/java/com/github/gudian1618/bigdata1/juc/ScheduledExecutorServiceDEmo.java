package com.github.gudian1618.bigdata1.juc;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/10/25 7:42 下午
 */

public class ScheduledExecutorServiceDEmo {

    public static void main(String[] args) {
        // 构建线程池对象
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(5);
        // 执行任务,推迟延迟任务的执行时间
        // ses.schedule(new ScheduledThread(), 3, TimeUnit.SECONDS);
        // 定时调度,每隔多长时间执行任务,周期性的执行,从上一个任务启动开始计算计时
        // ses.scheduleAtFixedRate(new ScheduledThread(), 0, 3, TimeUnit.SECONDS);
        // 从上一个任务结束开始计算计时
        ses.scheduleWithFixedDelay(new ScheduledThread(), 0, 3, TimeUnit.SECONDS);

    }

}

class ScheduledThread implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("Running");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

