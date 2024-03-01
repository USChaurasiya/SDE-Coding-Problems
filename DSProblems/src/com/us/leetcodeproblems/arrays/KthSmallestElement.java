package com.us.leetcodeproblems.arrays;

import java.util.PriorityQueue;

/**
 * Given an array arr[] of size N and a number K, where K is smaller than the size of the array. Find the K’th smallest element in the given array. Given that all array elements are distinct.
 * 
 * Example:
 * Input: arr[] = {7, 10, 4, 3, 20, 15}, K = 3 
 * Output: 7
 */
public class KthSmallestElement {

	public static int kSmallestElement(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((x,y)->y-x);
		for (int i = 0; i < nums.length; ++i) {
			pq.add(nums[i]);

			if (pq.size() > k) {
				pq.poll();
			}
		}
		return pq.peek();
	}

	public static void main(String[] args) {
		int[] nums = { 7, 10, 4, 3, 20, 15 };
		int k = 3;

		System.out.println(k + "th samllest element in Given array is : " + kSmallestElement(nums, k));
	}
}
