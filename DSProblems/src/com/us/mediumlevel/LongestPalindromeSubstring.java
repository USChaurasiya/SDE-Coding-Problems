package com.us.mediumlevel;

public class LongestPalindromeSubstring {

	public static void main(String[] args) {
		System.out.println(longestPalindromicSubstring("abaxyzzyxf"));
	}

	// Solution 1: O(n^2) Time and O(1) Space Complexity
	public static String longestPalindromicSubstring(String str) {

		int[] currentLongest = { 0, 1 };
		for (int i = 1; i < str.length(); i++) {
			// Odd is going to be palindrome that is of odd length
			int[] odd = getPalindromeFrom(str, i - 1, i + 1);
			// Even is going to be the even length palindrome
			int[] even = getPalindromeFrom(str, i - 1, i);

			int[] longest = odd[1] - odd[0] > even[1] - even[0] ? odd : even;
			currentLongest = currentLongest[1] - currentLongest[0] > longest[1] - longest[0] ? currentLongest : longest;
		}

		return str.substring(currentLongest[0], currentLongest[1]);
	}

	private static int[] getPalindromeFrom(String str, int leftIdx, int rightIdx) {
		while (leftIdx >= 0 && rightIdx < str.length()) {
			if (str.charAt(leftIdx) != str.charAt(rightIdx)) {
				break;
			}
			leftIdx--;
			rightIdx++;
		}
		return new int[] { leftIdx + 1, rightIdx };
	}

}
