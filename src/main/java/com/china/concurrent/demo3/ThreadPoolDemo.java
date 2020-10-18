package com.china.concurrent.demo3;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: china wu
 * @Description:
 * @Date: 2020/10/15 0:02
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                // 核心线程数量
                2,
                // 最大同时运行的线程数量
                5,
                // 多余的空闲线程存活时间
                3L,
                // 时间单位
                TimeUnit.SECONDS,
                // 等待的工作队列
                new LinkedBlockingDeque<>(3),
                // 工作线程的线程工厂
                Executors.defaultThreadFactory(),
                // 拒绝策略
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );

        for (int i = 1; i <= 10; i++) {
            threadPoolExecutor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "办理业务");
            });
        }
        threadPoolExecutor.shutdown();
    }
}

