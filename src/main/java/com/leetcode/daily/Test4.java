package com.leetcode.daily;

/**
 * @Author: wangwu
 * @Date: Created in 16:02 2021/08/05
 * @Description:
 */
public class Test4 {
	public static void main(String[] args) {
		int[] nums1 = new int[]{1, 2};
		int[] nums2 = new int[]{3, 4};
		double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
		System.out.println(medianSortedArrays);
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] nums;
		int m = nums1.length;
		int n = nums2.length;
		nums = new int[m + n];
		if (m == 0) {
			if (n % 2 == 0) {
				return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
			} else {

				return nums2[n / 2];
			}
		}
		if (n == 0) {
			if (m % 2 == 0) {
				return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
			} else {
				return nums1[m / 2];
			}
		}

		int count = 0;
		int i = 0, j = 0;
		while (count != (m + n)) {
			//第一个数组加完了，剩下都从第二个数组加
			if (i == m) {
				while (j != n) {
					nums[count++] = nums2[j++];
				}
				break;
			}
			//第二个数组加完了，剩下都从第一个数组加
			if (j == n) {
				while (i != m) {
					nums[count++] = nums1[i++];
				}
				break;
			}
            //归并
			if (nums1[i] < nums2[j]) {
				nums[count++] = nums1[i++];
			} else {
				nums[count++] = nums2[j++];
			}
		}

		if (count % 2 == 0) {
			return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
		} else {
			return nums[count / 2];
		}
	}
}
