package com.us.leetcodeproblems.tree;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node
 * of two given nodes in the BST. According to the definition of LCA on
 * Wikipedia: “The lowest common ancestor is defined between two nodes p and q
 * as the lowest node in T that has both p and q as descendants (where we allow
 * a node to be a descendant of itself).”
 * 
 * Example :
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 */
public class LowestCommonAncestor {

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

	// Time Complexity : O(log n)
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		if (p == root || q == root)
			return root;

		TreeNode leftCA = lowestCommonAncestor(root.left, p, q);
		TreeNode rightCA = lowestCommonAncestor(root.right, p, q);

		if (leftCA != null && rightCA != null) {
			return root;
		}
		if (leftCA != null) {
			return leftCA;
		}
		return rightCA;
	}

}
