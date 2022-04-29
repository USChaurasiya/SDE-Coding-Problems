package com.us.easylevel;

/**
 * @author Uma Shankar
 * <pre>
 * ------------------------------------------------------------------------------------
 * Say you have an array, A, for which the ith element is the price of a given stock on 
 * day i. If you were only permitted to complete at most one transaction (i.e, buy one 
 * and sell one share of the stock), design an algorithm to find the maximum profit.
 * 
 * Return the maximum possible profit.
 * 
 * Sample Input:
 * 	prices = [7,1,5,3,6,4]
 * 
 * Sample Output:
 * 	5
 * 
 * 
 * Buy on day 2 (price=1) and sell it on day 5 (price=6) so max profit = (6-1) = 5
 * 
 * -------------------------------------------------------------------------------------
 *
 */
public class BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };

		System.out.println("Max profit is : " + maxProfit(prices));
	}

	public static int maxProfit(int[] prices) {
		int maxProfit = 0;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < min) {
				min = prices[i];
			} else {
				maxProfit = Math.max(maxProfit, prices[i] - min);
			}
		}
		return maxProfit;
	}
}
