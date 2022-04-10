package com.us.veryhardlevel;

/**
 * @author Uma Shankar
 * <pre>
 * ------------------------------------------------------------------------------------------
 * Your'e given an array of non-negative integers where each non-zero integer represents the
 * height of pillar of width 1. Imagine water being poured over all of the pillars, write a 
 * function that returns the surface area of the water trapped between the pillar viewed from
 * the front.
 * 
 * 
 * Sample Input:
 * 		pillarHeights = [0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3]
 * 
 * Sample Output:
 * 		48
 * 
 * -------------------------------------------------------------------------------------------
 *
 */
public class TrapWater {
	
	public static void main(String[] args) {
		int[] inputHeightsArray = { 0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3 };
		System.out.println("Surface area of the water trapped between pillers is : " + trapWater(inputHeightsArray));
	}

	// Solution 1: O(n) Time and O(n) Space Complexity
	public static int waterArea(int[] heights) {
		int[] maxes = new int[heights.length];

		int leftMax = 0;
		for (int i = 0; i < heights.length; i++) {
			int height = heights[i];
			maxes[i] = leftMax;
			leftMax = Math.max(leftMax, height);
		}

		int rightMax = 0;
		for (int i = heights.length-1; i >=0; i--) {
			int height = heights[i];
			int minHeight = Math.min(rightMax, maxes[i]);
			if (height < minHeight) {
				maxes[i] = minHeight - height;
			} else {
				maxes[i] = 0;
			}
			rightMax = Math.max(rightMax, height);
		}
		int totalWater = 0;
		for (int i = 0; i < heights.length; i++) {
			totalWater += maxes[i];
		}

		return totalWater;
	}
	
	// Solution 2: O(n) Time and O(1) Space Complexity
	public static int trapWater(int[] heights) {

		if (heights.length == 0)
			return 0;

		var leftIdx = 0;
		var rightIdx = heights.length - 1;
		var leftMax = heights[leftIdx];
		var rightMax = heights[rightIdx];
		var surfaceArea = 0;
		while (leftIdx < rightIdx) {
			if (heights[leftIdx] < heights[rightIdx]) {
				leftIdx++;
				leftMax = Math.max(leftMax, heights[leftIdx]);
				surfaceArea += leftMax - heights[leftIdx];
			} else {
				rightIdx--;
				rightMax = Math.max(rightMax, heights[rightIdx]);
				surfaceArea += rightMax - heights[rightIdx];
			}
		}
		return surfaceArea;
	}
}
