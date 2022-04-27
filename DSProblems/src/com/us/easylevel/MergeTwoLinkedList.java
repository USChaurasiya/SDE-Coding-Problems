package com.us.easylevel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Uma Shankar
 * <pre>
 * -------------------------------------------------------------------------------------
 * You are given two Sorted Linked lists merge them so that the resulting linked list is 
 * also sorted.
 * 
 * Sample Input:
 * 	head1 -> 4 ->8 ->15 ->19 ->NULL
 * 	head2 -> 7 ->9 ->10 ->16 ->NULL
 * 
 * Sample Output:
 * 	head1 -> 4 ->7 ->8 ->9 ->10 ->15 ->16 ->19 -> NULL
 * 
 * -------------------------------------------------------------------------------------
 *
 */
public class MergeTwoLinkedList {

	public static void main(String[] args) {
		LinkedListNode linkedListOne = constructNewLinkedList(new int[] { 4, 8, 15, 19 });
		LinkedListNode linkedListTwo = constructNewLinkedList(new int[] { 7, 9, 10, 16 });

		List<Integer> mergedLinkedList = toArrayList(merge_sorted(linkedListOne, linkedListTwo));

		System.out.println("LinkedList after Merging : ");
		mergedLinkedList.forEach(x -> System.out.print(x + " "));
	}

	public static LinkedListNode merge_sorted(LinkedListNode head1, LinkedListNode head2) {
		if (head1 == null)
			return head2;
		else if (head2 == null)
			return head1;

		LinkedListNode mergedList = null;
		if (head1.data <= head2.data) {
			mergedList = head1;
			head1 = head1.next;
		} else {
			mergedList = head2;
			head2 = head2.next;
		}

		LinkedListNode mergedTail = mergedList;
		while (head1 != null && head2 != null) {
			LinkedListNode temp = null;
			if (head1.data <= head2.data) {
				temp = head1;
				head1 = head1.next;
			} else {
				temp = head2;
				head2 = head2.next;
			}
			mergedTail.next = temp;
			mergedTail = temp;
		}

		if (head1 != null) {
			mergedTail.next = head1;
		} else if (head2 != null) {
			mergedTail.next = head2;
		}

		return mergedList;

	}

	static class LinkedListNode {

		int data;
		LinkedListNode next;

		public LinkedListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static LinkedListNode constructNewLinkedList(int[] values) {
		LinkedListNode linkedList = new LinkedListNode(values[0]);
		LinkedListNode current = linkedList;
		for (int i = 1; i < values.length; i++) {
			current.next = new LinkedListNode(values[i]);
			current = current.next;
		}
		return linkedList;
	}

	public static List<Integer> toArrayList(LinkedListNode ll) {
		List<Integer> arr = new ArrayList<Integer>();
		LinkedListNode current = ll;
		while (current != null) {
			arr.add(current.data);
			current = current.next;
		}
		return arr;
	}
}
