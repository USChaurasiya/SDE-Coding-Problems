package com.us.mediumlevel;

/**
 * @author Uma Shankar
 * 
 *         <pre>
 *         ======================================================================
 * 
 *         Write a function that takes a non-empty sorted array of distinct Integers,construct a BST from the Integers and
 *         returns the root of the BST.
 *         
 *         
 *         
 *         
 * Sample Input:
 * 		array = [1,2,5,7,10,13,14,15,22]
 * 						
 *
 *Sample Output:	
 * 						  10
 * 						/	\
 * 					   5	 15
 *					  / \	 / \
 *					 2	 7  13  22
 *					/        \
 *				   1   		  14
 *	
 *         ======================================================================
 *
 */
public class MinHeightBST {
	
	public static class BST{
		public int value;
		public BST left;
		public BST right;
		
		public BST(int value) {
			this.value = value;
		}
		
		public void insert(int value) {
			if(value < this.value) {
				if(left == null) {
					left = new BST(value);
				}else {
					left.insert(value);
				}
			}else {
				if(right == null) {
					right = new BST(value);
				}else {
					right.insert(value);
				}
			}
		}
	}
	
	public static BST minimumHeightBST(int[] arr) {
		return constructMinHeightBST(arr, 0, arr.length-1);
	}

	
	// Solution 1: O(n) Time and O(n) Space Complexity
	private static BST constructMinHeightBST(int[] arr, int startIndex, int endIndex) {
		if(endIndex < startIndex) {
			return null;
		}
		int midIndex = (startIndex+endIndex)/2;
		BST bst = new BST(arr[midIndex]);
		bst.left = constructMinHeightBST(arr, startIndex, midIndex-1);
		bst.right = constructMinHeightBST(arr, midIndex+1, endIndex);
		return bst;
	}
	
	
	// Solution 2: O(nlog(n)) Time and O(n) Space complexity
	public static BST constructMinHeightBst(int[] array, BST bst, int startIndex, int endIndex) {
		if(endIndex < startIndex) return null;
		int midIndex = (startIndex+endIndex)/2;
		int nextNoToAdd = array[midIndex];
		if(bst == null) {
			bst = new BST(nextNoToAdd);
		}else {
			bst.insert(nextNoToAdd);
		}
		constructMinHeightBst(array, bst, startIndex, midIndex-1);
		constructMinHeightBst(array, bst, midIndex+1, endIndex);
		return bst;
	}

}
