package com.us.mediumlevel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author Uma Shankar
 * <pre>
 * ======================================================================
 * 
 * Write a function that takes in a non-empty array of distinct integers and an integer representing a target sum.
 * The function should returns all the triplets in the array that sum up to target sum. The numbers in each triplet 
 * should be ordered in ascending order.
 * <pre>
 * 
 * Sample Input: array = [12,3,1,2,-6,5,-8,6]
		targetSum = 0
 * 		
 * Sample Output: [[-8,2,6],[-8,3,5],[-6,1,5]]
 * 
 * ======================================================================
 *
 */
public class ThreeNumberSum {

	// O(n^2) time and O(n) Space complexity
	public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
		List<Integer[]> triplets = new ArrayList<Integer[]>();
		Arrays.sort(array);
		
		for(int i=0; i<array.length-2; i++) {
			int start = i+1;
			int end = array.length-1;
			
			while(start<end) {
				int currentSum = array[i]+array[start]+array[end];
				if(currentSum==targetSum) {
					Integer[] newTriplet = {array[i], array[start], array[end]};
					triplets.add(newTriplet);
					start++;
					end--;
				}else if (currentSum<targetSum) {
					start++;
				}else if (currentSum>targetSum) {
					end--;
				}
			}
		}
		return triplets;
	}
}
