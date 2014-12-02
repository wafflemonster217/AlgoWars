package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pckg1.AlgoWars;
import pckg1.Node;

public class NoCyclesTests {
	AlgoWars testSubject;
	@Before
	public void before() {
		testSubject = new AlgoWars("noCycles.txt");
	}
	
	@Test
	public void testLoadedFirstTwoLines() {
		assertEquals(6, testSubject.n_numberOfVertices);
		assertEquals(5, testSubject.m_numberOfEdges);
	}

	@Test
	public void testGraphCorrectSize() {
		for (Node n : testSubject.graph)
			System.out.println(n.id);
		assertEquals(6, testSubject.graph.size());
	}
	
	@Test
	public void testNotCyclic() {
		assertTrue(!testSubject.isCyclic());
	}

}
