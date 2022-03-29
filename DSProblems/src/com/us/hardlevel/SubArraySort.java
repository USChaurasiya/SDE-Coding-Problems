package com.us.hardlevel;

/**
 * @author Uma Shankar
 *<pre>
 *----------------------------------------------------------------------------------------
 *
 *	Write a function that takes in an array of at least two integers and returns an array of 
 *	the starting and ending indices of the smallest subarray in the input array that need to
 *	be sorted in place in order for the entire input array to be sorted in ascending order.
 *	
 *	If the input array is already sorted the function should return [-1,-1].
 *
 *	Sample Input:
 *		arr = [1,2,4,7,10,11,7,12,6,7,16,18,19]
 *	
 *	Sample Output:
 *		[3,9]
 *------------------------------------------------------------------------------------------
 */
public class SubArraySort {
	
	public static void main(String[] args) {
		int[] inputArray = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
		System.out.println("Subarray sort Index (starting, ending ): ");
		var resultedArray = subarraySort(inputArray);
		for (int element : resultedArray) {
			System.out.print(element+"  ");
		}
	}

	// O(n) Time and O(1) Space Complexity
	public static int[] subarraySort(int[] array) {
		int minOutOfOrder = Integer.MAX_VALUE;
		int maxOutOfOrder = Integer.MIN_VALUE;

		for (int i = 0; i < array.length; i++) {
			int num = array[i];
			if (isOutOfOrder(i, num, array)) {
				minOutOfOrder = Math.min(minOutOfOrder, num);
				maxOutOfOrder = Math.max(maxOutOfOrder, num);
			}
		}
		if (minOutOfOrder == Integer.MAX_VALUE) {
			return new int[] { -1, -1 };
		}
		int subArrayLeftIdx = 0;
		while (minOutOfOrder >= array[subArrayLeftIdx]) {
			subArrayLeftIdx++;
		}
		int subArrayRightIdx = array.length - 1;
		while (maxOutOfOrder <= array[subArrayRightIdx]) {
			subArrayRightIdx--;
		}
		return new int[] { subArrayLeftIdx, subArrayRightIdx };
	}

	private static boolean isOutOfOrder(int i, int num, int[] array) {
		if (i == 0) {
			return num > array[i + 1];
		}
		if (i == array.length - 1) {
			return num < array[i - 1];
		}
		return num > array[i + 1] || num < array[i - 1];
	}

}
