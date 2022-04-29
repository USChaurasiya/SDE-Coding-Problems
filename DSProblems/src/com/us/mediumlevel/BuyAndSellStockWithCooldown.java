package com.us.mediumlevel;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Uma Shankar
 * <pre>
 * ------------------------------------------------------------------------------------------
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * Find the maximum profit you can achieve. You may complete as many transactions as you like 
 * (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
 * 
 *		After you sell your stock, you cannot buy stock on the next day 
 * (i.e., cooldown one day).
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock 
 * before you buy again).
 *
 * Sample Input:
 * 	prices = [1,2,3,0,2]
 * 
 * Sample Output:
 * 	3
 * 
 * 
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 *----------------------------------------------------------------------------------------------
 */
public class BuyAndSellStockWithCooldown {
	
	public static void main(String[] args) {
		int[] prices = new int[] {1,2,3,0,2};
		
		System.out.println("Max Profit is : "+maxProfit(prices));
	}

	public static int maxProfit(int[] prices) {
		Map<String, Integer> hm = new HashMap<String, Integer>();
		return calculateMaxProfit(0, 0, prices, hm);
	}

	private static int calculateMaxProfit(int idx, int buyOrSell, int[] prices, Map<String, Integer> hm) {

		if (idx >= prices.length)
			return 0;

		String key = idx + "code" + buyOrSell;
		if (hm.containsKey(key)) {
			return hm.get(key);
		}
		int maxProfit = 0;
		
		if (buyOrSell == 0) {
			int buy = calculateMaxProfit(idx + 1, 1, prices, hm) - prices[idx];
			int noBuy = calculateMaxProfit(idx + 1, 0, prices, hm);
			maxProfit = Math.max(buy, noBuy);
		} else {
			int sell = calculateMaxProfit(idx + 2, 0, prices, hm) + prices[idx];
			int noSell = calculateMaxProfit(idx + 1, 1, prices, hm);
			maxProfit = Math.max(sell, noSell);
		}
		
		hm.put(key, maxProfit);
		return maxProfit;
	}
}
