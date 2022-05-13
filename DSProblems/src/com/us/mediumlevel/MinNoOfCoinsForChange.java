package com.us.mediumlevel;

import java.util.Arrays;

/**
 * @author Uma Shankar
 * <pre>
 * ------------------------------------------------------------------------------------------
 * Given an array of Integers representing coin denominations and a single Integer n representing 
 * a target amount of money, Write a function that returns the smallest number of coins needed 
 * to make change for that target amount using the given coin denomination.
 * 
 * If it's impossible to make change for the target amount, return -1.
 * 
 * Sample Input:
 * 	n=7
 * 	denoms = [1, 5, 10]
 * 
 * Sample Output:
 * 	3       // 2*1+1*5
 * 
 * --------------------------------------------------------------------------------------------
 *
 */
public class MinNoOfCoinsForChange {

	public static void main(String[] args) {
		int target = 7;
		int[] denoms = { 1, 5, 10 };

		System.out.println("Number of Coins : " + minNumberOfCoinsForChange(target, denoms));
	}

	// O(nd) Time Complexity and O(n) Space Complexity
	public static int minNumberOfCoinsForChange(int n, int[] denoms) {
		int[] numsOfCoins = new int[n + 1];
		Arrays.fill(numsOfCoins, Integer.MAX_VALUE);
		numsOfCoins[0] = 0;
		int toCompare = 0;

		for (int denom : denoms) {
			for (int amount = 0; amount < numsOfCoins.length; amount++) {
				if (denom <= amount) {
					if (numsOfCoins[amount - denom] == Integer.MAX_VALUE) {
						toCompare = numsOfCoins[amount - denom];
					} else {
						toCompare = numsOfCoins[amount - denom] + 1;
					}
					numsOfCoins[amount] = Math.min(numsOfCoins[amount], toCompare);
				}
			}
		}
		return numsOfCoins[n] != Integer.MAX_VALUE ? numsOfCoins[n] : -1;
	}
}
