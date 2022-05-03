package com.us.easylevel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Uma Shankar
 * <pre>
 * ----------------------------------------------------------------------------------------
 * Given the root of a binary tree, return the level order traversal of its nodes' values. 
 * (i.e., from left to right, level by level).
 * 
 *  Example:
 * 
 *             3
 *            / \
 *           9   20
 *               / \
 *              15	7
 *              
 * 
 *  Input:
 *  	root = [3,9,20,null,null,15,7]
 *  
 *  Output:
 *  	[[3], [9,20], [15,7]]
 *  
 * -----------------------------------------------------------------------------------------
 *
 *
 */
public class LevelOrderTraversalBT {

	static class TreeNode {
		public int value;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int value) {
			this.value = value;
		}
	}

	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> currentLevel = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode current = queue.remove();
				currentLevel.add(current.value);

				if (current.left != null) {
					queue.add(current.left);
				}
				if (current.right != null) {
					queue.add(current.right);
				}
			}
			result.add(currentLevel);
		}
		return result;
	}
}
