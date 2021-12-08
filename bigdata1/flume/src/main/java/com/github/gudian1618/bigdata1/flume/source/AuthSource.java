package com.github.gudian1618.bigdata1.flume.source;

import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.EventDrivenSource;
import org.apache.flume.channel.ChannelProcessor;
import org.apache.flume.conf.Configurable;
import org.apache.flume.event.EventBuilder;
import org.apache.flume.source.AbstractSource;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/12/8 9:19 PM
 * 继承抽象类之后,可以去实现覆盖我们想要覆盖的方法
 * 模拟: Sequence Generator Source
 */

public class AuthSource extends AbstractSource implements EventDrivenSource, Configurable {

    private ExecutorService es;
    private long end;
    private long step;

    // 启动Source
    @Override
    public synchronized void start() {
        // 构建线程池
        es = Executors.newFixedThreadPool(5);
        // 获取channel处理器
        ChannelProcessor cp = this.getChannelProcessor();
        // 提交任务
        es.submit(new Add(end, step, cp));
    }

    @Override
    public synchronized void stop() {
        if (es!=null) {
            es.shutdown();
        }
    }

    // 通过这个方法来获取指定的属性值
    @Override
    public void configure(Context context) {
        // 获取最大值,如果不指定,默认是Long.MAX_VALUE
        end = context.getLong("end", Long.MAX_VALUE);
        // 获取自增的步长
        step = context.getLong("step", 1L);
    }
}

class Add implements Runnable {

    private final Long end;
    private final Long step;
    private final ChannelProcessor cp;

    public Add(Long end, Long step, ChannelProcessor cp) {
        this.end = end;
        this.step = step;
        this.cp = cp;
    }

    @Override
    public void run() {
        for (int i = 0; i < end; i += step) {
            // 在flume中,数据都是以Event形式存在
            // 封装body
            byte[] body = (i + "").getBytes(StandardCharsets.UTF_8);
            // 封装headers
            Map<String, String> headers = new HashMap<>();
            headers.put("time", System.currentTimeMillis() + "");
            // 构建Event对象
            Event e = EventBuilder.withBody(body, headers);
            // 将Event对象交给Channel处理器来处理
            cp.processEvent(e);
        }
    }
}
