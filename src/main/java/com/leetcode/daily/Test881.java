package com.leetcode.daily;

import java.util.Arrays;

/**
 * @Author: wangwu
 * @Date: Created in 17:18 2021/08/26
 * @Description:
 */
public class Test881 {
	public static void main(String[] args) {
		int[] people = {3,2,2,1};
		int limit = 3;
		int i = numRescueBoats2(people, limit);
		System.out.println(i);
	}
	public static int numRescueBoats2(int[] people, int limit) {
		int total = 0;
		Arrays.sort(people);
		int head = 0;
		int tail = people.length-1;
		while (head <= tail){
			int headP = people[head];
			int tailP = people[tail];
			if (tailP+headP>limit) {
				total++;
				tail--;
			}else{
				total++;
				tail--;
		        head++;
			}
		}
		return total;
	}
}
