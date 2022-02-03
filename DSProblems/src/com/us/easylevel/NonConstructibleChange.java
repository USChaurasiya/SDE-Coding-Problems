package com.us.easylevel;

import java.util.Arrays;

/**
 * @author Uma Shankar
 * <pre>
 * ======================================================================
 * 
 * Given an array of positive Integers representing the value of coins in your possession,
 * Write a function that returns the minimum amount of change that you can't create.
 * <pre>
 * 
 * For Example if you have given coins = [1,2,5], the minimum amount of change that you can't create 
 * is 4.
 * 		
 * 
 * ======================================================================
 *
 */
public class NonConstructibleChange {
	public static void main(String[] args) {
		
		int[] coins = {5,7,1,1,2,3,22};
		int nonConstuctChange = nonConstructibleChange(coins);
		System.out.println("Change for given value Can't created using above coins : "+nonConstuctChange);
	}
	
	public static int nonConstructibleChange(int[] coinArray) {
		Arrays.sort(coinArray);
		int currentChange = 0;
		for (int coin : coinArray) {
			if(coin > currentChange+1) {
				return currentChange+1;
			}
			currentChange+=coin;
		}
		return currentChange+1;
	}

}
