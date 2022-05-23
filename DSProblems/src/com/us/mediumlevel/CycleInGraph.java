package com.us.mediumlevel;

import java.util.Arrays;

/**
 * @author Uma Shankar
 * <pre>
 * ------------------------------------------------------------------------------------------
 * You're given a list of edges representing an unweighted, directed graph with at least one 
 * node. Write a function that returns a boolean representing whether the given graph contians
 * a cycle.
 * 
 * A cycle is defined as any number of vertices, including the one vertex, that are connected 
 * in a closed chain.
 * The given list is what's called an adjacency list and it represent a graph.The number of 
 * vertices in a graph is equal to the length of edges where each index i in edges contains 
 * vertex i's outbound edges, in no particular order.
 * Note that these edges are directed meaning that you can only travel from a particular vertex
 * to its destination, not the other way around.
 * 
 * Also note that graph may contain self-loops. A self loops is an edge that has the same 
 * destination and origin.
 * 
 * 
 * Sample Input:
 * 	edges = [
 * 				[1,3],
 * 				[2,3,4],
 * 				[0],
 * 				[],
 * 				[2,5],
 * 				[],
 * 			]
 * 
 * Sample Output:
 * 	true
 * 	1: 0 -> 1 -> 2 ->0
 * 	2: 0 -> 1 -> 4 -> 2 ->0
 * 	3: 1 -> 2 -> 0 -> 1
 * 
 * ------------------------------------------------------------------------------------------
 * 	
 */
public class CycleInGraph {

	public static int WHITE = 0;
	public static int GREY = 1;
	public static int BLACK = 3;
	
	public static void main(String[] args) {
		int[][] input =
		        new int[][] {
		          {1, 3},
		          {2, 3, 4},
		          {0},
		          {},
		          {2, 5},
		          {}
		        };
		System.out.println("Is Cycle in the given Graph : "+cycleInGraph(input));
	}

	// Solution 1: O(v+e) Time and O(v) Space Complexity, v is vertex and e is the number of edges.
	public static boolean cycleInGraph(int[][] edges) {
		int numberOfNodes = edges.length;
		int[] colors = new int[numberOfNodes];
		Arrays.fill(colors, WHITE);

		for (int node = 0; node < numberOfNodes; node++) {
			if (colors[node] != WHITE)
				continue;

			boolean containsCycle = traverseAndColorNodes(node, edges, colors);
			if (containsCycle)
				return true;
		}
		return false;
	}

	public static boolean traverseAndColorNodes(int node, int[][] edges, int[] colors) {
		colors[node] = GREY;
		int[] neighbors = edges[node];
		for (int neighbor : neighbors) {
			int neighborColor = colors[neighbor];

			if (neighborColor == GREY) {
				return true;
			}
			if (neighborColor == BLACK) {
				continue;
			}
			boolean containsCycle = traverseAndColorNodes(neighbor, edges, colors);
			if (containsCycle) {
				return true;
			}
		}
		colors[node] = BLACK;
		return false;
	}
}
