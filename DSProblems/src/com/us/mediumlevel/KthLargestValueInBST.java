package com.us.mediumlevel;

import java.util.ArrayList;

/**
 * @author Uma Shankar
 * 
 * <pre>
 * ======================================================================
 *	Write a function that takes in a Binary Search Tree and a positive Integer k and returns the kth largest contained in the BST.
 *	Duplicate Integers will be treated as distinct values. For Example the second largest value in BST containing
 *	value {2,3,3,4} will be 3.
 *         
 *         
 * Sample Input:
 * tree =
 *           15
 *          /  \
 *         5    20
 *        / \   / \
 *       2   5 17  22
 *      / \
 *     1   3			
 *
 *
 *K = 3
 *Sample Output:	
 * 	17
 * ======================================================================
 *
 */
public class KthLargestValueInBST {
	
	public static void main(String[] args) {
		KthLargestValueInBST.BST root = new KthLargestValueInBST.BST(15);
	    root.left = new KthLargestValueInBST.BST(5);
	    root.left.left = new KthLargestValueInBST.BST(2);
	    root.left.left.left = new KthLargestValueInBST.BST(1);
	    root.left.left.right = new KthLargestValueInBST.BST(3);
	    root.left.right = new KthLargestValueInBST.BST(5);
	    root.right = new KthLargestValueInBST.BST(20);
	    root.right.left = new KthLargestValueInBST.BST(17);
	    root.right.right = new KthLargestValueInBST.BST(22);
	 
	    int k = 4;
	    System.out.println(k+"th largest Value in the given BST is : "+findKthLargestValue(root, k));
	}
	
	static class BST{
		public int value;
		public BST left = null;
		public BST right = null;
		
		public BST(int value) {
			this.value = value;
		}
	}
	
	// Solution : O(n) Time and O(n) Space Complexity
	public static int findKthLargestValue(BST tree, int k) {
		ArrayList<Integer> sortedValue = new ArrayList<Integer>();
		inOrderTraverse(tree, sortedValue);
		return sortedValue.get(sortedValue.size()-k);
	}
	
	public static void inOrderTraverse (BST node, ArrayList<Integer> sortedArray) {
		if(node == null) return ;
		inOrderTraverse(node.left, sortedArray);
		sortedArray.add(node.value);
		inOrderTraverse(node.right, sortedArray);
	}

}
