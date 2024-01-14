package com.us.leetcodeproblems.dp;

import java.util.HashMap;
import java.util.List;

/**
 * Write a function, nonAdjacentSum, that takes in an array of numbers as an argument. 
 * The function should return the maximum sum of non-adjacent elements in the array. 
 * There is no limit on how many elements can be taken into the sum as long as they are not adjacent.
For example, given:
[2, 4, 5, 12, 7]
The maximum non-adjacent sum is 16, because 4 + 12. 
4 and 12 are not adjacent in the array.
 */
public class NonAdjacentSum {

	// Time Complexity : O(n) Space Complexity O(n)
	public static int nonAdjacentSum(List<Integer> nums) {

		return nonAdjacentSum(nums, 0, new HashMap<>());
	}

	private static int nonAdjacentSum(List<Integer> nums, int i, HashMap<Integer, Integer> memo) {
		if (i >= nums.size())
			return 0;

		if (memo.containsKey(i)) {
			return memo.get(i);
		}

		int result = Math.max(nums.get(i) + nonAdjacentSum(nums, i + 2, memo), nonAdjacentSum(nums, i + 1, memo));
		return result;
	}

	public static void main(String[] args) {
		List<Integer> nums = List.of(2, 4, 5, 12, 7);
		System.out.println("Non Adjacent Sum of the given List is : " + nonAdjacentSum(nums));
	}
}
