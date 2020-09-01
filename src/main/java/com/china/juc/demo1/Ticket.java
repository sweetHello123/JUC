package com.china.juc.demo1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: china wu
 * @Description:
 * @Date: 2020/8/30 12:24
 */
class Ticket {

    private int num = 50;

    private Lock lock = new ReentrantLock();

    public void sale() {
        lock.lock();
        try {
            if (num <= 0) {
                return;
            }
            System.out.println(Thread.currentThread().getName() + "卖出第" + num-- + "号票");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
