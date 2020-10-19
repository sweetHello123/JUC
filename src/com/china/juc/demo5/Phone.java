package com.china.juc.demo5;

import java.util.concurrent.TimeUnit;

/**
 * @Author: china wu
 * @Description:
 * @Date: 2020/8/31 12:23
 */
public class Phone {

    /**
     * synchronized-锁的对象是方法的调用者
     * 如果调用者是同一个对象(先拿到锁的方法先执行)
     */

    public synchronized void sendMes() {
        // 延时3s
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public synchronized void call() {
        System.out.println("打电话");
    }

    /**
     * 普通方法不受锁影响
     */
    public void hello() {
        System.out.println("hello");
    }

    /**
     * static - 类一加载就有了，synchronized锁的是同一个Class类模板
     */
    public static synchronized void play() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("玩手机");
    }

    public static synchronized void watch() {
        System.out.println("看电影");
    }
}
