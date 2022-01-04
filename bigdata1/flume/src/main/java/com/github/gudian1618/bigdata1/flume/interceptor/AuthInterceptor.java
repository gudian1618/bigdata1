package com.github.gudian1618.bigdata1.flume.interceptor;

import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2022/1/4 9:43 PM
 * 模拟:Timestamp Interceptor
 */

public class AuthInterceptor implements Interceptor {

    // 初始化方法
    @Override
    public void initialize() {

    }

    // 拦截方法,对Event对象的处理就是在这个方法中
    @Override
    public Event intercept(Event event) {
        // 时间戳在headers中:首先获取时间戳
        Map<String, String> headers = event.getHeaders();
        // 判断headers中原本是否指定了时间戳
        if (headers.containsKey("time") || headers.containsKey("timestamp")) {
            // 如果指定,就不修改
            return event;
        }
        // 如果没有指定,添加一个时间戳
        headers.put("timestamp", System.currentTimeMillis() + "");
        event.setHeaders(headers);
        return event;
    }

    // 批量拦截
    @Override
    public List<Event> intercept(List<Event> list) {
        // 存储拦截之后的Event
        List<Event> es = new ArrayList<Event>();
        for (Event event : list) {
            es.add(intercept(event));
        }
        return es;
    }

    // 关闭方法
    @Override
    public void close() {

    }

    // 覆盖内部接口
    public static class Builder implements Interceptor.Builder{
        // 产生要使用的拦截器对象
        @Override
        public Interceptor build() {
            return new AuthInterceptor();
        }

        // 获取配置属性
        @Override
        public void configure(Context context) {

        }
    }
}
