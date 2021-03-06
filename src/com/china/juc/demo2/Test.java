package com.china.juc.demo2;

/**
 * @Author: china wu
 * @Description:
 * @Date: 2020/8/30 13:45
 */
public class Test {
    public static void main(String[] args) {
        ProviderAndConsumer providerAndConsumer = new ProviderAndConsumer();

        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    // A线程执行加业务
                    providerAndConsumer.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    // B线程执行减业务
                    providerAndConsumer.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();

        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    // C线程执行加业务
                    providerAndConsumer.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();

        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    // D线程执行减业务
                    providerAndConsumer.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }
}
