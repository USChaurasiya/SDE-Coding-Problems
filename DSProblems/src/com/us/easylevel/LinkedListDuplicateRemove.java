package com.us.easylevel;


/**
 * @author Uma Shankar
 * <pre>
 * ======================================================================
 * 
 * You're given the head of a singly LinkedList whose nodes are in sorted order with respect to
 * their values. Write a function that returns a modified version of the Linked List that
 * doesn't contain any node with duplicates values.
 * The Linked List should be modified in place(you shouldn't create a new list).and modified
 * Linked list should still have its nodes sorted with respect to their values.
 * 
 * 
 * <pre>
 * Sample Input: 
 * 		linkedList = 1->1->3->4->4->4->5->6->6
 * 		
 * Sample Output: 1->3->4->5->6
 * 
 * ======================================================================
 *
 */
public class LinkedListDuplicateRemove {
	
	
	public static class LinkedList{
		public int value;
		public LinkedList next;
		
		public LinkedList(int value) {
			this.value = value;
			this.next = null;
		}
	}
	
	// O(n) time complexity | O(1) Space Complexity
	public LinkedList removeDuplicate(LinkedList linkedList) {
		LinkedList currentNode = linkedList;
		while (currentNode != null) {
			LinkedList nextUniqueNode = currentNode.next;
			while (nextUniqueNode != null && currentNode.value == nextUniqueNode.value) {
				nextUniqueNode = nextUniqueNode.next;
			}
			currentNode.next = nextUniqueNode;
			currentNode = nextUniqueNode;
		}
		return linkedList;
	}
}
