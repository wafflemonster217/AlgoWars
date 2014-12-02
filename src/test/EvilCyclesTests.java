package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pckg1.AlgoWars;

public class EvilCyclesTests {
	AlgoWars testSubject;
	@Before
	public void before() {
		testSubject = new AlgoWars("evilCycles.txt");
	}
	
	@Test
	public void testLoadedFirstTwoLines() {
		assertEquals(4, testSubject.n_numberOfVertices);
		assertEquals(7, testSubject.m_numberOfEdges);
	}

	@Test
	public void testGraphCorrectSize() {
		assertEquals(4, testSubject.graph.size());
	}
	
	@Test
	public void testNotCyclic() {
		assertTrue(testSubject.isCyclic());
	}

}
