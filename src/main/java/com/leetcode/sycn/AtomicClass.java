package com.leetcode.sycn;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Author: wangwu
 * @Date: Created in 14:43 2021/04/09
 * @Description:
 */
public class AtomicClass {
	static volatile AtomicBoolean inResetLock = new AtomicBoolean(false);
	public static void main(String[] args) {
		boolean b = inResetLock.compareAndSet(false, true);
		System.out.println("b="+b);
		boolean b3 = inResetLock.compareAndSet(false, true);
		System.out.println("b3="+b3);

		if (!inResetLock.compareAndSet(false, true)) {
			boolean b1 = !inResetLock.compareAndSet(false, true);
			boolean b2 = !inResetLock.compareAndSet(false, true);

			System.out.println("b1="+b1);
			System.out.println("b2="+b2);

		}
		}


}
