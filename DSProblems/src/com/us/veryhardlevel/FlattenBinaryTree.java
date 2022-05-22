package com.us.veryhardlevel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Uma Shankar
 * <pre>
 * --------------------------------------------------------------------------------------
 * Write a function that takes in a Binary Tree, flatten it and return the leftMost Node.
 * 
 * A Flatten Binary Tree is a structure that's nearly identical to a double Linked List
 * where node follow the original tree's left-to-right order.
 * Note that if the input Binary Tree happens to be a valid Binary search tree, the node 
 * in the flattened tree will be sorted.
 * 
 * The flattening should be done in place, means the original data structure should be 
 * mutated(no new structure should be created).
 * 
 * 
 * Sample Input:
 *  tree =
 *                         1
 *                       /   \
 *                      2     3
 *                     / \   /
 *                    4   5 6
 *                        /  \
 *                       7    8
 *  
 *  Sample Output:
 *  	4 - 2 - 7 - 5 - 8 - 1 - 6 - 3
 *  
 *  ---------------------------------------------------------------------------------------
 *
 */
public class FlattenBinaryTree {

	static class BinaryTree {
		int value;
		BinaryTree left = null;
		BinaryTree right = null;

		public BinaryTree(int value) {
			this.value = value;
		}
	}

	// Solution 1: O(n) Time and O(n) Space Complexity
	public static BinaryTree flattenBinaryTree(BinaryTree root) {
		List<BinaryTree> inOrderNodes = getNodesInOrder(root, new ArrayList<BinaryTree>());
		for (int i = 0; i < inOrderNodes.size() - 1; i++) {
			BinaryTree leftNode = inOrderNodes.get(i);
			BinaryTree rightNode = inOrderNodes.get(i + 1);
			leftNode.right = rightNode;
			rightNode.left = leftNode;
		}
		return inOrderNodes.get(0);
	}

	public static List<BinaryTree> getNodesInOrder(BinaryTree tree, List<BinaryTree> array) {
		if (tree != null) {
			getNodesInOrder(tree.left, array);
			array.add(tree);
			getNodesInOrder(tree.right, array);
		}
		return array;
	}

	public static BinaryTree flattenBTree(BinaryTree root) {
		BinaryTree leftMost = flattenTree(root)[0];
		return leftMost;
	}

	// Solution 2: O(n) Time and O(d) Space Complexity, d is the depth of Binary
	// Tree.
	public static BinaryTree[] flattenTree(BinaryTree node) {
		BinaryTree leftMost;
		BinaryTree rightMost;

		if (node.left == null) {
			leftMost = node;
		} else {
			BinaryTree[] leftAndRightMostNodes = flattenTree(node.left);
			connectNodes(leftAndRightMostNodes[1], node);
			leftMost = leftAndRightMostNodes[0];
		}

		if (node.right == null) {
			rightMost = node;
		} else {
			BinaryTree[] leftAndRightMostNodes = flattenTree(node.right);
			connectNodes(node, leftAndRightMostNodes[0]);
			rightMost = leftAndRightMostNodes[1];
		}
		return new BinaryTree[] { leftMost, rightMost };
	}

	public static void connectNodes(BinaryTree left, BinaryTree right) {
		left.right = right;
		right.left = left;
	}
}
