package org.ryan.chapter1;

/**
 * @ClassName MultiThreadLong
 * @Description
 * @Author Administrator
 * @Date 2021/7/24 0024 14:38
 * @Version 1.0
 */
public class MultiThreadLong {
    public static long t = 0;

    public static class ChangeT implements Runnable {
        private long to;

        public ChangeT(long to) {
            this.to = to;
        }

        @Override
        public void run() {
            while (true) {
                MultiThreadLong.t = to;
                Thread.yield();
            }
        }

    }

    public static class ReadT implements Runnable {
        @Override
        public void run() {
            while (true) {
                long tmp = MultiThreadLong.t;
//                if (tmp != 111L && tmp != -999L && tmp != 333l && tmp != -444l) {
                    System.out.println(tmp);
                    Thread.yield();
//                }
            }
        }
    }

    public static void main(String[] args) {
        /**
         * 运行在32位系统上才会出现问题，64位系统是不会出现问题，long是64位的
         */
        new Thread(new ChangeT(111L)).start();
        new Thread(new ChangeT(-999L)).start();
        new Thread(new ChangeT(333L)).start();
        new Thread(new ChangeT(-444L)).start();
        new Thread(new ReadT()).start();
    }
}
