package com.us.dsa.graph;

import java.util.ArrayList;

/**
 * Function to Detect if there any cycle exist in the given Directed graph.
 */
public class CycleInDirectedGraph {

	public static class Edge {
		int src;
		int dest;

		public Edge(int s, int d) {
			this.src = s;
			this.dest = d;
		}
	}

	/**
	 * @param graph For Creating a Graph
	 */
	public static void createGraph(ArrayList<Edge> graph[]) {
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<Edge>();
		}

		graph[0].add(new Edge(0, 2));
		graph[1].add(new Edge(1, 0));
		graph[2].add(new Edge(2, 3));
		graph[3].add(new Edge(3, 0));
	}

	/**
	 * @param graph
	 * @param vis
	 * @param curr
	 * @param rec
	 * @return
	 * 
	 *         Function to check the existence of the cycle in graph.
	 */
	public static boolean isCycleExist(ArrayList<Edge> graph[], boolean[] vis, int curr, boolean[] rec) {
		vis[curr] = true;
		rec[curr] = true;

		for (int i = 0; i < graph[curr].size(); i++) {
			Edge e = graph[curr].get(i);

			if (rec[e.dest])
				return true;
			else if (!vis[e.dest]) {
				if (isCycleExist(graph, vis, e.dest, rec)) {
					return true;
				}
			}
		}
		rec[curr] = false;
		return false;
	}

	public static void main(String[] args) {
		int vertex = 4;
		ArrayList<Edge> graph[] = new ArrayList[vertex];
		boolean vis[] = new boolean[vertex];

		createGraph(graph);
		System.out.println(isCycleExist(graph, vis, 0, new boolean[vertex]));
	}

}
