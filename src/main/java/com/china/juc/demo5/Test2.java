package com.china.juc.demo5;

import java.util.concurrent.TimeUnit;

/**
 * @Author: china wu
 * @Description:
 * @Date: 2020/8/31 13:01
 */
public class Test2 {
    public static void main(String[] args) {
        // 两个不同的对象执行方法是不同的锁
        Phone phone1 = new Phone();
        Phone phone2 = new Phone();

        new Thread(() -> {
            // 该方法延时了3s，所以后执行
            phone1.sendMes();
        }, "A线程").start();

        // 主线程休眠1s
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            phone2.call();
        }, "B线程").start();

        new Thread(() -> {
            // 不受锁影响，根据延时执行
            phone1.hello();
        }, "C线程").start();
    }
}
