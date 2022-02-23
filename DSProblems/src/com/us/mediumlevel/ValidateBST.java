package com.us.mediumlevel;

/**
 * @author Uma Shankar
 * 
 *         <pre>
 *         ======================================================================
 * 
 *         Write a function that takes in a potentially invalid Binary search tree and returns a boolean value representing 
 *         whether the BST is valid or not.
 *         
 *         A node is said to be a valid BST node if and only if it satisfy the BST property, Its value is strictly greater
 *         than the values of every node to its left. Its value is less than or equal to the value of every node to its right.
 *         
 *         
 * 						
 * 	Example: 	
 * 						  10
 * 						/	\
 * 					   5	 15
 *					  / \	 / \
 *					 2	 5  13  20
 *					/        \
 *				   1   		 14
 *	Sample Output :
 *			true
 *			
 *         ======================================================================
 *
 */
public class ValidateBST {
	
	static class BST{
		public int value;
		public BST left;
		public BST right;
		
		public BST(int value) {
			this.value = value;
		}
	}
	
	public static boolean validateBST(BST tree) {
		return validateBST(tree,Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	
	// O(n) Time and O(d) Space Complexity
	private static boolean validateBST(BST tree, int minValue, int maxValue) {
		if (tree.value < minValue || tree.value >= maxValue) {
			return false;
		}
		if (tree.left != null && !validateBST(tree.left, minValue, tree.value)) {
			return false;
		}
		if (tree.right != null && !validateBST(tree.right, tree.value, maxValue)) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		var root = new ValidateBST.BST(10);
	    root.left = new ValidateBST.BST(5);
	    root.left.left = new ValidateBST.BST(2);
	    root.left.left.left = new ValidateBST.BST(1);
	    root.left.right = new ValidateBST.BST(5);
	    root.right = new ValidateBST.BST(15);
	    root.right.left = new ValidateBST.BST(13);
	    root.right.left.right = new ValidateBST.BST(14);
	    root.right.right = new ValidateBST.BST(22);
	    
	    System.out.println("Is given BST is valid : "+ validateBST(root));
	}

}
