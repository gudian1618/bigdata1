package com.github.gudian1618.bigdata1.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/10/31 8:45 下午
 */

public class AtomicDemo {

    // static int i = 0;
    static AtomicInteger  ai = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(2);
        new Thread(new Sum(cdl)).start();
        new Thread(new Sum(cdl)).start();
        cdl.await();
        // System.out.println(i);
        System.out.println(ai);
    }

}

class Sum implements Runnable {

    private CountDownLatch cdl;

    public Sum(CountDownLatch cdl) {
        this.cdl = cdl;
    }

    @Override
    public void run() {

        for (int i = 0; i < 100000; i++) {
            // synchronized (Sum.class) {
            //     AtomicDemo.i++;
            // }
            AtomicDemo.ai.incrementAndGet();
        }
        cdl.countDown();
    }
}
