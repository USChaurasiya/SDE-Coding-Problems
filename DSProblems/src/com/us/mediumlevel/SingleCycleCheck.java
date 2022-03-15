package com.us.mediumlevel;

/**
 * @author Uma Shankar
 * <pre>
 * ------------------------------------------------------------------------------------------------
 *	Write a function that returns a boolean representing whether the jumps in the array form a single
 *	cycle. A Single cycle occur if, starting at any index in the array and following the jumps, every
 *  element in the array is visited exactly once before landing back on the starting index.
 *  
 *  You are given an array of Integers where each integer represents a jump of its value in the array
 *  for instance the integer 2 represents a jump of two indices forward in the array, the integer -3
 *  represents jump of three indices backward in the array.
 *	
 *	Sample Input :
 *			array = [2,3,1,-4,-4,2]
 *
 *	Sample output :
 *			true
 * -------------------------------------------------------------------------------------------------
 */
public class SingleCycleCheck {
	
	public static void main(String[] args) {
		int[] inputArray = {2,3,1,-4,-4,2};
		System.out.println("Has Single cycle in the given array : "+checkSingleCycle(inputArray));
	}

	// O(n) Time and O(1) Space Complexity
	public static boolean checkSingleCycle(int[] array) {
		int numElementVisited = 0;
		int currentIndex = 0;
		while (numElementVisited < array.length) {
			if (numElementVisited > 0 && currentIndex == 0)
				return false;
			numElementVisited++;
			currentIndex = getNextIndex(currentIndex, array);
		}
		return currentIndex == 0;
	}

	public static int getNextIndex(int currentIndex, int[] array) {

		int jump = array[currentIndex];
		int nextIndex = (currentIndex + jump) % array.length;
		return nextIndex >= 0 ? nextIndex : nextIndex + array.length;
	}
}
