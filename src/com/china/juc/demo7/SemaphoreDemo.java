package com.china.juc.demo7;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Author: china wu
 * @Description: JUC中的辅助类 - Semaphore
 * @Date: 2020/9/1 13:18
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        // 指定容量的信号量(模拟停车位)
        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                try {
                    // 获取信号量，如果已满则等待当前信号量释放
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "抢到了车位");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName() + "离开了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 释放当前信号量
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}
