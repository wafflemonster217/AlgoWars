package pckg1;

import java.util.HashSet;

public class Node {
	// the ID of the current node
	public int id;
	// the ID of the adjacent nodes
	public HashSet<Integer> adjacencies;
	
	public boolean visited = false;

	public Node(int id) {
		adjacencies = new HashSet<Integer>();
		this.id = id;
	}

	public void addAdjacency(int adjacency) {
		adjacencies.add(adjacency);
	}

}
