package org.ryan.chapter3;

import java.util.concurrent.CyclicBarrier;

/**
 * @filename CyclicBarrierDemo2
 * @description
 * @author朱愈曌
 * @date 2021/7/26 17:24
 */
public class CyclicBarrierDemo2 {

	static class TaskThread extends Thread {

		CyclicBarrier barrier;

		public TaskThread(CyclicBarrier barrier) {
			this.barrier = barrier;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(1000);
				System.out.println(getName() + " 到达栅栏 A");
				barrier.await();
				System.out.println(getName() + " 冲破栅栏 A");

				Thread.sleep(2000);
				System.out.println(getName() + " 到达栅栏 B");
				barrier.await();
				System.out.println(getName() + " 冲破栅栏 B");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		int threadNum = 5;
		CyclicBarrier barrier = new CyclicBarrier(threadNum, new Runnable() {

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " 完成最后任务");
			}
		});

		for(int i = 0; i < threadNum; i++) {
			new TaskThread(barrier).start();
		}
	}

}
