package com.us.leetcodeproblems.dp;

import java.util.HashMap;
import java.util.List;

/**
 * Write a function, countingChange, that takes in an amount and an array of coins. 
 * The function should return the number of different ways it is possible to make change for the given amount using the coins.
You may reuse a coin as many times as necessary.
For example,
countingChange(4, [1,2,3]) -> 4
There are four different ways to make an amount of 4:

1. 1 + 1 + 1 + 1
2. 1 + 1 + 2
3. 1 + 3
4. 2 + 2
 */
public class CountingChange {
	
	public static int countingChange(int amount,List<Integer> coins) {
		return countingChange(amount,0, coins, new HashMap<>());
	}

	private static int countingChange(int amount, int coinIdx, List<Integer> coins, HashMap<List<Integer>,Integer> memo) {
		if(amount == 0) return 1;
		if(coinIdx >= coins.size()) return 0;
		
		List<Integer> key = List.of(amount, coinIdx);
		if(memo.containsKey(key)) {
			return memo.get(key);
		}
		int totalWays = 0;
		int value = coins.get(coinIdx);
		for(int qty = 0 ; qty * value <= amount; qty+=1) {
			int subAmt = amount - (qty*value);
			totalWays += countingChange(subAmt, coinIdx+1, coins, memo);
		}
		memo.put(key, totalWays);
		return totalWays;
	}
	
	public static void main(String[] args) {
		int amount = 4;
		List<Integer> coins = List.of(1,2,3);
		
		System.out.println("Number of ways to make the given Amount using Coins : "+countingChange(amount, coins));
	}

}
