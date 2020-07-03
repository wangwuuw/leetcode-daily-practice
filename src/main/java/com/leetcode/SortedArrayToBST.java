package com.leetcode;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
	public static TreeNode sortedArrayToBST(int[] nums) {
		return helper(nums, 0, nums.length - 1);
	}

	public static TreeNode helper(int[] nums, int left, int right) {
		if (left > right) {
			return null;
		}

		// 总是选择中间位置左边的数字作为根节点
		int mid = (left + right) / 2;

		TreeNode root = new TreeNode(nums[mid]);
		root.left = helper(nums, left, mid - 1);
		root.right = helper(nums, mid + 1, right);
		return root;
	}

	public static void main(String[] args) {
		int[] ints = {-10,-3,0,5,9};
		TreeNode treeNode = sortedArrayToBST(ints);
		System.out.println(treeNode);
	}
	/**
	 * Entry for Tree bins. Extends LinkedHashMap.Entry (which in turn
	 * extends Node) so can be used as extension of either regular or
	 * linked node.
	 */



  }
class TreeNode {
	int val;
	com.leetcode.TreeNode left;
	com.leetcode.TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}



