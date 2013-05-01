package at.fhhgb.mc.Aufgabe01test;

import static org.junit.Assert.*;

import org.junit.*;

import at.fhhgb.mc.Aufgabe01.InvalidAccessException;
import at.fhhgb.mc.Aufgabe01.RandomAccessDoubleLinkedList;

public class RandomAccessDoubleLinkedListTest {
	
	RandomAccessDoubleLinkedList radll; 
	
	@Before
	public void init() throws InvalidAccessException{
		radll = new RandomAccessDoubleLinkedList();
		radll.insertAt(0, 1);
		radll.insertAt(1, 2);
		radll.insertAt(2, 3);
		
	}
	
	//list with another list
	@Test
	public void testRandomAccessDoubleLinkedList(){
		RandomAccessDoubleLinkedList radll2 = new RandomAccessDoubleLinkedList(radll); 
		try{
			radll2.insertAt(0, 3);
			radll2.insertAt(1, 4);
		}catch (InvalidAccessException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		assertEquals(5,radll2.elements());

	}
	
	//other list with null as transfer parameter
	@Test
	public void testRandomAccessDoubleLinkedListNull() throws InvalidAccessException {
		RandomAccessDoubleLinkedList radll2 = new RandomAccessDoubleLinkedList(null); 
		radll2.insertAt(0, 1);
		assertEquals(1,radll2.elements());

	}
	
	//list initialized with itself
	@Test
	public void testRandomAccessDoubleLinkedListSelf() {
		radll = new RandomAccessDoubleLinkedList(radll);
		assertEquals(3,radll.elements());
		//System.out.println(radll.toString());

	}
	
	//test insert
	@Test
	public void testInsertAt() throws InvalidAccessException {
		RandomAccessDoubleLinkedList radll = new RandomAccessDoubleLinkedList();
		radll.insertAt(0, 5);
		assertEquals(5,radll.peekFront());
	}
	
	//test insert negative index
	@Test (expected=InvalidAccessException.class)
	public void testInsertAtNegative() throws InvalidAccessException {
		RandomAccessDoubleLinkedList radll = new RandomAccessDoubleLinkedList();
		radll.insertAt(-4, 5);
		assertEquals(Integer.MIN_VALUE,radll.elements());
	}
	
	//test insert with dummy nodes
	@Test
	public void testInsertAtDummyNodes() throws InvalidAccessException {
		RandomAccessDoubleLinkedList radll = new RandomAccessDoubleLinkedList();
		radll.insertAt(2, 5);
		assertEquals(true,radll.contains(5));
	}
	
	//test replacement of a dummy node
	@Test
	public void testInsertAtReplaceDummyNodes() throws InvalidAccessException {
		RandomAccessDoubleLinkedList radll = new RandomAccessDoubleLinkedList();
		radll.insertAt(2, 5);
		radll.insertAt(1, 3);
		assertEquals(3,radll.elements());
	}
	
	//test node count with dummys
	@Test
	public void testInsertAtDummyNodesElements() throws InvalidAccessException {
		RandomAccessDoubleLinkedList radll = new RandomAccessDoubleLinkedList();
		radll.insertAt(2, 5);
		assertEquals(3,radll.elements());
	}
	
	//test contains true
	@Test
	public void testContainsTrue() throws InvalidAccessException {
		RandomAccessDoubleLinkedList radll = new RandomAccessDoubleLinkedList();
		radll.insertAt(4, 5);
		assertEquals(true,radll.contains(5));
	}
	
	//test contains false
	@Test
	public void testContainsFalse() throws InvalidAccessException {
		RandomAccessDoubleLinkedList radll = new RandomAccessDoubleLinkedList();
		radll.insertAt(4, 5);
		assertEquals(false,radll.contains(8));
	}
	
	//test remove at
	@Test
	public void testRemoveAt() throws InvalidAccessException {
		
		assertEquals(true,radll.removeAt(1));
	}
	
	//test remove at
	@Test (expected=InvalidAccessException.class)
	public void testRemoveAtIndexToHigh() throws InvalidAccessException {
			
		assertEquals(false,radll.removeAt(9));
	}
	
	//test remove with contain after
	@Test
	public void testRemoveAtContainTest() throws InvalidAccessException {
		radll.removeAt(1);
		assertEquals(false,radll.contains(2));
	}
	
	//test remove with negtive index
	@Test (expected=InvalidAccessException.class)
	public void testRemoveAtNegative() throws InvalidAccessException {
		assertEquals(false,radll.removeAt(-1));

	}
	
	//test remove all true
	@Test
	public void testRemoveAllTrue() throws InvalidAccessException {
		radll.insertAt(3, 2);
		assertEquals(true,radll.removeAll(2));
	}
	
	//test remove all false
	public void testRemoveAllFalse() throws InvalidAccessException {
		radll.insertAt(3, 2);
		assertEquals(false,radll.removeAll(8));
	}
	
	//test remove with contains after
	@Test
	public void testRemoveAllContains() throws InvalidAccessException {
		radll.insertAt(3, 2);
		radll.removeAll(2);
		assertEquals(false,radll.contains(2));
	}
	
	//test remove with first element
	@Test
	public void testRemoveAllFirst() throws InvalidAccessException {
		radll.insertAt(3, 2);
		radll.insertAt(0, 2);
		radll.removeAll(2);
		assertEquals(false,radll.contains(2));
	}
	
	//test remove all dummys
	@Test
	public void testRemoveAllDummys() throws InvalidAccessException {
		RandomAccessDoubleLinkedList radll = new RandomAccessDoubleLinkedList();
		radll.insertAt(5, 2);
		radll.removeAll(Integer.MIN_VALUE);
		assertEquals(1,radll.elements());
		
	}
	
	//test element at
	@Test
	public void testElementAt() throws InvalidAccessException {
		assertEquals(2,radll.elementAt(1));
	}
	
	//test element at to high index
	@Test (expected=InvalidAccessException.class)
	public void testElementAtIndextoHigh() throws InvalidAccessException {
		assertEquals(Integer.MIN_VALUE,radll.elementAt(9));
	}
	
	//test element at negative index
	@Test (expected=InvalidAccessException.class)
	public void testElementAtNegative() throws InvalidAccessException {
		assertEquals(Integer.MIN_VALUE,radll.elementAt(-1));
	}
	
	//test element at with dummy
	@Test
	public void testElementAtDummy() throws InvalidAccessException {
		radll.insertAt(5, 2);
		//System.out.println(radll.toString());
		assertEquals(Integer.MIN_VALUE,radll.elementAt(3));
	}
	
	
	//String representation of the list
	@Test
	public void testtoString() throws InvalidAccessException {
		try{
			radll.insertAt(5, 2);
		}catch (InvalidAccessException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		System.out.println(radll.toString());
		
	}

}
