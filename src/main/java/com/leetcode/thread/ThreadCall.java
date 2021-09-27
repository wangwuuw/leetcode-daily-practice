package com.leetcode.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: wangwu
 * @Date: Created in 13:23 2021/09/09
 * @Description:两个线程交替打印数组中的值,
 */
public class ThreadCall {
	private static CountDownLatch latch = new CountDownLatch(1);
	public static void main(String[] args) {
		final Object s = new Object();
		int[] ai = {1,2,3,4,5,6,7};
		AtomicInteger index = new AtomicInteger();
		new Thread(()->{
			try {
				latch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (s){
				for (int i = 0;i<ai.length;i++){
					int andIncrement = index.getAndIncrement();
					if (andIncrement<ai.length) {
						System.out.println(Thread.currentThread().getName()+"-"+ai[andIncrement]);
					}
					//System.out.println(Thread.currentThread().getName()+"-"+a);
					try {
						s.notify();
						s.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				s.notify();
			}
		},"t1").start();
		new Thread(
				()->{
					synchronized (s){
						for (int i = 0;i<ai.length;i++){
							int andIncrement = index.getAndIncrement();
							if (andIncrement<ai.length) {
								System.out.println(Thread.currentThread().getName()+"-"+ai[andIncrement]);
							}
							latch.countDown();
							try {
								s.notify();
								s.wait();
							}catch (InterruptedException e)
							{
								e.printStackTrace();
							}
						}
						s.notify();
					}

				},"t2"
		).start();

	}

}
