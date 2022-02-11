package com.us.easylevel;

import java.util.Scanner;

/**
 * @author Uma Shankar
 * <pre>
 * ======================================================================
 * 
 * The Fibonacci sequence is defined as follows: The first number of the seqence is 0,
 * the second number is 1 and the nth number is the sum of (n-1)th and (n-2)th numbers.
 * Write a function that take an integer n and return the nth fibonacci number;
 * 
 * 
 * 
 * 
 * <pre>
 * Sample Input: 
 * 		n=2
 * 		
 * Sample Output: 1
 * 
 * ======================================================================
 *
 */
public class NthFibonacci {
	
	public static void main(String[] args) {
		System.out.println("Enter nth Number : ");
		Scanner sc = new Scanner(System.in);
		int no = sc.nextInt();
		
		System.out.println(no+"th fibonacci Number is : "+getNthFib(no));
	}
	
	
	// Solution 1: O(n) Time | O(1) Space complexity
	public static int getNthFib(int n) {
		int[] firstTwo = {0,1};
		int count = 3;
		
		while(count <= n) {
			int nextFib = firstTwo[0]+firstTwo[1];
			firstTwo[0] = firstTwo[1];
			firstTwo[1] = nextFib;
			
			count++;
		}
		return n>1 ? firstTwo[1] : firstTwo[0];
	}
	
	
	// Soulution 2: O(2^n) Time | O(n) Space
	public static int getNthFibonacci(int n) {
		if (n == 2) {
			return 1;
		} else if (n == 1) {
			return 0;
		} else {
			return getNthFibonacci(n - 1) + getNthFibonacci(n - 2);
		}
	}

}
