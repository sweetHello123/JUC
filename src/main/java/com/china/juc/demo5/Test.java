package com.china.juc.demo5;

import java.util.concurrent.TimeUnit;

/**
 * @Author: china wu
 * @Description: 8锁
 * @Date: 2020/8/31 12:24
 */
public class Test {
    public static void main(String[] args) {
        // 同一个对象，调用方法先拿到锁则会先执行
        Phone phone = new Phone();

        new Thread(() -> {
            // 先拿到锁对象，该方法先执行
            phone.sendMes();
        }, "A线程").start();

        // 主线程休眠1s
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            // 等待其他线程归还锁后再拿到锁才能执行
            phone.call();
        }, "B线程").start();

        new Thread(() -> {
            // 不受锁影响，根据延时执行
            phone.hello();
        }, "C线程").start();
    }
}
