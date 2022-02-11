package com.us.easylevel;

import java.util.Arrays;

/**
 * @author Uma Shankar
 * <pre>
 * ======================================================================
 * 
 * A Tandem Bicycle is a bicycle that's operated by two people, Person A and Person B.
 * Both people pedal the bicycle, but the person that pedal faster dictates the speed
 * of the bicycle. So if person A pedals at speed 5,and person B pedals at a speed 4, 
 * the tandem bicycle moves at a speed of 5.
 * 
 *  You are given two lists of positive integers one that contains the speed of riders wearing
 *  red shirt and one that contains the speed of riders wearing blue shirts. Each rider is 
 *  represented by a single positive integer, which is the speed that they pedal a tandem bicycle
 *  at. your goal to pair every rider wearing red shirt with a rider wearing a blue shirt to 
 *  operate the tandem bicycle.
 *  
 *  Write a function that returns the maximum possible total speed or the minimum possible total
 *  speed of all of the tandem bicycles being ridden based on an input parameter,faster. If
 *  faster=true, your function should return the maximum possible total speed.Otherwise it should
 *  return minimum total speed.
 * 
 * 
 * 
 * <pre>
 * 
 * Sample Input: 
 * 
 * 		redShirtSpeeds = [5,5,3,9,2]<br>
 * 		blueShirtSpeeds = [3,6,7,2,1]
 * 		fastest = true
 * 
 * Sample Output: 32
 * 
 * ======================================================================
 *
 */
public class TendemBicycle {
	
	public static void main(String[] args) {
		int[] redShirtSpeeds = {5,5,3,9,2};
		int[] blueShirtSpeeds = {3,6,7,2,1};
		
		System.out.println("Total Speed : "+tandemBicycle(redShirtSpeeds, blueShirtSpeeds, true));
		
	}
	
	public static int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
		
		Arrays.sort(redShirtSpeeds);
		Arrays.sort(blueShirtSpeeds);
		
		if(!fastest) {
			reverseArray(redShirtSpeeds);
		}
		
		int totalSpeed = 0;
		for(int i=0; i<redShirtSpeeds.length; i++) {
			int rider1 = redShirtSpeeds[i];
			int rider2 = blueShirtSpeeds[blueShirtSpeeds.length-i-1];
			totalSpeed += Math.max(rider1, rider2);
		}
		return totalSpeed;
	}
	
	public static void reverseArray(int[] array) {
		int start = 0;
		int end = array.length-1;
		
		while(start<end) {
			int temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			start+=1;
			end-=1;
		}
	}

}
