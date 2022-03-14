package com.us.mediumlevel;

/**
 * @author Uma Shankar
 * <pre>
 * ------------------------------------------------------------------------------------------------
 *	Write a function that takes in an array of positive integers and returns the maximum sum of non-
 *	adjacent elements in the array.
 *	If the input array is empty, the function should return 0.
 *	
 *	Sample Input :
 *			array = [7,10,12,7,9,14]
 *
 *	Sample output :
 *			33     // 7+12+14
 * -------------------------------------------------------------------------------------------------
 */
public class MaxSubsetSum {

	public static void main(String[] args) {
		System.out.println("--------------------Max Subset Sum--------------------------");
		int[] inputArray = new int[] { 7, 10, 12, 7, 9, 14 };
		System.out.println("Sum of Max Subset is : " + maxSubsetSumNoAdjacent(inputArray));
	}

	// Solution 1: O(n) Time and O(1) Space Complexity
	public static int maxSubsetSumNoAdjacent(int[] array) {
		if (array.length == 0)
			return 0;
		else if (array.length == 1)
			return array[0];

		int second = array[0];
		int first = Math.max(array[0], array[1]);
		for (int i = 2; i < array.length; i++) {
			int current = Math.max(first, second + array[i]);
			second = first;
			first = current;
		}
		return first;
	}

	// Solution 2: O(n) Time and O(n) Space Complexity
	public static int maxSubSetSumOfArray(int[] array) {
		if (array.length == 0)
			return 0;
		else if (array.length == 1)
			return array[0];

		int[] maxSum = array.clone();
		maxSum[1] = Math.max(array[0], array[1]);
		for (int i = 2; i < array.length; i++) {
			maxSum[i] = Math.max(maxSum[i - 1], maxSum[i - 2] + array[i]);
		}
		return maxSum[array.length - 1];
	}
}
