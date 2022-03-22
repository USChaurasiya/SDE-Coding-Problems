package com.us.mediumlevel;

/**
 * @author Uma Shankar
 * 
 * <pre>
 * --------------------------------------------------------------------------------------------------------
 *	You are given a root node of Binary Tree. Write a function that return true if the binary tree is height
 *  balanced and false if it isn't.
 *  
 *  A Binary Tree is height balanced if for each node in the tree, the difference between the height of it's 
 *  left subtree and the height of it's right subtree is at most 1.
 *         
 *         
 * Sample Input:
 * 
 *           1
 *          / \
 *         2   3
 *        / \   \
 *       4   5   6
 *          / \
 *         7   8
 * 						
 *
 *Sample Output:	
 *              true
 *           
 *           
 * To determine if a subtree is balanced, you need to know the height of it's left and right subtrees. If subtree
 * has no left and right subtrees then that subtree must be balanced.
 * 
 * --------------------------------------------------------------------------------------------------------
 *
 */
public class HeightBalancedBinaryTree {

	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(1);
		root = new BinaryTree(1);
		root.left = new BinaryTree(2);
		root.right = new BinaryTree(3);
		root.left.left = new BinaryTree(4);
		root.left.right = new BinaryTree(5);
		root.right.right = new BinaryTree(6);
		root.left.right.left = new BinaryTree(7);
		root.left.right.right = new BinaryTree(8);

		System.out.println("Is Given Binary tree is Height Balanced : " + heightBalancedBinaryTree(root));
	}

	static class BinaryTree {
		int value;
		public BinaryTree left = null;
		public BinaryTree right = null;

		public BinaryTree(int value) {
			this.value = value;
		}
	}

	static class TreeInfo {
		public boolean isBalanced;
		public int height;

		public TreeInfo(boolean isBalanced, int height) {
			this.height = height;
			this.isBalanced = isBalanced;
		}
	}

	public static boolean heightBalancedBinaryTree(BinaryTree tree) {
		TreeInfo treeInfo = getTreeInfo(tree);
		return treeInfo.isBalanced;
	}

	private static TreeInfo getTreeInfo(BinaryTree tree) {
		if (tree == null) {
			return new TreeInfo(true, -1);
		}

		TreeInfo leftSubTree = getTreeInfo(tree.left);
		TreeInfo rightSubTree = getTreeInfo(tree.right);

		boolean isBalanced = leftSubTree.isBalanced && rightSubTree.isBalanced
				&& Math.abs(leftSubTree.height - rightSubTree.height) <= 1;
		int height = Math.max(leftSubTree.height, rightSubTree.height) + 1;

		return new TreeInfo(isBalanced, height);
	}
}
