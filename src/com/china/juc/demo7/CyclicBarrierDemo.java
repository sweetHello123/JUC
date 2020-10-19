package com.china.juc.demo7;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: china wu
 * @Description: JUC中的辅助类 - CyclicBarrier
 * @Date: 2020/9/1 12:45
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        // 确定一个终点数的计数器类，达到值后执行参数内线程方法
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("召唤成功");
        });

        for (int i = 1; i <= 7; i++) {
            int temp = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "收集到" + temp + "个龙珠");
                try {
                    // 等待值达到
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
