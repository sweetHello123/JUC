package com.china.juc.demo6;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: china wu
 * @Description: Map不安全测试 - java.util.ConcurrentModificationException
 * @Date: 2020/8/31 15:14
 */
public class MapTest {
    public static void main(String[] args) {
        Map<Object, Object> map = new HashMap<>(16);

        /**
         * Map不安全解决方案
         * 1. Collections.synchronizedMap()
         * 2. new ConcurrentHashMap<>()
         */
        ConcurrentHashMap<Object, Object> hashMap = new ConcurrentHashMap<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                hashMap.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 5));
                System.out.println(hashMap);
            }).start();
        }
    }
}
