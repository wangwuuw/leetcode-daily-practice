package com.leetcode;

/**
 * @Author: wangwu
 * @Date: Created in 14:07 2021/08/04
 * @Description:
 */
public class GuanJianZiXiangJie {
	public static void main(String[] args) {
		/**
		 * 		<< 左移运算符，num << X,相当于num乘以2的X次方,也是去掉x位高位，低位补0
		 */
		System.out.println(2 << 3);//16
		System.out.println(Integer.MAX_VALUE << 1);
		/**
		 *      >>      :     右移运算符，num >> X,相当于num除以2的X次方
		 */
		System.out.println(Integer.MIN_VALUE >> 1); //两者的区别就是把符号位去掉了
		/**
		 *  >>>    :     无符号右移，忽略符号位，空位都以0补齐
		 *  高位和数学的数字表示是一样的，左侧表示高位，右侧表示低位
		 */
		System.out.println((Integer.MIN_VALUE/2)>>10); //最小的负数抹掉最高位的1，就全是0
		/**
		 * 对于Integer和Long来说最高位都是符号位，只要是正数，最高位就是0，负数就是1，所以最小负数-1就是最大的正数，最大的正数+1就是最小的负数
		 */
		System.out.println(Integer.toBinaryString(Integer.MIN_VALUE >> 1));//01111111111111111111111111111111 32位
		System.out.println(Integer.toBinaryString(-1048576));//10000000000000000000000000000000 32位
	}
}
