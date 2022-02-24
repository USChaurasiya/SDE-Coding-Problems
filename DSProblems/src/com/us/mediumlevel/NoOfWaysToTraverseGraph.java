package com.us.mediumlevel;

/**
 * @author Uma Shankar
 *
 *	<pre>
 *	===============================================================================================
 *	You're given two positive integers representing the width and height of a grid shaped rectangular graph.
 *	Write a function that returns the number of ways to reach the bottom right corner of the graph when starting 
 *	at the top left corner.Each move you take must either go down or right. You can never move up or left in the graph.
 *
 *	
 *	Sample Input:
 *			width = 4
 *			height = 3
 *
 *	Sample Output:
 *			10
 *
 *
 */
public class NoOfWaysToTraverseGraph {
	
	public static void main(String[] args) {
		int width = 4;
		int height = 3;
		
		System.out.println("Number of ways to traverse Graph having width "+width+ " and height "+height+" "
				+ "is : "+numberOfWaysToTraverseGraph(width, height));
	}
	
	
	// Solution 1: O(2^(n+m)) Time and O(n+m) Space complexity
	public static int numberOfWaysToTraverseGraph(int width, int height) {
		if(width == 1 || height == 1) return 1;
		return numberOfWaysToTraverseGraph(width-1, height)+numberOfWaysToTraverseGraph(width, height-1);
	}

	// Solution 2: O(n+m) Time and O(1) Space Complexity
	public static int noOfWaysToTraverseGraph(int width, int height) {
		int xCornerDistance = width-1;
		int yCornerDistance = height-1;
		
		return factorial(xCornerDistance+yCornerDistance)/(factorial(xCornerDistance)*factorial(yCornerDistance));
	}


	private static int factorial(int number) {
		int result = 1;
		for(int i=2; i<number+1; i++) {
			result *= number;
		}
		return result;
	}
}
