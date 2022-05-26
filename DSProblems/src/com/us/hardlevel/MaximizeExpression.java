package com.us.hardlevel;

/**
 * @author Uma Shankar
 * <pre>
 * ---------------------------------------------------------------------------------------
 * Write a function that takes in an array of Integers and returns the largest possible 
 * value for the expression array[a] - array[b] + array[c] - array[d] where a, b, c and
 * d are indices of the array and a<b<c<d.
 * 
 * If the input array has fewer than 4 elements, your function should return 0.
 * 
 * Sample Input:
 * 	array = [ 3, 6, 1, -3, 2, 7 ]
 * 
 * Sample Output:
 * 	4    // a = 1, b = 3, c = 4, d = 5
 *
 *-----------------------------------------------------------------------------------------
 */
public class MaximizeExpression {
	
	public static void main(String[] args) {
		
		int[] input = new int[] { 3, 6, 1, -3, 2, 7 };
		int maxPossibleValue = maximizeExpression(input);

		System.out.println("Maximum Possible Value for the expression is : " + maxPossibleValue);

	}
	
	
	// Solution 1: O(n^4)  time and O(1) Space Complexity
	public static int maximizeExpression(int[] array) {
		if (array.length < 4) {
			return 0;
		}

		int maxValueFound = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			int iValue = array[i];
			for (int j = i + 1; j < array.length; j++) {
				int jValue = array[j];
				for (int k = j + 1; k < array.length; k++) {
					int kValue = array[k];
					for (int l = k + 1; l < array.length; l++) {
						int lValue = array[l];
						int expressionValue = evaluateExpression(iValue, jValue, kValue, lValue);
						maxValueFound = Math.max(expressionValue, maxValueFound);
					}
				}
			}
		}
		return maxValueFound;
	}

	public static int evaluateExpression(int a, int b, int c, int d) {
		return a - b + c - d;
	}

}
