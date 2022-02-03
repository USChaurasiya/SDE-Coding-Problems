package com.us.easylevel;

/**
 * @author Uma Shankar
 * 
 *         <pre>
 *         ======================================================================
 * 
 *         Write a function that takes in a Binary Search tree(BST) and a target
 *         integer value and returns the closest value to that target value
 *         contained in BST.
 * 
 *         <pre>
 * 
 *         For Example if you have given coins = [1,2,5], the minimum amount of
 *         change that you can't create is 4.
 * 
 * 
 *         ======================================================================
 *
 */
public class ClosestValueInBST {

	public static int findClosestValueInBST(BST tree, int target) {
		return findClosestValueInBST(tree, target, tree.value);
	}

	public static int findClosestValueInBST(BST tree, int target, int closest) {
		BST currentNode = tree; // Assign the currentNode to BST
		while (currentNode != null) {
			if (Math.abs(target - closest) > Math.abs(target - currentNode.value)) {
				closest = currentNode.value;
			}
			if (target > currentNode.value) {
				currentNode = currentNode.right;
			} else if (target < currentNode.value) {
				currentNode = currentNode.left;
			} else {
				break;
			}
		}
		return closest;
	}

	static class BST {
		public int value;
		public BST left;
		public BST right;

		public BST(int value) {
			this.value = value;
		}
	}

}
