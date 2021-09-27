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
		double medianSortedArrays = findMedianSortedArrays2(nums1, nums2);
		System.out.println(medianSortedArrays);
	}

	public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
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
	public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
		int n = nums1.length;
		int m = nums2.length;
		int left = (n + m + 1) / 2;
		int right = (n + m + 2) / 2;
		//将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
		return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
	}

	private static int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
		int len1 = end1 - start1 + 1;
		int len2 = end2 - start2 + 1;
		//让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
		if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
		if (len1 == 0) return nums2[start2 + k - 1];

		if (k == 1) return Math.min(nums1[start1], nums2[start2]);

		int i = start1 + Math.min(len1, k / 2) - 1;
		int j = start2 + Math.min(len2, k / 2) - 1;

		if (nums1[i] > nums2[j]) {
			return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
		}
		else {
			return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
		}
	}
}
