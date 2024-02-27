package com.us.dsa.graph;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge u-v, 
 * vertex u comes before v in the ordering.
 */
public class TopologicalSorting {

	public static class Edge {
		int src;
		int dest;

		public Edge(int s, int d) {
			this.src = s;
			this.dest = d;
		}
	}

	public static void creatGraph(ArrayList<Edge> graph[], int v) {
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<TopologicalSorting.Edge>();
		}

		graph[2].add(new Edge(2, 3));
		graph[3].add(new Edge(3, 1));
		graph[4].add(new Edge(4, 0));
		graph[4].add(new Edge(4, 1));
		graph[5].add(new Edge(5, 2));
		graph[5].add(new Edge(5, 0));
	}

	/*
	 * Approach : DFS traversal and at the end adding the current into Stack
	 * 
	 * Use a temporary stack. 
	 * Don’t print the vertex immediately, 
	 * First recursively call topological sorting for all its adjacent vertices, then push
	 * it to a stack. 
	 * Finally, print the contents of the stack.
	 */
	public static void topSortUtil(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> stack) {
		vis[curr] = true;
		for (int i = 0; i < graph[curr].size(); i++) {
			Edge e = graph[curr].get(i);
			if (!vis[e.dest]) {
				topSortUtil(graph, e.dest, vis, stack);
			}
		}
		stack.push(curr);
	}

	public static void topSorting(ArrayList<Edge> graph[], int v) {
		boolean vis[] = new boolean[v];
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < graph.length; i++) {
			if (!vis[i]) {
				topSortUtil(graph, i, vis, stack);
			}
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	public static void main(String[] args) {
		int v = 6;
		ArrayList<Edge> graph[] = new ArrayList[v];
		creatGraph(graph, v);
		topSorting(graph, v);

	}

}
