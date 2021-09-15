package org.ryan.chapter3;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @filename CountTask
 * @description Fork/Join框架
 * @author朱愈曌
 * @date 2021/7/26 17:34
 */
public class CountTask extends RecursiveTask<Long> {

	/**ForkJoinTask的两个子类RecursiveTask<?>待返回值、RecursiveAction不带返回值
	 * 设置任务分解的策略要控制得当，不然程序分解的任务线程过多会造成内存溢出
	 * */

	private static final int THRESHOLD = 10000;
	private long start;
	private long end;

	public CountTask(long start, long end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected Long compute() {
		long sum = 0;
		boolean canCompute = (end - start) < THRESHOLD;
		if (canCompute) {//小于阀值进行计算
			for(long i = start;i <= end;i++) {
				sum += i;
			}
		}else {//大于阀值进行任务分解
			//分成100个小任务
			long step = (start + end) / 100;
			ArrayList<CountTask> subTasks = new ArrayList<CountTask>();
			long pos = start;
			for (int i = 0;i < 10000;i++) {
				long lastOne = pos + step;
				if (lastOne > end) lastOne = end;
				CountTask subTask = new CountTask(pos,lastOne);
				pos += step + 1;
				subTasks.add(subTask);
				subTask.fork();
			}
			for (CountTask task : subTasks) {
				sum += task.join();
			}
		}
		return sum;
	}

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		CountTask task = new CountTask(0,2000000L);
		ForkJoinTask<Long> result = forkJoinPool.submit(task);
		long res = result.get();
		System.out.println("sum = " + res);
	}
}
