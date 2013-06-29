package at.fhhgb.mc.uebung02;

/**
 * This class generates a Queue Object.
 * 
 * The Queue can be filled with Integer values and works with the FIFO 
 * (first in first out) concept. 
 * It's possible to display the elements and the size of the Queue.
 * 
 * In this class the queue(Array) positions for the elements are defined by different
 * pointers. If an element is deleted or enqueued the pointers will move accordingly.
 * If the Array reaches its last position, it will continue to insert elements at the beginning, 
 * if there have been already removed elements. 
 * 
 * @author Michael Nigl
 * @version 1.0
 *
 */
public class Queue {
	
	private int[] queue;
	private int zeromark = 0; //starting element of the queue
	private int pointer = 0; //next free position in the queue
	private int counter = 0; //counts element inputs
	private int value;
	
	
	/**
	 * Initializes the queue instance 
	 * @param size - the number of elements the Queue can contain
	 */
	public void initQueue(int size) { 
		
		if(size <= 0){
	    	
    		queue = new int[20];
    	
    	}else{
    		
    		queue = new int[size];
    	
    	}
		
	}
	
	/** 
	 * Clears all elements from the queue by resetting the positions of the pointers and the counter
	 */
	public void clear() { 
		
		pointer = 0; 
		zeromark = 0; 
		counter = 0; 
		
	}
	
	/** 
	 * Enqueues an element at the back of the queue 
	 *
	 * @param val - Is the new value pushed on the next empty place in the Queue
	 * @return - true, if val was successfully put into the Queue; false, if the Queue is full
	 */
	public boolean enqueue(int val) { 
		
		
		if(pointer == zeromark && counter != 0){
    		
    		return false;
    		
    	}else{
		
			queue[pointer] = val;
	    	counter++;
	    	pointer++;
	    	
	    	if(pointer == queue.length){
	    		
	    		pointer = 0;
	    		
	    	}
    	
	    	return true;
	    	
    	}
    	
		
	}
	
	/** 
	 * Dequeues the element at the front of the queue 
	 * 
	 * @return value - the removed element from the Queue, or IntegerMinValue if the Queue is empty
	 */
	public int dequeue() { 
		
		if(pointer == zeromark && counter == 0){
		
			value = Integer.MIN_VALUE;
			
		}else{
			
	    	value = queue[zeromark];
	    	zeromark ++;
	    	counter --;
	    	
	    	if(zeromark == queue.length){
	    		
	    		zeromark = 0;
	    		
	    	}
    		    	
		}
		
    	return value;
		
	}
	
	/** 
	 * Returns the front element of the queue without removing it 
	 * 
	 * @return value - the element in the first position of the Queue, or IntegerMinValue if the Queue is empty
	 */
	public int peek() { 
		
		
		if(pointer == zeromark && counter == 0){
			
			value = Integer.MIN_VALUE;
			
		}else{
			
			value = queue[zeromark];
			
		}
		
		return value;
		
	}
	
	/** 
	 * Returns the number of elements in the queue 
	 * 
	 * @return value - the number of elements in the Queue
	 */
	public int elements() { 
		
		if(zeromark <= pointer && counter < queue.length){
			
			value = pointer - zeromark;
			
		}else if(counter == queue.length){
			
			value = counter;
			
		}else{
			
			value = queue.length - (zeromark - pointer);
			
		}
		
		return value;
		
	}

	/** 
	 * Returns the maximum size of the queue 
	 * 
	 * @return value - the number of elements the Queue can contain
	 */
	public int size() { 
		
		value = queue.length;
		
		return value;
		
	}
	
	/** 
	 * Prints all elements in the queue 
	 */
	public void print() { 
		
		int element = zeromark;
				
		System.out.println("This Queue contains following elements: ");
		
		for(int i = 0;i<counter;i++){
						
			System.out.print(queue[element]);
			
			element ++;
			
			if(element == queue.length){
				
				element = 0;
				
			}
			
			
			if((i+1) != counter){
				
				System.out.print(", ");

			}else{
				
				System.out.println("");
				
			}
			
		}
		
	}
}