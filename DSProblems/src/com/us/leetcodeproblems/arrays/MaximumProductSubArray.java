package com.us.leetcodeproblems.arrays;

/**
 * Given an integer array nums, find a subarray that has the largest product, and return the product.
The test cases are generated so that the answer will fit in a 32-bit integer.

Example 1:
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class MaximumProductSubArray {
	
	// Time Complexity : O(n) Space Complexity : O(1)
	public static int maxProduct(int[] nums) {
		int n = nums.length;
		int left = 1;
		int right = 1;
		int res = nums[0];
		for (int i = 0; i < n; i++) {
			//If any of left or right become 0 then update it to 1
			left = left == 0 ? 1 : left;
			right = right == 0 ? 1 : right;

			// Prefix Product
			left *= nums[i];
			// Suffix Product
			right *= nums[n - 1 - i];

			res = Math.max(res, Math.max(left, right));
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums = {2,3,-2,4};
		System.out.println(" Max Product Sub Array is : "+maxProduct(nums));
	}
	
	
	/*
	 * Two pointer Approach Explanation : 
	 * 1.)If all the positive or negative elements are even then answer will be product of complete array which you will get in variable left and right at the last iteration. 
	 * 2.) But if negative elements are odd then we have to remove one negative element and make sure that it will be either right of max prefix product or left of max suffix product. 
	 * So u need not to modify accordingly as we are getting prefix product in left and suffix product in right. 
	 * 3.) If array also contains 0 then your left and right will become 0 at that point...then just update it to 1(or else we will keep multiplying with 0) to
	 * get the product ahead making another subarray.
	 */
}
