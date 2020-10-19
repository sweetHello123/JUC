package com.china.concurrent.demo1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: china wu
 * @Description: 测试volatile保证可见性和不保证原子性
 * @Date: 2020/9/2 13:40
 */
public class VolatileDemo {
    public static void main(String[] args) {
        MyData myData = new MyData();
        // 创建一个子线程去修改num值
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "开始执行");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.updateNum();
            System.out.println(Thread.currentThread().getName() + "执行完毕,num=" + myData.num);
        }, "子线程").start();

        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                myData.add();
            }).start();

        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(myData.atomicInteger);

        // 主线程判断num值是否已修改
        while (myData.num == 0) {

        }
        System.out.println(Thread.currentThread().getName() + "线程:num=" + myData.num);
    }
}

/**
 * 资源类
 */
class MyData {
    volatile int num = 0;

    AtomicInteger atomicInteger = new AtomicInteger();

    public void updateNum() {
        this.num = 10;
    }

    public void add() {
        atomicInteger.getAndIncrement();
    }
}
