package com.us.mediumlevel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Uma Shankar
 * <pre>
 * ----------------------------------------------------------------------------------------------------
 * Write a function that takes in an array of Unique integers and returns an array of all permutations of
 * those integers in no particular order.
 * 
 * If the array is Empty then the function should return an empty array.
 * 
 * 
 * Sample Input:
 *		array = [1,2,3]
 *
 *Sample Output:
 *		[[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]]
 *
 *------------------------------------------------------------------------------------------------------
 */
public class Permutations {
	
	public static void main(String[] args) {
		List<Integer> input = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
		List<List<Integer>> outputPermutations = getPermutations(input);
		
		System.out.println("Permutations of given Integer Array are :");
		outputPermutations.stream().flatMap(x-> Stream.of(x)).forEach(System.out::print);
	}
	
	public static List<List<Integer>> getPermutations(List<Integer> array) {
	    List<List<Integer>> permutations = new ArrayList<List<Integer>>();
			getPermutations(0, array, permutations);
	    return  permutations;
	  }

	private static void getPermutations(int i, List<Integer> array, List<List<Integer>> permutations) {
		if(i == array.size()-1) {
			permutations.add(new ArrayList<Integer>(array));
		}else {
			for(int j = i; j<array.size(); j++) {
				swap(array, i, j);
				getPermutations(i+1, array, permutations);
				swap(array,i,j);
			}
		}
	}

	private static void swap(List<Integer> array, int i, int j) {
		Integer temp = array.get(i);
		array.set(i, array.get(j));
		array.set(j, temp);
	}
}
