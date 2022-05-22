package com.us.veryhardlevel;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author Uma Shankar
 * <pre>
 * -----------------------------------------------------------------------------------------
 * Write a function that takes in a Binary Tree and Traverses it Iteratively using in-order
 * Traversal technique.
 * The traversal should specifically not use recursion. As the tree is being traversed, a callback
 * Function passed in as an argument to the main function should be called on each node.
 * callback(currentNode)
 * 
 * 
 * 
 * Sample Input:
 *    tree=
 *                  1
 *                /   \
 *               2     3
 *              /     / \
 *             4     6   7
 *              \
 *               9
 *  callback = someCallback
 *               
 * Sample Output:
 * 
 *  callback(4)
 *  callback(9)
 * 	callback(2)
 *  callback(1)
 *  callback(6)
 *  callback(3)
 *  callback(7)
 *
 *-----------------------------------------------------------------------------------------
 */
public class IterativeInOrderTraversal {

	public List<Integer> testArray = new ArrayList<Integer>();

	public static void main(String[] args) {

		IterativeInOrderTraversal iOrderTraversal = new IterativeInOrderTraversal();
		iOrderTraversal.test();

	}

	public void test() {

		var root = new BinaryTree(1);
		root.left = new BinaryTree(2, root);
		root.left.left = new BinaryTree(4, root.left);
		root.left.left.right = new BinaryTree(9, root.left.left);
		root.right = new BinaryTree(3, root);
		root.right.left = new BinaryTree(6, root.right);
		root.right.right = new BinaryTree(7, root.right);
		this.testArray.clear();

		iterativeInOrderTraversal(root, this::testCallback);
		System.out.println("In-Order Traversal of given Tree  is : ");
		this.testArray.forEach(ele -> System.out.print(ele + " "));
	}

	public Void testCallback(BinaryTree tree) {
		if (tree == null) {
			return null;
		}
		testArray.add(tree.value);
		return null;
	}

	static class BinaryTree {
		public int value;
		public BinaryTree left;
		public BinaryTree right;
		public BinaryTree parent;

		public BinaryTree(int value) {
			this.value = value;
		}

		public BinaryTree(int value, BinaryTree parent) {
			this.value = value;
			this.parent = parent;
		}
	}

	// O(n) Time and O(1) Space Complexity
	public static void iterativeInOrderTraversal(BinaryTree tree, Function<BinaryTree, Void> callback) {
		BinaryTree previousNode = null;
		BinaryTree currentNode = tree;

		while (currentNode != null) {
			BinaryTree nextNode;
			if (previousNode == null || previousNode == currentNode.parent) {
				if (currentNode.left != null) {
					nextNode = currentNode.left;
				} else {
					callback.apply(currentNode);
					nextNode = currentNode.right != null ? currentNode.right : currentNode.parent;
				}
			} else if (previousNode == currentNode.left) {
				callback.apply(currentNode);
				nextNode = currentNode.right != null ? currentNode.right : currentNode.parent;
			} else {
				nextNode = currentNode.parent;
			}
			previousNode = currentNode;
			currentNode = nextNode;
		}
	}

}
