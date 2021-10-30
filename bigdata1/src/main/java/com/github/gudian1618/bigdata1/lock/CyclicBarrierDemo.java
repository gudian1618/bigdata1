package com.github.gudian1618.bigdata1.lock;

import java.util.concurrent.CyclicBarrier;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/10/30 7:10 下午
 * 模拟运动员跑步
 * 运动员需要等待所有运动员到场之后才能进行跑步比赛
 */

public class CyclicBarrierDemo {

    public static void main(String[] args) {
        // 创建栅栏
        CyclicBarrier clc = new CyclicBarrier(6);

        new Thread(new Runner(clc), "3号").start();
        new Thread(new Runner(clc), "1号").start();
        new Thread(new Runner(clc), "2号").start();
        new Thread(new Runner(clc), "4号").start();
        new Thread(new Runner(clc), "5号").start();
        new Thread(new Runner(clc), "6号").start();
    }

}

class Runner implements Runnable {

    private CyclicBarrier clc;

    public Runner(CyclicBarrier clc) {
        this.clc = clc;
    }

    @Override
    public void run() {
        // 模拟运动员到达起跑线的时间
        try {
            Thread.sleep((long) (Math.random() * 10000));
            // 获取线程名字
            String name = Thread.currentThread().getName();
            System.out.println(name + "运动员走到了起跑线");
            // 运动员到场需要等待,等待所有运动员到场后,起跑
            // 要求所有线程到达之前,阻塞所有线程
            // await不仅仅是一个阻塞,还会进行计数的减少
            // 当计数归零之后,会自动放开阻塞
            clc.await();
            System.out.println(name + "运动员跑了出去");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
