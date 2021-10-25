package com.github.gudian1618.bigdata1.juc;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/10/16 10:33 上午
 */

public class ConcurrentHashMapDemo {

    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>(14);
        map.put("zhangsan", 12);
        map.put("lisi", 18);
        map.put("wangwu", 25);
        System.out.println(map);


    }

}
