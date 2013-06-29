package at.fhhgb.mc.uebung03;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackTest {

	@Test
	public void testStack() {
			
		Stack st = new Stack();
		assertEquals(20, st.size());
		
		
	}
	
	@Test
	public void testNegativeStack() {
		
		Stack st = new Stack(-4);
		assertEquals(20, st.size());
		
	}

	@Test
	public void testClear() {
		
		Stack st = new Stack(20);
		st.clear();
		assertEquals(0, st.elements());
		
	}
	
	@Test
	public void testFinalize() {
		
		Stack st = new Stack(20);
		st.finalize();
		//System.out.println(st.size());	--> NullPointer Exception	
	}
	
	
	@Test
	public void testPush() {
		
		Stack st = new Stack(20);
		assertEquals(true, st.push(13));
		
	}
	
	
	@Test
	public void testPushValue() {
		
		Stack st = new Stack(20);
		st.push(13);
		assertEquals(13, st.peek());
		
	}
	
	@Test
	public void testPushFullStack() {
		
		Stack st = new Stack(3);
		st.push(13);
		st.push(13);
		st.push(13);
		assertEquals(false, st.push(2));
		
	}
	
	@Test
	public void testPushStack() {
		
		Stack st = new Stack(5);
		Stack st2 = new Stack(8);
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		st2.push(11);
		st2.push(12);
		
		assertEquals(true, st2.push(st));
		
	}
	
	@Test
	public void testCopyConstructor() {
		Stack st = new Stack(5);
		st.push(1);
		st.push(2);
		st.push(3);
		Stack st2 = new Stack(st);
		assertEquals(true, st.equals(st2));
		
	}
	
	@Test
	public void testPushStackFullStack() {
		
		Stack st = new Stack(5);
		Stack st2 = new Stack(4);
		st.push(1);
		st.push(2);
		st.push(3);
		st2.push(11);
		st2.push(12);

		assertEquals(false, st2.push(st));
		
	}
	
	@Test
	public void testPushStackToString() {
		
		Stack st = new Stack(8);
		Stack st2 = new Stack(5);
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		st2.push(11);
		st2.push(12);
		st.push(st2);
		
		assertEquals("This Stack contains: 12, 11, 4, 3, 2, 1", st.toString());
		
	}
	
	
	@Test
	public void testEuqualsTrue() {
		
		Stack st = new Stack(5);
		Stack st2 = new Stack(5);
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
		
		Stack st = new Stack(5);
		Stack st2 = new Stack(5);
		st.push(1);
		st.push(2);
		st.push(3);
		st2.push(1);
		st2.push(2);
		st2.push(4);
		
		assertEquals(false, st.equals(st2));
		
	}
	
	@Test
	public void testEuqualsFalseDifferentSize() {
		
		Stack st = new Stack(5);
		Stack st2 = new Stack(8);
		st.push(1);
		st.push(2);
		st.push(3);
		st2.push(1);
		st2.push(2);
		st2.push(3);
		
		assertEquals(true, st.equals(st2));
		
	}
	
	@Test
	public void testClone() {
		
		Stack st = new Stack(20);
		st.push(12);
		st.push(13);
		st.push(14);		
		Stack st2 = st.clone();
		assertEquals(true, st.equals(st2));
		
	}

	@Test
	public void testPop() {
		
		Stack st = new Stack(20);
		st.push(13);
		assertEquals(13, st.pop());
		
	}
	
	@Test
	public void testPopEmptyStack() {
		
		Stack st = new Stack(20);
		assertEquals(Integer.MIN_VALUE, st.pop());
		
	}
	


	@Test
	public void testPeek() {
		
		Stack st = new Stack(20);
		st.push(11);
		assertEquals(11, st.peek());
		
	}
	
	@Test
	public void testPeekEmptyStack() {
		
		Stack st = new Stack(20);
		assertEquals(Integer.MIN_VALUE, st.peek());
		
	}

	@Test
	public void testElements() {
		
		Stack st = new Stack(20);
		st.push(3);
		st.push(5);
		st.push(2);
		st.push(6);
		assertEquals(4, st.elements());
		
	}
	
	@Test
	public void testElementsZero() {

		Stack st = new Stack(20);
		assertEquals(0, st.elements());
	
	}

	@Test
	public void testSize() {
		
		Stack st = new Stack(28);
		assertEquals(28, st.size());
		
	}
	
	@Test
	public void testSearchTrue() {
		
		Stack st = new Stack(5);
		st.push(3);
		st.push(5);
		st.push(2);
		st.push(6);
		assertEquals(true, st.search(2));
		
	}
	
	@Test
	public void testSearchFalse() {
		
		Stack st = new Stack(5);
		st.push(3);
		st.push(5);
		st.push(2);
		st.push(6);
		assertEquals(false, st.search(4));
		
	}
	
	@Test
	public void testSearchEmpty() {
		
		Stack st = new Stack(5);
		assertEquals(false, st.search(4));
		
	}

	@Test
	public void testToString() {
		
		Stack st = new Stack(20);
		st.push(10);
		st.push(11);
		st.push(12);
		assertEquals("This Stack contains: 12, 11, 10", st.toString());
		
	}
	
	@Test
	public void testToStringEmptyStack() {
		
		Stack st = new Stack(20);
		assertEquals("This Stack is Empty!", st.toString());
		
	}

}

