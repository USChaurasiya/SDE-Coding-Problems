package com.us.mediumlevel;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Uma Shankar
 *
 *	<pre>
 *	===============================================================================================
 *	Write a function that takes an n x m two dimensional array and returns a one dimensional array of all the array's 
 *	element in spiral order.
 *
 *	Spiral order starts at the top left corner of the two dimensional array, goes to right and proceeds in the spiral pattern 
 *	all the way until every element has been visited.
 *
 *	
 *	Sample Input:
 *			arr = [
 *					[1,2,3,4],
 *					[12,13,14,5],
 *					[11,16,15,6],
 *					[10,9,8,7],
 *				]
 *
 *	Sample Output:
 *			[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16]
 *
 *
 */
public class SpiralTraverse {
	
	public static void main(String[] args) {
		var input =
		        new int[][] {
		          {1, 2, 3, 4},
		          {12, 13, 14, 5},
		          {11, 16, 15, 6},
		          {10, 9, 8, 7},
		        };
		        
		 var output = spiralTraverse(input);
		 System.out.println("Spiral Traversal of given array is : "+output);
	}

	
	// Solution 1: O(n) Time and O(n) Space Complexity
	public static List<Integer> spiralTraverse(int[][] arr) {
		if (arr.length == 0)
			return new ArrayList<Integer>();

		var result = new ArrayList<Integer>();
		var startRow = 0;
		var startCol = 0;
		var endRow = arr.length - 1;
		var endCol = arr[0].length - 1;

		while (startRow <= endRow && startCol <= endCol) {
			for (int col = startCol; col <= endCol; col++) {
				result.add(arr[startRow][col]);
			}
			for (int row = startRow + 1; row <= endRow; row++) {
				result.add(arr[row][endCol]);
			}
			for (int col = endCol - 1; col >= startCol; col--) {
				if (startRow == endRow)
					break;
				result.add(arr[endRow][col]);
			}
			for (int row = endRow - 1; row > startRow; row--) {
				if (startCol == endCol)
					break;
				result.add(arr[row][startCol]);
			}
			startRow++;
			endRow--;
			startCol++;
			endCol--;
		}
		return result;
	}
	
	
	// Solution 2: O(n) Time and O(n) space complexity
	public static List<Integer> spiralTraverseOf2DArray(int[][] array){
		if (array.length == 0)
			return new ArrayList<Integer>();
		
		var result = new ArrayList<Integer>();
		spiralFill(array, 0, array.length-1, 0, array[0].length-1, result);
		return result;
	}

	private static void spiralFill(int[][] array, int startRow, int endRow, int startCol, int endCol, ArrayList<Integer> result) {
		if(startRow>endRow || startCol>endCol) return;
		
		for(int col = startCol; col <= endCol; col++) {
			result.add(array[startRow][col]);
		}
		
		for(int row = startRow+1; row<= endRow; row++) {
			result.add(array[row][endCol]);
		}
		
		for(int col = endCol - 1; col >= startCol; col--){
			if(startRow == endRow) break;
			result.add(array[endRow][col]);
		}
		
		for(int row = endRow - 1; row >= startRow+1; row--){
			if(startCol == endCol) break;
			result.add(array[row][startCol]);
		}
		
		spiralFill(array, startRow+1, endRow-1, startCol+1, endCol-1, result);
		
	}

}
