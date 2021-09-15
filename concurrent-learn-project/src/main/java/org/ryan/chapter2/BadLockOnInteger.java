package org.ryan.chapter2;

/**
 * @ClassName BadLockOnInteger
 * @Description
 * @Author Administrator
 * @Date 2021/7/25 0025 16:16
 * @Version 1.0
 */
public class BadLockOnInteger implements Runnable{
    public static Integer i = 0;
    static BadLockOnInteger instance = new BadLockOnInteger();

    @Override
    public void run() {
        for (int j = 0;j < 1000000; j++) {
            synchronized (i) {//虽然添加synchronized关键字，但是Integer是不变对象，++操作每次都创建一个新的Integer对象

                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
