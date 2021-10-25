package com.github.gudian1618.bigdata1.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/10/25 8:00 下午
 */

public class ForkJoinPoolDemo02 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool p = new ForkJoinPool();
        ForkJoinTask<Long> t = p.submit(new Sum(1, 10000000000000L));
        System.out.println(t.get());
        p.shutdown();
    }

}

class Sum extends RecursiveTask<Long> {

    private long start;
    private long end;

    public Sum(long start, long end) {
        this.start = start;
        this.end = end;
    }

    // 写分叉合并的逻辑
    @Override
    protected Long compute() {
        if (end - start <= 1000) {
            long sum = 0;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            // 否则觉得范围比较大,继续拆分
            long mid = (start + end) / 2;
            Sum left = new Sum(start, mid);
            Sum right = new Sum(mid, end);
            // 拆分
            left.fork();
            right.fork();
            // 合并
            return left.join() + right.join();
        }
    }
}
