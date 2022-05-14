package com.us.hardlevel;

import java.util.ArrayList;

/**
 * @author Uma Shankar
 * <pre>
 * -----------------------------------------------------------------------------------------
 * You're given the root node of a Binary tree, a target value of a node that's contained in
 * the tree, and a positive integer k. 
 * Write a function that returns the values of all the nodes that are exactly distance k from
 * the node with target value.
 * 
 * The distance between two nodes is defined as the number of edges that must be traversed to
 * go from one node to the other.
 * 
 * Note that all BinaryTree Node values will be unique, and function can return the output 
 * value in any order.
 * 
 * 
 * Sample Input:
 * 	tree:
 *                1
 *              /   \
 *             2     3
 *            / \     \
 *           4   5     6
 *                    / \
 *                   7   8
 *  target = 3
 *  k = 2
 *  
 *  Sample Output:
 *  	[2, 7, 8]
 *  
 *  -----------------------------------------------------------------------------------------
 *
 */
public class KDistanceNode {

	public static void main(String[] args) {

		BinaryTree root = new BinaryTree(1);
		root.left = new BinaryTree(2);
		root.right = new BinaryTree(3);
		root.left.left = new BinaryTree(4);
		root.left.right = new BinaryTree(5);
		root.right.right = new BinaryTree(6);
		root.right.right.left = new BinaryTree(7);
		root.right.right.right = new BinaryTree(8);
		int target = 3;
		int k = 2;

		System.out.println("Nodes with distance " + k + " from target " + target + " in given tree are :");
		findNodesDistanceK(root, target, k).forEach(ele -> System.out.print(ele + " "));
	}

	static class BinaryTree {
		public int value;
		public BinaryTree left = null;
		public BinaryTree right = null;

		public BinaryTree(int value) {
			this.value = value;
		}
	}

	static class Pair<U, V> {
		public final U first;
		public final V second;

		private Pair(U first, V second) {
			this.first = first;
			this.second = second;
		}
	}

	public static ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {

		ArrayList<Integer> nodeDistanceK = new ArrayList<Integer>();
		findDistanceFromNodeToTarget(tree, target, k, nodeDistanceK);
		return nodeDistanceK;
	}

	private static int findDistanceFromNodeToTarget(BinaryTree tree, int target, int k,
			ArrayList<Integer> nodeDistanceK) {
		if (tree == null)
			return -1;
		if (tree.value == target) {
			addSubTreeNodeAtDistanceK(tree, 0, k, nodeDistanceK);
			return 1;
		}
		int leftDistance = findDistanceFromNodeToTarget(tree.left, target, k, nodeDistanceK);
		int rightDistance = findDistanceFromNodeToTarget(tree.right, target, k, nodeDistanceK);

		if (leftDistance == k || rightDistance == k)
			nodeDistanceK.add(tree.value);

		if (leftDistance != -1) {
			addSubTreeNodeAtDistanceK(tree.right, leftDistance + 1, k, nodeDistanceK);
			return leftDistance + 1;
		}
		if (rightDistance != -1) {
			addSubTreeNodeAtDistanceK(tree.left, rightDistance + 1, k, nodeDistanceK);
			return rightDistance + 1;
		}
		return -1;
	}

	private static void addSubTreeNodeAtDistanceK(BinaryTree tree, int distance, int k,
			ArrayList<Integer> nodeDistanceK) {
		if (tree == null)
			return;
		if (distance == k) {
			nodeDistanceK.add(tree.value);
		} else {
			addSubTreeNodeAtDistanceK(tree.left, distance + 1, k, nodeDistanceK);
			addSubTreeNodeAtDistanceK(tree.right, distance + 1, k, nodeDistanceK);
		}
	}

}
