package at.fhhgb.mc.uebung04;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueTest {

	@Test
	public void TestQueue() {
			
		Queue qu = new Queue();
		assertEquals(20, qu.size());
		
		
	}
	
	@Test
	public void TestNegativeQueue() {
		
		Queue qu = new Queue(-4);
		assertEquals(20, qu.size());
		
	}

	@Test
	public void TestClear() {
		
		Queue qu = new Queue(20);
		qu.clear();
		assertEquals(0, qu.elements());
		
	}
	
	
	@Test
	public void Testenqueue() {
		
		Queue qu = new Queue(20);
		assertEquals(true, qu.enqueue(13));
		
	}
	
	
	@Test
	public void TestEnqueueValue() {
		
		Queue qu = new Queue(20);
		qu.enqueue(13);
		assertEquals(13, qu.peek());
		
	}
	
	@Test
	public void TestEnqueueFullQueue() {
		
		Queue qu = new Queue(3);
		qu.enqueue(13);
		qu.enqueue(13);
		qu.enqueue(13);
		assertEquals(false, qu.enqueue(2));
		
	}
	
	@Test
	public void TestEnqueueQueue() {
		
		Queue qu = new Queue(8);
		Queue qu2 = new Queue(5);
		qu.enqueue(1);
		qu.enqueue(2);
		qu.enqueue(3);
		qu.enqueue(4);
		qu2.enqueue(11);
		qu2.enqueue(12);
		
		assertEquals(true, qu.enqueue(qu2));
		
	}
	
	@Test
	public void TestEnQueueQueueFullQueue() {
		
		Queue qu = new Queue(5);
		Queue qu2 = new Queue(4);
		qu.enqueue(1);
		qu.enqueue(2);
		qu.enqueue(3);
		qu2.enqueue(11);
		qu2.enqueue(12);

		assertEquals(false, qu2.enqueue(qu));
		
	}
	
	@Test
	public void TestEnqueueQueueToString() {
		
		Queue qu = new Queue(8);
		Queue qu2 = new Queue(5);
		qu.enqueue(1);
		qu.enqueue(2);
		qu.enqueue(3);
		qu.enqueue(4);
		qu2.enqueue(11);
		qu2.enqueue(12);
		qu.enqueue(qu2);
		
		assertEquals("This Queue contains: 1, 2, 3, 4, 11, 12", qu.toString());
		
	}
	
	@Test
	public void testFinalize() {
		
		Queue qu = new Queue(20);
		qu.finalize();
		//System.out.println(qu.size());	--> NullPointer Exception	
	}
	
	@Test
	public void TestEuqualsTrue() {
		
		Queue qu = new Queue(5);
		Queue qu2 = new Queue(5);
		qu.enqueue(1);
		qu.enqueue(2);
		qu.enqueue(3);
		qu2.enqueue(1);
		qu2.enqueue(2);
		qu2.enqueue(3);
		
		assertEquals(true, qu.equals(qu2));
		
	}
	
	@Test
	public void TestEuqualsFalse() {
		
		Queue qu = new Queue(5);
		Queue qu2 = new Queue(5);
		qu.enqueue(1);
		qu.enqueue(2);
		qu.enqueue(3);
		qu2.enqueue(1);
		qu2.enqueue(2);
		qu2.enqueue(4);
		
		assertEquals(false, qu.equals(qu2));
		
	}
	
	@Test
	public void TestEuqualsFalseDifferentSize() {
		
		Queue qu = new Queue(5);
		Queue qu2 = new Queue(8);
		qu.enqueue(1);
		qu.enqueue(2);
		qu.enqueue(3);
		qu2.enqueue(1);
		qu2.enqueue(2);
		qu2.enqueue(3);
		
		assertEquals(true, qu.equals(qu2));
		
	}
	
	@Test
	public void TestClone() {
		
		Queue qu = new Queue(20);
		qu.enqueue(12);
		qu.enqueue(13);
		qu.enqueue(14);		
		Queue qu2 = qu.clone();
		assertEquals(true, qu.equals(qu2));
		
	}

	@Test
	public void TestDequeue() {
		
		Queue qu = new Queue(20);
		qu.enqueue(13);
		assertEquals(13, qu.dequeue());
		
	}
	
	@Test
	public void TestDequeueEmptyQueue() {
		
		Queue qu = new Queue(20);
		assertEquals(Integer.MIN_VALUE, qu.dequeue());
		
	}
	


	@Test
	public void TestPeek() {
		
		Queue qu = new Queue(20);
		qu.enqueue(11);
		assertEquals(11, qu.peek());
		
	}
	
	@Test
	public void TestPeekEmptyQueue() {
		
		Queue qu = new Queue(20);
		assertEquals(Integer.MIN_VALUE, qu.peek());
		
	}

	@Test
	public void TestElements() {
		
		Queue qu = new Queue(20);
		qu.enqueue(3);
		qu.enqueue(5);
		qu.enqueue(2);
		qu.enqueue(6);
		assertEquals(4, qu.elements());
		
	}
	
	@Test
	public void testElementsZero() {

		Queue qu = new Queue();
		assertEquals(0, qu.elements());
	
	}
	
	@Test
	public void testElementsInfinite() {

		Queue qu = new Queue(3);;
		qu.enqueue(5);
		qu.enqueue(6);
		qu.enqueue(7);
		qu.dequeue();
		qu.dequeue();
		qu.enqueue(8);
		assertEquals(2, qu.elements());
	
	}

	@Test
	public void TestSize() {
		
		Queue qu = new Queue(28);
		assertEquals(28, qu.size());
		
	}
	
	@Test
	public void TestSearchTrue() {
		
		Queue qu = new Queue(5);
		qu.enqueue(3);
		qu.enqueue(5);
		qu.enqueue(2);
		qu.enqueue(6);
		assertEquals(true, qu.search(2));
		
	}
	
	@Test
	public void TestSearchFalse() {
		
		Queue qu = new Queue(5);
		qu.enqueue(3);
		qu.enqueue(5);
		qu.enqueue(2);
		qu.enqueue(6);
		assertEquals(false, qu.search(4));
		
	}
	
	@Test
	public void TestSearchEmpty() {
		
		Queue qu = new Queue(5);
		assertEquals(false, qu.search(4));
		
	}

	@Test
	public void TestToString() {
		
		Queue qu = new Queue(20);
		qu.enqueue(10);
		qu.enqueue(11);
		qu.enqueue(12);
		assertEquals("This Queue contains: 10, 11, 12", qu.toString());
		
	}
	
	@Test
	public void TestToStringEmptyQueue() {
		
		Queue qu = new Queue(20);
		assertEquals("This Queue is Empty!", qu.toString());
		
	}
	
	@Test
	public void testToStrinfInfinite() {
		
		Queue qu = new Queue(3);
		qu.enqueue(5);
		qu.enqueue(6);
		qu.enqueue(7);
		qu.dequeue();
		qu.dequeue();
		qu.enqueue(8);
		assertEquals("This Queue contains: 7, 8", qu.toString());		
	}

}
