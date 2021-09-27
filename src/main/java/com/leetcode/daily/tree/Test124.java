package com.leetcode.daily.tree;


/**
 * @Author: wangwu
 * @Date: Created in 18:29 2021/08/05
 * @Description:二叉树中的最大路径和 深度优先
 */
public class Test124 {

	public static void main(String[] args) {
		TreeNode treeNode = getTree();
		int i = maxPathSum(treeNode);
		System.out.println(i);


	}
	static int maxSum = Integer.MIN_VALUE;

	public static int maxPathSum(TreeNode root) {
		maxGain(root);
		return maxSum;
	}

	public static int maxGain(TreeNode node) {
		if (node == null) {
			return 0;
		}

		// 递归计算左右子节点的最大贡献值
		// 只有在最大贡献值大于 0 时，才会选取对应子节点
		int leftGain = Math.max(maxGain(node.left), 0);
		int rightGain = Math.max(maxGain(node.right), 0);

		// 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
		int priceNewpath = node.val + leftGain + rightGain;

		// 更新答案
		maxSum = Math.max(maxSum, priceNewpath);

		// 返回节点的最大贡献值
		return node.val + Math.max(leftGain, rightGain);
	}
	public static TreeNode getTree(){
		TreeNode treeNode5 = new TreeNode();
		treeNode5.val = 7;
		TreeNode treeNode4 = new TreeNode();
		treeNode4.val = 15;
		TreeNode treeNode3 = new TreeNode();
		treeNode3.val = 20;
		treeNode3.left = treeNode4;
		treeNode3.right = treeNode5;
		TreeNode treeNode2 = new TreeNode();
		treeNode2.val = 9;
		TreeNode treeNode = new TreeNode();
		treeNode.left = treeNode2;
		treeNode.right = treeNode3;
		treeNode.val = -10;
		return treeNode;
	}


}
class TreeNode{
	TreeNode left;
	TreeNode right;
	int val;
	TreeNode() {}
}