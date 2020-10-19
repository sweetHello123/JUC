package com.china.juc.demo6;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: china wu
 * @Description: List不安全测试 - java.util.ConcurrentModificationException
 * @Date: 2020/8/31 14:00
 */
public class ListTest {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();

        /**
         *  List不安全解决方案
         *  1. new Vector()
         *  2. Collections.synchronizedList()
         *  3. new CopyOnWriteArrayList<>()
         */
        CopyOnWriteArrayList<Object> objects = new CopyOnWriteArrayList<>(list);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                objects.add(Thread.currentThread().getName());
                System.out.println(objects);
            }, String.valueOf(i)).start();
        }
    }
}
