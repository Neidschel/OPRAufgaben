package at.fhhgb.mc.uebung01;

import static org.junit.Assert.*;

import org.junit.Test;

import at.fhhgb.mc.uebung01.Stack;

public class StackTest {

	
	
	@Test
	public void testInitStack() {
			
		Stack st = new Stack();
		st.initStack(20);
		assertEquals(20, st.size());
		
		
	}
	
	@Test
	public void testInitNegativeStack() {
		
		Stack st = new Stack();
		st.initStack(-4);
		assertEquals(20, st.size());
		
	}

	@Test
	public void testClear() {
		
		Stack st = new Stack();
		st.initStack(20);
		st.clear();
		assertEquals(0, st.elements());
		
	}
	
	
	@Test
	public void testPush() {
		
		Stack st = new Stack();
		st.initStack(20);
		assertEquals(true, st.push(13));
		
	}
	
	
	@Test
	public void testPushValue() {
		
		Stack st = new Stack();
		st.initStack(20);
		st.push(13);
		assertEquals(13, st.peek());
		
	}
	
	@Test
	public void testPushFullStack() {
		
		Stack st = new Stack();
		st.initStack(3);
		st.push(13);
		st.push(13);
		st.push(13);
		assertEquals(false, st.push(2));
		
	}
	

	@Test
	public void testPop() {
		
		Stack st = new Stack();
		st.initStack(20);
		st.push(13);
		assertEquals(13, st.pop());
		
	}
	
	@Test
	public void testPopEmptyStack() {
		
		Stack st = new Stack();
		st.initStack(20);
		assertEquals(Integer.MIN_VALUE, st.pop());
		
	}

	@Test
	public void testPeek() {
		
		Stack st = new Stack();
		st.initStack(20);
		st.push(11);
		assertEquals(11, st.peek());
		
	}
	
	@Test
	public void testPeekEmptyStack() {
		
		Stack st = new Stack();
		st.initStack(20);
		assertEquals(Integer.MIN_VALUE, st.peek());
		
	}

	@Test
	public void testElements() {
		
		Stack st = new Stack();
		st.initStack(20);
		st.push(3);
		st.push(5);
		st.push(2);
		st.push(6);
		assertEquals(4, st.elements());
		
	}

	@Test
	public void testSize() {
		
		Stack st = new Stack();
		st.initStack(28);
		assertEquals(28, st.size());
		
	}

	@Test
	public void testPrint() {
		
		Stack st = new Stack();
		st.initStack(20);
		st.push(10);
		st.push(11);
		st.push(12);
		st.print();
		
	}
	
	@Test
	public void testPrintEmpty() {
		
		Stack st = new Stack();
		st.initStack(20);
		st.print();
		
	}

}
