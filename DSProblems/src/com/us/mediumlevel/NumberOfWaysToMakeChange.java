package com.us.mediumlevel;

/**
 * @author Uma Shankar
 *<pre>
 *-------------------------------------------------------------------------------------
 * Given an Array of distinct positive Integers representing coin denominations and a
 * Single non negative integer n representing target amount of money.
 * Write a function that returns the number of ways to make change for that target amount
 * using given coin denominations.
 * 
 * Sample Input:
 * 	n = 6
 * 	denoms = [1,5]
 *
 * Sample Output:
 * 	2     // 1x1 + 1x5 and 6x1
 *
 *--------------------------------------------------------------------------------------
 */
public class NumberOfWaysToMakeChange {
	
	public static void main(String[] args) {
		int targetAmount = 6;
		int[] denoms = {1,5};
		
		System.out.println("Number of Ways to make change of "+targetAmount+ " "
				+ "Using given demons is : "+ getNumberOfWaysToMakeChange(targetAmount, denoms));
	}

	// O(nd) Time and O(n) Space Complexity
	public static int getNumberOfWaysToMakeChange(int n, int[] denoms) {

		int[] ways = new int[n + 1];
		ways[0] = 1;

		for (int denom : denoms) {
			for (int amount = 1; amount < n + 1; amount++) {
				if (denom <= amount) {
					ways[amount] += ways[amount - denom];
				}
			}
		}
		return ways[n];
	}
}
