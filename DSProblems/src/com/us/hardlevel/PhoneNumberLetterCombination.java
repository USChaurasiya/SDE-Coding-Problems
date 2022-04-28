package com.us.hardlevel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Uma Shankar
 * <pre>
 * -------------------------------------------------------------------------------------- 
 * Given a string containing digits from 2-9 inclusive, return all possible letter 
 * combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note 
 * that 1 does not map to any letters.
 * 
 * Sample Input:
 * 	digits = "23"
 * 
 * Sample Output:
 * 	["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 
 * --------------------------------------------------------------------------------------
 */
public class PhoneNumberLetterCombination {

	public static void main(String[] args) {
		String inputDigit = "22";
		List<String> result = letterCombinations(inputDigit);

		System.out.println("Letter Combination represented using given Number " + inputDigit);
		result.forEach(x -> System.out.print(x + " "));
	}

	public static List<String> letterCombinations(String digits) {
		Map<Character, String> map = new HashMap<Character, String>();
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");

		List<String> result = new ArrayList<String>();
		if (digits.length() > 0) {
			dfs(0, "", result, digits, map);
		}

		return result;
	}

	private static void dfs(int index, String str, List<String> result, String digits, Map<Character, String> map) {
		if (str.length() == digits.length()) {
			result.add(str);
			return;
		}
		for (char c : map.get(digits.charAt(index)).toCharArray()) {
			dfs(index + 1, str + c, result, digits, map);
		}
	}
}
