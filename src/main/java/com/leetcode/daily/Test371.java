package com.leetcode.daily;

/**
 * @Author: wangwu
 * @Date: Created in 18:11 2021/09/09
 * @Description:
 */
public class Test371 {
	public static void main(String[] args) {
		int sum = getSum(123425345, 2213435);
		System.out.println(sum);
	}
	public static int getSum(int a, int b) {
		//进位为0说明没有被忽略的进位，异或就是最终的答案
		while(b != 0){
			//相加各个位置的值，不算进位
			int temp = a ^ b;
			//因为异或是得到进位的值，所以必须后面加0，比如5---101，7---111 进位需要加0
			b = (a & b) << 1;
			//然后再重复上面两步，直到进位为0
			a = temp;
		}
		return a;
	}
}
