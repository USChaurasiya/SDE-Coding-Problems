package com.us.mediumlevel;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Uma Shankar
 * <pre>
 * ======================================================================
 * 
 * You are given an array of Integers and an integer. Write a function that moves all instances
 * of that integer in the array to the end of the array and returns the array.
 * 
 * <pre>
 * Sample Input: array = [2,1,2,2,2,3,4,2]
 *		toMove = 2
 * 		
 * Sample Output: [1,,3,4,2,2,2,2,2]
 * 
 * ======================================================================
 *
 */
public class MoveElementToEnd {
	
	public static void main(String[] args) {
		List<Integer> inputList = new ArrayList<Integer>();
		inputList.add(1);
		inputList.add(2);
		inputList.add(3);
		inputList.add(2);
		inputList.add(2);
		inputList.add(4);
		inputList.add(2);
		inputList.add(2);
		
		int toMove = 2;
		
		System.out.println("Input Array is :");
		for (Integer integer : inputList) {
			System.out.print(integer + "  ");
		}
		
		System.out.println();
		System.out.println("Resulted Array : ");
		moveElementToEnd(inputList, toMove).forEach(System.out::print);
	}

	public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
		int start = 0;
		int end = array.size() - 1;
		while (start < end) {
			while (start < end && array.get(end) == toMove)
				end--;
			if (array.get(start) == toMove)
				swap(start, end, array);
			start++;
		}
		return array;
	}

	public static void swap(int i, int j, List<Integer> array) {
		int temp = array.get(j);
		array.set(j, array.get(i));
		array.set(i, temp);
	}
}
