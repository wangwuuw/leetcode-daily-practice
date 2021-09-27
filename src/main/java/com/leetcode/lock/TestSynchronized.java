package com.leetcode.lock;

/**
 * @Author: wangwu
 * @Date: Created in 13:57 2021/08/06
 * @Description:
 */
public class TestSynchronized {
	private Object lock = new Object();
	static int a = 0;
	static int b = 0;

	public static void main(String[] args) {
		new Thread() {
			@Override
			public void run() {
					a = 1;
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(b);
				super.run();
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
                   b = 1;
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				System.out.println(a);
				super.run();
			}
		}.start();
	}


	/**
	 *
	 * @throws InterruptedException
	 * synchronized关键字不加锁内部函数
	 */
	static synchronized public void test1() throws InterruptedException {
		System.out.println(Thread.currentThread().getName()+"访问test1");
		Thread.sleep(5000);
		test2();
	}
	 public static void test2(){
		 System.out.println(Thread.currentThread().getName()+"访问test2");

	 }

}
