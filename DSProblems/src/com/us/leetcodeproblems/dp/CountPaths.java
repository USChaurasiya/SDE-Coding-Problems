package com.us.leetcodeproblems.dp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). 
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

Example 1:
 Input: m = 3, n = 7
 Output: 28

Example 2:
 Input: m = 3, n = 2
 Output: 3
 Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
 */
public class CountPaths {

	// Time Complexity : O(r * c)  Space Complexity : O(r * c)
	public static int uniquePaths(int m, int n) {
		// For Memoize Duplicate Function call.
		Map<List<Integer>, Integer> memo = new HashMap<List<Integer>, Integer>();
		int[][] grid = new int[m][n];
		return uniquePaths(0, 0, grid, memo);
	}

	public static int uniquePaths(int r, int c, int[][] grid, Map<List<Integer>, Integer> memo) {
		// Checking OutOfBound Case
		if (r == grid.length || c == grid[0].length) {
			return 0;
		}
		// Checking Base Case when it will be bottom right corner
		if (r == grid.length - 1 || c == grid[0].length - 1) {
			return 1;
		}
		List<Integer> pos = List.of(r, c);
		if (memo.containsKey(pos)) {
			return memo.get(pos);
		}
		int res = uniquePaths(r + 1, c, grid, memo) + uniquePaths(r, c + 1, grid, memo);
		memo.put(pos, res);
		return res;
	}
	
	public static void main(String[] args) {
		int row = 3;
		int col = 7;
		System.out.println("Number of Unique Paths to Reach Bottom Right Corner are : "+ uniquePaths(row, col));
	}

}
