package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pckg1.AlgoWars;

public class Graph2Tests {
	AlgoWars testSubject;
	@Before
	public void before() {
		testSubject = new AlgoWars("graph2.txt");
	}

	@Test
	public void testLoadedFirstTwoLines() {
		assertEquals(6, testSubject.n_numberOfVertices);
		assertEquals(10, testSubject.m_numberOfEdges);
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
		assertTrue(testSubject.removeEdge(3, 1));
		assertEquals(1, testSubject.getNodeById(3).adjacencies.size());
		// should output "There is no edge from 3 to 4
		assertTrue(!testSubject.removeEdge(3, 1));
		assertTrue(testSubject.removeEdge(3, 4));
		assertEquals(0, testSubject.getNodeById(3).adjacencies.size());
	}

}
