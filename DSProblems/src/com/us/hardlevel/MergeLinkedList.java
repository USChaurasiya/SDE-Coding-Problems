package com.us.hardlevel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Uma Shankar
 * <pre>
 * --------------------------------------------------------------------------------------------------------
 *Write a function that takes in the heads of two Singly LinedLists that are in sorted order, respectively.
 *The function should merge the list in place and return the head of merged List, The merged List should be
 *in sorted order.
 *
 *
 *	
 *	Sample Input :
 *			headOne = 2->6->7->8
 *			headTwo = 1->3->4->5->9->10
 *
 *	Sample output :
 *			1->2->3->4->5->6->7->8->9->10
 * --------------------------------------------------------------------------------------------------
 */
public class MergeLinkedList {

	public static void main(String[] args) {
		LinkedList linkedListOne = constructNewLinkedList(new int[] { 2, 6, 7, 8 });
		LinkedList linkedListTwo = constructNewLinkedList(new int[] { 1, 3, 4, 5, 9, 10 });

		List<Integer> mergedLinkedList = toArrayList(mergeLinkedLists(linkedListOne, linkedListTwo));

		System.out.println("LinkedList after Merging : ");
		mergedLinkedList.forEach(x -> System.out.print(x + " "));
	}

	// O(n+m) Time and O(1) Space Complexity
	public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
		LinkedList p1 = headOne;
		LinkedList p1Previous = null;
		LinkedList p2 = headTwo;
		while (p1 != null && p2 != null) {
			if (p1.value < p2.value) {
				p1Previous = p1;
				p1 = p1.next;
			} else {
				if (p1Previous != null)
					p1Previous.next = p2;
				p1Previous = p2;
				p2 = p2.next;
				p1Previous.next = p1;
			}
		}
		if (p1 == null)
			p1Previous.next = p2;
		return headOne.value < headTwo.value ? headOne : headTwo;
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
