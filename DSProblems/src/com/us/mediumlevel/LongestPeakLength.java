package com.us.mediumlevel;

/**
 * @author Uma Shankar
 *
 *	<pre>
 *	===============================================================================================
 *	Write a function that takes an array of Integers and returns the length of the longest peak in the array.
 *	A Peak is defined as the adjacent integers in the array that are strictly increasing until they reach a tip, at which point
 *  they become strictly decreasing. At least three integers are required to form a peak.
 *
 *	
 *	Sample Input:
 *			arr = [1,2,3,3,4,0,10,6,5,-1,-3,2,3]
 *
 *	Sample Output:
 *			6
 *
 *		As it goes of from 0 to 10 and then from 10 it's decreasing till -3 so total 6 elements are there.
 *
 *
 */
public class LongestPeakLength {
	
	public static void main(String[] args) {
		int [] inputArray = {1,2,3,3,4,0,10,6,5,-1,-3,2,3};
		System.out.println("Longest Peak Length from given array is : "+ longestPeak(inputArray));
	}

	
	// O(n) Time and O(1) space Complexity
	public static int longestPeak(int[] array) {
		int longestPeak = 0;
		int i = 1;
		while (i < array.length - 1) {
			boolean isPeak = array[i - 1] < array[i] && array[i] > array[i + 1];
			if (!isPeak) {
				i += 1;
				continue;
			}
			int leftIndex = i - 2;
			while (leftIndex >= 0 && array[leftIndex] < array[leftIndex + 1]) {
				leftIndex -= 1;
			}

			int rightIndex = i + 2;
			while (rightIndex < array.length && array[rightIndex] < array[rightIndex - 1]) {
				rightIndex += 1;
			}
			int currentPeakLength = rightIndex - leftIndex - 1;
			if (currentPeakLength > longestPeak) {
				longestPeak = currentPeakLength;
			}
			i = rightIndex;
		}
		return longestPeak;
	}
}
