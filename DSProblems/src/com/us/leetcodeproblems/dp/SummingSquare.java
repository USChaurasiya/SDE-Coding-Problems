package com.us.leetcodeproblems.dp;

import java.util.HashMap;

/**
 * Write a function, summingSquares, that takes a target number as an argument. 
 * The function should return the minimum number of perfect squares that sum to the target. 
 * A perfect square is a number of the form (i*i) where i >= 1.

For example: 1, 4, 9, 16 are perfect squares, but 8 is not perfect square.
Given 12:
summingSquares(12) -> 3
The minimum squares required for 12 is three, by doing 4 + 4 + 4.
Another way to make 12 is 9 + 1 + 1 + 1, but that requires four 
 */
public class SummingSquare {

	// Time Complexity : O(n*sqrt(n))  Space Complexity : O(n)
	public static int summingSquare(int n) {
		return (int) sumSquare(n, new HashMap<>());
	}

	private static double sumSquare(int n, HashMap<Integer, Double> memo) {
		if (n == 0) {
			return 0;
		}
		if (memo.containsKey(n))
			return memo.get(n);
		double minSquare = Double.POSITIVE_INFINITY;
		for (int i = 1; i <= Math.sqrt(n); i += 1) {
			int sqr = i * i;
			double numSqr = 1 + sumSquare(n - sqr, memo);

			if (numSqr < minSquare) {
				minSquare = numSqr;
			}
		}
		double result = minSquare;
		memo.put(n, result);
		return result;
	}
	
	public static void main(String[] args) {
		int number = 12;
		System.out.println("The minimum squares required : "+summingSquare(number));
	}
}
