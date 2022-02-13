package com.us.easylevel;

/**
 * @author Uma Shankar
 * <pre>
 * ======================================================================
 * 
 * Given a non empty String of lowercase letters and a non negative integer representing a key.
 * Write a function that returns a new String Obtained by shifting every letter in the input string
 * by k position in the alphabet where k is the key.
 *
 * 
 * <pre>
 * Sample Input: 
 * 		string = "abc"
 * 		key = 2
 * 		
 * Sample Output: "cde"
 * 
 * ======================================================================
 *
 */
public class CaesarCipherEncryptor {
	
	public static void main(String[] args) {
		String inputStr = "xyz";
		int key = 2;
		
		System.out.println("Output String : "+caesarCypherEncryptor(inputStr, key));
	}
	
	// O(n) Time and O(n) Space Complexity
	public static String caesarCypherEncryptor(String str, int key) {
	    char[] newLetters = new char[str.length()];
			int newKey = key % 26;
			String alphabet = "abcdefghijklmnopqrstuvwxyz";
			for(int i=0; i<str.length(); i++){
				newLetters[i] = getNewLetter(str.charAt(i), newKey, alphabet);
			}
	    return new String(newLetters);
	  }
		
		public static char getNewLetter(char letter, int key, String alphabet){
			int newLetterCode = alphabet.indexOf(letter) + key;
			return alphabet.charAt(newLetterCode % 26);
		}
}
