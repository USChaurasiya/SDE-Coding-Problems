package com.us.easylevel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author Uma Shankar
 * <pre>
 * -------------------------------------------------------------------------------------
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',write 
 * a function which returns boolean (true/false) if the given parentheses is valid or not.
 * 
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * 
 * 
 * Input: s = "()[]{}"
 * Output: true
 * 
 * -------------------------------------------------------------------------------------
 */
public class ValidParentheses {

	public static void main(String[] args) {
		String inputExpression = "()(agawg)[{()gawggaw})]";
		System.out.println("Is given Expression valid : " + balancedBrackets(inputExpression));
	}

	// Solution 1: O(n) Time Complexity
	public static boolean isValidParentheses(String exp) {

		Stack<Character> characters = new Stack<Character>();

		for (char c : exp.toCharArray()) {
			if (c == '(' || c == '[' || c == '{') {
				characters.push(c);
			} else if (c == ')' && !characters.isEmpty() && characters.peek() == '(') {
				characters.pop();
			} else if (c == ']' && !characters.isEmpty() && characters.peek() == '[') {
				characters.pop();
			} else if (c == '}' && !characters.isEmpty() && characters.peek() == '{') {
				characters.pop();
			}
		}
		return characters.isEmpty();
	}

	
	// Solution 2: O(n) Time and O(n) Space Complexity
	public static boolean balancedBrackets(String str) {
		String openingBracckets = "({[";
		String closingBrackets = ")}]";
		Map<Character, Character> matchingBracket = new HashMap<Character, Character>();
		matchingBracket.put(')', '(');
		matchingBracket.put('}', '{');
		matchingBracket.put(']', '[');
		List<Character> stack = new ArrayList<Character>();
		for (char letter : str.toCharArray()) {
			if (openingBracckets.indexOf(letter) != -1) {
				stack.add(letter);
			} else if (closingBrackets.indexOf(letter) != -1) {
				if (stack.size() == 0) {
					return false;
				}
				if (stack.get(stack.size() - 1) == matchingBracket.get(letter)) {
					stack.remove(stack.size() - 1);
				} else {
					return false;
				}
			}
		}
		return stack.size() == 0;
	}
}
