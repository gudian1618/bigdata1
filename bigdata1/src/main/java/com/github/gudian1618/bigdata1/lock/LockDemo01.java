package com.github.gudian1618.bigdata1.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/10/30 6:05 下午
 */

public class LockDemo01 {

    static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        // Lock lock = new ReentrantLock();
        // 获取读写锁
        ReentrantReadWriteLock rw = new ReentrantReadWriteLock();
        // 获取写锁
        Lock lock = rw.writeLock();
        new Thread(new Add(lock)).start();
        new Thread(new Add(lock)).start();
        // 主函数所在的类也是一个线程,那么主线程和其他线程强占CPU执行权
        Thread.sleep(2000);
        System.out.println(i);
    }

}

class Add implements Runnable {
    private Lock lock;

    public Add(Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        // 加锁
        lock.lock();
        for (int i = 0; i < 100000; i++) {
            LockDemo01.i++;
        }
        // 解锁
        lock.unlock();
    }
}
