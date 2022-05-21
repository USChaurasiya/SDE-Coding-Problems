package com.us.mediumlevel;

import java.util.ArrayList;

/**
 * @author Uma Shankar
 * <pre>
 * ---------------------------------------------------------------------------------------
 * Write a function that takes in a Binary tree as well as a Node contained in that tree
 * and returns the given node's Successor.
 * 
 * A Node successor is the next node to be visited when traversing its tree using in-order
 * tree traversal Technique. A Node has no successor if it's the last node to be visited in
 * the in-order traversal.
 * 
 * If node has no successor, function should return None/Null.
 * 
 * Sample Input:
 * 	tree = 
 *                     1
 *                    / \
 *                   2   3
 *                  / \
 *                 4   5
 *                /
 *               6
 *  node = 5
 *  
 *  
 *  Sample Output:
 *  	1
 *  
 *  Tree's In-order traversal is 6 -> 4 -> 2-> 5-> 1 -> 3 so here 1 comes immediately after 5.
 *  
 *  ------------------------------------------------------------------------------------------
 * 	
 */
public class FindSuccessorBT {

	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(1);
		root.left = new BinaryTree(2);
		root.left.parent = root;
		root.right = new BinaryTree(3);
		root.right.parent = root;
		root.left.left = new BinaryTree(4);
		root.left.left.parent = root.left;
		root.left.right = new BinaryTree(5);
		root.left.right.parent = root.left;
		root.left.left.left = new BinaryTree(6);
		root.left.left.left.parent = root.left.left;
		BinaryTree node = root.left.right;

		System.out.println("Successor Node of given node " + node.value + " is : " + findSuccessor(root, node).value);
	}

	static class BinaryTree {
		public int value;
		public BinaryTree left = null;
		public BinaryTree right = null;
		public BinaryTree parent = null;

		public BinaryTree(int value) {
			this.value = value;
		}
	}

	// Solution 1: O(n) Time and O(n) Space Complexity, n is number of Nodes
	public static BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
		ArrayList<BinaryTree> inOrderTraversalOrder = new ArrayList<BinaryTree>();
		getInOrderTraversalOrder(tree, inOrderTraversalOrder);

		for (int i = 0; i < inOrderTraversalOrder.size(); i++) {
			BinaryTree currentNode = inOrderTraversalOrder.get(i);

			if (currentNode != node) {
				continue;
			}
			if (i == inOrderTraversalOrder.size() - 1) {
				return null;
			}
			return inOrderTraversalOrder.get(i + 1);
		}
		return null;
	}

	static void getInOrderTraversalOrder(BinaryTree node, ArrayList<BinaryTree> order) {
		if (node == null) {
			return;
		}

		getInOrderTraversalOrder(node.left, order);
		order.add(node);
		getInOrderTraversalOrder(node.right, order);
	}

	// Solution 2: O(h) Time and O(1) Space Complexity, h is the height of Tree
	public static BinaryTree findSuccessorInBT(BinaryTree tree, BinaryTree node) {
		if (node.right != null)
			return getLeftMostCild(node.right);
		return getRightMostParent(node);
	}

	public static BinaryTree getLeftMostCild(BinaryTree tree) {
		BinaryTree currentNode = tree;
		while (currentNode.left != null) {
			currentNode = currentNode.left;
		}
		return currentNode;
	}

	public static BinaryTree getRightMostParent(BinaryTree tree) {
		BinaryTree currentNode = tree;
		while (currentNode.parent != null && currentNode.parent.right == currentNode) {
			currentNode = currentNode.parent;
		}
		return currentNode.parent;
	}
}
