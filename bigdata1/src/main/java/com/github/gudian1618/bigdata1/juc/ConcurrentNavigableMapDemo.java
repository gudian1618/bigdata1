package com.github.gudian1618.bigdata1.juc;

import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/10/25 5:23 下午
 */

public class ConcurrentNavigableMapDemo {

    public static void main(String[] args) {
        ConcurrentNavigableMap<String, Integer> map = new ConcurrentSkipListMap<>();
        map.put("a", 13);
        map.put("g", 23);
        map.put("k", 34);
        map.put("s", 56);
        map.put("y", 76);
        map.put("i", 87);
        map.put("t", 91);
        System.out.println(map);
    }

}
