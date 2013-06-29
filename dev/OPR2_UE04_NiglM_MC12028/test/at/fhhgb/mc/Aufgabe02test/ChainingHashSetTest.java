package at.fhhgb.mc.Aufgabe02test;

import static org.junit.Assert.*;

import org.junit.*;
import at.fhhgb.mc.Aufgabe02.ChainingHashSet;

public class ChainingHashSetTest {
	
	ChainingHashSet chainH;
	
	@Before
	public void init(){
		
		chainH = new ChainingHashSet(5);
		
	}
	
	//test number of lists
	@Test
	public void testChainingHashSet() {
		ChainingHashSet chainH = new ChainingHashSet(7);
		assertEquals(7,chainH.getNumberOfLists());

	}
	
	//test number of lists default
	@Test
	public void testChainingHashSetDefaultSize() {
		ChainingHashSet chainH = new ChainingHashSet(-7);
		assertEquals(10,chainH.getNumberOfLists());

	}
	
	//test insert true
	@Test
	public void testInsertTrue() {
		assertEquals(true,chainH.insert(23));

	}
	
	//test insert false
	@Test
	public void testInsertFalse() {
		chainH.insert(23);
		assertEquals(false,chainH.insert(23));

	}
	
	//test contains true
	@Test
	public void testContainsTrue() {
		chainH.insert(23);
		chainH.insert(34);
		chainH.insert(239);
		chainH.insert(12);
		chainH.insert(502);
		chainH.insert(5);
		assertEquals(true,chainH.contains(502));

	}
	
	//test contains false
	@Test
	public void testContainsFalse() {
		chainH.insert(23);
		chainH.insert(34);
		chainH.insert(239);
		chainH.insert(12);
		chainH.insert(502);
		chainH.insert(5);
		assertEquals(false,chainH.contains(488));

	}
	
	//test contains true with negative value
	@Test
	public void testContainsTrueNegative() {
		chainH.insert(23);
		chainH.insert(34);
		chainH.insert(-239);
		chainH.insert(12);
		chainH.insert(502);
		chainH.insert(5);
		assertEquals(true,chainH.contains(-239));

	}
	
	//test contains false with negative value
	@Test
	public void testContainsFalseNegative() {
		chainH.insert(23);
		chainH.insert(34);
		chainH.insert(-239);
		chainH.insert(12);
		chainH.insert(502);
		chainH.insert(5);
		assertEquals(false,chainH.contains(-139));

	}
	
	//test remove true
	@Test
	public void testRemoveTrue() {
		chainH.insert(23);
		chainH.insert(34);
		chainH.insert(239);
		chainH.insert(12);
		chainH.insert(502);
		chainH.insert(5);
		assertEquals(true,chainH.remove(239));
	}
	
	//test remove false
	@Test
	public void testRemoveFalse() {
		chainH.insert(23);
		chainH.insert(34);
		chainH.insert(239);
		chainH.insert(12);
		chainH.insert(502);
		chainH.insert(5);
		assertEquals(false,chainH.remove(324));
	}
	
	//test overflowcount
	@Test
	public void testGetOverflowCount() {
		chainH.insert(23);
		chainH.insert(34);
		chainH.insert(239);
		chainH.insert(12);
		chainH.insert(502);
		chainH.insert(5);
		assertEquals(2,chainH.getOverflowCount(2));
	}
	
	//test overflow if empty
	@Test
	public void testGetOverflowCountEmpty() {
		assertEquals(Integer.MIN_VALUE,chainH.getOverflowCount(2));
	}
	
	//test overflow with to big hash
	@Test
	public void testGetOverflowCounttoBigHash() {
		chainH.insert(23);
		chainH.insert(34);
		chainH.insert(239);
		chainH.insert(12);
		chainH.insert(502);
		chainH.insert(5);
		assertEquals(Integer.MIN_VALUE,chainH.getOverflowCount(8));
	}
	
	//tes overflow with negative hash
	@Test
	public void testGetOverflowCountNegativeHash() {
		chainH.insert(23);
		chainH.insert(34);
		chainH.insert(239);
		chainH.insert(12);
		chainH.insert(502);
		chainH.insert(5);
		assertEquals(Integer.MIN_VALUE,chainH.getOverflowCount(-8));
	}
	
	//test elements
	@Test
	public void testElements() {
		chainH.insert(23);
		chainH.insert(34);
		chainH.insert(239);
		chainH.insert(12);
		chainH.insert(502);
		chainH.insert(5);
		assertEquals(6,chainH.elements());
	}
	
	//test elements zero
	@Test
	public void testElementsZero() {
		assertEquals(0,chainH.elements());
	}

}
