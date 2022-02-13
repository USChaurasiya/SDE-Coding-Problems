package com.us.easylevel;

/**
 * @author Uma Shankar
 * <pre>
 * ======================================================================
 * 
 * Write a function that takes in a non-empty string and that returns a boolean representing 
 * whether the string is a palindrome.
 * 
 *  
 *Example: 
 *	string = "abcdcba"
 *
 *Output : True
 * 
 * ======================================================================
 *
 */
public class Palindrome {

	public static void main(String[] args) {
		String inputString = "abcdcba";
		System.out.println("Is given String <" + inputString + "> is palindrome : " + isPalindrome(inputString));
	}

	// Solution 1: O(n) Time and O(1) Space Complexity
	public static boolean isPalindrome(String str) {
		int leftIndex = 0;
		int rightIndex = str.length() - 1;
		while (leftIndex < rightIndex) {
			if (str.charAt(leftIndex) != str.charAt(rightIndex)) {
				return false;
			}
			leftIndex++;
			rightIndex--;
		}
		return true;
	}
}
