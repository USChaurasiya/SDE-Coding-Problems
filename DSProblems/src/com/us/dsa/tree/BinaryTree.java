package com.us.dsa.tree;

import java.util.Comparator;
import java.util.Iterator;

/**
 * @author Uma Shankar
 * Generic Binary Tree for Different Operations like Insertion, Deletion, Traversal, etc.
 *	1: Search in Binary Tree
 *	2: Insert new Node in Binary Tree
 *	3: Delete a Node from Binary Tree
 *	4: Height of the Tree
 */
public class BinaryTree<T extends Comparable<T>> implements Iterable<T> {
	
	private Node<T> root;
	private Comparator<T> comparator;
	
	private int compare(T item1, T item2) {
		if(comparator == null) return item1.compareTo(item2);
		else
			return comparator.compare(item1, item2);
	}

	
	// ------------------------1: Search in Binary Tree-------------------------
	public boolean search(T nodeToSearch) {
		return search(root, nodeToSearch);
	}
	private boolean search(Node<T> root, T nodeToSearch) {
		if(root == null) {
			return false;
		}else {
			if(compare(root.data, nodeToSearch)==0) {
				return true;
			}else if (compare(nodeToSearch, root.data)<0) {
				return search(root.left, nodeToSearch);
			}else {
				return search(root.right, nodeToSearch);
			}
		}
	}


	// --------------------2: Insert new Node in Binary Tree--------------------
	public void insert(T data) {
		root = insert(root,data);
	}

	private Node<T> insert(Node<T> root, T dataToInsert) {
		if(root == null) {
			return new Node<T>(dataToInsert);
		}
		
		if(compare(root.data, dataToInsert)==0) {
			return root;
		}
		if(compare(dataToInsert, root.data)<0) {
			root.left = insert(root.left, dataToInsert);
		}else {
			root.right = insert(root.right, dataToInsert);
		}
		return root;
	}
	
	// --------------------3: Delete a Node from Binary Tree--------------------
	public void delete(T nodeToDelete) {
		root = delete(root,nodeToDelete);
	}

	private Node<T> delete(Node<T> root, T nodeToDelete) {
		if(root == null) throw new RuntimeException("Node can't be Deleted");
		else if(compare(nodeToDelete, root.data)<0) {
			root.left = delete(root.left, nodeToDelete);
		}else if(compare(nodeToDelete, root.data)>0) {
			root.right = delete(root.right, nodeToDelete);
		}else {
			if(root.left==null) return root.right;
			else if(root.right == null) return root.left;
			else {
				root.data = retrieveData(root.left);
				root.left = delete(root.left, root.data);
			}
		}
		return root;
	}

	private T retrieveData(Node<T> root) {
		while(root.right!=null) root = root.right;
		return root.data;
	}
	
	// -----------------------4: Height of Binary Tree------------------------
	public int heightOfTree() {
		return height(root);
	}

	private int height(Node<T> root) {
		if(root==null) return -1;
		else 
			return 1+Math.max(height(root.left), height(root.right));
	}

	// Standard Node Class consist of Data and Left, Right Node
	private class Node<T>{
		private T data;
		private Node<T> left, right;
		
		public Node(T data, Node<T> left, Node<T> right) {
			this.data = data;
			left = left;
			right = right;
		}
		
		public Node(T data) {
			this(data, null, null);
		}
		
		public String toString() {
			return data.toString();
		}
	}


	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
