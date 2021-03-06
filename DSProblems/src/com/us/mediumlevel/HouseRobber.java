package com.us.mediumlevel;

/**
 * @author Uma Shankar
 * <pre>
 * --------------------------------------------------------------------------------------
 * You are a professional robber planning to rob houses along a street. Each house has a 
 * certain amount of money stashed, the only constraint stopping you from robbing each of 
 * them is that adjacent houses have security systems connected and it will automatically 
 * contact the police if two adjacent houses were broken into on the same night.
 * 
 * Given an integer array nums representing the amount of money of each house, return the 
 * maximum amount of money you can rob tonight without alerting the police.
 * 
 * 
 * Sample Input:
 * 	nums = [1,2,3,1]
 * 
 * Output: 4
 * 
 * 
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 *---------------------------------------------------------------------------------------
 */
public class HouseRobber {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 1 };
		System.out.println("Max Amount that can be rob tonight is : " + robHouse(nums));
	}

	// Solution 1: Linear Time Complexity O(n)
	public static int robHouse(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}

		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
		}
		return dp[nums.length - 1];
	}
	
	
	// Solution 2: Constant Space Complexity 
	public static int houseRobber(int[] nums) {
		int prev = 0;
		int current = nums[0];
		
		for(int i=1; i<nums.length;i++) {
			int temp = current;
			current = Math.max(nums[i]+prev, current);
			prev = temp;
		}
		return current;
	}
}
