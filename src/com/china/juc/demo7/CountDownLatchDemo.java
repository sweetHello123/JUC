package com.china.juc.demo7;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: china wu
 * @Description: JUC中的辅助类 - CountDownLatch
 * @Date: 2020/9/1 12:17
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        // 从起始数开始执行
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "执行");
                // 计数器减1
                countDownLatch.countDown();
            }).start();
        }
        // 等待计数器归0再向下执行
        countDownLatch.await();
        System.out.println("所有线程结束");
    }
}
