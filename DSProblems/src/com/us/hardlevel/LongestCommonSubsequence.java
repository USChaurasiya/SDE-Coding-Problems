package com.us.hardlevel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Uma Shankar
 * <pre>
 * ------------------------------------------------------------------------------------------------
 *	Write a function that takes i two Strings and returns their longest common subsequence. A subsequence
 * 	of a string is a set of characters that aren't necessarily adjacent in the string but that are in same
 * 	order as they appear in the string.
 *	
 *
 *
 *	Sample Input :
 *			str1 = "ZXVVYZW"
 *			str2 = "XKYKZPW"
 *
 *	Sample output :
 *			["X", "Y", "Z", "W"]
 * -------------------------------------------------------------------------------------------------
 */
public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String s1 = "ZXVVYZW";
		String s2 = "XKYKZPW";

		System.out.println("Longest Common Subsequence of Given Strings are : ");
		longestCommonSubsequence(s1, s2).forEach(x -> System.out.print(x + " "));
	}

	// Solution 1: O(nm) Time and O(nm) Space complexity
	public static List<Character> longestCommonSubsequence(String str1, String str2) {
		int[][] length = new int[str2.length() + 1][str1.length() + 1];
		for (int i = 1; i < str2.length() + 1; i++) {
			for (int j = 1; j < str1.length() + 1; j++) {
				if (str2.charAt(i - 1) == str1.charAt(j - 1)) {
					length[i][j] = length[i - 1][j - 1] + 1;
				} else {
					length[i][j] = Math.max(length[i - 1][j], length[i][j - 1]);
				}
			}
		}
		return buildSequence(length, str1);
	}

	public static List<Character> buildSequence(int[][] length, String str) {
		List<Character> sequence = new ArrayList<Character>();
		int i = length.length - 1;
		int j = length[0].length - 1;

		while (i != 0 && j != 0) {
			if (length[i][j] == length[i - 1][j]) {
				i--;
			} else if (length[i][j] == length[i][j - 1]) {
				j--;
			} else {
				sequence.add(0, str.charAt(j - 1));
				i--;
				j--;
			}
		}
		return sequence;
	}

}
