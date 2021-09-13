package com.alogrithm.learn.part1.datastructure.queue;

import com.alogrithm.learn.part1.datastructure.stack.ArrayStack;
import com.alogrithm.learn.part1.datastructure.stack.Stack;

/**
 * @filename StackQueue
 * @description 使用栈实现队列
 * @author朱愈曌
 * @date 2021/8/23 15:42
 */
public class StackQueue<E> implements Queue<E> {

	/**
	 * 使用栈来是实现队列的数据结构也是使用两个栈来实现
	 */
	private ArrayStack<E> arrayStackUse;
	private ArrayStack<E> arrayStackBak;
	//队首元素
	private E front;

	public StackQueue(int capacity) {
		arrayStackUse = new ArrayStack<>(capacity);
		arrayStackBak = new ArrayStack<>(capacity);
		front = null;
	}

	public StackQueue() {
		this(10);
	}

	@Override
	public int getSize() {
		return arrayStackUse.getSize();
	}

	@Override
	public boolean isEmpty() {
		return arrayStackUse.isEmpty();
	}

	@Override
	public void enqueue(E e) {
		if (getSize() == 0) {
			front = e;
		}
		arrayStackUse.push(e);
	}

	@Override
	public E dequeue() {
		E e = arrayStackUse.pop();
		if (e == null) {
			front = null;
		}
		while (!arrayStackUse.isEmpty()) {
			arrayStackBak.push(e);
			e = arrayStackUse.pop();
		}
		front = arrayStackBak.peek();
		while (!arrayStackBak.isEmpty()) {
			arrayStackUse.push(arrayStackBak.pop());
		}

		return e;
	}

	@Override
	public E getFront() {
		return front;
	}

	@Override
	public String toString() {
		return arrayStackUse.toString();
	}

	public static void main(String[] args) {
		StackQueue<Integer> queue = new StackQueue<>();
		for (int i = 0; i < 10; i++) {
			queue.enqueue(i);
			System.out.println(queue);
		}
		queue.dequeue();
		System.out.println(queue);

		queue.dequeue();
		System.out.println(queue);
		System.out.println("front:" + queue.getFront());
	}
}
