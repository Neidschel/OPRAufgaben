package at.fhhgb.mc.Aufgabe01test;

import static org.junit.Assert.*;

import org.junit.Test;

import at.fhhgb.mc.Aufgabe01.DoubleLinkedList;

public class DoubleLinkedListTest {

	@Test
	public void testInitDoubleLinkedList() {

		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushFront(1);
		dll.pushFront(2);
		assertEquals(2,dll.elements());
		
	}
	
	@Test
	public void testInitDoubleLinkedListEmpty() {

		DoubleLinkedList dll = new DoubleLinkedList();
		assertEquals(Integer.MIN_VALUE,dll.elements());
		
	}

	@Test
	public void testClear() {
		
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushFront(5);
		dll.pushFront(6);
		dll.pushFront(7);
		dll.clear();
		assertEquals(Integer.MIN_VALUE,dll.elements());	
		
	}

	@Test
	public void testPushFront() {
		
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushFront(5);
		assertEquals(1,dll.elements());
		
	}

	@Test
	public void testPushBack() {
		
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(5);
		assertEquals(1,dll.elements());
		
	}

	@Test
	public void testPopFront() {
		
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushFront(5);
		dll.pushFront(6);
		assertEquals(6,dll.popFront());	
		
	}
	
	@Test
	public void testPopFrontEmpty() {
		
		DoubleLinkedList dll = new DoubleLinkedList();
		assertEquals(Integer.MIN_VALUE,dll.popFront());	
		
	}
	
	@Test
	public void testPopFrontCaunt() {
		
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushFront(5);
		dll.pushFront(6);
		dll.pushFront(7);
		assertEquals(7,dll.popFront());	
		assertEquals(2,dll.elements());	
		
	}

	@Test
	public void testPeekFront() {
		
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushFront(5);
		dll.pushFront(6);
		assertEquals(6,dll.popFront());	
	
	}
	
	@Test
	public void testPeekFrontEmpty() {
		
		DoubleLinkedList dll = new DoubleLinkedList();
		assertEquals(Integer.MIN_VALUE,dll.popFront());	
		
	}

	@Test
	public void testPopBack() {
		
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(6);
		dll.pushBack(5);
		assertEquals(5,dll.popBack());	
		
	}
	
	@Test
	public void testPopBackEmpty() {
		
		DoubleLinkedList dll = new DoubleLinkedList();
		assertEquals(Integer.MIN_VALUE,dll.popBack());	
		
	}
	
	@Test
	public void testPopBackCaunt() {
		
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(6);
		dll.pushBack(5);
		assertEquals(5,dll.popBack());
		assertEquals(1,dll.elements());

		
	}

	@Test
	public void testPeekBack() {
		
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(6);
		dll.pushBack(5);
		assertEquals(5,dll.popBack());	
		
	}
	
	@Test
	public void testPeekBackEmpty() {
		
		DoubleLinkedList dll = new DoubleLinkedList();
		assertEquals(Integer.MIN_VALUE,dll.popFront());	
		
	}

	@Test
	public void testElements() {
		
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(6);
		dll.pushBack(5);
		dll.pushFront(1);
		dll.pushFront(2);
		assertEquals(4,dll.elements());	
		
	}

	@Test
	public void testReverse() {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(1);
		dll.pushBack(2);
		dll.pushBack(3);
		dll.pushBack(4);
		dll.reverse();
		assertEquals(1,dll.popBack());
		assertEquals(2,dll.popBack());
		assertEquals(3,dll.popBack());
		assertEquals(4,dll.popBack());

	}
	
	@Test
	public void testMultipleReverse() {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(1);
		dll.pushBack(2);
		dll.pushBack(3);
		dll.pushBack(4);
		dll.reverse();
		assertEquals(1,dll.popBack());
		assertEquals(2,dll.popBack());
		dll.reverse();
		assertEquals(4,dll.popBack());
		assertEquals(3,dll.popBack());

	}

}
