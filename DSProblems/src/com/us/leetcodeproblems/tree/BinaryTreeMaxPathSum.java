package com.us.leetcodeproblems.tree;

/**
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 * The path sum of a path is the sum of the node's values in the path.
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 */
public class BinaryTreeMaxPathSum {

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

	// Time Complexity : O(n)
	public int maxPathSum(TreeNode root) {
		int maxValue[] = new int[1];
		maxValue[0] = Integer.MIN_VALUE;
		maxChildPathSum(root, maxValue);
		return maxValue[0];
	}

	int maxChildPathSum(TreeNode root, int[] maxValue) {
		if (root == null)
			return 0;
		int left = Math.max(maxChildPathSum(root.left, maxValue), 0);
		int right = Math.max(maxChildPathSum(root.right, maxValue), 0);

		maxValue[0] = Math.max(maxValue[0], root.val + left + right);
		return root.val + Math.max(left, right);

	}
}
