package com.china.juc.demo6;

import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Author: china wu
 * @Description: Set不安全测试 - java.util.ConcurrentModificationException
 * @Date: 2020/8/31 14:43
 */
public class SetTest {
    public static void main(String[] args) {
        HashSet<Object> set = new HashSet<>();

        /**
         * Set不安全解决方案
         * 1. Collections.synchronizedSet()
         * 2. new CopyOnWriteArraySet<>()
         */

        CopyOnWriteArraySet<Object> objects = new CopyOnWriteArraySet<>(set);
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                objects.add(Thread.currentThread().getName());
                System.out.println(objects);
            }, String.valueOf(i)).start();
        }
    }
}
