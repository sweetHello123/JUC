package com.china.juc.demo4;

/**
 * @Author: china wu
 * @Description: 测试精准唤醒多线程-顺序执行
 * @Date: 2020/8/31 11:32
 */
public class Test {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.methodA();
            }
        }, "1线程").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.methodB();
            }
        }, "2线程").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.methodC();
            }
        }, "3线程").start();
    }
}
