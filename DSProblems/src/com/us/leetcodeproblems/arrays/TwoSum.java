package com.us.leetcodeproblems.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]

 */
public class TwoSum {
	
	// Time Complexity : O(n) Space Complexity : O(n)
	// Logic : Use hash map to check for difference value, If difference doesn't exist then add index of last occurrence of a num to map, don’t use same element twice;

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] res = new int[2];
		for (int i = 0; i < nums.length; i++) {
			int difference = target - nums[i];
			if (map.containsKey(difference)) {
				res[0] = map.get(difference);
				res[1] = i;
				return res;
			}
			map.put(nums[i], i);
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[]nums = {3,2,4};
		int target = 6;
		System.out.println(twoSum(nums, target));
	}
}
