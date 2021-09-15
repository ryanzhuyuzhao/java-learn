package org.ryan.chapter3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ReenterLock
 * @Description
 * @Author Administrator
 * @Date 2021/7/25 0025 16:53
 * @Version 1.0
 */
public class ReenterLock implements Runnable{
    /**重入锁*/

    public static ReentrantLock lock = new ReentrantLock();

    public static int i = 0;


    @Override
    public void run() {
        for (int j = 0;j < 10000000;j++) {
            lock.lock();
            try {
                i++;
            } finally {//lock()方法后要记得使用unlock()方法释放锁
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLock reenterLock = new ReenterLock();
        Thread t1 = new Thread(reenterLock);
        Thread t2 = new Thread(reenterLock);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
