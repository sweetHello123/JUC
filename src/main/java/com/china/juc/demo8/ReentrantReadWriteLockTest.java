package com.china.juc.demo8;

/**
 * @Author: china wu
 * @Description: 读写锁 - 独占锁(写锁)、共享锁(读锁)
 * @Date: 2020/9/1 19:01
 */
public class ReentrantReadWriteLockTest {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();

        // 多个线程去写
        for (int i = 1; i <= 5; i++) {
            int temp = i;
            new Thread(() -> {
                myCache.write(temp + "", temp);
            }, "线程" + i).start();
        }

        //  多个线程去读
        for (int i = 1; i <= 5; i++) {
            int temp = i;
            new Thread(() -> {
                myCache.read(temp + "");
            }, "线程" + i).start();
        }
    }
}
