package com.china.concurrent.demo2;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author: china wu
 * @Description:
 * @Date: 2020/10/12 0:00
 */
public class BlockingQueueDemo {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        System.out.println(queue.add("a"));
        System.out.println(queue.add("a"));
        System.out.println(queue.add("a"));
    }
}
