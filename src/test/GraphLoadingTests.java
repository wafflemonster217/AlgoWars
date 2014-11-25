package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pckg1.AlgoWars;

public class GraphLoadingTests {
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

}
