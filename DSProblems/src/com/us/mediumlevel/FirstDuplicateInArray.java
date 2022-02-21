package com.us.mediumlevel;

import java.util.HashSet;

/**
 * @author Uma Shankar
 * <pre>
 * ======================================================================
 * 
 * Given an array of Integers, write a function that returns the first integer that appears more than once.
 * If no integer appears more than once then function should return -1.
 * 
 * <pre>
 * Sample Input: array = [-3,1,3,1,1,4,4]
 *		
 * Sample Output: 3
 * 
 * ======================================================================
 *
 */
public class FirstDuplicateInArray {
	
	public static void main(String[] args) {
		int[] inputArray = {3,1,3,1,1,4,4};
		System.out.println("First Duplicate element in the given array is : "+ findFirstDuplicateValue(inputArray));
		
	}

	// Solution 1: O(n^2) Time and O(1) Space complexity
	public static int firstDuplicate(int[] array) {

		var minSecondIndex = array.length;
		for (int i = 0; i < array.length; i++) {
			int value = array[i];
			for (int j = i + 1; j < array.length; j++) {
				int valueToCompare = array[j];
				if (value == valueToCompare) {
					minSecondIndex = Math.min(minSecondIndex, j);
				}
			}
		}
		if (minSecondIndex == array.length)
			return -1;

		return array[minSecondIndex];
	}

	// Solution 2: O(n) Time and O(n) Space complexity
	public static int firstDuplicateValue(int[] array) {
		HashSet<Integer> visited = new HashSet<Integer>();
		for (int element : array) {
			if (visited.contains(element))
				return element;
			visited.add(element);
		}
		return -1;
	}

	// Solution 3: O(n) Time and O(1) Space complexity
	public static int findFirstDuplicateValue(int[] array) {
		for (int ele : array) {
			int absValue = Math.abs(ele);
			if (array[absValue - 1] < 0)
				return absValue;
			array[absValue - 1] *= -1;
		}
		return -1;
	}
}
