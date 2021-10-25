package com.github.gudian1618.bigdata1.juc;

import java.util.concurrent.*;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/10/25 6:16 下午
 */

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 启动callable线程
        // 方式一,将callable线程包装成Runnable线程通过Thread来进行启动
        // 将callable封装到runnable来运行
        // 这种方法并不会拿到返回值
        FutureTask<String> f = new FutureTask<>(new Cdemo());
        new Thread(f).start();

        // 方法二,将callable线程通过线程池来启动
        ExecutorService es = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5));
        // 将结果封装成Future对象返回
        Future<String> ff =  es.submit(new Cdemo());
        // 将结果对象,解析处理
        System.out.println(ff.get());
        // 关闭线程

    }
}


class Cdemo implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "SUCCESS";
    }
}
