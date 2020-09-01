package com.china.juc.demo5;

import java.util.concurrent.TimeUnit;

/**
 * @Author: china wu
 * @Description:
 * @Date: 2020/8/31 13:01
 */
public class Test3 {
    public static void main(String[] args) {
        new Thread(() -> {
            // 同一个Class类先调用方法先执行
            Phone.play();
        }, "A线程").start();

        // 主线程休眠1s
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            Phone.watch();
        }, "B线程").start();

    }
}
