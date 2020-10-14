package com.china.concurrent.demo2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: china wu
 * @Description: 阻塞队列 - 4组api存取元素
 * @Date: 2020/10/12 0:00
 */
public class ArrayBlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        test1();
        System.out.println("-----");
        test2();
        System.out.println("-----");
        test3();
        System.out.println("-----");
        test4();
    }

    private static void test1() {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        // 从队尾存放元素，若队列已满抛出异常
        queue.add("a");
        queue.add("b");
        queue.add("c");

        // 取出队头元素，若队列为空抛出异常
        System.out.println(queue.remove());
        System.out.println(queue.remove());

        // 查看队头元素，若队列为空抛出异常
        System.out.println(queue.element());
    }

    private static void test2() {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        // 存放元素进队列，若队列已满返回false
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        System.out.println(queue.offer("b"));

        // 查看队头元素，若队列为空返回null
        System.out.println(queue.peek());

        // 取出队头元素，若队列为空返回null
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    private static void test3() throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        // 存放元素进队列
        queue.put("a");
        queue.put("b");
        queue.put("c");
        // 若队列已满则阻塞并等待，程序不会退出
//        queue.put("d");

        // 取出队头元素
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());

        // 若队列为空则阻塞并等待，程序不会退出
//        queue.take();
    }

    private static void test4() throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        // 存放元素进队列，若队列已满则阻塞等待，超时自动退出
        queue.offer("d", 2, TimeUnit.SECONDS);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        // 从队头取出元素，若队列为空则阻塞等待，超时自动退出
        queue.poll(2, TimeUnit.SECONDS);
    }
}