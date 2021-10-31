package com.github.gudian1618.bigdata1.lock;

import java.util.concurrent.Semaphore;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/10/31 8:17 下午
 * 用餐排号
 */

public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore s = new Semaphore(6);
        for (int i = 0; i < 9; i++) {
            new Thread(new Eater(s)).start();
        }
    }

}

class Eater implements Runnable {

    private Semaphore s;

    public Eater(Semaphore s) {
        this.s = s;
    }

    @Override
    public void run() {
        // 每过来一拨客人,就有一张桌子被占用
        // 相当于一个信号被占用
        // 一旦所有的信号被占用,后来的客人需要等待
        try {
            s.acquire();
            System.out.println("来了一拨客人,一张桌子被占用");
            // 模拟客人的用餐时间
            Thread.sleep((long) (Math.random() * 10000));
            System.out.println("一桌客人用餐完毕,买单离开,空出一张桌子");
            s.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
