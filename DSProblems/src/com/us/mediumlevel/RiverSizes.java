package com.us.mediumlevel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author Uma Shankar
 * 
 *         <pre>
 *         --------------------------------------------------------------------------------------
 *         You're given a two-dimensional array(a matrix) of potentially unequal
 *         height and width containing only 0's and 1's. Each 0 represents land
 *         and each 1 represents part of a river. A river consists of any number
 *         of 1's that are either horizontally or vertically adjacent. The
 *         Number of Adjacent 1's forming a river determine its size.
 * 
 *         Note that a river can twist, In other words, it doesn't have to be a
 *         straight vertical line or a straight horizontal line.
 * 
 *         Write a function that returns an array of the sizes of all rivers
 *         represented in the input matrix. The size doesn't need to be in any
 *         particular order.
 * 
 * 
 *         Sample Input: matrix = [ [1, 0, 0, 1, 0], [1, 0, 1, 0, 0], [0, 0, 1,
 *         0, 1], [1, 0, 1, 0, 1], [1, 0, 1, 1, 0] ]
 * 
 *         Sample Output: [1, 2, 2, 2, 5]
 * 
 *         ----------------------------------------------------------------------------------------
 *
 */
public class RiverSizes {

	public static void main(String[] args) {
		int[][] input = { 
							{ 1, 0, 0, 1, 0 }, 
							{ 1, 0, 1, 0, 0 }, 
							{ 0, 0, 1, 0, 1 }, 
							{ 1, 0, 1, 0, 1 },
							{ 1, 0, 1, 1, 0 }, 
						};

		List<Integer> output = riverSizes(input);
		Collections.sort(output);
		System.out.println("River Sizes are : ");
		output.forEach(x -> System.out.print(x + " "));
	}

	public static List<Integer> riverSizes(int[][] matrix) {
		List<Integer> sizes = new ArrayList<Integer>();
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (visited[i][j]) {
					continue;
				}
				traverseNode(i, j, matrix, visited, sizes);
			}
		}
		return sizes;
	}

	private static void traverseNode(int i, int j, int[][] matrix, boolean[][] visited, List<Integer> sizes) {
		int currentRiverSize = 0;
		Stack<Integer[]> nodeToExplore = new Stack<Integer[]>();
		nodeToExplore.push(new Integer[] { i, j });

		while (!nodeToExplore.empty()) {
			Integer[] currentNode = nodeToExplore.pop();
			i = currentNode[0];
			j = currentNode[1];
			if (visited[i][j]) {
				continue;
			}
			visited[i][j] = true;
			if (matrix[i][j] == 0) {
				continue;
			}
			currentRiverSize++;
			List<Integer[]> unvisitedNeighbors = getUnvisitedNeighbors(i, j, matrix, visited);
			for (Integer[] neighbor : unvisitedNeighbors) {
				nodeToExplore.add(neighbor);
			}
		}
		if (currentRiverSize > 0) {
			sizes.add(currentRiverSize);
		}
	}

	private static List<Integer[]> getUnvisitedNeighbors(int i, int j, int[][] matrix, boolean[][] visited) {
		List<Integer[]> unvisitedNeighbors = new ArrayList<Integer[]>();
		if (i > 0 && !visited[i - 1][j]) {
			unvisitedNeighbors.add(new Integer[] { i - 1, j });
		}
		if (i < matrix.length - 1 && !visited[i + 1][j]) {
			unvisitedNeighbors.add(new Integer[] { i + 1, j });
		}
		if (j > 0 && !visited[i][j - 1]) {
			unvisitedNeighbors.add(new Integer[] { i, j - 1 });
		}
		if (j < matrix[0].length - 1 && !visited[i][j + 1]) {
			unvisitedNeighbors.add(new Integer[] { i, j + 1 });
		}
		return unvisitedNeighbors;
	}
}
