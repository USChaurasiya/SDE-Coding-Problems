package com.us.easylevel;

import java.util.HashMap;

/**
 * @author Uma Shankar
 * <pre>
 * ======================================================================
 * 
 * Write a function that takes in a string in lower case English letters and returns the
 * index of the string's first Non-repeating character.
 * 
 * The first non-repeating char is the first char in a string that occurs only once.
 * If the input doesn't have any non-repeating char then it should return -1;
 *
 * 
 * <pre>
 * Sample Input: 
 * 		string = "abcdcaf"
 * 		
 * Sample Output: 1
 * 
 * ======================================================================
 */
public class FirstNonRepeatingChar {
	
	
	public static void main(String[] args) {
		String inputString = "abcdacf";
		
		System.out.println("Result : "+firstNonRepeatingCharacter(inputString));
	}

	// O(n) Time and O(1) Space complexity
	public static int firstNonRepeatingCharacter(String string) {
		HashMap<Character, Integer> charFrequencies = new HashMap<Character, Integer>();

		for (int i = 0; i < string.length(); i++) {
			char character = string.charAt(i);
			charFrequencies.put(character, charFrequencies.getOrDefault(character, 0) + 1);
		}

		for (int i = 0; i < string.length(); i++) {
			char character = string.charAt(i);
			if (charFrequencies.get(character) == 1) {
				return i;
			}
		}
		return -1;
	}
}
