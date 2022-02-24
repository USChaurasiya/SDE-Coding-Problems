package com.us.mediumlevel;

import java.util.ArrayDeque;

/**
 * @author Uma Shankar
 * 
 *         <pre>
 *         ======================================================================
 *			Write a function that takes in a binary tree and inverts it. The function should swap every left node in 
 *			the tree for its corresponding right node.
 *         
 *         
 *         
 *         
 * Sample Input:
 * 						 10
 * 						/	\
 * 					   4	 17
 *					  / \	  \
 *					 2	 5     19
 *					/          /
 *				   1   		  18
 * 						
 *
 *Sample Output:	
 * 						  10
 * 						/	\
 * 					   17	 4
 *					  / 	/ \
 *					 19	   5   2
 *					  \         \
 *				      18		 1
 *	
 *         ======================================================================
 *
 */
public class InvertBinaryTree {
	
	
	public static class BinaryTree{
		public int value;
		public BinaryTree left;
		public BinaryTree right;
		
		public BinaryTree(int value) {
			this.value = value;
		}		
	}
	
	// Solution 1: O(n) Time and O(d) Space Complexity
	public static void invertBinaryTree(BinaryTree tree) {
		if(tree == null) return;
		swapLeftAndRightNode(tree);
		invertBinaryTree(tree.left);
		invertBinaryTree(tree.right);
	}
	
	
	// Solution 2: O(n) Time and O(n) Space complexity
	public static void invertBinaryTREE(BinaryTree tree) {
		ArrayDeque<BinaryTree> queue = new ArrayDeque<BinaryTree>();
		queue.addLast(tree);
		while(queue.size()>0) {
			BinaryTree current = queue.pollFirst();
			swapLeftAndRightNode(current);
			if(current.left != null) {
				queue.addLast(current.left);
			}
			if(current.right != null) {
				queue.addLast(current.right);
			}
		}
	}

	private static void swapLeftAndRightNode(BinaryTree tree) {
		BinaryTree left = tree.left;
		tree.left = tree.right;
		tree.right = left;
	}

}
