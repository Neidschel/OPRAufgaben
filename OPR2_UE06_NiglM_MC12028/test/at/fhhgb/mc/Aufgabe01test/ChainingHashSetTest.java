package at.fhhgb.mc.Aufgabe01test;

import static org.junit.Assert.*;

import org.junit.*;
import at.fhhgb.mc.Aufgabe01.ChainingHashSet;
import at.fhhgb.mc.Aufgabe01.InvalidAccessException;
import at.fhhgb.mc.Aufgabe01.ValueException;

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
	
	//test insert ; no exception
	@Test
	public void testInsertTrue() throws ValueException {
		chainH.insert(23);

	}
	
	//test insert false
	@Test (expected=ValueException.class)
	public void testInsertFalse() throws ValueException {
		chainH.insert(23);
		chainH.insert(23);
		chainH.getOverflowCount(-7);
	}
	
	@Test
	public void testInsertExcp(){
		
		
		try{
			chainH.insert(23);
			chainH.insert(23);
		}catch(ValueException e){
			//test ok
			return;
		}
		
		fail("Expected ValueException!");
	}
	
	//test contains true
	@Test
	public void testContainsTrue() throws ValueException {
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
	public void testContainsFalse() throws ValueException {
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
	public void testContainsTrueNegative() throws ValueException {
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
	public void testContainsFalseNegative() throws ValueException {
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
	public void testRemoveTrue() throws ValueException {
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
	public void testRemoveFalse() throws ValueException {
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
	public void testGetOverflowCount() throws ValueException {
		chainH.insert(23);
		chainH.insert(34);
		chainH.insert(239);
		chainH.insert(12);
		chainH.insert(502);
		chainH.insert(5);
		assertEquals(2,chainH.getOverflowCount(2));
	}
	
	//test overflow if empty
	@Test (expected=ValueException.class)
	public void testGetOverflowCountEmpty() throws ValueException {
		assertEquals(Integer.MIN_VALUE,chainH.getOverflowCount(2));
	}
	
	//test overflow with to big hash
	@Test (expected=ValueException.class)
	public void testGetOverflowCounttoBigHash() throws ValueException {
		chainH.insert(23);
		chainH.insert(34);
		chainH.insert(239);
		chainH.insert(12);
		chainH.insert(502);
		chainH.insert(5);
		assertEquals(Integer.MIN_VALUE,chainH.getOverflowCount(8));
	}
	
	//test overflow with negative hash
	@Test (expected=ValueException.class)
	public void testGetOverflowCountNegativeHash() throws ValueException {
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
	public void testElements() throws ValueException {
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
