package com.us.easylevel;

/**
 * @author Uma Shankar
 * <pre>
 * --------------------------------------------------------------------------------------------
 * Write a function that takes in an array of Integers and returns a sorted version of the array. Use the Insertion sort
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
public class InsertionSort {

	public static void main(String[] args) {
		int[] inputArray = { 8, 5, 2, 1, 4, 7, 9 };
		int[] sortedArray = insertionSorting(inputArray);
		System.out.println("Array after Sorting :");
		for (int ele : sortedArray) {
			System.out.print(ele + " ");
		}
	}

	public static int[] insertionSorting(int[] array) {
		if (array.length == 0)
			return new int[] {};

		for(int i=1; i<array.length; i++) {
			int j=i;
			while(j>0 && array[j] < array[j-1]) {
				int temp = array[j-1];
				array[j-1] = array[j];
				array[j] = temp;
				j -= 1;
			}
		}
		return array;
	}
}
