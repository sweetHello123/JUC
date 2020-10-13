package com.china.juc.demo8;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: china wu
 * @Description: 自定义缓存类
 * @Date: 2020/9/1 19:01
 */
public class MyCache {

    private Map<String, Object> map = new HashMap<>();

    /**
     * 构造一个可重用的读写锁
     */
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    /**
     * 写方法加锁保证同一时刻只有一个线程去写
     */
    public void write(String key, Object value) {
        // 加写锁不会执行读操作
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "开始写入" + key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "写入完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    /**
     * 所有线程可以同时读
     *
     * @param key
     */
    public void read(String key) {
        // 加读锁不会执行写操作
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "开始读取" + key);
            map.get(key);
            System.out.println(Thread.currentThread().getName() + "读取完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}
