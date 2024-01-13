package com.us.leetcodeproblems.dp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, 
 * which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.

Example 1:
	Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
	Output: 7
	Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

Example 2:
	Input: grid = [[1,2,3],[4,5,6]]
	Output: 12
 */
public class MinPathSum {
	
	// Time Complexity : O(r * c)  Space Complexity O(r * c)
	public static int minPathSum(int[][] grid) {
		Map<List<Integer>, Integer> memo = new HashMap<List<Integer>, Integer>();

		return minPathSum(0, 0, grid, memo);
	}

	public static int minPathSum(int r, int c, int[][] grid, Map<List<Integer>, Integer> memo) {
		if (r == grid.length || c == grid[0].length) {
			return Integer.MAX_VALUE;
		}
		if (r == grid.length - 1 && c == grid[0].length - 1) {
			return grid[r][c];
		}

		List<Integer> pos = List.of(r, c);
		if (memo.containsKey(pos)) {
			return memo.get(pos);
		}

		int res = Math.min(minPathSum(r + 1, c, grid, memo), minPathSum(r, c + 1, grid, memo)) + grid[r][c];
		memo.put(pos, res);
		return res;

	}
	
	public static void main(String[] args) {
		int [][] grid = {{1,3,1},{1,5,1},{4,2,1}};
		System.out.println("Min Path Sum of Given Grid is : " +minPathSum(grid) );
	}
}
