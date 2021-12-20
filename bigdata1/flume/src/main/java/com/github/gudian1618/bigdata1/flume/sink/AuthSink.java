package com.github.gudian1618.bigdata1.flume.sink;

import org.apache.flume.*;
import org.apache.flume.conf.Configurable;
import org.apache.flume.sink.AbstractSink;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Map;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/12/20 9:10 PM
 * 模拟: File Roll Sink -> 将数据写到本地磁盘上
 */

public class AuthSink extends AbstractSink implements Sink, Configurable {

    private String path;
    private PrintStream ps;

    @Override
    public Status process() {
        // 获取Sink对应的Channel
        Channel c = this.getChannel();
        // 获取事务
        Transaction t = c.getTransaction();
        // 开启事务
        t.begin();
        // 获取数据
        Event e;
        try {
            if ((e = c.take()) != null) {
                // 获取headers
                Map<String, String> headers = e.getHeaders();
                // 写出headers部分的数据
                ps.println("headers");
                for (Map.Entry<String, String> h : headers.entrySet()) {
                    ps.println("\t" + h.getKey() + ":" + h.getValue());
                }
                // 获取body
                byte[] body = e.getBody();
                // 写出body的数据
                ps.println("body");
                ps.println("\t" + new String());
            }
            // 如果循环正常结束,说明数据正常写出
            // 提交事务
            t.commit();
            return Status.READY;
        } catch (Exception ex) {
            // 如果循环失败,进入异常处理
            // 回滚操作
            t.rollback();
            return Status.BACKOFF;
        } finally {
            t.close();
        }
    }

    // 获取用户指定的属性
    @Override
    public void configure(Context context) {
        // 获取指定的存储路径
        path = context.getString("path");
        // 判断用户是否指定了这个属性
        if (path == null) {
            throw new IllegalArgumentException("必须指定path属性!!!");
        }
    }

    // 启动sink
    @Override
    public synchronized void start() {
        try {
            // 构建流用于将数据写到磁盘上
            ps = new PrintStream(path + "/" + System.currentTimeMillis());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public synchronized void stop() {
        if (ps != null) {
            ps.close();
        }
    }
}
