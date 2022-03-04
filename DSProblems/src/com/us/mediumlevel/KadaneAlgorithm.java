package com.us.mediumlevel;


/**
 * @author Uma Shankar
 * <pre>
 * ======================================================================
 * 
 * Write a function that takes in a non-empty array of Integers and returns that maximum sum that can be obtained by summing 
 * up all of the integers in a non-empty subArray of the input array. A subArray must only contain Adjacent numbers.
 * <pre>
 * 
 * Sample Input: 
 * 		inputArray = [3,5,-9,1,3,-2,3,4,7,2,-9,6,3,1,-5,4]
 * 		
 * Sample Output: 19
 * 
 * ======================================================================
 */
public class KadaneAlgorithm {

	public static void main(String[] args) {
		int[] inputArray = { 3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4 };
		System.out.println("Maximum Sum is : " + kadanesAlgorithm(inputArray));
	}

	// O(n) Time and O(1) Space Complexity
	public static int kadanesAlgorithm(int[] array) {
		int maxEnding = array[0];
		int maxTillNow = array[0];
		for (int i = 1; i < array.length; i++) {
			int num = array[i];
			maxEnding = Math.max(num, maxEnding + num);
			maxTillNow = Math.max(maxTillNow, maxEnding);
		}
		return maxTillNow;
	}
}
