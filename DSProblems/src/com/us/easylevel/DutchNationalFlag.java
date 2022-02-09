package com.us.easylevel;

/**
 * @author Uma Shankar
 * <pre>
 * ======================================================================
 * 
 * Your are given an array arr, consisting of only zeros, ones, and twos.
 * Sort the same array in-place ans return it, don't create new array.
 * <pre>
 * 
 * Sample Input: array = [2,0,1,0,2]<br>
 * 		
 * Sample Output: [0,0,1,2,2]
 * 
 * ======================================================================
 *
 */
public class DutchNationalFlag {
	
	public static void main(String[] args) {
		int[] array = {2,0,1,0,2};
		int[] result = sortItUp(array);
		System.out.println("Sorted array is: ");
		for (int i : result) {
			System.out.print(i+ "  ");
		}
	}
	
	public static int[] sortItUp(int[] inputArray) {
		
		int length = inputArray.length;
		int left_pointer = 0;
		int right_pointer = length-1;
		int i = 0;
		
		while(i<=right_pointer) {
			if(inputArray[i]==2) {
				inputArray[i] = inputArray[right_pointer];
				inputArray[right_pointer] = 2;
				right_pointer -= 1;
			}else if (inputArray[i]==1) {
				i+=1;
			}else {
				inputArray[i] = inputArray[left_pointer];
				inputArray[left_pointer] = 0;
				left_pointer += 1;
				i+=1;
			}
		}
		return inputArray;
	}

}
