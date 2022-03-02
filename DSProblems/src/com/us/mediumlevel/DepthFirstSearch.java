package com.us.mediumlevel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Uma Shankar
 * 
 * <pre>
 * ======================================================================
 *	You are given a Node class that has a name and an array of children nodes.
 *	Implement a depth first search method on the node class  which takes and empty array, traverse the 
 *	tree using depth first search approach, stores all of the node's name in the input array and returns it.
 *         
 *         
 * Sample Input:
 * 						  A
 * 						/ |	\
 * 					   B  c	 D
 *					  / \	  \
 *					 E	 F     G
 *					          /
 *				      		 H
 * 						
 *
 *Sample Output:	
 * 					
 *		[ A B E F C D G H ]
 * ======================================================================
 *
 */

public class DepthFirstSearch {
	
	public static void main(String[] args) {
		DepthFirstSearch.Node graph  =  new DepthFirstSearch.Node("A");
		graph.addChild("B").addChild("C").addChild("D");
		graph.children.get(0).addChild("E").addChild("F");
		graph.children.get(2).addChild("G");
		graph.children.get(2).children.get(0).addChild("H");
		
		var resultedArray = new ArrayList<String>();
		graph.depthFirstSearch(resultedArray);
		
		System.out.println("Output array : "+resultedArray);
	}

	static class Node {
		String name;
		List<Node> children = new ArrayList<Node>();

		public Node(String name) {
			this.name = name;
		}

		public List<String> depthFirstSearch(List<String> array) {
			array.add(this.name);
			for (int i = 0; i < children.size(); i++) {
				children.get(i).depthFirstSearch(array);
			}
			return array;
		}

		public Node addChild(String name) {
			Node child = new Node(name);
			children.add(child);
			return this;
		}
	}
}
