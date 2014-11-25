package pckg1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class AlgoWars {
	public String filename;

	// the main graph
	public HashSet<Node> graph;

	public int n_numberOfVertices;
	public int m_numberOfEdges;

	// just a helper to determine what has been added to the graph
	private HashSet<Integer> hasAdded;

	public AlgoWars(String filename) {
		this.filename = filename;
		graph = new HashSet<Node>();
		hasAdded = new HashSet<Integer>();
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
			} else {
				getNodeById(fromNode).addAdjacency(toNode);
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
			return true;
		}
		System.out.println("There is no edge from " + from + " to " + to);
		return false;
	}
}
	
