package com.us.mediumlevel;

import java.util.Arrays;

/**
 * @author Uma Shankar
 * <pre>
 * ======================================================================
 * 
 * Write a function that takes in two non-empty arrays of integers, find the pair of numbers whose absolute 
 * difference is closest to zero.
 * 
 * Absolute difference of two integers is the distance between them on the real number line.
 * Absolute difference of -5 and 5 is 10 and absolute difference of 10 and 17 is 7.
 * <pre>
 * 
 * Sample Input: array1 = [-1,5,10,20,28,3]
		array2 = [26, 110, 120, 15, 17]
 * 		
 * Sample Output: [28,26]
 * 
 * ======================================================================
 *
 */
public class SmallestDifference {

	public static void main(String[] args) {
		int[] arr1 = {-1,5,10,20,28,3};
		int[] arr2 = {26,110,120,15,17};
		
		System.out.println("Smallest difference Pair : ");
		int[] diffPair = smallestDifference(arr1, arr2);
		for (int i : diffPair) {
			System.out.print(i+ " ");
		}
	}
	
	// O(nlog(n)) + O(mlog(m)) Time and O(1) Space complexity
	public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
		Arrays.sort(arrayOne);
		Arrays.sort(arrayTwo);
		int index1 = 0;
		int index2 = 0;
		int smallest = Integer.MAX_VALUE;
		int current = Integer.MAX_VALUE;
		int[] smallestPair = new int[2];
		while (index1 < arrayOne.length && index2 < arrayTwo.length) {
			int firstNumber = arrayOne[index1];
			int secondNumber = arrayTwo[index2];

			if (firstNumber < secondNumber) {
				current = secondNumber - firstNumber;
				index1++;
			} else if (secondNumber < firstNumber) {
				current = firstNumber - secondNumber;
				index2++;
			} else {
				return new int[] { firstNumber, secondNumber };
			}
			if (smallest > current) {
				smallest = current;
				smallestPair = new int[] { firstNumber, secondNumber };
			}
		}
		return smallestPair;
	}
}
