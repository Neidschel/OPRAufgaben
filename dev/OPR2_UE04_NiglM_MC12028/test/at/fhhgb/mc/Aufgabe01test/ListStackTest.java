package at.fhhgb.mc.Aufgabe01test;

import static org.junit.Assert.*;

import org.junit.Test;

import at.fhhgb.mc.Aufgabe01.ListStack;

public class ListStackTest {

	@Test
	public void testListStack() {
			
		ListStack st = new ListStack();
		assertEquals(0, st.elements());
			
	}

	
	@Test
	public void testClear() {
		
		ListStack st = new ListStack();
		st.push(10);
		st.push(15);
		st.push(8);
		st.clear();
		assertEquals(0, st.elements());
		
	}
	
	@Test
	public void testPushValue() {
		
		ListStack st = new ListStack();
		st.push(13);
		assertEquals(13, st.peek());
		
	}
	
	@Test
	public void testCopyConstructor() {
		ListStack st = new ListStack();
		st.push(1);
		st.push(2);
		st.push(3);
		ListStack st2 = new ListStack(st);
		assertEquals(true, st.equals(st2));
		
	}
	
	@Test
	public void testPushListStack() {
		
		ListStack st = new ListStack();
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		ListStack st2 = new ListStack(st);
		st2.push(11);
		st2.push(12);
		
		assertEquals(6, st2.elements());
		
	}
	
	@Test
	public void testPushListStackToString() {
		
		ListStack st = new ListStack();
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		ListStack st2 = new ListStack(st);
		st2.push(11);
		st2.push(12);
		
		assertEquals("Node 1 contains the Value 12"+"\n"+
				"Node 2 contains the Value 11"+"\n"+
				"Node 3 contains the Value 4"+"\n"+
				"Node 4 contains the Value 3"+"\n"+
				"Node 5 contains the Value 2"+"\n"+
				"Node 6 contains the Value 1", st2.toString());
		
	}
	
	
	@Test
	public void testEuqualsTrue() {
		
		ListStack st = new ListStack();
		ListStack st2 = new ListStack();
		st.push(1);
		st.push(2);
		st.push(3);
		st2.push(1);
		st2.push(2);
		st2.push(3);
		
		assertEquals(true, st.equals(st2));
		
	}
	
	@Test
	public void testEuqualsFalse() {
		
		ListStack st = new ListStack();
		ListStack st2 = new ListStack();
		st.push(1);
		st.push(2);
		st.push(3);
		st2.push(1);
		st2.push(2);
		st2.push(4);
		
		assertEquals(false, st.equals(st2));
		
	}
	

	@Test
	public void testPop() {
		
		ListStack st = new ListStack();
		st.push(13);
		assertEquals(13, st.pop());
		
	}
	
	@Test
	public void testPopEmptyListStack() {
		
		ListStack st = new ListStack();
		assertEquals(Integer.MIN_VALUE, st.pop());
		
	}
	


	@Test
	public void testPeek() {
		
		ListStack st = new ListStack();
		st.push(11);
		assertEquals(11, st.peek());
		
	}
	
	@Test
	public void testPeekEmptyListStack() {
		
		ListStack st = new ListStack();
		assertEquals(Integer.MIN_VALUE, st.peek());
		
	}

	@Test
	public void testElements() {
		
		ListStack st = new ListStack();
		st.push(3);
		st.push(5);
		st.push(2);
		st.push(6);
		assertEquals(4, st.elements());
		
	}
	
	@Test
	public void testElementsZero() {

		ListStack st = new ListStack();
		assertEquals(0, st.elements());
	
	}

	
	@Test
	public void testSearchTrue() {
		
		ListStack st = new ListStack();
		st.push(3);
		st.push(5);
		st.push(2);
		st.push(6);
		assertEquals(true, st.search(2));
		
	}
	
	@Test
	public void testSearchFalse() {
		
		ListStack st = new ListStack();
		st.push(3);
		st.push(5);
		st.push(2);
		st.push(6);
		assertEquals(false, st.search(4));
		
	}
	
	@Test
	public void testSearchEmpty() {
		
		ListStack st = new ListStack();
		assertEquals(false, st.search(4));
		
	}

	@Test
	public void testToString() {
		
		ListStack st = new ListStack();
		st.push(10);
		st.push(11);
		st.push(12);
		assertEquals("Node 1 contains the Value 12"+"\n"+
				"Node 2 contains the Value 11"+"\n"+
				"Node 3 contains the Value 10"
				, st.toString());
		
	}
	
	@Test
	public void testToStringEmptyListStack() {
		
		ListStack st = new ListStack();
		assertEquals("No Nodes in that list!", st.toString());
		
	}


}
