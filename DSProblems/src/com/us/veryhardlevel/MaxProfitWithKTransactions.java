package com.us.veryhardlevel;

/**
 * @author Uma Shankar
 * <pre>
 * ------------------------------------------------------------------------------------
 * You're given an array of positive integers representing the prices of a single stock
 * on various days (each index in the array represents a different day). You're also 
 * given an integer k, which represents the number of transactions you're allowed to 
 * make. One transaction consists of buying the stock on a given day and selling it on
 * another, later day.
 * 
 * Write a function that returns the maximum profit that you can make by buying and selling
 * the stock, given k transactions.
 * 
 * 
 * Sample Input:
 * 	prices = [5, 11, 3, 50, 60, 90]
 * 	k = 2
 * 
 * Sample Output:
 * 	93 // Buy : 5, Sell : 11, Buy : 3, Sell : 90
 * 
 * --------------------------------------------------------------------------------------
 */
public class MaxProfitWithKTransactions {

	public static void main(String[] args) {
		
		int[] inputPrices = { 5, 11, 3, 50, 60, 90 };
		int k = 2;
		System.out.println("Max Profit After Buying/Selling stocks is : " + maxProfitWithKTransactions(inputPrices, k));

	}

	// Solution 1: O(nk) Time and O(nk) Space Complexity
	public static int maxProfitWithKTransactions(int[] prices, int k) {
		if (prices.length == 0)
			return 0;
		int[][] profits = new int[k + 1][prices.length];
		for (int t = 1; t < k + 1; t++) {
			int maxSoFar = Integer.MIN_VALUE;
			for (int d = 1; d < prices.length; d++) {
				maxSoFar = Math.max(maxSoFar, profits[t - 1][d - 1] - prices[d - 1]);
				profits[t][d] = Math.max(profits[t][d - 1], maxSoFar + prices[d]);
			}
		}
		return profits[k][prices.length - 1];
	}

	// Solution 2: O(nk) Time and O(n) Space Complexity
	// TBD
}
