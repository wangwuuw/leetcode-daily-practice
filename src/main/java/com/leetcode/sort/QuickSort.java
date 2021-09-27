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
		int[] ints = new int[]{9,8,7,6,5,4};
		quick_sort(ints,0,ints.length-1);
		System.out.println("ints:"+ Arrays.toString(ints));
	}

	//快速排序
	static void quick_sort(int s[], int l, int r)
	{
		if (l < r) {
			int i = l,j = r,x = s[l];
			/**
			 * 总体逻辑
			 * 设定一个基准值
			 * 把比基准值小的移到左边，比基准值大的移到右边
			 * 右边开始遍历的第一个比基准值小的，替代最左边的值，最左边的值已经设为基准值了，所以不用担心最左边的值被覆盖，
			 * 然后从左边开始遍历第一个比基准值大的下标值，然后替换上次替换左边的那个下标值
			 * 然后继续循环
			 */
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
			//因为只有i=j才退出，所以这里s[i]或者s[j]都可以
			s[i] = x;
			quick_sort(s,l,i-1);
			quick_sort(s,i+1,r);
		}

	}
}
