package com.us.mediumlevel;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Uma Shankar
 * <pre>
 * ------------------------------------------------------------------------------------------
 * Write a function that takes in an array of integers and returns a new array containing, at
 * each index, the next element in the input array that's greater than the element at that 
 * index in the input array.
 * 
 * If there is no such next greater element for a particular index, the value at that index in 
 * the output array should be -1. For Example array=[1,3], your function should return [3,-1].
 * 
 * Additionally your function should treat the input array as a circular array. A circular array
 * wraps around itself as if it were connected end-to-end. So the next index after the last index
 * in a circular array is the first index.
 * 
 * 
 * 
 * Sample Input:
 * 	array = [2, 5, -3, -4, 6, 7, 2]
 * 
 * Sample Output:
 * 	[5, 6, 6, 6, 7, -1, 5]
 * 
 * ---------------------------------------------------------------------------------------------
 *
 */
public class NextGreaterElement {

	public static void main(String[] args) {
		int[] inputArray = new int[] { 2, 5, -3, -4, 6, 7, 2 };
		int[] output = nextGreaterElement(inputArray);

		System.out.println("Resulted array : ");
		for (int element : output) {
			System.out.print(element + "  ");
		}

	}

	// O(n) Time and O(n) Space Complexity, n is the length of array.
	public static int[] nextGreaterElement(int[] array) {
		int[] result = new int[array.length];
		Arrays.fill(result, -1);
		Stack<Integer> stack = new Stack<Integer>();

		for (int idx = 0; idx < 2 * array.length; idx++) {
			int circularIdx = idx % array.length;

			while (stack.size() > 0 && array[stack.peek()] < array[circularIdx]) {
				int top = stack.pop();
				result[top] = array[circularIdx];
			}
			stack.push(circularIdx);
		}
		return result;
	}
}
