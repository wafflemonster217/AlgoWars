package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pckg1.AlgoWars;

public class SuperSimpleGraphTests {
	AlgoWars testSubject;
	@Before
	public void before() {
		testSubject = new AlgoWars("superSimpleGraph.txt");
	}
	
	@Test
	public void testLoadedFirstTwoLines() {
		assertEquals(2, testSubject.n_numberOfVertices);
		assertEquals(1, testSubject.m_numberOfEdges);
	}

	@Test
	public void testGraphCorrectSize() {
		assertEquals(2, testSubject.graph.size());
	}
	
	@Test
	public void testNotCyclic() {
		
	}
	
	// incomplete
	@Test
	public void testParents() {
		assertTrue(!testSubject.hasCycles());
//		assertEquals(1, testSubject.getNodeById(1).parents.size());
//		assertEquals(0, testSubject.getNodeById(0).parents.size());
	}

}
