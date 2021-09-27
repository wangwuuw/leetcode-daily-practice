package com.leetcode.daily;

/**
 * @Author: wangwu
 * @Date: Created in 15:44 2021/09/23
 * @Description:
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3 x
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-three
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test326 {
	public static void main(String[] args) {
		System.out.println(5/3);
	}
	public boolean isPowerOfThree(int n) {
		while (n!=0&&n%3==0){
			n/=3;
		}
		return n == 1;
	}

}
