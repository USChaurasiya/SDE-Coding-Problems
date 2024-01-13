package com.us.leetcodeproblems.arrays;

import java.util.Arrays;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

 */
public class ProductExceptSelf {
	// Time Complexity : O(n) Space Complexity : O(1)
	public static int[] productExceptSelf(int[] nums) {
		int length = nums.length;
		int res[] = new int[length];
		Arrays.fill(res, 1);
		int current = 1;
		for (int i = 0; i < length; i++) {
			res[i] *= current;
			current *= nums[i];
		}
		current = 1;
		for (int i = length - 1; i >= 0; i--) {
			res[i] *= current;
			current *= nums[i];
		}
		return res;
	}
	public static void main(String[] args) {
		int[] nums = {24,12,8,6};
		int res[] = new int[nums.length];
		res = productExceptSelf(nums);
		System.out.println("Product Array is : "+res);
	}
	
/* Solution: 
 * 1. Brute Force
	Simplest method that comes to mind is to loop through the complete array using a pointer, 
	say j, for every index i, and multiply all the elements at index j except when i == j. 
	This would ensure that I skip the element at index i from being multiplied.
	The Time Complexity for this solution would be O(n2).
	
	2. Finding Prefix Product and Suffix Product
	Finding Prefix Sum Array, here we would find the Prefix Product Array and Suffix Product Array for our original array, 
	i.e. pre[i] = pre[i - 1] * a[i - 1] (yes, we multiply with a[i - 1] and not with a[i] on purpose) and similarly 
	suff[i] = suff[i + 1] * a[i + 1].Finally ans[i] would be given by ans[i] = pre[i] * suff[i]. 
	The Time Complexity would be O(n), and Space Complexity would be O(n)

*/ 

}
