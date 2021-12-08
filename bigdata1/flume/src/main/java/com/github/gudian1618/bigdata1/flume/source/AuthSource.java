package com.github.gudian1618.bigdata1.flume.source;

import org.apache.flume.Context;
import org.apache.flume.EventDrivenSource;
import org.apache.flume.conf.Configurable;
import org.apache.flume.source.AbstractSource;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/12/8 9:19 PM
 * 继承抽象类之后,可以去实现覆盖我们想要覆盖的方法
 */

public class AuthSource extends AbstractSource implements EventDrivenSource, Configurable {

    @Override
    public synchronized void start() {
        //
    }

    @Override
    public synchronized void stop() {
        //
    }

    // 通过这个方法来获取指定的属性值
    @Override
    public void configure(Context context) {

    }
}
