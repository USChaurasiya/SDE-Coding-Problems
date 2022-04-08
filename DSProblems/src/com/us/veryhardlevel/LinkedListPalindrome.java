package com.us.veryhardlevel;

/**
 * @author Uma Shankar
 * <pre>
 * ----------------------------------------------------------------------------------------
 * Write a function that takes in the head of singly Linked List and return a boolean value
 * representing whether the given LinkedList Node form a palindrome. Your function should 
 * not make use of any auxiliary data structure.
 * 
 * 
 * 
 * Sample Input:
 * 		head = 0 -> 1 -> 2 -> 2 -> 1 -> 0
 * 
 * Sample Output:
 * 		true
 * 
 * --------------------------------------------------------------------------------------
 *
 */
public class LinkedListPalindrome {

	public static void main(String[] args) {

		var head = new LinkedList(0);
		head.next = new LinkedList(1);
		head.next.next = new LinkedList(2);
		head.next.next.next = new LinkedList(2);
		head.next.next.next.next = new LinkedList(1);
		head.next.next.next.next.next = new LinkedList(0);

		boolean isPalindrome = isPalindrome(head);

		System.out.println("Is given LinkedList is Palindrome : " + isPalindrome);
	}

	public static class LinkedList {
		public int value;
		public LinkedList next;

		public LinkedList(int value) {
			this.value = value;
			this.next = null;
		}
	}

	// Solution 1: O(n) Time and O(1) Space Complexity
	public static boolean isPalindrome(LinkedList head) {
		LinkedList slowNode = head;
		LinkedList fastNode = head;

		while (fastNode != null && fastNode.next != null) {
			slowNode = slowNode.next;
			fastNode = fastNode.next.next;
		}

		LinkedList reverseSecondHalf = reverseLinkedList(slowNode);
		LinkedList firstHalfNode = head;

		while (reverseSecondHalf != null) {
			if (reverseSecondHalf.value != firstHalfNode.value)
				return false;
			reverseSecondHalf = reverseSecondHalf.next;
			firstHalfNode = firstHalfNode.next;
		}
		return true;
	}

	private static LinkedList reverseLinkedList(LinkedList head) {
		LinkedList previousNode = null;
		LinkedList currentNode = head;

		while (currentNode != null) {
			LinkedList nextNode = currentNode.next;
			currentNode.next = previousNode;
			previousNode = currentNode;
			currentNode = nextNode;
		}
		return previousNode;
	}
	
	// Solution 2: O(n) Time and O(n) Space Complexity
	
	// TBD
}
