package com.us.dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This class Consist of different Traversal ways for a given Graph like BFS & DFS
 */
public class GraphTraversal {
	
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
	 * @param vertex
	 * Traversing a graph in Breadth First manner using Queue
	 */
	public static void bfsTraversal(ArrayList<Edge> graph[], int vertex) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean vis[] = new boolean[vertex];
		q.add(0);
		
		while(!q.isEmpty()) {
			int current = q.remove();
			if(vis[current] == false) {
				System.out.print(current+" ");
				vis[current] = true;
				
				for(int i=0; i<graph[current].size(); i++) {
					Edge e = graph[current].get(i);
					q.add(e.dest);
				}
			}
		}
	}
	
	/**
	 * @param graph
	 * @param current
	 * @param vis
	 * Traversing a Graph in Depth First Manner
	 */
	public static void dfsTraversal(ArrayList<Edge> graph[], int current, boolean vis[]) {
		System.out.print(current + " ");
		vis[current] = true;
		for(int i=0; i<graph[current].size(); i++) {
			Edge e = graph[current].get(i);
			if(vis[e.dest] == false) {
				dfsTraversal(graph, e.dest, vis);
			}
		}
	}
	
	public static void main(String[] args) {
		int noOfVertex = 7;
		ArrayList<Edge> graph[] = new ArrayList[noOfVertex];
		createGraph(graph);
		boolean[] vis = new boolean[noOfVertex];
		
		
		System.out.println("Neighbors  of 0 are : ");
		for (int i = 0; i < graph[0].size(); i++) {
			Edge e = graph[0].get(i);
			System.out.println(e.dest + " ");
		}
		 
		
		System.out.println("BFS Traversal of Given graph :");
		bfsTraversal(graph, noOfVertex);
		System.out.println();
		System.out.println("DFS Traversal of Given Graph :");
		dfsTraversal(graph, 0, vis);
		
	}

}
