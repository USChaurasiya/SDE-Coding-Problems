package com.us.mediumlevel;


/**
 * @author Uma Shankar
 * 
 * <pre>
 * --------------------------------------------------------------------------------------------------------
 *	Write a function that takes a Binary Tree and returns it's diameter. The diameter of a Binary tree is 
 *	Defined as the length of it's longest path, even if that path doesn't pass through root of the tree.
 *
 *	A path is is a collection of nodes in a tree, where no node is connected to more than two other nodes.
 *	The length of the path is the number of edges between the path's first node and it's last Node.
 *         
 *         
 * Sample Input:
 * 
 *           1
 *          / \
 *         3   2
 *        / \
 *       7   4
 *      /     \
 *     8       5
 *    /         \
 *   9           6
 * 						
 *
 *Sample Output:	
 *              6
 *              // 9->8->7->3->4->5->6
 *              // total 6 edges
 * --------------------------------------------------------------------------------------------------------
 *
 */
public class BinaryTreeDiameter {
	
	public static class BinaryTree{
		int value;
		BinaryTree left = null;
		BinaryTree right = null;
		
		public BinaryTree(int value) {
			this.value = value;
		}
	}
	
	static class TreeInfo{
		int diameter;
		int height;
		
		public TreeInfo(int diameter, int height) {
			this.diameter = diameter;
			this.height = height;
		}
	}

	// O(n) Time and O(h) Space Complexity
	public int binaryTreeDiameter(BinaryTree tree) {
		return getTreeInfo(tree).diameter;
	}
	
	public TreeInfo getTreeInfo(BinaryTree tree) {
		if(tree==null) return new TreeInfo(0, 0);
		
		TreeInfo leftTreeInfo = getTreeInfo(tree.left);
		TreeInfo rightTreeInfo = getTreeInfo(tree.right);
		
		int longestPathThroughRoot = leftTreeInfo.height + rightTreeInfo.height;
		int maxDiameterSoFar = Math.max(leftTreeInfo.diameter, rightTreeInfo.diameter);
		int currentDiameter = Math.max(longestPathThroughRoot, maxDiameterSoFar);
		int currentHeight = 1+Math.max(leftTreeInfo.height, rightTreeInfo.height);
		
		return new TreeInfo(currentDiameter, currentHeight);
	}
}
