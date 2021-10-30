package com.github.gudian1618.bigdata1.lock;

import java.util.concurrent.CountDownLatch;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/10/30 6:54 下午
 * 假设有多名考官和考生
 * 全部就位之后开始考试
 * 闭锁
 */

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        // 创建闭锁
        CountDownLatch cdl = new CountDownLatch(7);

        new Thread(new Teacher(cdl)).start();
        new Thread(new Teacher(cdl)).start();
        new Thread(new Student(cdl)).start();
        new Thread(new Student(cdl)).start();
        new Thread(new Student(cdl)).start();
        new Thread(new Student(cdl)).start();
        new Thread(new Student(cdl)).start();

        // 考官和考生都到达考场考试开始
        // 在计数归零之前,需要让当前线程陷入阻塞
        // 当计数归零之后,自动放开阻塞
        cdl.await();
        System.out.println("考试开始...");
    }

}

class Teacher implements Runnable {

    private CountDownLatch cdl;

    public Teacher(CountDownLatch cdl) {
        this.cdl = cdl;
    }

    @Override
    public void run() {
        // 模拟:考官到场时间
        try {
            Thread.sleep((long) (Math.random() * 10000));
            System.out.println("考官已经到达考场...");
            // 减少一个计数
            cdl.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Student implements Runnable {

    private CountDownLatch cdl;

    public Student(CountDownLatch cdl) {
        this.cdl = cdl;
    }

    @Override
    public void run() {
        // 模拟:考生到达考场的时间
        try {
            Thread.sleep((long) (Math.random() * 10000));
            System.out.println("考生已经到达考场......");
            cdl.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
