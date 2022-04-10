package com.us.hardlevel;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Uma Shankar
 * <pre>
 * ------------------------------------------------------------------------------------
 *	You are given an m x n grid where each cell can have one of three values:
 *
 *	0 representing an empty cell,
 *	1 representing a fresh orange, or
 *	2 representing a rotten orange.
 *	Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange 
 *	becomes rotten.
 *
 *	Write a function which takes in the matrix and return the minimum number of minutes 
 *	that must elapse until no cell has a fresh orange.If this is impossible, return -1.
 * 
 * 
 *	Sample Input: 
 *	    grid = [[2,1,1],[1,1,0],[0,1,1]]
 *
 *
 *	Output: 4
 * --------------------------------------------------------------------------------------
 */
public class RottenOrange {

	public static void main(String[] args) {
		
		int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
		System.out.println("Minimum no of min to rotten all orange in the grid is : "+orangesRotting(grid));
		
	}
	
	public static int orangesRotting(int[][] grid) {

		if (grid.length == 0 || grid == null)
			return 0;
		int rows = grid.length;
		int cols = grid[0].length;
		Queue<int[]> queue = new LinkedList<int[]>();
		int totalCount = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 2) {
					queue.offer(new int[] { i, j });
				}

				if (grid[i][j] != 0) {
					totalCount++;
				}
			}
		}

		if (totalCount == 0)
			return 0;

		int countMin = 0, count = 0;
		int dx[] = { 0, 0, 1, -1 };
		int dy[] = { 1, -1, 0, 0 };
		while (!queue.isEmpty()) {
			int size = queue.size();
			count += size;

			for (int i = 0; i < size; i++) {
				int[] point = queue.poll();
				for (int j = 0; j < 4; j++) {
					int x = point[0] + dx[j];
					int y = point[1] + dy[j];

					if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2)
						continue;
					grid[x][y] = 2;
					queue.offer(new int[] { x, y });
				}
			}
			if (queue.size() != 0) {
				countMin++;
			}
		}
		return totalCount == count ? countMin : -1;
	}
}
