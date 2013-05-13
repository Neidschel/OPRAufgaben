package at.fhhgb.mc.Aufgabe01test;

import static org.junit.Assert.*;

import org.junit.Test;

import at.fhhgb.mc.Aufgabe01.*;

public class DoubleLinkedListTest {

	

	@Test
	public void testDoubleLinkedListEmpty() {
		DoubleLinkedList dll = new DoubleLinkedList();
		assertEquals(0,dll.elements());
	}

	@Test
	public void testDoubleLinkedListDoubleLinkedList() {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushFront(1);
		dll.pushFront(2);
		dll.pushFront(3);
		DoubleLinkedList dll2 = new DoubleLinkedList(dll);
		assertEquals(3,dll2.elements());
	}

	@Test
	public void testClear() {
		
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushFront(5);
		dll.pushFront(6);
		dll.pushFront(7);
		dll.clear();
		assertEquals(0,dll.elements());	
		
	}

	@Test
	public void testPushFront() {
		
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushFront(5);
		assertEquals(1,dll.elements());
		
	}
	
	@Test
	public void testPushFrontDoubleLinkedList() {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushFront(5);
		dll.pushFront(6);
		DoubleLinkedList dll2 = new DoubleLinkedList();
		dll2.pushFront(1);
		dll2.pushFront(2);
		dll2.pushFront(3);
		dll.pushFront(dll2);
		
		assertEquals(3,dll.elements());
	}

	@Test
	public void testPushBack() {
		
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(5);
		assertEquals(1,dll.elements());
		
	}
	
	@Test
	public void testPushBackDoubleLinkedList() {
		
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(5);
		dll.pushBack(6);
		DoubleLinkedList dll2 = new DoubleLinkedList();
		dll2.pushBack(1);
		dll2.pushBack(2);
		dll2.pushBack(3);
		dll.pushBack(dll2);
		
		assertEquals(5,dll.elements());
		
	}
	
	//no Exception expected
	@Test
	public void testPopFront() throws InvalidAccessException {
		
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushFront(5);
		dll.pushFront(6);
		try{
			assertEquals(6,dll.popFront());	
		}catch(InvalidAccessException ex){
			fail(ex.getMessage());
		}
		
		
	}
	
	//Exception expected
	@Test
	public void testPopFrontEmpty() throws InvalidAccessException {
		DoubleLinkedList dll = new DoubleLinkedList();
		try{
			dll.popFront();
		}catch(InvalidAccessException ex){
			return;
		}
		fail("ExceptionExpected");
	}
	
	@Test
	public void testPopFrontCaunt() throws InvalidAccessException {
		
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushFront(5);
		dll.pushFront(6);
		dll.pushFront(7);
		assertEquals(7,dll.popFront());	
		assertEquals(2,dll.elements());	
		
	}
	
	//no Exception expected
	@Test
	public void testPeekFront() throws InvalidAccessException {
		
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushFront(5);
		dll.pushFront(6);
		try{
			assertEquals(6,dll.peekFront());	
		}catch(InvalidAccessException ex){
			fail(ex.getMessage());
		}
	
	}
	
	//exception expected
	@Test
	public void testPeekFrontEmpty() throws InvalidAccessException {
		
		DoubleLinkedList dll = new DoubleLinkedList();
		try{
			dll.peekFront();
		}catch(InvalidAccessException ex){
			return;
		}
		fail("ExceptionExpected");
		
	}
	//no exception expected
	@Test
	public void testPopBack() throws InvalidAccessException {
		
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(6);
		dll.pushBack(5);
		
		try{
			assertEquals(5,dll.popBack());
		}catch(InvalidAccessException ex){
			fail(ex.getMessage());
		}
		
		
	}
	
	//exception expected
	@Test
	public void testPopBackEmpty() throws InvalidAccessException {
		
		DoubleLinkedList dll = new DoubleLinkedList();
		try{
			dll.popBack();
		}catch(InvalidAccessException ex){
			return;
		}
		fail("ExceptionExpected");	
		
	}
	
	@Test
	public void testPopBackCount() throws InvalidAccessException {
		
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(6);
		dll.pushBack(5);
		assertEquals(5,dll.popBack());
		assertEquals(1,dll.elements());

		
	}
	//no exception expected
	@Test
	public void testPeekBack() throws InvalidAccessException {
		
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(6);
		dll.pushBack(5);
		try{
			assertEquals(5,dll.popBack());
		}catch(InvalidAccessException ex){
			fail(ex.getMessage());
		}
		
	}
	
	//exception expected
	@Test
	public void testPeekBackEmpty() throws InvalidAccessException {
		
		DoubleLinkedList dll = new DoubleLinkedList();
		try{
			dll.peekBack();
		}catch(InvalidAccessException ex){
			return;
		}
		fail("ExceptionExpected");
		
	}
	
	@Test
	public void testEqualsTrue() {
		
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(6);
		dll.pushBack(5);
		DoubleLinkedList dll2 = new DoubleLinkedList();
		dll2.pushBack(6);
		dll2.pushBack(5);
		assertEquals(true,dll.equals(dll2));	
		
	}
	
	@Test
	public void testEqualsFalse() {
		
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(6);
		dll.pushBack(5);
		DoubleLinkedList dll2 = new DoubleLinkedList();
		dll2.pushFront(6);
		dll2.pushFront(5);
		assertEquals(false,dll.equals(dll2));	
		
	}
	
	@Test
	public void testClone() {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(6);
		dll.pushBack(5);
		DoubleLinkedList dll2 = dll.clone();
		assertEquals(true,dll.equals(dll2));	
		
	}
	
	@Test
	public void testSearchTrue() {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(6);
		dll.pushBack(5);
		dll.pushFront(new Integer(3));
		dll.pushFront(2);
		assertEquals(true,dll.search(new Integer(3)));	
	}
	
	@Test
	public void testSearchFalse() {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(6);
		dll.pushBack(5);
		dll.pushFront(3);
		dll.pushFront(2);
		assertEquals(false,dll.search(4));	
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
	public void testReverse() throws InvalidAccessException {
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
	public void testMultipleReverse() throws InvalidAccessException {
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
	
	@Test
	public void testEmptyToString() {
		DoubleLinkedList dll = new DoubleLinkedList();
		assertEquals("No Nodes in that list!",dll.toString());
	}
	
	@Test
	public void testToString() {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(1);
		dll.pushBack(2);
		System.out.println(dll.toString());
	}


}
