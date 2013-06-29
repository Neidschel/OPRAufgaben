package at.fhhgb.mc.uebung02;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueTest {

	@Test
	public void testInitQueue() {
		
		Queue qu = new Queue();
		qu.initQueue(20);
		assertEquals(20, qu.size());
		
	}
	
	@Test
	public void testInitNegativeQueue() {
		
		Queue qu = new Queue();
		qu.initQueue(-4);
		assertEquals(20, qu.size());
		
	}

	@Test
	public void testClear() {

		Queue qu = new Queue();
		qu.initQueue(20);
		qu.clear();
		assertEquals(0, qu.elements());
	
	}

	@Test
	public void testEnqueue() {

		Queue qu = new Queue();
		qu.initQueue(20);
		assertEquals(true, qu.enqueue(5));
	
	}
	
	@Test
	public void testEnqueueValue() {

		Queue qu = new Queue();
		qu.initQueue(20);
		qu.enqueue(5);
		assertEquals(5, qu.peek());
	
	}
	
	@Test
	public void testEnqueueFullQueue() {

		Queue qu = new Queue();
		qu.initQueue(3);
		qu.enqueue(5);
		qu.enqueue(6);
		qu.enqueue(7);
		assertEquals(false, qu.enqueue(8));
	
	}

	@Test
	public void testDequeue() {

		Queue qu = new Queue();
		qu.initQueue(20);
		qu.enqueue(5);
		assertEquals(5, qu.dequeue());
		
	}
	
	@Test
	public void testDequeueEmptyQueue() {

		Queue qu = new Queue();
		qu.initQueue(20);
		assertEquals(Integer.MIN_VALUE, qu.dequeue());
		
	}

	@Test
	public void testPeek() {
		
		Queue qu = new Queue();
		qu.initQueue(20);
		qu.enqueue(5);
		qu.enqueue(6);
		qu.enqueue(7);
		assertEquals(5, qu.peek());
		
	}
	
	@Test
	public void testPeekEmptyQueue() {
		
		Queue qu = new Queue();
		qu.initQueue(20);
		assertEquals(Integer.MIN_VALUE, qu.peek());
		
	}

	@Test
	public void testElements() {

		Queue qu = new Queue();
		qu.initQueue(20);
		qu.enqueue(5);
		qu.enqueue(6);
		qu.enqueue(7);
		assertEquals(3, qu.elements());
	
	}
	
	@Test
	public void testElementsZero() {

		Queue qu = new Queue();
		qu.initQueue(20);
		assertEquals(0, qu.elements());
	
	}
	
	@Test
	public void testElementsInfinite() {

		Queue qu = new Queue();
		qu.initQueue(3);
		qu.enqueue(5);
		qu.enqueue(6);
		qu.enqueue(7);
		qu.dequeue();
		qu.dequeue();
		qu.enqueue(8);
		assertEquals(2, qu.elements());
	
	}

	@Test
	public void testSize() {
		
		Queue qu = new Queue();
		qu.initQueue(20);
		assertEquals(20, qu.size());
		
	}

	@Test
	public void testPrint() {
		
		Queue qu = new Queue();
		qu.initQueue(20);
		qu.enqueue(5);
		qu.enqueue(6);
		qu.enqueue(7);
		qu.enqueue(8);
		qu.print();
		
	}
	
	@Test
	public void testPrintInfinite() {
		
		Queue qu = new Queue();
		qu.initQueue(3);
		qu.enqueue(5);
		qu.enqueue(6);
		qu.enqueue(7);
		qu.dequeue();
		qu.dequeue();
		qu.enqueue(8);
		qu.print();
		
	}

}
