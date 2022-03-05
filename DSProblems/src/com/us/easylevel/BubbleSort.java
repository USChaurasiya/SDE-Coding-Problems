package com.us.easylevel;

/**
 * @author Uma Shankar
 * <pre>
 * --------------------------------------------------------------------------------------------
 * Write a function that takes in an array of Integers and returns a sorted version of the array. Use the bubble sort
 * Algorithm to sort the array.
 * 
 * 
 * Sample Input: 
 * 		array = [8,5,2,1,4,7,9]
 * 
 * Output :
 * 		[1,2,4,5,7,8,9]
 * 
 * ----------------------------------------------------------------------------------------------
 *
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] inputArray = { 8, 5, 2, 1, 4, 7, 9 };
		int[] sortedArray = bubbleSorting(inputArray);
		System.out.println("Array after Sorting :");
		for (int ele : sortedArray) {
			System.out.print(ele + " ");
		}
	}

	public static int[] bubbleSorting(int[] array) {
		if (array.length == 0)
			return new int[] {};

		boolean isSorted = false;
		int count = 0;
		while (!isSorted) {
			isSorted = true;
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i + 1]) {
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					isSorted = false;
				}
			}
			count++;
		}
		return array;
	}
}
