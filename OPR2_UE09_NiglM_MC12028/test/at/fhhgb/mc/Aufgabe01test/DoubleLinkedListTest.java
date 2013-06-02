package at.fhhgb.mc.Aufgabe01test;

import static org.junit.Assert.*;

import org.junit.Test;

import at.fhhgb.mc.Aufgabe01.*;


public class DoubleLinkedListTest {

	@Test
	public void testDoubleLinkedListEmpty() {
		DoubleLinkedList<Integer> dll = new DoubleLinkedList<Integer>();
		assertEquals(0, dll.elements());
	}

	// no Exception
	@Test
	public void testDoubleLinkedList()  {
		DoubleLinkedList<Integer> dll = new DoubleLinkedList<Integer>();
		dll.pushFront(1);
		dll.pushFront(2);
		dll.pushFront(3);
		DoubleLinkedList<Integer> dll2;
		try {
			dll2 = new DoubleLinkedList<Integer>(dll);
			assertEquals(3, dll2.elements());
		} catch (NullPointerException ex) {
			fail("No Exception expected");
		}

	}

	// Exception expected
	@Test
	public void testDoubleLinkedListException()  {
		DoubleLinkedList<Integer> dll = new DoubleLinkedList<Integer>();
		dll.pushFront(1);
		dll.pushFront(2);
		dll.pushFront(3);
		DoubleLinkedList<Integer> dll2;
		try {
			dll2 = new DoubleLinkedList<Integer>(null);
			assertEquals(3, dll2.elements());
		} catch (NullPointerException ex) {
			return;
		}

		fail("Exception expected");

	}

	@Test
	public void testClear()  {

		DoubleLinkedList<Integer> dll = new DoubleLinkedList<Integer>();
		dll.pushFront(5);
		dll.pushFront(6);
		dll.pushFront(7);
		dll.clear();
		assertEquals(0, dll.elements());

	}

	@Test
	public void testPushFront()  {

		DoubleLinkedList<Integer> dll = new DoubleLinkedList<Integer>();
		dll.pushFront(5);
		assertEquals(1, dll.elements());

	}



	// null exception expected
	@Test
	public void testPushFrontNullPointerException()  {

		DoubleLinkedList<String> dll = new DoubleLinkedList<String>();
		try {
			dll.pushFront((String)null);
			dll.pushFront("String");
		} catch (NullPointerException ex) {
			return;
		}
		fail("Exception expected!");
	}

	@Test
	public void testPushBack()  {

		DoubleLinkedList<Integer> dll = new DoubleLinkedList<Integer>();
		dll.pushBack(5);
		assertEquals(1, dll.elements());

	}



	// no Exception expected
	@Test
	public void testPopFront() throws InvalidAccessException, ValueException {

		DoubleLinkedList<Integer> dll = new DoubleLinkedList<Integer>();
		dll.pushFront(5);
		dll.pushFront(6);
		try {
			assertEquals(6, (Object)dll.popFront());
		} catch (InvalidAccessException ex) {
			fail(ex.getMessage());
		}

	}

	// Exception expected
	@Test
	public void testPopFrontEmpty() throws InvalidAccessException {
		DoubleLinkedList<Integer> dll = new DoubleLinkedList<Integer>();
		try {
			dll.popFront();
		} catch (InvalidAccessException ex) {
			return;
		}
		fail("ExceptionExpected");
	}

	@Test
	public void testPopFrontCaunt() throws InvalidAccessException,
			ValueException {

		DoubleLinkedList<Integer> dll = new DoubleLinkedList<Integer>();
		dll.pushFront(5);
		dll.pushFront(6);
		dll.pushFront(7);
		assertEquals(7, (Object)dll.popFront());
		assertEquals(2, dll.elements());

	}

	// no Exception expected
	@Test
	public void testPeekFront() throws InvalidAccessException, ValueException {

		DoubleLinkedList<Integer> dll = new DoubleLinkedList<Integer>();
		dll.pushFront(5);
		dll.pushFront(6);
		try {
			assertEquals(6, (Object)dll.peekFront());
		} catch (InvalidAccessException ex) {
			fail(ex.getMessage());
		}

	}

	// exception expected
	@Test
	public void testPeekFrontEmpty() throws InvalidAccessException,
			ValueException {

		DoubleLinkedList<Integer> dll = new DoubleLinkedList<Integer>();
		try {
			dll.peekFront();
		} catch (InvalidAccessException ex) {
			return;
		}
		fail("ExceptionExpected");

	}

	// no exception expected
	@Test
	public void testPopBack() throws InvalidAccessException {

		DoubleLinkedList<Integer> dll = new DoubleLinkedList<Integer>();
		dll.pushBack(6);
		dll.pushBack(5);

		try {
			assertEquals(5, (Object)dll.popBack());
		} catch (InvalidAccessException ex) {
			fail(ex.getMessage());
		}

	}

	// exception expected
	@Test
	public void testPopBackEmpty() throws InvalidAccessException,
			ValueException {

		DoubleLinkedList<Integer> dll = new DoubleLinkedList<Integer>();
		try {
			dll.popBack();
		} catch (InvalidAccessException ex) {
			return;
		}
		fail("ExceptionExpected");

	}

	@Test
	public void testPopBackCount() throws InvalidAccessException,
			ValueException {

		DoubleLinkedList<Integer> dll = new DoubleLinkedList<Integer>();
		dll.pushBack(6);
		dll.pushBack(5);
		assertEquals(5, (Object)dll.popBack());
		assertEquals(1, dll.elements());

	}

	// no exception expected
	@Test
	public void testPeekBack() throws InvalidAccessException, ValueException {

		DoubleLinkedList<Integer> dll = new DoubleLinkedList<Integer>();
		dll.pushBack(6);
		dll.pushBack(5);
		try {
			assertEquals(5, (Object)dll.popBack());
		} catch (InvalidAccessException ex) {
			fail(ex.getMessage());
		}

	}

	// exception expected
	@Test
	public void testPeekBackEmpty() throws InvalidAccessException {

		DoubleLinkedList<Integer> dll = new DoubleLinkedList<Integer>();
		try {
			dll.peekBack();
		} catch (InvalidAccessException ex) {
			return;
		}
		fail("ExceptionExpected");

	}

	

	@Test
	public void testSearchTrue()  {
		DoubleLinkedList<Integer> dll = new DoubleLinkedList<Integer>();
		dll.pushBack(6);
		dll.pushBack(5);
		dll.pushFront(new Integer(3));
		dll.pushFront(2);
		assertEquals(true, dll.search(new Integer(3)));
	}

	@Test
	public void testSearchFalse()  {
		DoubleLinkedList<Integer> dll = new DoubleLinkedList<Integer>();
		dll.pushBack(6);
		dll.pushBack(5);
		dll.pushFront(3);
		dll.pushFront(2);
		assertEquals(false, dll.search(4));
	}

	// no Exception expected
	@Test
	public void testSearchNoException()  {
		DoubleLinkedList<Integer> dll = new DoubleLinkedList<Integer>();
		dll.pushBack(6);
		dll.pushBack(5);
		dll.pushFront(3);
		dll.pushFront(2);
		try {
			assertEquals(false, dll.search(4));
		} catch (NullPointerException ex) {
			fail("No Exception expected!");
		}
	}


	// null Exception expected
	@Test
	public void testSearchNullException()  {
		DoubleLinkedList<Integer> dll = new DoubleLinkedList<Integer>();
		dll.pushBack(6);
		dll.pushBack(5);
		dll.pushFront(3);
		dll.pushFront(2);
		try {
			assertEquals(false, dll.search(null));
		} catch (NullPointerException ex) {
			return;
		}
		fail("Exception expected!");
	}

	@Test
	public void testElements()  {

		DoubleLinkedList<Integer> dll = new DoubleLinkedList<Integer>();
		dll.pushBack(6);
		dll.pushBack(5);
		dll.pushFront(1);
		dll.pushFront(2);
		assertEquals(4, dll.elements());

	}

	@Test
	public void testReverse() throws InvalidAccessException, ValueException {
		DoubleLinkedList<Integer> dll = new DoubleLinkedList<Integer>();
		dll.pushBack(1);
		dll.pushBack(2);
		dll.pushBack(3);
		dll.pushBack(4);
		dll.reverse();
		assertEquals(1, (Object)dll.popBack());
		assertEquals(2, (Object)dll.popBack());
		assertEquals(3, (Object)dll.popBack());
		assertEquals(4, (Object)dll.popBack());

	}

	@Test
	public void testMultipleReverse() throws InvalidAccessException,
			ValueException {
		DoubleLinkedList<Integer> dll = new DoubleLinkedList<Integer>();
		dll.pushBack(1);
		dll.pushBack(2);
		dll.pushBack(3);
		dll.pushBack(4);
		dll.reverse();
		assertEquals(1, (Object)dll.popBack());
		assertEquals(2, (Object)dll.popBack());
		dll.reverse();
		assertEquals(4, (Object)dll.popBack());
		assertEquals(3, (Object)dll.popBack());

	}

	@Test
	public void testEmptyToString() {
		DoubleLinkedList<Integer> dll = new DoubleLinkedList<Integer>();
		assertEquals("No Nodes in that list!", dll.toString());
	}

	@Test
	public void testToString()  {
		DoubleLinkedList<Integer> dll = new DoubleLinkedList<Integer>();
		dll.pushBack(1);
		dll.pushBack(2);
		System.out.println(dll.toString());
	}

}
