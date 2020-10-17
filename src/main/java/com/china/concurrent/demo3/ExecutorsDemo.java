package com.china.concurrent.demo3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: china wu
 * @Description: Executors工具类创建线程池
 * @Date: 2020/10/15 0:02
 */
public class ExecutorsDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        try {
            for (int i = 0; i < 5; i++) {
                // 利用线程池创建线程
                executorService.execute(() -> {
                    System.out.println(Thread.currentThread().getName());
                });
            }
        } finally {
            executorService.shutdown();
        }
    }
}

