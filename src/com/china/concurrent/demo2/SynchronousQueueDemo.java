package com.china.concurrent.demo2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: china wu
 * @Description: 阻塞队列 - 同步队列
 * @Date: 2020/10/14 21:44
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        // 同步队列
        BlockingQueue<String> queue = new SynchronousQueue<>();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "存a");
                queue.put("a");

                System.out.println(Thread.currentThread().getName() + "存b");
                queue.put("b");

                System.out.println(Thread.currentThread().getName() + "存c");
                queue.put("c");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "子线程").start();

        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println(Thread.currentThread().getName() + "取" + queue.take());
            TimeUnit.SECONDS.sleep(2);
            System.out.println(Thread.currentThread().getName() + "取" + queue.take());
            TimeUnit.SECONDS.sleep(2);
            System.out.println(Thread.currentThread().getName() + "取" + queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}