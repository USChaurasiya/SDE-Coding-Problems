package com.us.hardlevel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Uma Shankar
 * <pre>
 * ------------------------------------------------------------------------------------------------
 *	Write a function that takes in the head of a Singly Linked list, reverse the list in place(don't
 *	create a new one) and returns its new head;
 *	
 *	Sample Input :
 *			head = 0->1->2->3->4->5
 *
 *	Sample output :
 *			5->4->3->2->1->0
 * --------------------------------------------------------------------------------------------------
 */
public class ReverseLinkedList {

	public static void main(String[] args) {
		LinkedList testLinkedList = constructNewLinkedList(new int[] { 0, 1, 2, 3, 4, 5 });
		List<Integer> reversedLinkedlist = toArrayList(reverseLinkedList(testLinkedList));

		System.out.println("Reversed Linked List : ");
		reversedLinkedlist.forEach(x -> System.out.print(x + " "));
	}

	// O(n) Time and O(1) Space Complexity
	public static LinkedList reverseLinkedList(LinkedList head) {
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

	static class LinkedList {
		int value;
		LinkedList next = null;

		public LinkedList(int value) {
			this.value = value;
		}
	}

	public static LinkedList constructNewLinkedList(int[] values) {
		LinkedList linkedList = new LinkedList(values[0]);
		LinkedList current = linkedList;
		for (int i = 1; i < values.length; i++) {
			current.next = new LinkedList(values[i]);
			current = current.next;
		}
		return linkedList;
	}

	public static List<Integer> toArrayList(LinkedList ll) {
		List<Integer> arr = new ArrayList<Integer>();
		LinkedList current = ll;
		while (current != null) {
			arr.add(current.value);
			current = current.next;
		}
		return arr;
	}
}
