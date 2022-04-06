package com.us.hardlevel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author Uma Shankar
 * 
 * <pre>
 * --------------------------------------------------------------------------------------------------------
 *	Write a function that takes a Binary Tree and returns it's max path sum. 
 *
 *	A path is is a collection of nodes in a tree, where no node is connected to more than two other nodes.
 *	Path sum is the sum of the value of the nodes in a particular path.
 *         
 *         
 * Sample Input:
 * 
 *           1
 *          / \
 *         2   3
 *        / \  /\
 *       4   5 6 7
 *    
 * 						
 *
 *Sample Output:	
 *              18
 *              // 5+2+1+3+7
 * --------------------------------------------------------------------------------------------------------
 *
 */
public class BinaryTreeMaxPathSum {
	
	public static void main(String[] args) {
		var root = new BinaryTreeMaxPathSum.BinaryTree(1);
	    root.left = new BinaryTreeMaxPathSum.BinaryTree(2);
	    root.left.left = new BinaryTreeMaxPathSum.BinaryTree(4);
	    root.left.right = new BinaryTreeMaxPathSum.BinaryTree(5);
	    root.right = new BinaryTreeMaxPathSum.BinaryTree(3);
	    root.right.left = new BinaryTreeMaxPathSum.BinaryTree(6);
	    root.right.right = new BinaryTreeMaxPathSum.BinaryTree(7);
	
	   
	    System.out.println("Max Path Sum of Given Binary Tree is : "+ maxPathSum(root));
	}

	
	// O(n) Time and O(log(n)) Space Complexity
	public static int maxPathSum(BinaryTree tree) {
		List<Integer> maxSumArray = findMaxSum(tree);

		return maxSumArray.get(1);
	}

	public static List<Integer> findMaxSum(BinaryTree tree) {
		if (tree == null) {
			return new ArrayList<Integer>(Arrays.asList(0, Integer.MIN_VALUE));
		}
		List<Integer> leftMaxSumArray = findMaxSum(tree.left);
		Integer leftMaxSumAsBranch = leftMaxSumArray.get(0);
		Integer leftMaxPathSum = leftMaxSumArray.get(1);

		List<Integer> rightMaxSumArray = findMaxSum(tree.right);
		Integer rightMaxSumAsBranch = rightMaxSumArray.get(0);
		Integer rightMaxPathSum = rightMaxSumArray.get(1);

		Integer maxChildSumAsBranch = Math.max(leftMaxSumAsBranch, rightMaxSumAsBranch);
		Integer maxSumAsBranch = Math.max(maxChildSumAsBranch + tree.value, tree.value);
		Integer maxSumAsRootNode = Math.max(leftMaxSumAsBranch + tree.value + rightMaxSumAsBranch, maxSumAsBranch);
		int maxPathSum = Math.max(leftMaxPathSum, Math.max(rightMaxPathSum, maxSumAsRootNode));
		return new ArrayList<Integer>(Arrays.asList(maxSumAsBranch, maxPathSum));
	}

	static class BinaryTree {
		public int value;
		public BinaryTree left;
		public BinaryTree right;

		public BinaryTree(int value) {
			this.value = value;
		}
	}

}
