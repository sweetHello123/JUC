package com.china.concurrent.demo1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: china wu
 * @Description: CAS - 比较并交换
 * @Date: 2020/9/6 18:02
 */
public class CAS_Demo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 100) + ",data：" + atomicInteger);
        System.out.println(atomicInteger.compareAndSet(5, 200) + ",data：" + atomicInteger);
        atomicInteger.getAndIncrement();
    }
}
