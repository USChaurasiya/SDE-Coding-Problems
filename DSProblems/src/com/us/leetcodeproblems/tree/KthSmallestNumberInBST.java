package com.us.leetcodeproblems.tree;

/**
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 * Example:
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 */
public class KthSmallestNumberInBST {

	public static class TreeNode {
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
	public static int kthSmallest(TreeNode root, int k) {
		int[] nums = new int[2];
		inorderTraversal(root, k, nums);
		return nums[1];
	}

	public static void inorderTraversal(TreeNode root, int k, int[] nums) {
		if (root == null)
			return;

		inorderTraversal(root.left, k, nums);
		nums[0]++;
		if (k == nums[0]) {
			nums[1] = root.val;
			return;
		}
		inorderTraversal(root.right, k, nums);

	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left= new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right =  new TreeNode(6);
		
		int result = kthSmallest(root, 1);
		System.out.println("Kth smallest Number is : "+result);
	}
}
