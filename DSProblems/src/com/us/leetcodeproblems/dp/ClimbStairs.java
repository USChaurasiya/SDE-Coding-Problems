package com.us.leetcodeproblems.dp;

import java.util.HashMap;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. 
In how many distinct ways can you climb to the top?

Example 1:
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 */
public class ClimbStairs {
	
	public static int climbStairs(int n) {
        return climbStairs (n, new HashMap<>());
    }

	// Solution 1 : Using Memoization  
    public static int climbStairs(int n, HashMap<Integer,Integer> memo){
        if(n == 0 || n == 1){
            return 1;
        }
        if(!memo.containsKey(n)){
            memo.put(n,climbStairs(n-1, memo)+ climbStairs(n-2,memo));
        }
        return memo.get(n);
    }
    
    // Solution 2 : Space Optimized Solution
    public int climbStairsSpaceOptimized(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int prev = 1, curr = 1;
        for (int i = 2; i <= n; i++) {
            int temp = curr;
            curr = prev + curr;
            prev = temp;
        }
        return curr;
    }
    
    public static void main(String[] args) {
		int steps = 5;
		System.out.println("Distinct ways to reach on Top : "+climbStairs(steps));
	}

}
