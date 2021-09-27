package com.leetcode.daily;


import java.util.Arrays;

/**
 * @Author: wangwu
 * @Date: Created in 14:26 2021/08/30
 * @Description:
 */
public class Test528 {
	int[] pre;
	int total;

	public static void main(String[] args) {
		Test528 test528 = new Test528(new int[]{1,1});
		while (true){
			int i = test528.pickIndex();
			System.out.println(i);
		}
	}
	public Test528(int[] w) {
		pre = new int[w.length];
		pre[0] = w[0];
		for (int i = 1; i < w.length; ++i) {
			pre[i] = pre[i - 1] + w[i];
		}
		total = Arrays.stream(w).sum();
	}

	public int pickIndex() {
		int x = (int) (Math.random() * total) + 1;
		return binarySearch(x);
	}

	private int binarySearch(int x) {
		int low = 0, high = pre.length - 1;
		while (low < high) {
			int mid = (high - low) / 2 + low;
			if (pre[mid] < x) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}
}
