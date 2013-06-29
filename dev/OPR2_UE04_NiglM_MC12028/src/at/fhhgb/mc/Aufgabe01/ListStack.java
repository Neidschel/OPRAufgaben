package at.fhhgb.mc.Aufgabe01;

/**
 * This class generates a Stack Object which extends from the DoubleLinkedList.
 * 
 * The Stack can be filled with Integer values and works with the LIFO 
 * (last in first out) concept. 
 * 
 * The Queue uses the DoubleLinkedList to store the elements in order.
 * 
 * 
 * @author Michael Nigl
 * @version 1.0
 *
 */
public class ListStack extends DoubleLinkedList{
	

	/**
	 * Initializes an empty stack by calling the 
	 * empty Constructor of the super class
	 */
	public ListStack() { 
		
		super();
		
	}
	
	/**
	 * Initializes an stack with another one by calling the 
	 * Constructor of the super class with the another list.
	 * 
	 * @param other - the other list
	 */
	public ListStack(ListStack other) { 
		
		super(other);
		
	}
	
	/**
     * Pushes an element onto the stack
     * 
     * @param val - Is the new value pushed onto the top on the stack
     */
	public void push(int val) { 
		
		pushFront(val);
		
	}
	

    /** 
     * Returns the top element of the stack and removes it
     * 
     * @return - the removed element of the stack, or IntegerMinValue if the Stack is empty
     */
	public int pop() { 
		
		
		return popFront();
		
	}
	
	/** 
     * Returns the top element of the stack without removing it
     * 
     * @return value - the top element of the stack, or IntegerMinValue if the Stack is empty
     */
	public int peek() { 
		
		return peekFront();
		
	}
	
}
