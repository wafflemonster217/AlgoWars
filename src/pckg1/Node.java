package pckg1;

import java.util.HashSet;
import java.util.Set;

public class Node {
	// the ID of the current node
	public int id;
	// the ID of the adjacent nodes
	public Set<Integer> adjacencies;
	
	public boolean visited = false;
	public boolean recStack = false;
	public Set<Integer> parents;

	public Node(int id) {
		adjacencies = new HashSet<Integer>();
		parents = new HashSet<Integer>();
		this.id = id;
	}

	public void addAdjacency(int adjacency) {
		adjacencies.add(adjacency);
	}
}