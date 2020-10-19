package com.china.concurrent.demo3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @Author: china wu
 * @Description: Executors工具类创建线程池(实际工作不使用,并发下容易导致OOM)
 * @Date: 2020/10/18 0:31
 */
public class ExecutorsDemo {
    public static void main(String[] args) {
//        testFixedThreadPool();
//        testSingleThreadPool();
        testCacheThreadPool();
//        testScheduledThreadPool();
    }


    private static void testFixedThreadPool() {
        // 创建一个固定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(5);

        try {
            // 10个用户办理业务
            for (int i = 1; i <= 10; i++) {
                service.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "-办理");
                });
            }
        } finally {
            service.shutdown();
        }
    }

    private static void testSingleThreadPool() {
        // 创建一个单个线程的线程池
        ExecutorService service = Executors.newSingleThreadExecutor();
        try{
            for (int i = 1; i <= 5; i++) {
                service.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "-ok");
                });
            }
        }finally {
            service.shutdown();
        }
    }

    private static void testCacheThreadPool() {
        // 创建一个N个线程的线程池
        ExecutorService service = Executors.newCachedThreadPool();
        try{
            for (int i = 1; i <= 6; i++) {
                service.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "-yes");
                });
            }
        }finally {
            service.shutdown();
        }
    }

    private static void testScheduledThreadPool() {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
        try{
            for (int i = 1; i <= 6; i++) {
                service.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "-s");
                });
            }
        }finally {
            service.shutdown();
        }
    }
}
