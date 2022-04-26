package com.us.easylevel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Uma Shankar
 * <pre>
 * -------------------------------------------------------------------------------------
 * You are given an array of positive numbers from 1 to n, such that all numbers from 1 
 * to n are present except one number ‘x’. You have to find ‘x’. The input array is not 
 * sorted.
 * 
 * Sample Input:
 * 	n = 8
 * array = [3,7,1,2,8,4,5]
 * 
 * Sample Output:
 * 	6
 *
 *---------------------------------------------------------------------------------------
 */
public class MissingNumberInArray {
	
	public static void main(String[] args) {
		List<Integer> inputArray = new ArrayList<Integer>();
		inputArray.add(3);
		inputArray.add(7);
		inputArray.add(1);
		inputArray.add(2);
		inputArray.add(8);
		inputArray.add(4);
		inputArray.add(5);
		
		System.out.println("Missing Element in the given Array is : "+findMissingNumber(inputArray));
	}

	// O(n) Time and O(1) Space Complexity
	public static int findMissingNumber(List<Integer> input) {
		int sumOfElements = 0;
		for (int ele : input) {
			sumOfElements += ele;
		}

		int n = input.size() + 1;
		int actualSum = (n * (n + 1)) / 2;

		return actualSum - sumOfElements;
	}
}
