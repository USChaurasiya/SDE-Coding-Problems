package com.us.easylevel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Uma Shankar
 * <pre>
 * ---------------------------------------------------------------------------------------
 * Given an integer array nums of length n where all the integers of nums are in the range
 * [1, n] and each integer appears once or twice, return an array of all the integers that 
 * appears twice.
 * 
 * You must write an algorithm that runs in O(n) time and uses only constant extra space.
 * 
 * Sample Input:
 * 	nums = [4,3,2,7,8,2,3,1]
 *
 * Sample Output:
 * 	[2,3]
 * 
 * ----------------------------------------------------------------------------------------
 */
public class FindDuplicateFromArray {

	public static void main(String[] args) {
		int[] input = new int[] { 4, 3, 2, 7, 8, 2, 3, 1 };
		System.out.println("Duplicate Numbers from the given Array are: ");
		findDuplicates(input).forEach(x -> System.out.print(x + " "));
	}

	// O(n) Time and O(1) Space Complexity
	public static List<Integer> findDuplicates(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i])-1;
			if (nums[index] < 0) {
				result.add(index + 1);
			}
			nums[index] = -nums[index];
		}
		return result;
	}
}
