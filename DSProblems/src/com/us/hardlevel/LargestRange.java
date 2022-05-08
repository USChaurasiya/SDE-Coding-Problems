package com.us.hardlevel;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Uma Shankar
 * <pre>
 * ----------------------------------------------------------------------------------------------
 * Write a function that takes an array of Integers and returns an array of length 2 representing 
 * the largest range of Integers contained in the array.
 * 
 * The first number in the output array should be the first number in the range, while the second
 * number should be the last number in the range.
 * 
 * A Range of numbers is defined as a set of numbers that come right after each other in the set
 * of real integers.For instance the output array [2,6] represents the range {2, 3, 4, 5, 6} which
 * is a range of length 5.
 * 
 * 
 * Sample Input:
 * 	array : [1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6]
 * 
 * Sample Output:
 * 	[0, 7]
 *
 */
public class LargestRange {

	public static void main(String[] args) {

		int[] input = { 1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6 };
		System.out.println("Longest Range is : ");
		for (int num : largestRange(input)) {
			System.out.print(num + " ");
		}
	}

	// O(n) Time and O(n) Space Complexity
	public static int[] largestRange(int[] array) {
		int[] bestRange = new int[2];
		int longestLength = 0;
		Map<Integer, Boolean> nums = new HashMap<Integer, Boolean>();
		for (int num : array) {
			nums.put(num, true);
		}
		for (int num : array) {
			if (!nums.get(num)) {
				continue;
			}
			nums.put(num, false);
			int currentLen = 1;
			int left = num - 1;
			int right = num + 1;
			while (nums.containsKey(left)) {
				nums.put(left, false);
				currentLen++;
				left--;
			}
			while (nums.containsKey(right)) {
				nums.put(right, false);
				currentLen++;
				right++;
			}
			if (currentLen > longestLength) {
				longestLength = currentLen;
				bestRange = new int[] { left + 1, right - 1 };
			}
		}
		return bestRange;
	}
}
