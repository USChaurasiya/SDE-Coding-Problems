package com.us.easylevel;

import java.util.Arrays;

/**
 * @author Uma Shankar
 * <pre>
 * ======================================================================
 * 
 * Write a function that takes in a non-empty array of Integers that are sorted in ascending 
 * order and returns a new array of the same length with the squares of the original Integers 
 * also in  ascending order.
 * <pre>
 * 
 * Sample Input: array = [1,3,5,6,8]<br>
 * 		
 * Sample Output: [1,9,25,36,64]
 * 
 * ======================================================================
 *
 */
public class SortedSquaredArray {
	
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,8};
		int [] arrayWithNegativeElement = {-7,-5,-4,3,6,8,9};
		int [] result = sortedSqrArray(arrayWithNegativeElement);
		displayArray(result);
		
	}

	//Solution 1: O(nlogn) Time | O(n) Space Complexity
	public static int[] sortedSquaredArray(int[] array) {
		int[] sqauredArray = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			sqauredArray[i] = getSquare(array[i]);
		}
		Arrays.sort(sqauredArray);
		return sqauredArray;
	}
	
	// Solution 2: O(n) Time | O(n) Space Complexity
	public static int[] sortedSqrArray(int[] array) {
		int[] sortedArray = new int[array.length];
		
		int startIndex = 0;
		int endIndex = array.length-1;
		for(int i = array.length-1;i>=0;i--){
			int smallerValue = array[startIndex];
			int largerValue = array[endIndex];
			if(Math.abs(smallerValue) > Math.abs(largerValue)){
				sortedArray[i] = getSquare(smallerValue);
				startIndex ++;
			}else{
				sortedArray[i] = getSquare(largerValue);
				endIndex--;
			}
		}
		return sortedArray;
	}
	

	public static int getSquare(int element) {
		return element * element;
	}
	
	public static void displayArray(int [] array) {
		System.out.println("Output Array :");
		for (int element : array) {
			System.out.print(element+"  ");
		}
	}
}
