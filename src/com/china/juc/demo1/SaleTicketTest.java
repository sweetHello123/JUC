package com.china.juc.demo1;

/**
 * @Author: china wu
 * @Description: Lock锁解决线程并发安全问题
 * @Date: 2020/8/30 12:22
 */
public class SaleTicketTest {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread(() -> {
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        }, "C").start();
    }
}
