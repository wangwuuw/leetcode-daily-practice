package com.leetcode.bit_operation;

/**
 * @Author: wangwu
 * @Date: Created in 11:30 2021/09/18
 * @Description:
 * 异或^：只有两个对应位不同时才为 1
 * 与&：只有两个对应位都为 1 时才为 1
 * 或|：只要两个对应位中有一个 1 时就为 1
 */
public class Test {
	public static void main(String[] args) {

	}

	/**
	 *
	 * 用异或交换两个变量
	 */
	public static void changeVar(){
		int a = 10,b = 20;
		a = a ^ b;
		b = b ^ a;
		a = a ^ b;
		System.out.println(String.format("a:%s b:%s",a,b));
	}
}
