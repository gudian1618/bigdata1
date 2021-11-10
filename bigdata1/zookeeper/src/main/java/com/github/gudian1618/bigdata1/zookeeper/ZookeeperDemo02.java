package com.github.gudian1618.bigdata1.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/11/9 6:47 下午
 * 练习
 */

public class ZookeeperDemo02 {
    private ZooKeeper zk;

    @Before
    public void connect() throws Exception {

        CountDownLatch cdl = new CountDownLatch(1);

        zk = new ZooKeeper("192.168.1.200:2181", 5000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
                    System.out.println("连接成功");
                    cdl.countDown();
                }
            }
        });
        cdl.await();
        System.out.println("finish...");
    }

    // 监控节点的数据是否被修改
    @Test
    public void dataChanged() throws InterruptedException, KeeperException {
        // zookeeper的连接过程是异步阻塞的
        // 所以无论是否监控到数据的变化,代码都会向下执行
        /// 因为Test线程会抢占执行
        CountDownLatch cdl = new CountDownLatch(1);
        zk.getData("/log", new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if (watchedEvent.getType() == Event.EventType.NodeDataChanged) {
                    // 实际开发中需要记录日志
                    System.out.println("节点数据被修改...");
                    cdl.countDown();
                }
            }
        }, null);
        cdl.await();
    }

    // 监控子节点个数是否发生变化
    // 修改子节点的个数是不触发的
    @Test
    public void childrenChanged() throws InterruptedException, KeeperException {
        CountDownLatch cdl = new CountDownLatch(1);
        zk.getChildren("/log", new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if (watchedEvent.getType() == Event.EventType.NodeChildrenChanged) {
                    System.out.println("子节点的个数发生了变化...");
                    cdl.countDown();
                }
            }
        });
        cdl.await();
    }

    // 监控节点的增删
    @Test
    public void nodeChanged() throws InterruptedException, KeeperException {
        CountDownLatch cdl = new CountDownLatch(1);
        zk.exists("/book", new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if (watchedEvent.getType() == Event.EventType.NodeCreated) {
                    System.out.println("节点被创建...");
                } else if (watchedEvent.getType() == Event.EventType.NodeDeleted) {
                    System.out.println("节点被删除了...");
                }
                cdl.countDown();
            }
        });
        cdl.await();
    }

}
