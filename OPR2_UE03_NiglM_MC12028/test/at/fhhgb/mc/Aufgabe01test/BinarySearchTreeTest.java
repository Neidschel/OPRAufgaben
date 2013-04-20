package at.fhhgb.mc.Aufgabe01test;

import static org.junit.Assert.*;

import org.junit.Test;

import at.fhhgb.mc.Aufgabe01.BinarySearchTree;

public class BinarySearchTreeTest {
	
	//test simple insert true
	@Test
	public void testInsertTrue() {
		BinarySearchTree tree = new BinarySearchTree();
		assertEquals(true, tree.insert(10));

	}
	
	//test simple insert false
	@Test
	public void testInsertFalse() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		assertEquals(false, tree.insert(10));

	}
	
	//test find value true
	@Test
	public void testFindTrue() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(3);
		tree.insert(18);
		tree.insert(7);
		tree.insert(11);
		assertEquals(true,tree.find(15));
	}
	
	//test find value false
	@Test
	public void testFindFalse() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(3);
		tree.insert(18);
		tree.insert(7);
		tree.insert(11);
		assertEquals(false,tree.find(13));
	}
	
	//test find value with an empty tree
	@Test
	public void testFindZeroElements() {
		BinarySearchTree tree = new BinarySearchTree();
		assertEquals(false,tree.find(15));
	}
	
	//test simple remove true
	@Test
	public void testRemoveTrue() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(3);
		tree.insert(18);
		tree.insert(7);
		tree.insert(11);
		assertEquals(true,tree.remove(15));
	}
	
	//test simple remove false
	@Test
	public void testRemoveFalse() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(3);
		tree.insert(18);
		tree.insert(7);
		tree.insert(11);
		assertEquals(false,tree.remove(4));
	}
	
	//test remove with removing root
	@Test
	public void testRemoveRoot() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(3);
		tree.insert(18);
		tree.insert(7);
		tree.insert(11);
		assertEquals(true,tree.remove(10));
		assertEquals(true,tree.find(3));
		assertEquals(true,tree.find(18));
	}
	
	//test remove with removing root with only a right subtree
	@Test
	public void testRemoveRootRightOnly() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10);
		tree.insert(15);
		tree.insert(18);
		tree.insert(11);
		assertEquals(true,tree.remove(10));
		assertEquals(true,tree.find(18));
		assertEquals(true,tree.find(11));
		
	}
	
	//test remove with removing root with only a left subtree
	@Test
	public void testRemoveRootLeftOnly() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10);
		tree.insert(5);
		tree.insert(3);
		tree.insert(7);
		assertEquals(true,tree.remove(10));
		assertEquals(true,tree.find(3));
		assertEquals(true,tree.find(7));
	}
	
	//test remove with removing root with only a root node
	@Test
	public void testRemoveRootOnly() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10);
		assertEquals(true,tree.remove(10));
		assertEquals("This Tree is empty!",tree.toString());
		
	}
	
	//test correct tree size
	@Test
	public void testSize() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(3);
		tree.insert(18);
		tree.insert(7);
		tree.insert(11);
		assertEquals(7,tree.size());
	}
	
	//test correct tree size after removing an element
	@Test
	public void testSizeRemoved() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(18);
		tree.insert(3);
		tree.insert(7);
		tree.insert(11);
		tree.remove(15);
		assertEquals(6,tree.size());
	}
	
	//test correct tree size with no elements
	@Test
	public void testSizeZero() {
		BinarySearchTree tree = new BinarySearchTree();
		assertEquals(0,tree.size());
	}

	//test toArray ascending
	@Test
	public void testToArrayAscending() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(3);
		tree.insert(18);
		tree.insert(7);
		tree.insert(11);
		int[] compare = {3,5,7,10,11,15,18};
		assertArrayEquals(compare,tree.toArray(true));
	}
	
	//test toArray descending
	@Test
	public void testToArrayDescending() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(3);
		tree.insert(18);
		tree.insert(7);
		tree.insert(11);
		int[] compare = {18,15,11,10,7,5,3};
		assertArrayEquals(compare,tree.toArray(false));
	}
	
	//test toArray with null 
	@Test
	public void testToArrayNull() {
		BinarySearchTree tree = new BinarySearchTree();
		assertNull(tree.toArray(true));
	}
	
	//test max element
	@Test
	public void testMax() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(3);
		tree.insert(18);
		tree.insert(7);
		tree.insert(11);
		assertEquals(18,tree.max());
	}
	
	//test max element with empty tree
	@Test
	public void testToMaxZeroElements() {
		BinarySearchTree tree = new BinarySearchTree();
		assertEquals(Integer.MAX_VALUE,tree.max());
	}
	
	//test min element
	@Test
	public void testMin() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(3);
		tree.insert(18);
		tree.insert(7);
		tree.insert(11);
		assertEquals(3,tree.min());
	}
	
	//test min element with empty tree
	@Test
	public void testToMinZeroElements() {
		BinarySearchTree tree = new BinarySearchTree();
		assertEquals(Integer.MIN_VALUE,tree.min());
	}
	
	//String representation of the tree (just once to see how it looks like)
	@Test
	public void testToString() {
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
	
	//String representation of the tree with no elements
	@Test
	public void testToStringNoTree() {
		BinarySearchTree tree = new BinarySearchTree();
		assertEquals("This Tree is empty!",tree.toString());
	}

}
