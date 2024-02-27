package com.us.dsa.graph;

import java.util.ArrayList;

/**
 * Function to detect Cycle in Given Undirected graph.
 */
public class CycleInUnDirectedGraph {

	public static class Edge {
		int src;
		int dest;

		public Edge(int s, int d) {
			this.src = s;
			this.dest = d;
		}
	}

	public static void createGraph(ArrayList<Edge> graph[], int v) {
		for (int i = 0; i < v; i++) {
			graph[i] = new ArrayList<Edge>();
		}

		graph[0].add(new Edge(0, 1));
		graph[0].add(new Edge(0, 4));

		graph[1].add(new Edge(1, 0));
		graph[1].add(new Edge(1, 4));
		graph[1].add(new Edge(1, 2));

		graph[2].add(new Edge(2, 3));
		graph[2].add(new Edge(2, 1));

		graph[3].add(new Edge(3, 2));

		graph[4].add(new Edge(4, 0));
		graph[4].add(new Edge(4, 1));
		graph[4].add(new Edge(4, 5));

		graph[5].add(new Edge(5, 4));
	}

	// Time complexity : O(V + E)
	public static boolean cycleExist(ArrayList<Edge> graph[], boolean vis[], int curr, int parent) {
		vis[curr] = true;
		for (int i = 0; i < graph[curr].size(); i++) {
			Edge e = graph[curr].get(i);
			if (vis[e.dest] = true && parent != e.dest) {
				return true;
			}
			if (!vis[e.dest]) {
				if (cycleExist(graph, vis, e.dest, curr) == true) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int vertex = 6;
		ArrayList<Edge> graph[] = new ArrayList[vertex];
		boolean vis[] = new boolean[vertex];

		createGraph(graph, vertex);
		System.out.println(cycleExist(graph, vis, 0, -1));

	}

}
