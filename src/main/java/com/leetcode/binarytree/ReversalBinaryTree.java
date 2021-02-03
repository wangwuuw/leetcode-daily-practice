package com.leetcode.binarytree;

/**
 * @Author: wangwu
 * @Date: Created in 16:59 2021/02/02
 * @Description:
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
public class ReversalBinaryTree {
	public static void main(String[] args) {
		ReversalBinaryTree reversalBinaryTree = new ReversalBinaryTree();
		TreeNode binaryTree = reversalBinaryTree.createBinaryTree();
		reversalBinaryTree.preOrder(binaryTree);
		reversalBinaryTree.reversal(binaryTree);
		System.out.println(binaryTree);

	}
	void reversal(TreeNode treeNode){
		TreeNode leftChild = treeNode.leftChild;
		TreeNode rightChild = treeNode.rightChild;
		if (leftChild != null) {
			TreeNode temp = rightChild;
			rightChild = leftChild;
			leftChild = temp;
			treeNode.rightChild = rightChild;
			treeNode.leftChild = leftChild;
			reversal(leftChild);
			reversal(rightChild);

		}
//		if (leftChild != null) {
//			int temp = rightChild.data;
//			rightChild.data = leftChild.data;
//			leftChild.data = temp;
//			reversal(leftChild);
//		}

	}
	public void preOrder(TreeNode treeNode){
		if (treeNode != null) {
			System.out.println(treeNode.data);
			preOrder(treeNode.leftChild);
			preOrder(treeNode.rightChild);
		}
	}
	/**
	 * BinaryTree 的节点数据结构
	 */
	public  TreeNode createBinaryTree(){
		TreeNode treeNode = new TreeNode(4);
		TreeNode treeNodeB = new TreeNode(2);
		TreeNode treeNodeC = new TreeNode(3);
		TreeNode treeNodeD = new TreeNode(1);
		TreeNode treeNodeF = new TreeNode(6);
		TreeNode treeNodeG = new TreeNode(7);
		TreeNode treeNodeH = new TreeNode(9);
		treeNode.leftChild = treeNodeB;
		treeNodeB.leftChild = treeNodeD;
		treeNodeB.rightChild = treeNodeC;
		treeNode.rightChild = treeNodeG;
		treeNodeG.leftChild = treeNodeF;
		treeNodeG.rightChild = treeNodeH;
		return treeNode;
	}
	private class TreeNode {
		private int data = 0;
		private ReversalBinaryTree.TreeNode leftChild = null;
		private ReversalBinaryTree.TreeNode rightChild = null;

		public TreeNode() {
		}

		public TreeNode(int data) {
			this.data = data;
			this.leftChild = null;
			this.rightChild = null;
		}
	}
}

