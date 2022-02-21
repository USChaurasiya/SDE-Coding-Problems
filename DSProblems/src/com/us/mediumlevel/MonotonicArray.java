package com.us.mediumlevel;

/**
 * @author Uma Shankar
 * <pre>
 * ======================================================================
 * 
 * A array is said to be monotonic if its elements, from left to right are entirely non-decreasing or entirely non-increasing.
 * 
 * Write a function that takes in an array of integers and returns a boolean representing whether array is monotonic or not.
 * 
 * <pre>
 * Sample Input: array = [-5,-8,-100,-1100,-1100,-1102,-9901]
 *		
 * Sample Output: true
 * 
 * ======================================================================
 *
 */
public class MonotonicArray {

	public static void main(String[] args) {
		int[] inputArray = { -1, -5, -100, -1100, -1102, -9001 };
		System.out.println("Is Given array is Nonotonic : " + isMonotonic(inputArray));
	}

	// Solution 1: O(n) Time and O(1) Space complexity
	public static boolean isMonotonic(int[] array) {

		var isNonDecreasing = true;
		var isNonIncreasing = true;

		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[i - 1]) {
				isNonDecreasing = false;
			}

			if (array[i] > array[i - 1]) {
				isNonIncreasing = false;
			}
		}
		return isNonDecreasing || isNonIncreasing;
	}

	// Solution 2: O(n) Time and O(1) Space complexity
	public static boolean isMonotonicArray(int[] array) {
		if (array.length <= 2)
			return true;

		var direction = array[1] - array[0];
		for (int i = 2; i < array.length; i++) {
			if (direction == 0) {
				direction = array[i] - array[i - 1];
				continue;
			}
			if (breakDirection(direction, array[i - 1], array[i])) {
				return false;
			}
		}
		return true;
	}

	private static boolean breakDirection(int direction, int pre, int current) {
		var diff = current - pre;
		if (direction > 0)
			return diff < 0;

		return diff > 0;
	}
}
