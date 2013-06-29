package at.fhhgb.mc.Aufgabe02test;

import static org.junit.Assert.*;

import org.junit.*;

import at.fhhgb.mc.Aufgabe02.RandomAccessDoubleLinkedList;

public class RandomAccessDoubleLinkedListTest {
	
	RandomAccessDoubleLinkedList radll; 
	
	@Before
	public void init(){
		radll = new RandomAccessDoubleLinkedList();
		radll.insertAt(0, 1);
		radll.insertAt(1, 2);
		radll.insertAt(2, 3);
		
	}
	
	//list with another list
	@Test
	public void testRandomAccessDoubleLinkedList() {
		RandomAccessDoubleLinkedList radll2 = new RandomAccessDoubleLinkedList(radll); 
		radll2.insertAt(0, 3);
		radll2.insertAt(1, 4);
		assertEquals(5,radll2.elements());

	}
	
	//other list with null as transfer parameter
	@Test
	public void testRandomAccessDoubleLinkedListNull() {
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
	public void testInsertAt() {
		RandomAccessDoubleLinkedList radll = new RandomAccessDoubleLinkedList();
		radll.insertAt(0, 5);
		assertEquals(5,radll.peekFront());
	}
	
	//test insert negative index
	@Test
	public void testInsertAtNegative() {
		RandomAccessDoubleLinkedList radll = new RandomAccessDoubleLinkedList();
		radll.insertAt(-4, 5);
		assertEquals(Integer.MIN_VALUE,radll.elements());
	}
	
	//test insert with dummy nodes
	@Test
	public void testInsertAtDummyNodes() {
		RandomAccessDoubleLinkedList radll = new RandomAccessDoubleLinkedList();
		radll.insertAt(2, 5);
		assertEquals(true,radll.contains(5));
	}
	
	//test replacement of a dummy node
	@Test
	public void testInsertAtReplaceDummyNodes() {
		RandomAccessDoubleLinkedList radll = new RandomAccessDoubleLinkedList();
		radll.insertAt(2, 5);
		radll.insertAt(1, 3);
		assertEquals(3,radll.elements());
	}
	
	//test node count with dummys
	@Test
	public void testInsertAtDummyNodesElements() {
		RandomAccessDoubleLinkedList radll = new RandomAccessDoubleLinkedList();
		radll.insertAt(2, 5);
		assertEquals(3,radll.elements());
	}
	
	//test contains true
	@Test
	public void testContainsTrue() {
		RandomAccessDoubleLinkedList radll = new RandomAccessDoubleLinkedList();
		radll.insertAt(4, 5);
		assertEquals(true,radll.contains(5));
	}
	
	//test contains false
	@Test
	public void testContainsFalse() {
		RandomAccessDoubleLinkedList radll = new RandomAccessDoubleLinkedList();
		radll.insertAt(4, 5);
		assertEquals(false,radll.contains(8));
	}
	
	//test contains empty
	@Test
	public void testContainsEmpty() {
		RandomAccessDoubleLinkedList radll = new RandomAccessDoubleLinkedList();
		assertEquals(false,radll.contains(8));
	}
	
	//test remove at
	@Test
	public void testRemoveAt() {
		
		assertEquals(true,radll.removeAt(1));
	}
	
	//test remove at
	@Test
	public void testRemoveAtIndexToHigh() {
			
		assertEquals(false,radll.removeAt(9));
	}
	
	//test remove with contain after
	@Test
	public void testRemoveAtContainTest() {
		radll.removeAt(1);
		assertEquals(false,radll.contains(2));
	}
	
	//test remove with negtive index
	@Test
	public void testRemoveAtNegative() {
		assertEquals(false,radll.removeAt(-1));

	}
	
	//test remove all true
	@Test
	public void testRemoveAllTrue() {
		radll.insertAt(3, 2);
		assertEquals(true,radll.removeAll(2));
	}
	
	//test remove all false
	public void testRemoveAllFalse() {
		radll.insertAt(3, 2);
		assertEquals(false,radll.removeAll(8));
	}
	
	//test remove with contains after
	@Test
	public void testRemoveAllContains() {
		radll.insertAt(3, 2);
		radll.removeAll(2);
		assertEquals(false,radll.contains(2));
	}
	
	//test remove with first element
	@Test
	public void testRemoveAllFirst() {
		radll.insertAt(3, 2);
		radll.insertAt(0, 2);
		radll.removeAll(2);
		assertEquals(false,radll.contains(2));
	}
	
	//test remove all empty
		@Test
		public void testRemoveAllEmpty() {
			radll.clear();
			assertEquals(false,radll.removeAll(2));
		}
	
	//test remove all dummys
	@Test
	public void testRemoveAllDummys() {
		RandomAccessDoubleLinkedList radll = new RandomAccessDoubleLinkedList();
		radll.insertAt(5, 2);
		radll.removeAll(Integer.MIN_VALUE);
		assertEquals(1,radll.elements());
		
	}
	
	//test element at
	@Test
	public void testElementAt() {
		assertEquals(2,radll.elementAt(1));
	}
	
	//test element at to high index
		@Test
	public void testElementAtIndextoHigh() {
		assertEquals(Integer.MIN_VALUE,radll.elementAt(9));
	}
	
	//test element at negative index
	@Test
	public void testElementAtNegative() {
		assertEquals(Integer.MIN_VALUE,radll.elementAt(-1));
	}
	
	//test element at with dummy
	@Test
	public void testElementAtDummy() {
		radll.insertAt(5, 2);
		//System.out.println(radll.toString());
		assertEquals(Integer.MIN_VALUE,radll.elementAt(3));
	}
	
	
	//String representation of the list
	@Test
	public void testtoString() {
		radll.insertAt(5, 2);
		System.out.println(radll.toString());
		
	}

}
