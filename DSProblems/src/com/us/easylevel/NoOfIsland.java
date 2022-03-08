package com.us.easylevel;

/**
 * @author Uma Shankar
 * <pre>
 * ----------------------------------------------------------------------------------------------------
 * You're given a two-dimensional array(a Matrix) of potentially unequal height and width containing 
 * only 1's and 0's. 1 represents land and 0 represent water. Write a function which returns the number
 * of island from the given matrix.
 * 
 * An island is defined as a number of 1's that are horizontally or vertically adjacent but not diagonally.
 * In other word a group of horizontally or vertically adjacent 1's isn't an island if any of those 1's are 
 * in the first row, last row, first column or last column of the input matrix.
 * 
 * 
 * Sample Input:
 *	array = [
    	[1,1,0,0,0],
    	[1,1,0,0,0],
    	[0,0,1,0,0],
    	[0,0,0,1,1]
  	]
 *
 *Sample Output:
 *            3
 *            
 *Approach -> Find the cell which contains 1 and visit all 4 direction to check if it's 1 or 0;
 *
 *                    (x-1,y)
 *                       |
 *                       |
 *        (x,y-1)------(x,y)------(x,y+1)
 *                       |
 *                       |
 *                   (x+1,y)
 *
 *------------------------------------------------------------------------------------------------------
 */
public class NoOfIsland {

	public static void main(String[] args) {
		int[][] array = { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 0, 1, 1 } };

		System.out.println("Number of islands : " + numbersOfIsland(array));
	}
	
	public static int numbersOfIsland(int[][] matrix) {
		int islandCount = 0;
		int rows = matrix.length;
		if (rows == 0)
			return 0;
		int cols = matrix[0].length;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (matrix[i][j] == 1) {
					markCurrentIsland(matrix, i, j, rows, cols);
					islandCount += 1;
				}
			}
		}
		return islandCount;
	}

	private static void markCurrentIsland(int[][] matrix, int x, int y, int rows, int cols) {
		if (x < 0 || x >= rows || y < 0 || y >= cols || matrix[x][y] != 1)
			return;

		matrix[x][y] = 2;
		markCurrentIsland(matrix, x + 1, y, rows, cols); // Down
		markCurrentIsland(matrix, x, y + 1, rows, cols); // Right
		markCurrentIsland(matrix, x - 1, y, rows, cols); // Top
		markCurrentIsland(matrix, x, y - 1, rows, cols); // Left
	}
}
