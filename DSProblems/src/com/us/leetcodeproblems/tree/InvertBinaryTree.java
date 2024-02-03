package com.us.leetcodeproblems.tree;

/**
 * Given the root of a binary tree, invert the tree, and return its root.
 * Example :
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 */
public class InvertBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	// Time Complexity : O(n)  Space Complexity : O(h) h-> Height of the tree;
	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return null;
		swap(root);
		invertTree(root.left);
		invertTree(root.right);
		return root;
	}

	private void swap(TreeNode root) {
		TreeNode left = root.left;
		root.left = root.right;
		root.right = left;

	}

}
