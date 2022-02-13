package com.us.easylevel;


/**
 * @author Uma Shankar
 * <pre>
 * ======================================================================
 * 
 * Write a function that takes in an array of at least three integers and, without sorting the
 * input array, returns a sorted array of the three largest integers in the input array.
 * 
 * The function should return duplicate integers if necessary. For example it should return
 * [10,10,12] for an input array[10,5,9,10,12]
 * 
 * ======================================================================
 *
 */
public class ThreeLargestNumber {
	
	public static void main(String[] args) {
		int[] inputArray = {10,4,7,10,12};
		int[] largestThreeArray = findThreeLargestNumber(inputArray);
		
		System.out.println("Resulted Array : ");
		for (int ele : largestThreeArray) {
			System.out.print(ele+ " ");
		}
	}
	
	public static int[] findThreeLargestNumber(int[] array) {
		int [] largestThree = {Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};
		for(int element : array) {
			updateLargestValue(largestThree,element);
		}
		return largestThree;
	}

	private static void updateLargestValue(int[] largestThree, int element) {
		if(element>largestThree[2])
			shiftAndUpdate(largestThree,element,2);
		else if (element>largestThree[1]) 
			shiftAndUpdate(largestThree,element,1);
		else if (element>largestThree[0]) 
			shiftAndUpdate(largestThree, element, 0);
	}

	private static void shiftAndUpdate(int[] largestThree, int element, int index) {
		for (int i = 0; i <= index; i++) {
			if(i==index) {
				largestThree[i] = element;
			}else {
				largestThree[i] = largestThree[i+1];
			}
		}
	}

}
