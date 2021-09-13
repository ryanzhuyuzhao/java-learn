package com.alogrithm.learn.part1.datastructure.stack;

import com.alogrithm.learn.part1.datastructure.queue.ArrayQueue;

/**
 * @filename QueueStack
 * @description 队列实现栈
 * @author朱愈曌
 * @date 2021/8/23 15:18
 */
public class QueueStack<E> implements Stack<E> {

	private ArrayQueue<E> arrayQueueUse;

	private ArrayQueue<E> arrayQueueBak;

	public QueueStack(int capacity) {
		arrayQueueUse = new ArrayQueue<>(capacity);
		arrayQueueBak = new ArrayQueue<>(capacity);
	}

	public QueueStack() {
		this(10);
	}

	@Override
	public int getSize() {
		return arrayQueueUse.getSize();
	}

	@Override
	public boolean isEmpty() {
		return arrayQueueUse.isEmpty();
	}

	@Override
	public void push(E e) {
		arrayQueueUse.enqueue(e);
	}

	@Override
	public E pop() {
		E e = arrayQueueUse.dequeue();
		//将数据存入arrayQueueUse队列中
		while (!arrayQueueUse.isEmpty()) {
			arrayQueueBak.enqueue(e);
			e = arrayQueueUse.dequeue();
		}
		//再将arrayQueueUse队列中的数据放回arrayQueueUse
		while (!arrayQueueBak.isEmpty()) {
			arrayQueueUse.enqueue(arrayQueueBak.dequeue());
		}
		return e;
	}

	@Override
	public String toString() {
		return arrayQueueUse.toString();
	}

	@Override
	public E peek() {
		return arrayQueueUse.getTail();
	}

	public static void main(String[] args) {
		QueueStack<Integer> stack = new QueueStack<>();
		for (int i = 0; i < 10; i++) {
			stack.push(i);
			System.out.println(stack);
		}
		stack.pop();
		stack.pop();
		System.out.println(stack);


	}
}
