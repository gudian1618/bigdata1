package com.github.gudian1618.bigdata1.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/11/9 4:53 下午
 *
 */

public class ZookeeperDemo01 {

    private ZooKeeper zk;

    // 连接zookeeper
    @Before
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

        zk = new ZooKeeper("192.168.1.200:2181", 5000, new Watcher() {
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

    // 创建节点
    @Test
    public void createNode() throws InterruptedException, KeeperException {
        // path 节点路径
        // data 节点数据
        // acl 权限策略
        // createNode 创建节点类型
        // 返回值 节点名
        String s = zk.create("/log", "hello zookeeper".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(s);
    }

    // 修改节点数据
    @Test
    public void setData() throws InterruptedException, KeeperException {
        // Path 节点的路径
        // data 节点的数据
        // version 节点的信息列表
        // 当客户端尝试修改数据的时候,会校验version和节点的dataversion是否一致
        // 如果不想受版本控制,设置0或-1
        Stat stat = zk.setData("/log", "hello log".getBytes(), -1);
        System.out.println(stat);
    }

    // 获取节点数据
    @Test
    public void getData() throws InterruptedException, KeeperException {
        Stat s = new Stat();
        byte[] data = zk.getData("/log", null, s);
        System.out.println(new String(data));
    }

    // 获取子节点
    @Test
    public void getChildren() throws InterruptedException, KeeperException {
        // 将子节点的名字放在List中返回
        List<String> children = zk.getChildren("/", null);
        for (String child : children) {
            System.out.println(child);
        }
    }

    // 删除节点
    @Test
    public void deleteNode() throws InterruptedException, KeeperException {
        zk.delete("/log", -1);
    }

    // 判断节点是否存在
    @Test
    public void exists() throws InterruptedException, KeeperException {
        Stat s = zk.exists("/log", null);
        System.out.println(s != null);
    }

}
