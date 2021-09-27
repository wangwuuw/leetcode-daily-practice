package com.leetcode.daily;

import java.util.Arrays;

/**
 * @Author: wangwu
 * @Date: Created in 16:19 2021/08/26
 * @Description:
 */
public class Test88 {
	public static void main(String[] args) {
		int[] nums1 = new int[]{4,5,6,0,0,0};
		int[] nums2 = new int[]{1,2,3};
		 merge(nums1, 3, nums2, 3);
		System.out.println("ints:"+ Arrays.toString(nums1));


	}
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int flag = 0;
		for(int i=0;i<nums1.length;i++){
			int value = nums1[i];
			if(value!=0){
				flag++;
			}
		}
		for(int i=0;i<n;i++){
			int value = nums2[i];
			if(value!=0){
				nums1[m+i] = value;
			}
		}
		quick_sort(nums1,0,nums1.length-1);

	}
	static void quick_sort(int[] src, int l, int r){
		if(l<r){
			int i = l,j = r,x = src[l];
			while (i<j) {
				while (i < j && src[j] > x)
					j--;
				if (i < j) {
					src[i++] = src[j];
				}
				while (i < j && src[i] <= x)
					i++;
				if (i < j) {
					src[j--] = src[i];
				}

			}
			src[i] = x;
			quick_sort(src,l,i-1);
			quick_sort(src,i+1,r);


		}
	}
}
