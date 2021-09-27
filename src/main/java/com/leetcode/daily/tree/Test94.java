package com.leetcode.daily.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wangwu
 * @Date: Created in 10:03 2021/08/09
 * @Description:树的遍历 所谓的前中后指的是树根遍历的时机
 *               -10
 *            9       20
 *                 15    7
 */
public class Test94 {
	public static void main(String[] args) {
		TreeNode treeNode = Test124.getTree();
		backSort(treeNode);
	}
	public static void midSort(TreeNode treeNode){
		if (treeNode == null) {
			return;
		}
		midSort(treeNode.left);
		System.out.println(treeNode.val);
		midSort(treeNode.right);
	}
	public static void frontSort(TreeNode treeNode){
		if (treeNode == null) {
			return;
		}
		System.out.println(treeNode.val);
		frontSort(treeNode.left);
		frontSort(treeNode.right);
	}
	public static void backSort(TreeNode treeNode){
		if (treeNode == null) {
			return;
		}
		backSort(treeNode.left);
		backSort(treeNode.right);
		System.out.println(treeNode.val);

	}

}
