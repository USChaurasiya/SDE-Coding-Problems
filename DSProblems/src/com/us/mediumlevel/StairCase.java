package com.us.mediumlevel;

import java.util.ArrayList;

/**
 * @author Uma Shankar
 * <pre>
 * -------------------------------------------------------------------------------------
 * You are given two integers representing the height of the staircase and the maximum
 * number of steps that you can advance up the staircase at a time.
 * 
 * Write a function that returns the number of ways in which you can climb the staircase.
 * 
 * For Example There's a staircase with N steps, and you can climb 1 or 2 steps at a time
 * then lets take N = 4, now we have 5 unique ways to reach on top.
 *  1, 1, 1, 1
 *  2, 1, 1
 *  1, 2, 1
 *  1, 1, 2
 *  2, 2
 *  
 *  
 *  
 *  Sample Input:
 *  	height = 4
 *  	maxSteps = 2
 *  
 *  Sample Output:
 *  	5
 *  
 *  
 *  N = 1: [1]
 *  N = 2: [1, 1], [2]
 *  N = 3: [1, 2], [1, 1, 1], [2, 1]
 *  N = 4: [1, 1, 2], [2, 2], [1, 2, 1], [1, 1, 1, 1], [2, 1, 1]
 *  
 *  What's the relationship?
 *
 *  The only ways to get to N = 3, is to first get to N = 1, and then go up by 2 steps,
 *  or get to N = 2 and go up by 1 step. So f(3) = f(2) + f(1).
 *  Does this hold for N = 4? Yes, it does. Since we can only get to the 4th step by 
 *  getting to the 3rd step and going up by one, or by getting to the 2nd step and going 
 *  up by two. So f(4) = f(3) + f(2).
 *  
 *  To generalize, f(n) = f(n - 1) + f(n - 2). That's just the Fibonacci sequence!
 *
 * --------------------------------------------------------------------------------------
 *
 */
public class StairCase {

	public static void main(String[] args) {
		int heightOfStair = 4;
		int maxAllowedSteps = 2;
		
		System.out.println("Number of ways to reach on the top of stair of having "
				+ heightOfStair+ " steps are : "+ staircaseTraversal(heightOfStair, maxAllowedSteps));
	}
	
	
	// Solution 1: O(n) Time and O(n) Space Complexity
	public static int staircaseTraversal(int height, int maxSteps) {
		int currentNumberOfWays = 0;
		ArrayList<Integer> wayToTop = new ArrayList<Integer>();
		wayToTop.add(1);

		for (int currentHeight = 1; currentHeight < height + 1; currentHeight++) {
			int startOfWindow = currentHeight - maxSteps - 1;
			int endOfWindow = currentHeight - 1;

			if (startOfWindow >= 0) {
				currentNumberOfWays -= wayToTop.get(startOfWindow);
			}
			currentNumberOfWays += wayToTop.get(endOfWindow);
			wayToTop.add(currentNumberOfWays);
		}
		return wayToTop.get(height);
	}
	
	// Solution 2: Recursive Approach
	public static int stairCase(int height) {
		if(height<2) return 1;
		return stairCase(height-1)+stairCase(height-2);
	}
	
	//Solution 3: Bottom Up Approach
	public static int climbStairs(int height) {
		
		int dp[] = new int [height+1];
		dp[0] = 1;
		dp[1] = 1;
		for(int i=2; i<= height; i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		return dp[height];
	}
}
