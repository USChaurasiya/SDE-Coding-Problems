package com.us.hardlevel;

import java.util.Arrays;

/**
 * @author Uma Shankar
 * <pre>
 * ----------------------------------------------------------------------------------------------------
 * You're given a non-empty array of positive integers where each integer represents the maximum number 
 * of steps you can take forward in the array.
 * For example if the element at index 1 is 3, you can go from index 1 to index 2, 3, or 4.
 * 
 * Write a function that returns the minimum number of Jumps needed to reach the final index.
 * 
 * 
 * Sample Input:
 *		array = [3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3]
 *
 *Sample Output:
 *            4
 *
 *------------------------------------------------------------------------------------------------------
 */
public class JumpGame {

	public static void main(String[] args) {
		int[] inputArray = { 3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3 };
		System.out.println("Minimum Number of Jumps to reach Last index is : " + minNumberOfJumps(inputArray));
	}

	// Solution 1: O(n^2) Time and O(n) Space Complexity
	public static int minNumberOfJumps(int[] array) {
		int[] jumps = new int[array.length];
		Arrays.fill(jumps, Integer.MAX_VALUE);
		jumps[0] = 0;
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				if (array[j] >= i - j) {
					jumps[i] = Math.min(jumps[j] + 1, jumps[i]);
				}
			}
		}
		return jumps[jumps.length - 1];
	}

	// Solution 2: O(n) Time and O(1) Space Complexity
	public static int minimumNoOfJumps(int[] array) {
		if (array.length == 1)
			return 0;

		int jump = 0;
		int maxReach = array[0];
		int steps = array[0];
		for (int i = 1; i < array.length - 1; i++) {
			maxReach = Math.max(maxReach, i + array[i]);
			steps--;
			if (steps == 0) {
				jump++;
				steps = maxReach - i;
			}
		}
		return jump + 1;
	}
}
