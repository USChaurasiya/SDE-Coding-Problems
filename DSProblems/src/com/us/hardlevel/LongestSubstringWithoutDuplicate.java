package com.us.hardlevel;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Uma Shankar
 * <pre>
 *----------------------------------------------------------------------------------
 * Write a function that takes in a string and returns its longest substring without
 * duplicate characters.
 * 
 * Sample Input:
 * 	string = "umashankar"
 * 
 * Sample Output:
 * 		"umash"
 *----------------------------------------------------------------------------------
 */
public class LongestSubstringWithoutDuplicate {
	
	public static void main(String[] args) {
		
		System.out.println(longestSubstringWithoutDuplication("umashankar"));
	}

	// O(n) Time and O(min(n,a)) Space Complexity
	public static String longestSubstringWithoutDuplication(String str) {

		Map<Character, Integer> lastSeen = new HashMap<Character, Integer>();
		int[] longest = { 0, 1 };
		int startIdx = 0;

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (lastSeen.containsKey(c)) {
				startIdx = Math.max(startIdx, lastSeen.get(c) + 1);
			}
			if (longest[1] - longest[0] < i + 1 - startIdx) {
				longest = new int[] { startIdx, i + 1 };
			}
			lastSeen.put(c, i);
		}
		String resultedString = str.substring(longest[0], longest[1]);
		return resultedString;
	}
}
