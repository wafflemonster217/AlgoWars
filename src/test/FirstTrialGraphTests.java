package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pckg1.AlgoWars;

public class FirstTrialGraphTests {
	AlgoWars testSubject;
	@Before
	public void before() {
		testSubject = new AlgoWars("firstTrial.txt");
	}
	
	@Test
	public void testLoadedFirstTwoLines() {
		assertEquals(4, testSubject.n_numberOfVertices);
		assertEquals(5, testSubject.m_numberOfEdges);
	}

	@Test
	public void testGraphCorrectSize() {
		assertEquals(4, testSubject.graph.size());
	}
	
	@Test
	public void testCyclic() {
		assertTrue(testSubject.hasCycles());
	}

}
