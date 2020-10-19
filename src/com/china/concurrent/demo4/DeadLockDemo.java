package com.china.concurrent.demo4;

import java.util.concurrent.TimeUnit;

/**
 * @Author: china wu
 * @Description: 死锁案例
 * @Date: 2020/10/19 15:29
 */
public class DeadLockDemo {

    private static Object object1 = new Object();

    private static Object object2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (object1) {
                System.out.println(Thread.currentThread().getName() + "拿到锁1");
                try {
                    //让当前线程睡眠，保证让另一线程得到o2，防止这个线程启动一下连续获得o1和o2两个对象的锁。
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object2) {
                    System.out.println(Thread.currentThread().getName() + "尝试获得锁2");
                }
            }
        }, "线程1").start();

        new Thread(() -> {
            synchronized (object2) {
                System.out.println(Thread.currentThread().getName() + "拿到锁2");
                synchronized (object1) {
                    System.out.println(Thread.currentThread().getName() + "尝试获得锁1");
                }
            }
        }, "线程2").start();
    }
}