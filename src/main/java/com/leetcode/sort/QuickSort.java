package com.leetcode.sort;

import java.util.Arrays;

/**
 * @Author: wangwu
 * @Date: Created in 16:17 2021/03/02
 * @Description:
 * 快排的逻辑就是
 */
public class QuickSort {
	public static void main(String[] args) {
		int[] ints = new int[]{72,6,57,88,60,42,83,73,48,85};
		quick_sort(ints,0,ints.length-1);
		System.out.println("ints:"+ Arrays.toString(ints));
	}

	//快速排序
	static void quick_sort(int s[], int l, int r)
	{
		if (l < r) {
			int i = l,j = r,x = s[l];
			while (i<j) {
				while (i < j && s[j] >= x)
					j--;
				if (i < j) {
					s[i++] = s[j];
				}
				while (i < j && s[i] < x)
					i++;
				if (i < j) {
					s[j--] = s[i];
				}
			}
			s[i] = x;
			quick_sort(s,l,i-1);
			quick_sort(s,i+1,r);
		}

	}
}
