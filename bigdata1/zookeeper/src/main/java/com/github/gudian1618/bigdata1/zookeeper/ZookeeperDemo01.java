package com.github.gudian1618.bigdata1.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/11/9 4:53 下午
 *
 */

public class ZookeeperDemo01 {

    // 连接zookeeper
    @Test
    public void connect() throws IOException, InterruptedException {
        // 获取zookeeper对象
        // ConnectString连接zookeeper的ip和端口号
        // SessionTimeOut 会话超时时间
        // Watcher 监控者 用于监控连接是否建立
        // zookeeper是基于netty来完成连接的
        // netty是基于nio的异步非阻塞通信框架
        // 非阻塞:无论连没连上,都会向下执行
        // 异步:zookeeper可能还没有建立连接或者还在监控中,测试线程可能已经在抢占资源执行
        CountDownLatch cdl = new CountDownLatch(1);

        ZooKeeper zk = new ZooKeeper("192.168.1.200:2181", 5000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
                    System.out.println("连接成功");
                    cdl.countDown();
                }
            }
        });
        // 即便抢到资源也要阻塞等待
        cdl.await();
        System.out.println("finish");
    }

}
