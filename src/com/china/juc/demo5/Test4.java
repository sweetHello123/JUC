package com.china.juc.demo5;

import java.util.concurrent.TimeUnit;

/**
 * @Author: china wu
 * @Description:
 * @Date: 2020/8/31 13:01
 */
public class Test4 {
    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread(() -> {
            // 锁的实体对象
            phone.sendMes();
        }, "A线程").start();

        // 主线程休眠1s
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            // 锁的是Class
            Phone.watch();
        }, "B线程").start();

    }
}
