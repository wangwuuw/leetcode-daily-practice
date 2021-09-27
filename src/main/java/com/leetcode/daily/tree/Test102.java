package com.leetcode.daily.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: wangwu
 * @Date: Created in 11:27 2021/08/09
 * @Description:
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * 二叉树：[3,9,20,null,null,15,7] 返回[[3],[9,20],[15,7]]
 */
public class Test102 {
	public static void main(String[] args) {
		ArrayList<Object> objects = new ArrayList<>();
		objects.remove(0);
		TreeNode tree = Test124.getTree();
		List<List<Integer>> lists = levelOrder(tree);
		System.out.println(lists);


	}

	/**
	 * 用队列解决有点意思
	 * @param root
	 * @return
	 */
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (root == null) {
			return ret;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			List<Integer> level = new ArrayList<Integer>();
			int currentLevelSize = queue.size();
			for (int i = 1; i <= currentLevelSize; ++i) {
				TreeNode node = queue.poll();
				level.add(node.val);
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			ret.add(level);
		}

		return ret;
	}
}
