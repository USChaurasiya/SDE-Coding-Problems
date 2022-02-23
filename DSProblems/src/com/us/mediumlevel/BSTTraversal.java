package com.us.mediumlevel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Uma Shankar
 * 
 *         <pre>
 *         ======================================================================
 * 
 *         Write three functions that take in a binary search tree and an empty array, traverse the tree add its node 
 *         value to the input array and return the array. The three functions should traverse the BST using in-order,
 *         pre-order, and post-order.
 *         
 *         
 * 						
 * 	Example: 	
 * 						  10
 * 						/	\
 * 					   5	 15
 *					  / \	  \
 *					 2	 5     20
 *					/       
 *				   1   		 
 *	Sample Output :
 *			in-order : [1,2,5,5,10,15,20]
 *			pre-order: [10,5,2,1,5,15,20]
 *			post-order:[1,2,5,5,20,15,10]
 *			
 *         ======================================================================
 *
 */
public class BSTTraversal {
	
	static class BST {
		public int value;
		public BST left;
		public BST right;

		public BST(int value) {
			this.value = value;
		}
	}

	public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
		if (tree.left != null) {
			inOrderTraverse(tree.left, array);
		}
		array.add(tree.value);
		if (tree.right != null) {
			inOrderTraverse(tree.right, array);
		}
		return array;
	}

	public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
		array.add(tree.value);
		if (tree.left != null) {
			preOrderTraverse(tree.left, array);
		}
		if (tree.right != null) {
			preOrderTraverse(tree.right, array);
		}
		return array;
	}

	public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
		if (tree.left != null) {
			postOrderTraverse(tree.left, array);
		}
		if (tree.right != null) {
			postOrderTraverse(tree.right, array);
		}
		array.add(tree.value);
		return array;
	}
	
	public static void main(String[] args) {
		var root = new BSTTraversal.BST(10);
	    root.left = new BSTTraversal.BST(5);
	    root.left.left = new BSTTraversal.BST(2);
	    root.left.left.left = new BSTTraversal.BST(1);
	    root.left.right = new BSTTraversal.BST(5);
	    root.right = new BSTTraversal.BST(15);
	    root.right.right = new BSTTraversal.BST(20);
	    
	    List<Integer> inOrderList = new ArrayList<Integer>();
	    List<Integer> preOrderList = new ArrayList<Integer>();
	    List<Integer> postOrderList = new ArrayList<Integer>();
	    
	    System.out.print("In-Order traversal : ");
	    List<Integer> inresulted = inOrderTraverse(root, inOrderList);
	    inresulted.forEach(x->System.out.print(x+ " "));
	    
	    System.out.print("\nIn-Order traversal : ");
	    List<Integer> preresulted = preOrderTraverse(root, preOrderList);
	    preresulted.forEach(x->System.out.print(x+ " "));
	    
	    System.out.print("\nIn-Order traversal : ");
	    List<Integer> postresulted = postOrderTraverse(root, postOrderList);
	    postresulted.forEach(x->System.out.print(x+ " "));
	}
}
