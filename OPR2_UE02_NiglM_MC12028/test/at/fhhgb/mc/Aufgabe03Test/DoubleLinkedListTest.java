package at.fhhgb.mc.Aufgabe03Test;

import static org.junit.Assert.*;

import org.junit.Test;

import at.fhhgb.mc.Aufgabe03.DoubleLinkedList;

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
	public void testClearRecursive() {
		
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushFront(5);
		dll.pushFront(6);
		DoubleLinkedList dll2 = new DoubleLinkedList();
		dll2.pushFront(1);
		dll2.pushFront(2);
		dll2.pushFront(3);
		DoubleLinkedList dll3 = new DoubleLinkedList();
		dll3.pushFront(7);
		dll3.pushFront(8);
		dll3.pushFront(9);
		dll.pushFrontRecursive(dll2);
		dll.pushFrontRecursive(dll3);
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
	public void testPushFrontRecursive() {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushFront(5);
		dll.pushFront(6);
		DoubleLinkedList dll2 = new DoubleLinkedList();
		dll2.pushFront(1);
		dll2.pushFront(2);
		dll2.pushFront(3);
		DoubleLinkedList dll3 = new DoubleLinkedList();
		dll3.pushFront(7);
		dll3.pushFront(8);
		dll3.pushFront(9);
		dll.pushFrontRecursive(dll2);
		dll.pushFrontRecursive(dll3);
		assertEquals(10,dll.elements());
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
	
	@Test
	public void testPushBackRecursive() {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(5);
		dll.pushBack(6);
		DoubleLinkedList dll2 = new DoubleLinkedList();
		dll2.pushBack(1);
		dll2.pushBack(2);
		dll2.pushBack(3);
		DoubleLinkedList dll3 = new DoubleLinkedList();
		dll3.pushBack(7);
		dll3.pushBack(8);
		dll3.pushBack(9);
		dll.pushBackRecursive(dll2);
		dll.pushBackRecursive(dll3);
		assertEquals(10,dll.elements());
	}
	
	@Test
	public void testPushRecursiveBoth() {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushFront(5);
		dll.pushFront(6);
		DoubleLinkedList dll2 = new DoubleLinkedList();
		dll2.pushFront(1);
		dll2.pushFront(2);
		dll2.pushFront(3);
		DoubleLinkedList dll3 = new DoubleLinkedList();
		dll3.pushFront(7);
		dll3.pushFront(8);
		dll3.pushFront(9);
		dll.pushFrontRecursive(dll2);
		dll.pushBackRecursive(dll3);
		assertEquals(10,dll.elements());
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
	public void testPopFrontRecursive() {
		
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushFront(5);
		dll.pushFront(6);
		DoubleLinkedList dll2 = new DoubleLinkedList();
		dll2.pushFront(1);
		dll2.pushFront(2);
		dll2.pushFront(3);
		DoubleLinkedList dll3 = new DoubleLinkedList();
		dll3.pushFront(7);
		dll3.pushFront(8);
		dll3.pushFront(9);
		dll.pushFrontRecursive(dll2);
		dll.pushFrontRecursive(dll3);
		assertEquals(9,dll.popFront());
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
	public void testPeekFrontRecursive() {
		
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushFront(5);
		dll.pushFront(6);
		DoubleLinkedList dll2 = new DoubleLinkedList();
		dll2.pushFront(1);
		dll2.pushFront(2);
		dll2.pushFront(3);
		DoubleLinkedList dll3 = new DoubleLinkedList();
		dll3.pushFront(7);
		dll3.pushFront(8);
		dll3.pushFront(9);
		dll.pushFrontRecursive(dll2);
		dll.pushFrontRecursive(dll3);
		assertEquals(9,dll.peekFront());
		assertEquals(9,dll.popFront());
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
	public void testPopBackCount() {
		
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(6);
		dll.pushBack(5);
		assertEquals(5,dll.popBack());
		assertEquals(1,dll.elements());

		
	}
	
	@Test
	public void testPopBackRecursive() {
		
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(5);
		dll.pushBack(6);
		DoubleLinkedList dll2 = new DoubleLinkedList();
		dll2.pushBack(1);
		dll2.pushBack(2);
		dll2.pushBack(3);
		DoubleLinkedList dll3 = new DoubleLinkedList();
		dll3.pushBack(7);
		dll3.pushBack(8);
		dll3.pushBack(9);
		dll.pushBackRecursive(dll2);
		dll.pushBackRecursive(dll3);
		assertEquals(9,dll.popBack());
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
	public void testPeekBackRecursive() {
		
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(5);
		dll.pushBack(6);
		DoubleLinkedList dll2 = new DoubleLinkedList();
		dll2.pushBack(1);
		dll2.pushBack(2);
		dll2.pushBack(3);
		DoubleLinkedList dll3 = new DoubleLinkedList();
		dll3.pushBack(7);
		dll3.pushBack(8);
		dll3.pushBack(9);
		dll.pushBackRecursive(dll2);
		dll.pushBackRecursive(dll3);
		assertEquals(9,dll.peekBack());
		assertEquals(9,dll.popBack());
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
	public void testEqualsTrueRecursive() {
		
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(6);
		dll.pushBack(5);
		DoubleLinkedList dll2 = new DoubleLinkedList();
		dll2.pushFront(4);
		dll2.pushFront(2);
		DoubleLinkedList dll3 = new DoubleLinkedList();
		dll3.pushFront(3);
		dll3.pushFront(5);
		dll.pushBackRecursive(dll2);
		dll.pushBackRecursive(dll3);
		DoubleLinkedList dll4 = new DoubleLinkedList();
		dll4.pushBack(6);
		dll4.pushBack(5);
		DoubleLinkedList dll5 = new DoubleLinkedList();
		dll5.pushFront(4);
		dll5.pushFront(2);
		DoubleLinkedList dll6 = new DoubleLinkedList();
		dll6.pushFront(3);
		dll6.pushFront(5);
		dll4.pushBackRecursive(dll5);
		dll4.pushBackRecursive(dll6);
		assertEquals(true,dll.equals(dll4));	
		
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
	public void testCloneRecursive() {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(5);
		dll.pushBack(6);
		DoubleLinkedList dll2 = new DoubleLinkedList();
		dll2.pushBack(1);
		dll2.pushBack(2);
		dll2.pushBack(3);
		DoubleLinkedList dll3 = new DoubleLinkedList();
		dll3.pushBack(7);
		dll3.pushBack(8);
		dll3.pushBack(9);
		dll.pushBackRecursive(dll2);
		dll.pushBackRecursive(dll3);
		DoubleLinkedList dll4 = new DoubleLinkedList();
		dll4 = dll.clone();
		assertEquals(true,dll.equals(dll4));	
		
	}
	
	@Test
	public void testSearchTrue() {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(6);
		dll.pushBack(5);
		dll.pushFront(3);
		dll.pushFront(2);
		assertEquals(true,dll.search(3));	
	}
	
	@Test
	public void testSearchTrueRecursive() {
		
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(6);
		dll.pushBack(5);
		DoubleLinkedList dll2 = new DoubleLinkedList();
		dll.pushFront(4);
		dll.pushFront(2);
		DoubleLinkedList dll3 = new DoubleLinkedList();
		dll.pushFront(3);
		dll.pushFront(5);
		dll.pushBackRecursive(dll2);
		dll.pushBackRecursive(dll3);
		assertEquals(true,dll.search(3));	
		
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
	public void testElementsRecursive() {
		
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(6);
		dll.pushBack(5);
		DoubleLinkedList dll2 = new DoubleLinkedList();
		dll2.pushFront(4);
		dll2.pushFront(2);
		DoubleLinkedList dll3 = new DoubleLinkedList();
		dll3.pushFront(3);
		dll3.pushFront(5);
		dll.pushBackRecursive(dll2);
		dll.pushBackRecursive(dll3);
		assertEquals(8,dll.elements());	
		
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
		assertEquals("Node 1 contains the Value 1"+"\n"+"Node 2 contains the Value 2",dll.toString());
	}
	
	@Test
	public void testToStringFrontRecursive() {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushFront(5);
		dll.pushFront(6);
		DoubleLinkedList dll2 = new DoubleLinkedList();
		dll2.pushFront(1);
		dll2.pushFront(2);
		dll2.pushFront(3);
		DoubleLinkedList dll3 = new DoubleLinkedList();
		dll3.pushFront(7);
		dll3.pushFront(8);
		dll3.pushFront(9);
		dll.pushFrontRecursive(dll2);
		dll.pushFrontRecursive(dll3);
		
		
		String test = new String("Node 1 contains following List:"+
	"\n"+"\t"+"Node 1 contains following List:"+
	"\n"+"\t"+"\t"+"Node 1 contains the Value 9"+
	"\n"+"\t"+"\t"+"Node 2 contains the Value 8"+
	"\n"+"\t"+"\t"+"Node 3 contains the Value 7"+
	"\n"+"\t"+"Node 2 contains the Value 3"+
	"\n"+"\t"+"Node 3 contains the Value 2"+
	"\n"+"\t"+"Node 4 contains the Value 1"+
	"\n"+"Node 2 contains the Value 6"+
	"\n"+"Node 3 contains the Value 5");
		
		assertEquals(test,dll.toString());
	}
	
	@Test
	public void testToStringBackRecursive() {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.pushBack(5);
		dll.pushBack(6);
		DoubleLinkedList dll2 = new DoubleLinkedList();
		dll2.pushBack(1);
		dll2.pushBack(2);
		dll2.pushBack(3);
		DoubleLinkedList dll3 = new DoubleLinkedList();
		dll3.pushBack(7);
		dll3.pushBack(8);
		dll3.pushBack(9);
		dll.pushBackRecursive(dll2);
		dll.pushBackRecursive(dll3);
		
		
		String test = new String("Node 1 contains the Value 5"+
	"\n"+"Node 2 contains the Value 6"+
	"\n"+"Node 3 contains following List:"+		
	"\n"+"\t"+"Node 1 contains the Value 1"+
	"\n"+"\t"+"Node 2 contains the Value 2"+
	"\n"+"\t"+"Node 3 contains the Value 3"+
	"\n"+"\t"+"Node 4 contains following List:"+
	"\n"+"\t"+"\t"+"Node 1 contains the Value 7"+
	"\n"+"\t"+"\t"+"Node 2 contains the Value 8"+
	"\n"+"\t"+"\t"+"Node 3 contains the Value 9");
		
		assertEquals(test,dll.toString());
	}


}
