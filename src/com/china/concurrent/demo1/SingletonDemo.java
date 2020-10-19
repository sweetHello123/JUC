package com.china.concurrent.demo1;

/**
 * @Author: china wu
 * @Description: 多线程下的单例模式不安全测试
 * @Date: 2020/9/2 19:18
 */
public class SingletonDemo {

    private static SingletonDemo instance = null;

    private SingletonDemo() {
        System.out.println(Thread.currentThread().getName() + "\t我是构造方法");
    }

    public static SingletonDemo getInstance() {
        if (instance == null) {
            instance = new SingletonDemo();
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                SingletonDemo.getInstance();
            }, String.valueOf(i)).start();
        }
        SingletonDemo.getInstance();
    }
}
