package com.github.gudian1618.bigdata1.atomic;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/10/31 9:05 下午
 */

public class VolatileDemo01 {

    public static void main(String[] args) {
        Data d = new Data();
        d.i = 10;
        // 线程A
        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("A线程已经启动");
                while (d.i == 10);
                System.out.println("A线程已经执行结束");
            }
        }).start();

        // 线程B
        new Thread(new Runnable() {

            @Override
            public void run() {
                // 延迟B线程的启动
                try {
                    Thread.sleep(1000);
                    System.out.println("B线程已经启动成功");
                    d.i = 20;
                    System.out.println("B线程执行结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}

class Data {
    volatile int i;
}
