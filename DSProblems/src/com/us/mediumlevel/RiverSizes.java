package com.us.mediumlevel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Uma Shankar
 * <pre>
 * --------------------------------------------------------------------------------------
 * You're given a two-dimensional array(a matrix) of potentially unequal height and width
 * containing only 0's and 1's. Each 0 represents land and each 1 represents part of a 
 * river. A river consists of any number of 1's that are either horizontally or vertically 
 * adjacent. The Number of Adjacent 1's forming a river determine its size.
 * 
 * Note that a river can twist, In other words, it doesn't have to be a straight vertical 
 * line or a straight horizontal line.
 * 
 * Write a function that returns an array of the sizes of all rivers represented in the 
 * input matrix. The size doesn't need to be in any particular order.
 * 
 * 
 * Sample Input:
 * 	matrix = [
 * 			[1, 0, 0, 1, 0],
 * 			[1, 0, 1, 0, 0],
 * 			[0, 0, 1, 0, 1],
 * 			[1, 0, 1, 0, 1],
 * 			[1, 0, 1, 1, 0]
 * 		]
 * 
 * Sample Output:
 * 	[1, 2, 2, 2, 5]
 * 
 * ----------------------------------------------------------------------------------------
 *
 */
public class RiverSizes {

	public static List<Integer> riverSizes(int[][] matrix) {
		// TBD
		return new ArrayList<Integer>();
	}
}
