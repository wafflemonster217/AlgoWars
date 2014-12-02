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
		assertEquals(6, testSubject.graph.size());
	}
	
	@Test
	public void testRandomNodeDegrees() {
		assertEquals(1, testSubject.getNodeById(1).adjacencies.size());
		assertEquals(2, testSubject.getNodeById(2).adjacencies.size());
		assertEquals(0, testSubject.getNodeById(4).adjacencies.size());
	}
	
	@Test
	public void testNotCyclic() {
		assertTrue(!testSubject.isCyclic());
	}

}
