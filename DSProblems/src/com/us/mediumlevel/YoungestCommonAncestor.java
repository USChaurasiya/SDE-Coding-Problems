package com.us.mediumlevel;

import java.util.HashMap;

/**
 * @author Uma Shankar
 * <pre>
 * -------------------------------------------------------------------------------------
 * You are given three inputs, all of which are instances of an AncestralTree class that
 * have an ancestor property pointing to their youngest Ancestor. The first input is the 
 * top ancestor in the tree, and the other two inputs are descendants in the ancestral 
 * tree.
 * 
 * Write a function that returns youngest Common ancestor to the two Descendants.
 * Note that a Descendant is considered its own ancestor.
 * 
 * Sample Input:
 * 	topAncestor = node A
 * 	descendantOne = node E
 * 	descendantTwo = node I
 * 
 *                 A
 *               /   \
 *              B     C
 *             / \   / \
 *            D   E F   G
 *           / \
 *          H   I
 *          
 * Sample Output:
 * 	Node B
 * 
 * --------------------------------------------------------------------------------------
 */
public class YoungestCommonAncestor {

	public static void main(String[] args) {
		var trees = getTrees();
		trees.get('A').addAsAncestor(new AncestralTree[] { trees.get('B'), trees.get('C') });
		trees.get('B').addAsAncestor(new AncestralTree[] { trees.get('D'), trees.get('E') });
		trees.get('D').addAsAncestor(new AncestralTree[] { trees.get('H'), trees.get('I') });
		trees.get('C').addAsAncestor(new AncestralTree[] { trees.get('F'), trees.get('G') });

		var youngestCommonAncestor = getYoungestCommonAncestor(trees.get('A'), trees.get('E'), trees.get('I'));
		System.out.println("Youngest Common Ancestor is : " + youngestCommonAncestor.name);
	}

	// O(d) Time and O(1) Space Complexity where d is the depth of tree
	public static AncestralTree getYoungestCommonAncestor(AncestralTree topAncestor, AncestralTree descendantOne,
			AncestralTree descendantTwo) {
		int depthOne = getDescendantDepth(descendantOne, topAncestor);
		int depthTwo = getDescendantDepth(descendantTwo, topAncestor);
		if (depthOne > depthTwo) {
			return backTrackAncestralTree(descendantOne, descendantTwo, depthOne - depthTwo);
		} else {
			return backTrackAncestralTree(descendantTwo, descendantOne, depthTwo - depthOne);
		}
	}

	public static int getDescendantDepth(AncestralTree descendant, AncestralTree topAncestor) {
		int depth = 0;
		while (descendant != topAncestor) {
			depth++;
			descendant = descendant.ancestor;
		}
		return depth;
	}

	public static AncestralTree backTrackAncestralTree(AncestralTree lowerDescendant, AncestralTree higherDescendant,
			int diff) {
		while (diff > 0) {
			lowerDescendant = lowerDescendant.ancestor;
			diff--;
		}
		while (lowerDescendant != higherDescendant) {
			lowerDescendant = lowerDescendant.ancestor;
			higherDescendant = higherDescendant.ancestor;
		}
		return lowerDescendant;
	}

	static class AncestralTree {
		public char name;
		public AncestralTree ancestor;

		AncestralTree(char name) {
			this.name = name;
			this.ancestor = null;
		}

		void addAsAncestor(AncestralTree[] descendants) {
			for (AncestralTree descendant : descendants) {
				descendant.ancestor = this;
			}
		}
	}

	public static HashMap<Character, AncestralTree> getTrees() {
		var trees = new HashMap<Character, AncestralTree>();
		var alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (char a : alphabet.toCharArray()) {
			trees.put(a, new AncestralTree(a));
		}

		trees.get('A').addAsAncestor(
				new AncestralTree[] { trees.get('B'), trees.get('C'), trees.get('D'), trees.get('E'), trees.get('F') });
		return trees;
	}
}
