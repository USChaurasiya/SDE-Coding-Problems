package com.us.mediumlevel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Uma Shankar
 * <pre>
 * --------------------------------------------------------------------------------------
 * The powerset of a set X is the set of all subsets of X. For example the powerset of [1,2]
 * is [[],[1],[2],[1,2]].
 * 
 * Write a function that takes in an array of unique integers and returns its powerset.
 * 
 * Sample Input :
 * 	array = [1,2,3]
 * 
 * Sample Output : 
 *	[[], [1], [2], [3], [1,2], [1,3], [2,3], [1,2,3]]
 *
 *----------------------------------------------------------------------------------------
 *
 */
public class PowerSet {

	public static void main(String[] args) {

		List<List<Integer>> output = getPowerSet(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
		System.out.println("Powerset of given List is : ");
		for (List<Integer> list : output) {
			System.out.print(list + "  ");
		}
	}

	// Solution 1: O(n*2^n) Time and O(n*2^n) Space Complexity
	public static List<List<Integer>> getPowerSet(List<Integer> array) {
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		subsets.add(new ArrayList<Integer>());

		for (Integer element : array) {
			int length = subsets.size();
			for (int i = 0; i < length; i++) {
				List<Integer> currentSubset = new ArrayList<Integer>(subsets.get(i));
				currentSubset.add(element);
				subsets.add(currentSubset);
			}
		}
		return subsets;
	}
}
