package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import pckg1.AlgoWars;
import pckg1.Node;

public class ExampleGraphTests {
	AlgoWars testSubject;
	@Before
	public void before() {
		testSubject = new AlgoWars("graph.txt");
	}

	@Test
	public void testLoadedFirstTwoLines() {
		assertEquals(6, testSubject.n_numberOfVertices);
		assertEquals(7, testSubject.m_numberOfEdges);
	}

	@Test
	public void testGraphCorrectSize() {
		assertEquals(6, testSubject.graph.size());
	}
	
	@Test
	public void testRandomNodeDegrees() {
		assertEquals(2, testSubject.getNodeById(3).adjacencies.size());
	}
	
	@Test
	public void testRemovingEdges() {
		assertTrue(testSubject.removeEdge(3, 4));
		assertEquals(1, testSubject.getNodeById(3).adjacencies.size());
		// should output "There is no edge from 3 to 4
		assertTrue(!testSubject.removeEdge(3, 4));
		assertTrue(testSubject.removeEdge(3, 5));
		assertEquals(0, testSubject.getNodeById(3).adjacencies.size());
	}
	
	@Test
	public void testDetectCyclic() {
		assertTrue(testSubject.hasCycles());
	}
	
	@Test
	public void testRemoveCycles() {
		assertTrue(testSubject.hasCycles());
		testSubject.removeCycles();
	}
	
	
	@Test
	public void figureStuffOut() {
		for (Node n : testSubject.graph)
			if (n.temp)
				System.out.println(n.id);
	}

}
