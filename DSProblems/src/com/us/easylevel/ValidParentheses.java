package com.us.easylevel;

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
		String inputExpression = "[{())}]";
		System.out.println("Is given Expression valid : " + isValidParentheses(inputExpression));
	}

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
			} else {
				return false;
			}
		}
		return characters.isEmpty();
	}
}
