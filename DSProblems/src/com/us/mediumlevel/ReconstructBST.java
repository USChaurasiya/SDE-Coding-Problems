package com.us.mediumlevel;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Uma Shankar
 * 
 *         <pre>
 *         ======================================================================
 * 
 *         Given a non-empty array of integers representing the pre-order traversal of a Binary search tree, write a function
 *         that creates the appropriate BST and returns its root node.
 *         
 *         The pre-order traversal of a binary tree is a traversal technique that starts at the tree's root and visits node in 
 *         the following order:
 *         		1: Current Node
 *         		2: Left Subtree
 *         		3: Right Subtree
 *         
 *         
 *         
 *         
 * Sample Input:
 * 		array = [10,4,2,1,5,17,19,18]
 * 						
 *
 *Sample Output:	
 * 						  10
 * 						/	\
 * 					   4	 17
 *					  / \	  \
 *					 2	 5     19
 *					/          /
 *				   1   		  18
 *	
 *         ======================================================================
 *
 */
public class ReconstructBST {
	
	static class BST {
		public int value;
		public BST left = null;
		public BST right = null;

		public BST(int value) {
			this.value = value;
		}
	}

	static class TreeInfo {
		public int rootIndex;

		public TreeInfo(int rootIndex) {
			this.rootIndex = rootIndex;
		}
	}

	// O(n) Time and O(n) Space complexity
	public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
		TreeInfo treeInfo = new TreeInfo(0);
		return reconstructBSTFromRange(Integer.MIN_VALUE, Integer.MAX_VALUE, preOrderTraversalValues, treeInfo);
	}

	public BST reconstructBSTFromRange(int lower, int upper, List<Integer> preOrderTraversalValues,
			TreeInfo currentSubTreeInfo) {
		if (currentSubTreeInfo.rootIndex == preOrderTraversalValues.size()) {
			return null;
		}
		int rootValue = preOrderTraversalValues.get(currentSubTreeInfo.rootIndex);
		if (rootValue < lower || rootValue >= upper) {
			return null;
		}
		currentSubTreeInfo.rootIndex += 1;
		BST leftSubTree = reconstructBSTFromRange(lower, rootValue, preOrderTraversalValues, currentSubTreeInfo);
		BST rightSubTree = reconstructBSTFromRange(rootValue, upper, preOrderTraversalValues, currentSubTreeInfo);

		BST bst = new BST(rootValue);
		bst.left = leftSubTree;
		bst.right = rightSubTree;

		return bst;
	}

}
