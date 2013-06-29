package at.fhhgb.mc.Aufgabe01test;

import static org.junit.Assert.*;

import org.junit.Test;

import at.fhhgb.mc.Aufgabe01.ListQueue;

public class ListQueueTest {
	

	@Test
	public void testListQueue() {
			
		ListQueue st = new ListQueue();
		assertEquals(0, st.elements());
			
	}

	
	@Test
	public void testClear() {
		
		ListQueue st = new ListQueue();
		st.enqueue(10);
		st.enqueue(15);
		st.enqueue(8);
		st.clear();
		assertEquals(0, st.elements());
		
	}
	
	@Test
	public void testenqueueValue() {
		
		ListQueue st = new ListQueue();
		st.enqueue(13);
		assertEquals(13, st.peek());
		
	}
	
	@Test
	public void testCopyConstructor() {
		ListQueue st = new ListQueue();
		st.enqueue(1);
		st.enqueue(2);
		st.enqueue(3);
		ListQueue st2 = new ListQueue(st);
		assertEquals(true, st.equals(st2));
		
	}
	
	@Test
	public void testenqueueListQueue() {
		
		ListQueue st = new ListQueue();
		st.enqueue(1);
		st.enqueue(2);
		st.enqueue(3);
		st.enqueue(4);
		ListQueue st2 = new ListQueue(st);
		st2.enqueue(11);
		st2.enqueue(12);
		
		assertEquals(6, st2.elements());
		
	}
	
	@Test
	public void testenqueueListQueueToString() {
		
		ListQueue st = new ListQueue();
		st.enqueue(1);
		st.enqueue(2);
		st.enqueue(3);
		st.enqueue(4);
		ListQueue st2 = new ListQueue(st);
		st2.enqueue(11);
		st2.enqueue(12);
		
		assertEquals("Node 1 contains the Value 1"+"\n"+
				"Node 2 contains the Value 2"+"\n"+
				"Node 3 contains the Value 3"+"\n"+
				"Node 4 contains the Value 4"+"\n"+
				"Node 5 contains the Value 11"+"\n"+
				"Node 6 contains the Value 12", st2.toString());
		
	}
	
	
	@Test
	public void testEuqualsTrue() {
		
		ListQueue st = new ListQueue();
		ListQueue st2 = new ListQueue();
		st.enqueue(1);
		st.enqueue(2);
		st.enqueue(3);
		st2.enqueue(1);
		st2.enqueue(2);
		st2.enqueue(3);
		
		assertEquals(true, st.equals(st2));
		
	}
	
	@Test
	public void testEuqualsFalse() {
		
		ListQueue st = new ListQueue();
		ListQueue st2 = new ListQueue();
		st.enqueue(1);
		st.enqueue(2);
		st.enqueue(3);
		st2.enqueue(1);
		st2.enqueue(2);
		st2.enqueue(4);
		
		assertEquals(false, st.equals(st2));
		
	}
	

	@Test
	public void testdequeue() {
		
		ListQueue st = new ListQueue();
		st.enqueue(13);
		assertEquals(13, st.dequeue());
		
	}
	
	@Test
	public void testdequeueEmptyListQueue() {
		
		ListQueue st = new ListQueue();
		assertEquals(Integer.MIN_VALUE, st.dequeue());
		
	}
	


	@Test
	public void testPeek() {
		
		ListQueue st = new ListQueue();
		st.enqueue(11);
		assertEquals(11, st.peek());
		
	}
	
	@Test
	public void testPeekEmptyListQueue() {
		
		ListQueue st = new ListQueue();
		assertEquals(Integer.MIN_VALUE, st.peek());
		
	}

	@Test
	public void testElements() {
		
		ListQueue st = new ListQueue();
		st.enqueue(3);
		st.enqueue(5);
		st.enqueue(2);
		st.enqueue(6);
		assertEquals(4, st.elements());
		
	}
	
	@Test
	public void testElementsZero() {

		ListQueue st = new ListQueue();
		assertEquals(0, st.elements());
	
	}

	
	@Test
	public void testSearchTrue() {
		
		ListQueue st = new ListQueue();
		st.enqueue(3);
		st.enqueue(5);
		st.enqueue(2);
		st.enqueue(6);
		assertEquals(true, st.search(2));
		
	}
	
	@Test
	public void testSearchFalse() {
		
		ListQueue st = new ListQueue();
		st.enqueue(3);
		st.enqueue(5);
		st.enqueue(2);
		st.enqueue(6);
		assertEquals(false, st.search(4));
		
	}
	
	@Test
	public void testSearchEmpty() {
		
		ListQueue st = new ListQueue();
		assertEquals(false, st.search(4));
		
	}

	@Test
	public void testToString() {
		
		ListQueue st = new ListQueue();
		st.enqueue(10);
		st.enqueue(11);
		st.enqueue(12);
		assertEquals("Node 1 contains the Value 10"+"\n"+
				"Node 2 contains the Value 11"+"\n"+
				"Node 3 contains the Value 12"
				, st.toString());
		
	}
	
	@Test
	public void testToStringEmptyListQueue() {
		
		ListQueue st = new ListQueue();
		assertEquals("No Nodes in that list!", st.toString());
		
	}


}
