package org.ryan.chapter3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName IntLocak
 * @Description
 * @Author Administrator
 * @Date 2021/7/25 0025 17:27
 * @Version 1.0
 */
public class IntLocak implements Runnable{
    /**重入锁锁中断演示*/
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();

    int lock = 0;

    /**
     * @Author Ryan
     * 控制加锁顺序，方便构造死锁
     * @Date 17:32 2021/7/25 0025
     * @Param [lock]
     * @return
     */
    public IntLocak(int lock) {
        this.lock = lock;
    }


    @Override
    public void run() {
        try {
            if (lock == 1) {
                lock1.lockInterruptibly();
                Thread.sleep(500);
                lock2.lockInterruptibly();
            }else {
                lock2.lockInterruptibly();
                Thread.sleep(500);
                lock1.lockInterruptibly();
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (lock1.isHeldByCurrentThread()) {
                lock1.unlock();
            }
            if (lock2.isHeldByCurrentThread()) {
                lock2.unlock();
            }
            System.out.println(Thread.currentThread().getId() + "：线程退出");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        IntLocak r1 = new IntLocak(1);
        IntLocak r2 = new IntLocak(2);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        Thread.sleep(1000);
        //中断其中一个线程
        t2.interrupt();
    }
}
