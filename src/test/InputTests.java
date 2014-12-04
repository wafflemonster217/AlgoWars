package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pckg1.AlgoWars;
import pckg1.Node;

public class InputTests {
	AlgoWars testSubject;
	@Before
	public void before() {
		testSubject = new AlgoWars("input.txt");
	}

	@Test
	public void testLoadedFirstTwoLines() {
		assertEquals(8, testSubject.n_numberOfVertices);
		assertEquals(13, testSubject.m_numberOfEdges);
	}

	@Test
	public void testGraphCorrectSize() {
		assertEquals(8, testSubject.graph.size());
	}
	
	@Test
	public void testRandomNodeDegrees() {
		assertEquals(3, testSubject.getNodeById(2).adjacencies.size());
		assertEquals(3, testSubject.getNodeById(3).adjacencies.size());
	}
	
	@Test
	public void testRemovingEdges() {
		assertTrue(testSubject.removeEdge(2, 1));
		assertEquals(2, testSubject.getNodeById(2).adjacencies.size());
	}
	
	@Test
	public void testDetectCyclic() {
		assertTrue(testSubject.hasCycles());
	}
	
	@Test
	public void testRemoveCycles() {
		assertTrue(testSubject.hasCycles());
		System.out.println(testSubject.possibleRemovals);
		testSubject.removeCycles();
		System.out.println(testSubject.numEdgesRemoved);
	}
}
