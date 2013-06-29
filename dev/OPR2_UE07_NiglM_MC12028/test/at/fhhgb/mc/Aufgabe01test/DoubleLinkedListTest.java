package at.fhhgb.mc.Aufgabe01test;

import static org.junit.Assert.*;

import org.junit.Test;

import at.fhhgb.mc.Aufgabe01.*;

public class DoubleLinkedListTest {

	@Test
	public void testDoubleLinkedListEmpty() {
		DoubleLinkedList dll = new DoubleLinkedList();
		assertEquals(0, dll.elements());
	}

	// no Exception
	@Test
	public void testDoubleLinkedList() throws ValueException {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushFront(1);
		dll.pushFront(2);
		dll.pushFront(3);
		DoubleLinkedList dll2;
		try {
			dll2 = new DoubleLinkedList(dll);
			assertEquals(3, dll2.elements());
		} catch (NullPointerException ex) {
			fail("No Exception expected");
		}

	}

	// Exception expected
	@Test
	public void testDoubleLinkedListException() throws ValueException {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushFront(1);
		dll.pushFront(2);
		dll.pushFront(3);
		DoubleLinkedList dll2;
		try {
			dll2 = new DoubleLinkedList(null);
			assertEquals(3, dll2.elements());
		} catch (NullPointerException ex) {
			return;
		}

		fail("Exception expected");

	}

	@Test
	public void testClear() throws ValueException {

		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushFront(5);
		dll.pushFront(6);
		dll.pushFront(7);
		dll.clear();
		assertEquals(0, dll.elements());

	}

	@Test
	public void testPushFront() throws ValueException {

		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushFront(5);
		assertEquals(1, dll.elements());

	}

	// No Exception
	@Test
	public void testPushFrontNoException() throws ValueException {

		DoubleLinkedList dll = new DoubleLinkedList();
		try {
			dll.pushFront(5);
			dll.pushFront(6);
			assertEquals(2, dll.elements());
		} catch (ValueException ex) {
			fail("No Exception expected!");
		}
	}

	// exception expected
	@Test
	public void testPushFrontException() throws ValueException {

		DoubleLinkedList dll = new DoubleLinkedList();
		try {
			dll.pushFront(5);
			dll.pushFront("String");
		} catch (ValueException ex) {
			return;
		}
		fail("Exception expected!");
	}

	// null exception expected
	@Test
	public void testPushFrontNullPointerException() throws ValueException {

		DoubleLinkedList dll = new DoubleLinkedList();
		try {
			dll.pushFront((Comparable) null);
			dll.pushFront("String");
		} catch (NullPointerException ex) {
			return;
		}
		fail("Exception expected!");
	}

	// No exception expected
	@Test
	public void testPushFrontDoubleLinkedList() throws ValueException {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushFront(5);
		dll.pushFront(6);
		DoubleLinkedList dll2 = new DoubleLinkedList();
		dll2.pushFront(1);
		dll2.pushFront(2);
		dll2.pushFront(3);
		try {
			dll.pushFront(dll2);
			assertEquals(3, dll.elements());
		} catch (ValueException ex) {
			fail("No Exceptione expected!");
		}
	}

	// exception expected
	@Test
	public void testPushFrontDoubleLinkedListException() throws ValueException {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushFront(5);
		dll.pushFront(6);
		DoubleLinkedList dll2 = new DoubleLinkedList();
		dll2.pushFront("String");
		dll2.pushFront("ssdf");
		dll2.pushFront("sdf");
		try {
			dll.pushFront(dll2);
		} catch (ValueException ex) {
			return;
		}
		fail("Exceptione expected!");

	}

	// null exception expected
	@Test
	public void testPushFrontDoubleLinkedListNullPointerException()
			throws ValueException {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushFront(5);
		dll.pushFront(6);
		DoubleLinkedList dll2 = new DoubleLinkedList();
		dll2.pushFront("String");
		dll2.pushFront("ssdf");
		dll2.pushFront("sdf");
		try {
			dll.pushFront((DoubleLinkedList) null);
		} catch (NullPointerException ex) {
			return;
		}
		fail("Exceptione expected!");

	}

	@Test
	public void testPushBack() throws ValueException {

		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(5);
		assertEquals(1, dll.elements());

	}

	// No Exception
	@Test
	public void testPushBackNoException() throws ValueException {

		DoubleLinkedList dll = new DoubleLinkedList();
		try {
			dll.pushBack(5);
			dll.pushBack(6);
			assertEquals(2, dll.elements());
		} catch (ValueException ex) {
			fail("No Exception expected!");
		}
	}

	// exception expected
	@Test
	public void testPushBackException() throws ValueException {

		DoubleLinkedList dll = new DoubleLinkedList();
		try {
			dll.pushBack(5);
			dll.pushBack("String");
		} catch (ValueException ex) {
			return;
		}
		fail("Exception expected!");
	}

	// null exception expected
	@Test
	public void testPushBackNullPointerException() throws ValueException {

		DoubleLinkedList dll = new DoubleLinkedList();
		try {
			dll.pushBack((Comparable) null);
			dll.pushBack("String");
		} catch (NullPointerException ex) {
			return;
		}
		fail("Exception expected!");
	}

	// no exception expected
	@Test
	public void testPushBackDoubleLinkedList() throws ValueException {

		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(5);
		dll.pushBack(6);
		DoubleLinkedList dll2 = new DoubleLinkedList();
		dll2.pushBack(1);
		dll2.pushBack(2);
		dll2.pushBack(3);
		try {
			dll.pushBack(dll2);
			assertEquals(5, dll.elements());
		} catch (ValueException ex) {
			fail("No Exception expected!");
		}

	}

	// Exception expected
	@Test
	public void testPushBackDoubleLinkedListException() throws ValueException {

		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(5);
		dll.pushBack(6);
		DoubleLinkedList dll2 = new DoubleLinkedList();
		dll2.pushBack("dssdf");
		dll2.pushBack("sdfsd");
		dll2.pushBack("sdf");
		try {
			dll.pushBack(dll2);
		} catch (ValueException ex) {
			return;
		}
		fail("Exception expected!");
	}

	// Null Exception expected
	@Test
	public void testPushBackDoubleLinkedListNullPointerException()
			throws ValueException {

		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(5);
		dll.pushBack(6);
		DoubleLinkedList dll2 = new DoubleLinkedList();
		dll2.pushBack("dssdf");
		dll2.pushBack("sdfsd");
		dll2.pushBack("sdf");
		try {
			dll.pushBack((DoubleLinkedList) null);
		} catch (NullPointerException ex) {
			return;
		}
		fail("Exception expected!");
	}

	// no Exception expected
	@Test
	public void testPopFront() throws InvalidAccessException, ValueException {

		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushFront(5);
		dll.pushFront(6);
		try {
			assertEquals(6, dll.popFront());
		} catch (InvalidAccessException ex) {
			fail(ex.getMessage());
		}

	}

	// Exception expected
	@Test
	public void testPopFrontEmpty() throws InvalidAccessException {
		DoubleLinkedList dll = new DoubleLinkedList();
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

		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushFront(5);
		dll.pushFront(6);
		dll.pushFront(7);
		assertEquals(7, dll.popFront());
		assertEquals(2, dll.elements());

	}

	// no Exception expected
	@Test
	public void testPeekFront() throws InvalidAccessException, ValueException {

		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushFront(5);
		dll.pushFront(6);
		try {
			assertEquals(6, dll.peekFront());
		} catch (InvalidAccessException ex) {
			fail(ex.getMessage());
		}

	}

	// exception expected
	@Test
	public void testPeekFrontEmpty() throws InvalidAccessException,
			ValueException {

		DoubleLinkedList dll = new DoubleLinkedList();
		try {
			dll.peekFront();
		} catch (InvalidAccessException ex) {
			return;
		}
		fail("ExceptionExpected");

	}

	// no exception expected
	@Test
	public void testPopBack() throws InvalidAccessException, ValueException {

		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(6);
		dll.pushBack(5);

		try {
			assertEquals(5, dll.popBack());
		} catch (InvalidAccessException ex) {
			fail(ex.getMessage());
		}

	}

	// exception expected
	@Test
	public void testPopBackEmpty() throws InvalidAccessException,
			ValueException {

		DoubleLinkedList dll = new DoubleLinkedList();
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

		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(6);
		dll.pushBack(5);
		assertEquals(5, dll.popBack());
		assertEquals(1, dll.elements());

	}

	// no exception expected
	@Test
	public void testPeekBack() throws InvalidAccessException, ValueException {

		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(6);
		dll.pushBack(5);
		try {
			assertEquals(5, dll.popBack());
		} catch (InvalidAccessException ex) {
			fail(ex.getMessage());
		}

	}

	// exception expected
	@Test
	public void testPeekBackEmpty() throws InvalidAccessException {

		DoubleLinkedList dll = new DoubleLinkedList();
		try {
			dll.peekBack();
		} catch (InvalidAccessException ex) {
			return;
		}
		fail("ExceptionExpected");

	}

	@Test
	public void testEqualsTrue() throws ValueException {

		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(6);
		dll.pushBack(5);
		DoubleLinkedList dll2 = new DoubleLinkedList();
		dll2.pushBack(6);
		dll2.pushBack(5);
		assertEquals(true, dll.equals(dll2));

	}

	@Test
	public void testEqualsFalse() throws ValueException {

		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(6);
		dll.pushBack(5);
		DoubleLinkedList dll2 = new DoubleLinkedList();
		dll2.pushFront(6);
		dll2.pushFront(5);
		assertEquals(false, dll.equals(dll2));

	}

	// no Exception expected
	@Test
	public void testEqualsNoException() throws ValueException {

		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(6);
		dll.pushBack(5);
		DoubleLinkedList dll2 = new DoubleLinkedList();
		dll2.pushFront(6);
		dll2.pushFront(5);
		try {
			assertEquals(false, dll.equals(dll2));
		} catch (NullPointerException ex) {
			fail("No Exception expected!");
		}

	}

	// Exception expected
	@Test
	public void testEqualsException() throws ValueException {

		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(6);
		dll.pushBack(5);
		DoubleLinkedList dll2 = new DoubleLinkedList();
		dll2.pushFront(6);
		dll2.pushFront(5);
		try {
			assertEquals(false, dll.equals(null));
		} catch (NullPointerException ex) {
			return;
		}
		fail("Exception expected!");
	}

	@Test
	public void testClone() throws ValueException {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(6);
		dll.pushBack(5);
		DoubleLinkedList dll2 = dll.clone();
		assertEquals(true, dll.equals(dll2));

	}

	@Test
	public void testSearchTrue() throws ValueException {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(6);
		dll.pushBack(5);
		dll.pushFront(new Integer(3));
		dll.pushFront(2);
		assertEquals(true, dll.search(new Integer(3)));
	}

	@Test
	public void testSearchFalse() throws ValueException {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(6);
		dll.pushBack(5);
		dll.pushFront(3);
		dll.pushFront(2);
		assertEquals(false, dll.search(4));
	}

	// no Exception expected
	@Test
	public void testSearchNoException() throws ValueException {
		DoubleLinkedList dll = new DoubleLinkedList();
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

	// Exception expected
	@Test
	public void testSearchException() throws ValueException {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(6);
		dll.pushBack(5);
		dll.pushFront(3);
		dll.pushFront(2);
		try {
			assertEquals(false, dll.search("String"));
		} catch (ValueException ex) {
			return;
		}
		fail("Exception expected!");
	}

	// null Exception expected
	@Test
	public void testSearchNullException() throws ValueException {
		DoubleLinkedList dll = new DoubleLinkedList();
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
	public void testElements() throws ValueException {

		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(6);
		dll.pushBack(5);
		dll.pushFront(1);
		dll.pushFront(2);
		assertEquals(4, dll.elements());

	}

	@Test
	public void testReverse() throws InvalidAccessException, ValueException {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(1);
		dll.pushBack(2);
		dll.pushBack(3);
		dll.pushBack(4);
		dll.reverse();
		assertEquals(1, dll.popBack());
		assertEquals(2, dll.popBack());
		assertEquals(3, dll.popBack());
		assertEquals(4, dll.popBack());

	}

	@Test
	public void testMultipleReverse() throws InvalidAccessException,
			ValueException {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(1);
		dll.pushBack(2);
		dll.pushBack(3);
		dll.pushBack(4);
		dll.reverse();
		assertEquals(1, dll.popBack());
		assertEquals(2, dll.popBack());
		dll.reverse();
		assertEquals(4, dll.popBack());
		assertEquals(3, dll.popBack());

	}

	@Test
	public void testEmptyToString() {
		DoubleLinkedList dll = new DoubleLinkedList();
		assertEquals("No Nodes in that list!", dll.toString());
	}

	@Test
	public void testToString() throws ValueException {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(1);
		dll.pushBack(2);
		System.out.println(dll.toString());
	}

}
