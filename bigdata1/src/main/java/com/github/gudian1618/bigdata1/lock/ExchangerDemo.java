package com.github.gudian1618.bigdata1.lock;

import java.util.concurrent.Exchanger;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/10/30 8:21 下午
 * 用于商品交换,一手交钱,一手交换
 */

public class ExchangerDemo {

    public static void main(String[] args) {

    }

}

class Producer implements Runnable {

    private Exchanger<String> exchanger;

    public Producer(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        // 生产者准备商品
        String info = "商品";
        // 生产者将商品交换给消费者,同时应该接收到消费者的钱
        try {
            String msg = exchanger.exchange(info);
            System.out.println("生产者收到了消费者换过来的" + msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {

    private Exchanger<String> exchanger;

    public Consumer(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        
    }
}
