package com.us.leetcodeproblems.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).
 * Example :
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[15,7],[9,20],[3]]
 */
public class LevelOrderBottomTraversal {
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

	/**
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		dfs(root, 0, ans);
		Collections.reverse(ans);
		return ans;
	}

	public void dfs(TreeNode node, int depth, List<List<Integer>> ans) {
		if (node == null)
			return;
		if (depth == ans.size())
			ans.add(new ArrayList<>());
		ans.get(depth).add(node.val);
		dfs(node.left, depth + 1, ans);
		dfs(node.right, depth + 1, ans);
	}
}
