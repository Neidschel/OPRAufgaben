package at.fhhgb.mc.Aufgabe01;

/**
 * This class generates a Queue Object which extends from the DoubleLinkedList.
 * 
 * The Queue can be filled with Integer values and works with the FIFO 
 * (first in first out) concept. 
 * It's possible to display the elements and the size of the Queue.
 * 
 * The Queue uses the DoubleLinkedList to store the elements in order.
 * 
 * @author Michael Nigl
 * @version 1.0
 *
 */
public class ListQueue extends DoubleLinkedList{
	
	/**
	 * Initializes an empty queue by calling the 
	 * empty Constructor of the super class
	 */
	public ListQueue() {
		
		super();
		
	}
	
	/**
	 * Initializes an queue with another one by calling the 
	 * Constructor of the super class with the another list.
	 * 
	 * @param other - the other list
	 */
	public ListQueue(ListQueue other) { 
		
		super(other);
		
	}
	
	/** 
	 * Enqueues an element at the back of the queue 
	 *
	 * @param val - Is the new value pushed on the back in the Queue
	 */
	public void enqueue(int val) { 
		
		pushBack(val);
		
	}
	
	/** 
	 * Removes and returns the element at the front of the linked list. 
	 * Returns Integer.MIN_VALUE if empty
	 * 
	 * @return - the removed value at the front of the queue
	 */
	public int dequeue() { 
		
		return popFront();
		
	}
	
	/** 
	 * Returns the front element of the queue without removing it. 
	 * Returns Integer.MIN_VALUE if empty
	 * 
	 * @return -  the value at the front of the queue
	 */
	public int peek() { 
		
		return peekFront();
		
	}
	
}
