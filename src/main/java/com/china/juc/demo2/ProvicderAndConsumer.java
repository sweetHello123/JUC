package com.china.juc.demo2;

/**
 * @Author: china wu
 * @Description: 线程间的通信：生产者消费者问题
 * @Date: 2020/8/30 13:42
 */
public class ProvicderAndConsumer {

    private int num = 0;

    public synchronized void increment() throws InterruptedException {
        while (num != 0) {
            this.wait();
        }
        num++;
        System.out.println(Thread.currentThread().getName() + "->" + num);
        this.notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
        while (num == 0) {
            this.wait();
        }
        num--;
        System.out.println(Thread.currentThread().getName() + "->" + num);
        this.notifyAll();
    }
}
