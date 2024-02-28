package com.us.dsa.graph;

import java.util.ArrayList;

/**
 * Bellman-Ford is a single source shortest path algorithm that determines the
 * shortest path between a given source vertex and every other vertex in a
 * graph. This algorithm can be used on both weighted and unweighted graphs.
 * 
 * Although Bellman-Ford is slower than Dijkstra’s algorithm, it is capable of
 * handling graphs with negative edge weights, which makes it more versatile.
 */
public class BellmanFordAlgorithm {

	public static class Edge {
		int src;
		int dest;
		int wt;

		public Edge(int src, int dest, int wt) {
			super();
			this.src = src;
			this.dest = dest;
			this.wt = wt;
		}
	}

	public static void createGraph(ArrayList<Edge> graph[], int v) {
		for (int i = 0; i < v; i++) {
			graph[i] = new ArrayList<BellmanFordAlgorithm.Edge>();
		}

		graph[0].add(new Edge(0, 1, 2));
		graph[0].add(new Edge(0, 2, 4));

		graph[1].add(new Edge(1, 2, -4));

		graph[2].add(new Edge(2, 3, 2));
		graph[3].add(new Edge(3, 4, 4));

		graph[4].add(new Edge(4, 1, -1));
	}

	public static void bellmanFord(ArrayList<Edge> graph[], int src, int vertex) {
		int dist[] = new int[vertex];
		for (int i = 0; i < vertex; i++) {
			if (i != src)
				dist[i] = Integer.MAX_VALUE;
		}

		for (int k = 0; k < vertex - 1; k++) {
			for (int i = 0; i < vertex; i++) {
				for (int j = 0; j < graph[i].size(); j++) {
					Edge e = graph[i].get(j);
					int u = e.src;
					int v = e.dest;
					if (dist[u] != Integer.MAX_VALUE && dist[u] + e.wt < dist[v]) {
						dist[v] = dist[u] + e.wt;
					}
				}
			}
		}

		for (int i = 0; i < dist.length; i++) {
			System.out.print(dist[i] + " ");
		}
	}

	public static void main(String[] args) {

		int vertex = 5;
		ArrayList<Edge> graph[] = new ArrayList[vertex];
		createGraph(graph, vertex);
		
		bellmanFord(graph, 0, vertex);
	}

}
