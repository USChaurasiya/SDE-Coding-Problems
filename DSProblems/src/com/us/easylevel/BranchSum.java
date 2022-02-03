package com.us.easylevel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Uma Shankar
 * 
 *         <pre>
 *         ======================================================================
 * 
 *         Write a function that takes in a Binary Search tree(BST) and returns a list of its branch sums
 *         ordered from leftmost branch sum to rightmost branch sum.
 *         
 *         <b>A branch sum is the sum of all the values in a Binary Tree branch, A Binary tree branch is a path
 *         of nodes in a tree that starts at the root node and ends at any leaf Node.<b>
 * 						
 * 	Example: 	
 * 						  1
 * 						/	\
 * 					   2	 3
 *					  / \	 / \
 *					 4	 5  6   7
 *					/ \  /
 *					8  9 10
 *	Sample Output :
 *			[15,16,18,10,11]
 *
 *			15 == 1+2+4+8
 *			16 == 1+2+4+9
 *			18 == 1+2+5+10
 *			10 == 1+3+6
 *			11 == 1+3+7
 *         ======================================================================
 *
 */
public class BranchSum {

	public static class BinaryTree {
		int value;
		BinaryTree left;
		BinaryTree right;

		BinaryTree(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}

	public static List<Integer> branchSums(BinaryTree root) {
		List<Integer> result = new ArrayList<Integer>();

		calculateBranchSum(root, 0, result);
		return result;
	}

	public static void calculateBranchSum(BinaryTree tree, int runningSum, List<Integer> sums) {
		if (tree == null)
			return;

		int newRunningSum = runningSum + tree.value;
		if (tree.left == null && tree.right == null) {
			sums.add(newRunningSum);
			return;
		}
		calculateBranchSum(tree.left, newRunningSum, sums);
		calculateBranchSum(tree.right, newRunningSum, sums);
	}

}
