package com.leetcode.collect;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author: wangwu
 * @Date: Created in 10:42 2021/07/06
 * @Description:
 */
public class QueueTest {
	public static void main(String[] args) throws InterruptedException {
		ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue(2);
		arrayBlockingQueue.offer("1");
		arrayBlockingQueue.offer("2");
//		arrayBlockingQueue.put("6");
		String poll = arrayBlockingQueue.poll();
		arrayBlockingQueue.offer("3");
		String poll2 = arrayBlockingQueue.poll();

		System.out.println(poll);
		System.out.println(poll2);




	}
}
