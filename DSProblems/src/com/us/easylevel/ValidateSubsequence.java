package com.us.easylevel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Uma Shankar
 * <pre>
 * ======================================================================
 * 
 * Given Two Non empty Arrays of Integers, write a function that determines whether 
 * the second array is subsequence of the first one.
 * <pre>
 * Sample Input: array = [1,3,5,6,8,-2,4]<br>
 * 		sequence = [3,8,-2]<br>
 * 
 * Sample Output: true
 * 
 * ======================================================================
 *
 */
public class ValidateSubsequence {

	public static void main(String[] args) {
		
		List<Integer> array = new ArrayList<Integer>();
		array.add(1);
		array.add(3);
		array.add(5);
		array.add(6);
		array.add(8);
		array.add(-2);
		array.add(4);
		
		List<Integer> sequence = new ArrayList<Integer>();
		sequence.add(3);
		sequence.add(8);
		sequence.add(-2);
		
		boolean result = isValidSubsequence(array, sequence);
		System.out.println(result);
		
	}
	
	
	// Solution 1: O(n) Time | O(1) Space complexity
	public static boolean isValidSubsequence(List<Integer> array, List<Integer>sequence) {
		
		int arrayIndex = 0;
		int sequenceIndex = 0;
		
		while(arrayIndex<array.size() && sequenceIndex<sequence.size()) {
			if(array.get(arrayIndex).equals(sequence.get(sequenceIndex))) {
				sequenceIndex++;
			}
			arrayIndex++;
		}
		return sequenceIndex == sequence.size();
	}
	
	
	// Solution 2: O(n) Time | O(1) Space Complexity
	public static boolean isValidSubSequence(List<Integer> array, List<Integer>sequence) {
		
		int sequenceIndex = 0;
		for(Integer value : array) {
			if(sequenceIndex == sequence.size()) {
				break;
			}
			if(sequence.get(sequenceIndex).equals(value)) {
				sequenceIndex++;
			}
		}
		return sequenceIndex == sequence.size();
	}

}
