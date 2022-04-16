package com.us.easylevel;

/**
 * @author Uma Shankar
 * <pre>
 * --------------------------------------------------------------------------------------
 * Write a function which takes in two arrays and returns if the one array is rotation of
 * another.
 * 
 * Sample Input:
 * 	array1 = [1,2,3,4,5,6,7]
 * 	array2 = [4,5,6,7,1,2,3]
 * 
 * Sample Output:
 * 	true
 * 
 * ---------------------------------------------------------------------------------------
 */
public class RotationArray {
	
	public static void main(String[] args) {
		int[] inputArray1 = {1,2,3,4,5,6,7};
		int[] inputArray2 = {4,5,6,7,1,2,3};
		
		System.out.println("Is from given arrays one array rotation of another : "+
				isRotation(inputArray1, inputArray2));
	}

	public static boolean isRotation(int[] array1, int[] array2) {
		if (array1.length != array2.length)
			return false;

		int key = array1[0];
		int keyIndex = -1;

		for (int i = 0; i < array2.length; i++) {
			if (array2[i] == key) {
				keyIndex = i;
				break;
			}
		}

		if (keyIndex == -1)
			return false;

		for (int i = 0; i < array1.length; i++) {
			int j = (keyIndex + i) % array1.length;
			if (array1[i] != array2[j]) {
				return false;
			}
		}
		return true;
	}
}
