package com.us.easylevel;

import java.util.Arrays;

/**
 * @author Uma Shankar
 * <pre>
 * ======================================================================
 * 
 * You're given a non-empty array of positive integers representing the amount of time that specific 
 * queries take to execute. Only one query can be executed at a time, but query can be executed in any
 * order.
 * 
 * A query's waiting time is defined as the amount of time that it must wait before it's execution
 * starts. In other words, if a query is executed second, then waiting time is the duration of first
 * query. If the query is Executed third, then its waiting time is the sum of the duration of first 
 * two queries.
 * 
 * Write a function that returns the min amount of total waiting time for all the queries.
 * For Example if the given queries of duration [5,1,4] then the total waiting time if the query was 
 * executed in the order [5,1,4] would be (0)+(5)+(5+1) = 11.
 * 
 * <pre>
 * 
 * Sample Input: array = [3,2,1,2,6]<br>
 * 		
 * Sample Output: 17
 * 
 * ======================================================================
 *
 */
public class MinimumWaitingTime {
	
	public static void main(String[] args) {
		int[] queryArray = {3,2,1,2,6};
		System.out.println("Minimum Waiting time for given Queries would be :" + minWaitingTime(queryArray));
	}
	
	public static int minWaitingTime(int[] queries) {
		Arrays.sort(queries);

		int totalWaitTime = 0;
		for (int i = 0; i < queries.length; i++) {
			int duration = queries[i];
			int queryLeft = queries.length - (i + 1);

			totalWaitTime += duration * queryLeft;
		}
		return totalWaitTime;
	}

}
