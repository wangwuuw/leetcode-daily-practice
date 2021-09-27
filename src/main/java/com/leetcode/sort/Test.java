package com.leetcode.sort;

import java.util.Arrays;

/**
 * @Author: wangwu
 * @Date: Created in 16:01 2021/09/15
 * @Description:
 */
public class Test {

	public static void main(String[] args) {
		int[] ints = new int[]{1,3,5,2,4};
		quick_sort(ints,0,ints.length-1);
		System.out.println(Arrays.toString(ints));

	}
	public static void quick_sort(int[] arr, int l, int r){
		if (l<r) {
			int i = l,j = r,x = arr[l];
			while (i<j){
				while (i<j&&arr[j]>=x)
					j--;
				if (i<j){
                   arr[i++] = arr[j];
				}
				while(i<j&&arr[i]<x)
					i++;
				if (i<j) {
					arr[j--] = arr[i];
				}
			}
			arr[i] = x;
			quick_sort(arr,l,i);
			quick_sort(arr,i+1,r);

		}
	}
}
