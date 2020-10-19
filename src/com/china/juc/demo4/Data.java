package com.china.juc.demo4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: china wu
 * @Description: 资源类-A执行完执行B，B执行完执行C，C执行完执行A
 * @Date: 2020/8/31 11:32
 */
public class Data {

    private int num = 1;

    private Lock lock = new ReentrantLock();

    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void methodA() {
        lock.lock();
        try {
            while (num != 1) {
                condition1.await();
            }
            num = 2;
            System.out.println(Thread.currentThread().getName() + "执行AAA," + "num=" + num);
            // 唤醒执行B方法的监视器
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void methodB() {
        lock.lock();
        try {
            while (num != 2) {
                condition2.await();
            }
            num = 3;
            System.out.println(Thread.currentThread().getName() + "执行BBB," + "num=" + num);
            // 唤醒执行C方法的监视器
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void methodC() {
        lock.lock();
        try {
            while (num != 3) {
                condition3.await();
            }
            num = 1;
            System.out.println(Thread.currentThread().getName() + "执行CCC," + "num=" + num);
            // 唤醒执行A方法的监视器
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
