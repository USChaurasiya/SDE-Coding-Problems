package com.us.leetcodeproblems.arrays;

import java.util.PriorityQueue;

/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * Can you solve it without sorting?
 * 
 * Example:
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 */
public class KthLargestElement {

	// Time Complexity : O(N * log(K))  Auxiliary Space: O(K)
	public static int kLargestElement(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < nums.length; ++i) {
			pq.add(nums[i]);

			if (pq.size() > k)
				pq.poll();
		}
		return pq.peek();
	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 1, 5, 6, 4 };
		int k = 2;

		System.out.println(k + "th Largest Number in the Given Array is : " + kLargestElement(nums, k));
	}

}
