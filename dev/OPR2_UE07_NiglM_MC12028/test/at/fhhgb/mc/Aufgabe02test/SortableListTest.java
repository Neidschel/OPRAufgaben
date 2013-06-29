package at.fhhgb.mc.Aufgabe02test;

import static org.junit.Assert.*;

import org.junit.*;
import at.fhhgb.mc.Aufgabe02.*;
import at.fhhgb.mc.Aufgabe01.*;

public class SortableListTest {

	SortableList saLInt;
	SortableList saLString;

	@Before
	public void init() throws ValueException {
		saLInt = new SortableList();
		saLString = new SortableList();

		saLInt.pushBack(34);
		saLInt.pushBack(45);
		saLInt.pushBack(2);
		saLInt.pushBack(6465);
		saLInt.pushBack(4);
		saLInt.pushBack(234);

		saLString.pushBack("Ralph");
		saLString.pushBack("Sebastian");
		saLString.pushBack("Michael");
		saLString.pushBack("Magdalena");
		saLString.pushBack("Konrad");
		saLString.pushBack("Stefan");

	}

	@Test
	public void testInsertSortedAscendingInt() throws ValueException,
			InvalidAccessException {
		saLInt.insertSorted(300, true);
		try {
			assertEquals(300, saLInt.elementAt(3));
		} catch (InvalidAccessException ex) {
			fail("No Exception expected!");
		}
	}

	@Test
	public void testInsertSortedDescendingInt() throws ValueException,
			InvalidAccessException {
		saLInt.insertSorted(300, false);
		try {
			assertEquals(300, saLInt.elementAt(0));
		} catch (InvalidAccessException ex) {
			fail("No Exception expected!");
		}

	}

	@Test
	public void testInsertSortedAscendingString() throws ValueException,
			InvalidAccessException {
		saLString.insertSorted("Gerald", true);
		try {
			assertEquals("Gerald", saLString.elementAt(0));
		} catch (InvalidAccessException ex) {
			fail("No Exception expected!");
		}

	}

	@Test
	public void testInsertSortedDescendingString() throws ValueException,
			InvalidAccessException {
		saLString.insertSorted("Gerald", false);
		try {
			assertEquals("Gerald", saLString.elementAt(6));
		} catch (InvalidAccessException ex) {
			fail("No Exception expected!");
		}

	}

	// Value exception expected
	@Test
	public void testInsertSortedValueException() throws ValueException,
			InvalidAccessException {

		try {
			saLString.insertSorted(2, false);
		} catch (ValueException ex) {
			return;
		}
		fail("Exception expected!");

	}

	// Value exception expected
	@Test
	public void testInsertSortedNullPointerException() throws ValueException,
			InvalidAccessException {

		try {
			saLString.insertSorted(null, false);
		} catch (NullPointerException ex) {
			return;
		}
		fail("Exception expected!");

	}

	@Test
	public void testSortAscendingInt() {
		SortableList saL2 = new SortableList();
		saL2 = (SortableList) saLInt.sortAscending();
		try {
			assertEquals(2, saL2.elementAt(0));
			assertEquals(4, saL2.elementAt(1));
			assertEquals(34, saL2.elementAt(2));
			assertEquals(45, saL2.elementAt(3));
			assertEquals(234, saL2.elementAt(4));
			assertEquals(6465, saL2.elementAt(5));

		} catch (InvalidAccessException ex) {
			fail("No Exception expected!");
		}
	}

	@Test
	public void testSortDescendingInt() {
		SortableList saL2 = new SortableList();
		saL2 = (SortableList) saLInt.sortDescending();
		try {
			assertEquals(2, saL2.elementAt(5));
			assertEquals(4, saL2.elementAt(4));
			assertEquals(34, saL2.elementAt(3));
			assertEquals(45, saL2.elementAt(2));
			assertEquals(234, saL2.elementAt(1));
			assertEquals(6465, saL2.elementAt(0));

		} catch (InvalidAccessException ex) {
			fail("No Exception expected!");
		}
	}

	@Test
	public void testSortAscendingString() {
		SortableList saL2 = new SortableList();
		saL2 = (SortableList) saLString.sortAscending();
		try {
			assertEquals("Konrad", saL2.elementAt(0));
			assertEquals("Magdalena", saL2.elementAt(1));
			assertEquals("Michael", saL2.elementAt(2));
			assertEquals("Ralph", saL2.elementAt(3));
			assertEquals("Sebastian", saL2.elementAt(4));
			assertEquals("Stefan", saL2.elementAt(5));

		} catch (InvalidAccessException ex) {
			fail("No Exception expected!");
		}
	}

	@Test
	public void testSortDescendingString() {
		SortableList saL2 = new SortableList();
		saL2 = (SortableList) saLString.sortDescending();
		try {
			assertEquals("Konrad", saL2.elementAt(5));
			assertEquals("Magdalena", saL2.elementAt(4));
			assertEquals("Michael", saL2.elementAt(3));
			assertEquals("Ralph", saL2.elementAt(2));
			assertEquals("Sebastian", saL2.elementAt(1));
			assertEquals("Stefan", saL2.elementAt(0));

		} catch (InvalidAccessException ex) {
			fail("No Exception expected!");
		}
	}

}
