package com.us.dsa.graph;

import java.util.ArrayList;

/**
 * Find all paths from given Source vertex to destination vertex in graph;
 */
public class GraphFindAllPath {
	
	public static class Edge{
		int src;
		int dest;
		
		public Edge(int source, int destination) {
			this.src = source;
			this.dest = destination;
		}
	}
	
	/**
	 * @param graph
	 * For Creating a graph using Adjacency List
	 */
	public static void createGraph(ArrayList<Edge> graph[]) {
		// Initialize every index of the Graph array with new ArrayList
		for(int i=0; i<graph.length; i++) {
			graph[i] = new ArrayList<Edge>();
		}
		
		graph[0].add(new Edge(0, 1));
		graph[0].add(new Edge(0, 2));
		
		graph[1].add(new Edge(1, 0));
		graph[1].add(new Edge(1, 3));
		
		graph[2].add(new Edge(2, 0));
		graph[2].add(new Edge(2, 4));
		
		graph[3].add(new Edge(3, 1));
		graph[3].add(new Edge(3, 4));
		graph[3].add(new Edge(3, 5));
		
		graph[4].add(new Edge(4, 2));
		graph[4].add(new Edge(4, 3));
		graph[4].add(new Edge(4, 5));
		
		graph[5].add(new Edge(5, 3));
		graph[5].add(new Edge(5, 4));
		graph[5].add(new Edge(5, 6));
		
		graph[6].add(new Edge(6, 5));
	}
	
	/**
	 * @param graph
	 * @param vis
	 * @param current
	 * @param path
	 * @param target
	 * Finding all possible paths from given node to target Node
	 */
	public static void findAllPath(ArrayList<Edge> graph[], boolean vis[], int current, String path, int target) {
		if (current == target) {
			System.out.println(path);
			return;
		}
		for (int i = 0; i < graph[current].size(); i++) {
			Edge e = graph[current].get(i);
			if (!vis[e.dest]) {
				vis[current] = true;
				findAllPath(graph, vis, e.dest, path +" -> "+ e.dest, target);
				vis[current] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		int vertex = 7;
		ArrayList<Edge> graph[] = new ArrayList[vertex];
		createGraph(graph);
		boolean[] vis = new boolean[vertex];
		int src = 0;
		int target = 5;
		System.out.println("All possible paths from "+src+ " to "+target+" are: ");
		findAllPath(graph, vis, src, "0", target);
		
	}

}
