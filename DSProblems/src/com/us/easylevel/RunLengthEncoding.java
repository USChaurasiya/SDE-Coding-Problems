package com.us.easylevel;

/**
 * @author Uma Shankar
 * <pre>
 * ======================================================================
 * 
 * Write a function that takes in a non-empty string and returns it's run-length Encoding.
 * Run Length is any sequence of consecutive, identical characters. So the run "BBB" would
 * be run-length encoded as "3B".
 * 
 * Long run(runs of 10 or more characters) should be encoded in a split fashion.
 * "BBBBBBBBBBBB" should be encoded as "9B3B"
 *
 * 
 * <pre>
 * Sample Input: 
 * 		string = "AAAAAABBBDDDDD"
 * 		
 * Sample Output: "6A3B5D"
 * 
 * ======================================================================
 */
public class RunLengthEncoding {
	
	public static void main(String[] args) {
		String inputString = "AABCD";
		
		System.out.println("Encoded String for given input is : "+ runLengthEncoding(inputString));
	}

	public static String runLengthEncoding(String str) {
		StringBuilder encodedStringChar = new StringBuilder();
		int currentRunLength = 1;

		for (int i = 1; i < str.length(); i++) {
			char currentChar = str.charAt(i);
			char previousChar = str.charAt(i - 1);

			if ((currentChar != previousChar) || (currentRunLength == 9)) {
				encodedStringChar.append(Integer.toString(currentRunLength));
				encodedStringChar.append(previousChar);
				currentRunLength = 0;
			}
			currentRunLength += 1;
		}
		encodedStringChar.append(Integer.toString(currentRunLength));
		encodedStringChar.append(str.charAt(str.length() - 1));

		return encodedStringChar.toString();
	}
}
