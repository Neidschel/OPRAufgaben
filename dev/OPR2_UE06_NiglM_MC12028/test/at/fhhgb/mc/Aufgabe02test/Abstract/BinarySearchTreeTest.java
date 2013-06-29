package at.fhhgb.mc.Aufgabe02test.Abstract;

import static org.junit.Assert.*;

import org.junit.Test;

import at.fhhgb.mc.Aufgabe02.Abstract.*;

public class BinarySearchTreeTest {

	// test simple insert true
	@Test
	public void testInsertTrue() throws ValueException, NullPointerException {
		BinarySearchTree tree = new BinarySearchTree();
		assertEquals(true, tree.insert(10));

	}

	// test simple insert false
	@Test
	public void testInsertFalse() throws ValueException, NullPointerException {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		assertEquals(false, tree.insert(10));

	}

	// insert test for no Exception
	@Test
	public void testInsertException() throws ValueException,
			NullPointerException {
		BinarySearchTree tree = new BinarySearchTree();
		try {
			tree.insert(10);
			tree.insert(5);
			tree.insert(15);
		} catch (ValueException ex1) {
			fail(ex1.getMessage());
		} catch (NullPointerException ex2) {
			fail(ex2.getMessage());
		}

	}

	// insert test for Exception NullPointer
	@Test
	public void testInsertExceptionNull() throws ValueException,
			NullPointerException {
		BinarySearchTree tree = new BinarySearchTree();
		try {
			tree.insert(10);
			tree.insert(5);
			tree.insert(null);
		} catch (NullPointerException ex2) {
			return;
		}

		fail("Exception expected");

	}

	// insert test for Exception not Comparable
	@Test
	public void testInsertExceptionComparable() throws ValueException,
			NullPointerException {
		BinarySearchTree tree = new BinarySearchTree();
		try {
			tree.insert(10);
			tree.insert("Hallo");
		} catch (ValueException ex2) {
			return;
		}

		fail("Exception expected");

	}

	// test find value true
	@Test
	public void testFindTrue() throws ValueException, NullPointerException {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(3);
		tree.insert(18);
		tree.insert(7);
		tree.insert(11);
		assertEquals(true, tree.find(15));
	}

	// test find value false
	@Test
	public void testFindFalse() throws ValueException, NullPointerException {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(3);
		tree.insert(18);
		tree.insert(7);
		tree.insert(11);
		assertEquals(false, tree.find(13));
	}

	// test find value with an empty tree
	@Test
	public void testFindZeroElements() throws ValueException,
			NullPointerException {
		BinarySearchTree tree = new BinarySearchTree();
		assertEquals(false, tree.find(15));
	}

	// insert test for no Exception
	@Test
	public void testFindException() throws ValueException, NullPointerException {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(3);
		tree.insert(18);
		tree.insert(7);
		tree.insert(11);
		try {
			tree.find(10);
		} catch (ValueException ex1) {
			fail(ex1.getMessage());
		} catch (NullPointerException ex2) {
			fail(ex2.getMessage());
		}

	}

	// insert test for Exception NullPointer
	@Test
	public void testFindExceptionNull() throws ValueException,
			NullPointerException {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(3);
		tree.insert(18);
		tree.insert(7);
		tree.insert(11);
		try {
			tree.find(null);
		} catch (NullPointerException ex2) {
			return;
		}

		fail("Exception expected");

	}

	// insert test for Exception not Comparable
	@Test
	public void testFindExceptionComparable() throws ValueException,
			NullPointerException {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(3);
		tree.insert(18);
		tree.insert(7);
		tree.insert(11);
		try {
			tree.find("Hallo");
		} catch (ValueException ex2) {
			return;
		}

		fail("Exception expected");

	}

	// test simple remove true
	@Test
	public void testRemoveTrue() throws ValueException, NullPointerException {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(3);
		tree.insert(18);
		tree.insert(7);
		tree.insert(11);
		assertEquals(true, tree.remove(15));
	}

	// test simple remove false
	@Test
	public void testRemoveFalse() throws ValueException, NullPointerException {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(3);
		tree.insert(18);
		tree.insert(7);
		tree.insert(11);
		assertEquals(false, tree.remove(4));
	}

	// test remove with removing root
	@Test
	public void testRemoveRoot() throws ValueException, NullPointerException {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(3);
		tree.insert(18);
		tree.insert(7);
		tree.insert(11);
		assertEquals(true, tree.remove(10));
		assertEquals(true, tree.find(3));
		assertEquals(true, tree.find(18));
	}

	// test remove with removing root with only a right subtree
	@Test
	public void testRemoveRootRightOnly() throws ValueException,
			NullPointerException {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10);
		tree.insert(15);
		tree.insert(18);
		tree.insert(11);
		assertEquals(true, tree.remove(10));
		assertEquals(true, tree.find(18));
		assertEquals(true, tree.find(11));

	}

	// test remove with removing root with only a left subtree
	@Test
	public void testRemoveRootLeftOnly() throws ValueException,
			NullPointerException {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10);
		tree.insert(5);
		tree.insert(3);
		tree.insert(7);
		assertEquals(true, tree.remove(10));
		assertEquals(true, tree.find(3));
		assertEquals(true, tree.find(7));
	}

	// test remove with removing root with only a root node
	@Test
	public void testRemoveRootOnly() throws ValueException,
			NullPointerException {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10);
		assertEquals(true, tree.remove(10));
		assertEquals("This Tree is empty!", tree.toString());

	}

	// remove test for no Exception
	@Test
	public void testRemoveException() throws ValueException,
			NullPointerException {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		try {
			tree.remove(15);
		} catch (ValueException ex1) {
			fail(ex1.getMessage());
		} catch (NullPointerException ex2) {
			fail(ex2.getMessage());
		}

	}

	// remove test for Exception NullPointer
	@Test
	public void testRemoveExceptionNull() throws ValueException,
			NullPointerException {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		try {
			tree.remove(null);
		} catch (NullPointerException ex2) {
			return;
		}

		fail("Exception expected");

	}

	// remove test for Exception not Comparable
	@Test
	public void testRemoveExceptionComparable() throws ValueException,
			NullPointerException {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		try {
			tree.remove("Hallo");
		} catch (ValueException ex2) {
			return;
		}

		fail("Exception expected");

	}

	// test correct tree size
	@Test
	public void testSize() throws ValueException, NullPointerException {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(3);
		tree.insert(18);
		tree.insert(7);
		tree.insert(11);
		assertEquals(7, tree.size());
	}

	// test correct tree size after removing an element
	@Test
	public void testSizeRemoved() throws ValueException, NullPointerException {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(18);
		tree.insert(3);
		tree.insert(7);
		tree.insert(11);
		tree.remove(15);
		assertEquals(6, tree.size());
	}

	// test correct tree size with no elements
	@Test
	public void testSizeZero() {
		BinarySearchTree tree = new BinarySearchTree();
		assertEquals(0, tree.size());
	}

	// test toArray ascending
	@Test
	public void testToArrayAscending() throws ValueException,
			NullPointerException {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(3);
		tree.insert(18);
		tree.insert(7);
		tree.insert(11);
		Integer[] compare = { 3, 5, 7, 10, 11, 15, 18 };
		assertArrayEquals(compare, tree.toArray(true));
	}

	// test toArray descending
	@Test
	public void testToArrayDescending() throws ValueException,
			NullPointerException {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(3);
		tree.insert(18);
		tree.insert(7);
		tree.insert(11);
		Integer[] compare = { 18, 15, 11, 10, 7, 5, 3 };
		assertArrayEquals(compare, tree.toArray(false));
	}

	// test toArray with null
	@Test
	public void testToArrayNull() {
		BinarySearchTree tree = new BinarySearchTree();
		assertNull(tree.toArray(true));
	}

	// test max element
	@Test
	public void testMax() throws ValueException, NullPointerException {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(3);
		tree.insert(18);
		tree.insert(7);
		tree.insert(11);
		assertEquals(18, tree.max());
	}

	// test max element with empty tree
	@Test
	public void testToMaxZeroElements() {
		BinarySearchTree tree = new BinarySearchTree();
		assertEquals(Integer.MAX_VALUE, tree.max());
	}

	// test min element
	@Test
	public void testMin() throws ValueException, NullPointerException {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(3);
		tree.insert(18);
		tree.insert(7);
		tree.insert(11);
		assertEquals(3, tree.min());
	}

	// test min element with empty tree
	@Test
	public void testToMinZeroElements() {
		BinarySearchTree tree = new BinarySearchTree();
		assertEquals(Integer.MIN_VALUE, tree.min());
	}

	// String representation of the tree (just once to see how it looks like)
	@Test
	public void testToString() throws ValueException, NullPointerException {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10);
		tree.insert(5);
		tree.insert(1500);
		tree.insert(3);
		tree.insert(1800);
		tree.insert(7);
		tree.insert(1100);
		tree.insert(1900);
		tree.insert(1700);
		tree.insert(1);
		tree.insert(8);
		tree.insert(2000);
		System.out.println("Tree elements: ");
		System.out.println(tree.toString());
	}

	// String representation of the tree with no elements
	@Test
	public void testToStringNoTree() {
		BinarySearchTree tree = new BinarySearchTree();
		assertEquals("This Tree is empty!", tree.toString());
	}

}
