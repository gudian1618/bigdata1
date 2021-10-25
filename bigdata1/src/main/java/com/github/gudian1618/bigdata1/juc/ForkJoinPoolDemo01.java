package com.github.gudian1618.bigdata1.juc;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/10/25 7:56 下午
 */

public class ForkJoinPoolDemo01 {

    public static void main(String[] args) {
        // 求和
        // 一个主线程会交给1个CPU核去进行进行计算
        long sum = 0;
        for (long i = 0; i < 1000000000L; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

}
