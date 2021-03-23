package com.leetcode.tree;

import java.util.List;

/**
 * @Author: wangwu
 * @Date: Created in 14:44 2020/11/27
 * @Description:
 */
public class BTree {
	public static void main(String[] args) {
		int[] a = {3, 2, 1, 4, 5, 6, 7, 10, 9, 8};
//		int[] a = {1,1,1,1};

		AVLTree avlTree = new AVLTree();

		for (int i = 0; i < a.length; i++) {
			avlTree.insert(new AVLNode(a[i]));
		}
		/**
		 *                      4
		 *                 2           7
		 *               1  3       6      9
		 *                        5      8   10
		 */
//		System.out.println("---------前序遍历，节点值----------");
//		avlTree.preOrderTraverse(avlTree.getmRoot());
//		System.out.println();
//		System.out.println("---------中序遍历，节点值----------");
//		avlTree.midOrderTraverse(avlTree.getmRoot());
//		System.out.println();
//		System.out.println("---------后序遍历，节点值----------");
//		avlTree.afterOrderTraverse(avlTree.getmRoot());
		System.out.println("---------蛇形遍历，节点值----------");
		List<List<Object>> lists = avlTree.zigzagLevelOrder(avlTree.getmRoot());
		System.out.println(lists);

//		System.out.println();
//		System.out.println("---------前序遍历，节点高度----------");
//		avlTree.preOrderHeightTraverse(avlTree.getmRoot());

	}
}
