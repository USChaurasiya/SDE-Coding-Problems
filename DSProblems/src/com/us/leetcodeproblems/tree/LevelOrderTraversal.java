package com.us.leetcodeproblems.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 * Example:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 */
public class LevelOrderTraversal {

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
	
	//Time Complexity : O(log n) | Space Complexity O(n)
	public List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if (root == null)
			return result;
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> levelList = new LinkedList<>();
			for (int i = 0; i < size; i++) {
				if (queue.peek().left != null)
					queue.offer(queue.peek().left);
				if (queue.peek().right != null)
					queue.offer(queue.peek().right);
				levelList.add(queue.poll().val);
			}
			result.add(levelList);
		}
		return result;
	}
}
