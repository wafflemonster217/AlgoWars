package pckg1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AlgoWars {
	public String filename;

	// the main graph
	public HashSet<Node> graph;

	public int n_numberOfVertices;
	public int m_numberOfEdges;

	// just a helper to determine what has been added to the graph
	private HashSet<Integer> hasAdded;
	
	public int numEdgesRemoved = 0;
	
	public HashMap<Integer, Integer> possibleRemovals;

	public AlgoWars(String filename) {
		this.filename = filename;
		graph = new HashSet<Node>();
		hasAdded = new HashSet<Integer>();
		possibleRemovals = new HashMap<Integer, Integer>();
		try {
			loadGraphFromFile();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	private void loadGraphFromFile() throws FileNotFoundException {
		Scanner reader = new Scanner(new File(filename));
		n_numberOfVertices = Integer.parseInt(reader.nextLine());
		m_numberOfEdges = Integer.parseInt(reader.nextLine());
		while (reader.hasNextLine()) {
			String[] line = reader.nextLine().split(" ");
			int fromNode = Integer.parseInt(line[0]);
			int toNode = Integer.parseInt(line[1]);
			if (!hasAdded.contains(fromNode)) {
				Node n = new Node(fromNode);
				n.addAdjacency(toNode);
				graph.add(n);
				hasAdded.add(fromNode);
				if (!hasAdded.contains(toNode)) {
					graph.add(new Node(toNode));
					hasAdded.add(toNode);
				}
				
			} else {
				getNodeById(fromNode).addAdjacency(toNode);
				if (!hasAdded.contains(toNode)) {
					graph.add(new Node(toNode));
					hasAdded.add(toNode);
				}
			}

		}
	}

	public Node getNodeById(int id) {
		for (Node n : graph)
			if (n.id == id)
				return n;
		return null;
	}
	
	public boolean removeEdge(int from, int to) {
		if (getNodeById(from).adjacencies.contains(to)) {
			getNodeById(from).adjacencies.remove(to);
			numEdgesRemoved++;
			return true;
		}
		System.out.println("There is no edge from " + from + " to " + to);
		return false;
	}
	
	private boolean modifiedDFS(int v) {
		if (getNodeById(v).visited == false) {
			getNodeById(v).visited = true;
			getNodeById(v).recStack = true;
			for (int i : getNodeById(v).adjacencies) {
				if (!getNodeById(i).visited && modifiedDFS(i)) {
					possibleRemovals.put(v, i);
					return true;
				} else if (getNodeById(i).recStack) {
					possibleRemovals.put(v, i);
					return true;
				}
			}
		}
		getNodeById(v).recStack = false;
		return false;
	}

	public boolean hasCycles() {
		for (Node n : graph)
			if (modifiedDFS(n.id))
				return true;
		return false;
	}
	
	public void removeCycles() {
		int[] keyset = new int[possibleRemovals.size()];
		int i = 0;
		for (Object k : possibleRemovals.keySet()) {
			keyset[i] = (int) k;
			i++;
		}
		int j = 1;
		while (hasCycles()) {
			System.out.println("removing edge from " + j + " to " + possibleRemovals.get((Object) j));
			removeEdge(j, possibleRemovals.get((Object) j));
			possibleRemovals.remove((Object) j);
			j++;
		}
	}		
}

