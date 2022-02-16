package com.us.easylevel;
/**
 * @author Uma Shankar
 * 
 *         <pre>
 *         ======================================================================
 * 
 *         The distance between a node in a binary tree and the tree's root is called the Node's depth.
 * 
 *         Write a function that takes in a Binary Search tree(BST) and returns the sum of it's node's depths.
 *         
 * 						
 * 	Example: 	
 * 						  1
 * 						/	\
 * 					   2	 3
 *					  / \	 / \
 *					 4	 5  6   7
 *					/ \  
 *					8  9 
 *	Sample Output :
 *			16
 *
 *			The depth of the node with value 2 is 1.
 *			The depth of the node with value 3 is 1.
 *			The depth of the node with value 4 is 2.
 *			The depth of the node with value 5 is 2.
 *			The depth of the node with value 8 is 3.
 *			The depth of the node with value 9 is 3.
 *			The depth of the node with value 6 is 2.
 *			The depth of the node with value 7 is 2.
 *			
 *         ======================================================================
 *
 */
public class NodeDepths {

	// Average case : When tree is balanced
	// O(n) time complexity and O(h) space complexity. n is Number of nodes and h is height of binary tree.'
	public static int nodeDepths(BinaryTree root) {
		return nodeDepthsCalculator(root, 0);
	}

	public static int nodeDepthsCalculator(BinaryTree tree, int depth) {
		if (tree == null)
			return 0;
		return depth + nodeDepthsCalculator(tree.left, depth + 1) + nodeDepthsCalculator(tree.right, depth + 1);
	}

	static class BinaryTree {
		int value;
		BinaryTree left;
		BinaryTree right;

		public BinaryTree(int value) {
			this.value = value;
			left = null;
			right = null;
		}
	}

}
