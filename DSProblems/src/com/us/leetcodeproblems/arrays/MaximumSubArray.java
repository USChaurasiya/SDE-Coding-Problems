package com.us.leetcodeproblems.arrays;

/**
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Example 2:
Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.

Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 
 */
public class MaximumSubArray {

	// Time Complexity : O(n) Space Complexity : O(1)
	public static int maxSubArray(int[] nums) {

		int maxSub = nums[0];
		int currentSum = 0;

		for (int n : nums) {
			if (currentSum < 0)
				currentSum = 0;
			currentSum += n;
			maxSub = Math.max(maxSub, currentSum);
		}
		return maxSub;
	}
	
	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println("Max SubArray is : "+maxSubArray(nums));
	}
	
	/*
	 * Solution Approach : 
	 * 
	 * Negative Number Don't contribute in finding the MaxSum so We can ignore the
	 * Negative Value by checking if the CurrentSum < 0 then reset the CurrentSum =0.
	 * Negative Prefix which came before the positive one is not's gonna help so
	 * don't consider that. It's a kind of Sliding Window problem , keep
	 * incrementing the right pointer and left pointer keeps getting shifter if we
	 * ever get a negative Prefix.
	 */}
