package com.us.dsa.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Dijkstra Algorithm for finding shortest Distance from Source to all Vertices.
 */
public class DijkstraAlgorithm {

	public static class Edge {
		int src;
		int dest;
		int wt;

		public Edge(int s, int d, int w) {
			this.src = s;
			this.dest = d;
			this.wt = w;
		}
	}

	public static class Pair implements Comparable<Pair> {
		int node;
		int dist;

		public Pair(int n, int d) {
			this.node = n;
			this.dist = d;
		}

		@Override
		public int compareTo(Pair p) {
			return this.dist - p.dist;
		}
	}

	public static void createGraph(ArrayList<Edge> graph[]) {
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<Edge>();
		}

		graph[0].add(new Edge(0, 1, 2));
		graph[0].add(new Edge(0, 2, 4));

		graph[1].add(new Edge(1, 3, 7));
		graph[1].add(new Edge(1, 2, 1));

		graph[2].add(new Edge(2, 4, 3));

		graph[3].add(new Edge(3, 5, 1));

		graph[4].add(new Edge(4, 3, 2));
		graph[4].add(new Edge(4, 5, 5));

	}

	// Time Complexity : O(E + ElogV)
	public static void dijkstra(ArrayList<Edge> graph[], int source, int vertex) {
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		int dist[] = new int[vertex];
		boolean vis[] = new boolean[vertex];
		pq.add(new Pair(0, 0));
		
		for (int i = 0; i < vertex; i++) {
			if (i != source) {
				dist[i] = Integer.MAX_VALUE;
			}
		}
		while (!pq.isEmpty()) {
			Pair current = pq.remove();
			if (!vis[current.node]) {
				vis[current.node] = true;
			}

			for (int i = 0; i < graph[current.node].size(); i++) {
				Edge e = graph[current.node].get(i);
				int u = e.src;
				int v = e.dest;

				if (dist[u] + e.wt < dist[v]) {
					dist[v] = dist[u] + e.wt;
					pq.add(new Pair(v, dist[v]));
				}
			}
		}
		for (int i = 0; i < vertex; i++) {
			System.out.print(dist[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int vertex = 6;
		ArrayList<Edge> graph[] = new ArrayList[vertex];

		createGraph(graph);
		dijkstra(graph, 0, vertex);
	}

}
