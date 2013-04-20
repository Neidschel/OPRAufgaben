package at.fhhgb.mc.uebung04;

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
 * Queue's can now be merged and cloned.
 * 
 * Furthermore the queue can be searched for containing elements.
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
	* Constructor initializes queue with a standard size. 
	*/
	public Queue() { 
		
		queue = new int[20];
		
	}
	
	/**
	 * Constructor initializes queue with the given size. 
	 * @param size - the number of elements the Queue can contain
	 */
	public Queue(int size) { 
		
		if(size <= 0){
	    	
    		queue = new int[20];
    	
    	}else{
    		
    		queue = new int[size];
    	
    	}
		
	}
	
	/**
	 * Constructor initializes Queue with another Queue. Size and containing elements of the 
	 * other Queue are copied.
	 * 
	 * @param other - the other Queue used for initializing
	 */
	public Queue(Queue other) { 
		
		
		
		queue = new int[other.size()];
		
		int element = other.zeromark;
		
		for(int i = 0;i<other.counter;i++){
			
			queue[i] = other.queue[element]; 
			
			element ++;
			pointer ++;
			counter ++;
			
			if(element == other.queue.length){
				
				element = 0;
				
			}
		}
		
	}
	
	/**
	* Sets the queue array to null;
	* This method is usually automatically used by the GarbageCollection if an Object is removed.
	*/
	protected void finalize() { 
		
		queue = null;
		
	}

	/**
	 * Clones this Queue instance and returns an exact COPY. 
	 * 
	 * @return - qu2, an exact copy of the Queue
	 */
	public Queue clone() { 
		
		Queue qu2 = new Queue(this.size());
		qu2.enqueue(this);
		
		return qu2;
		
	}
	
	/**
	 * Compares the Queue of this and another Queue Object. The Queue is equal if 
	 * the containing elements are the same on the same position. Position means the relative position! The 
	 * first element of the first queue has to be the the same first element of the second queue, but 
	 * those first positions can be different. (different values in the "zeromark" variable)
	 * 
	 * Maximum size of both Queue's doesn't matter.
	 * 
	 * @param other - another Queue Object for comparison.
	 * @return false, if there are different elements;.true, if all elements are the same on the same reltative positions
	 */
	public boolean equals(Queue other) { 
		
		if(elements() == other.elements()){
			
			int compare1 = zeromark;
			int compare2 = other.zeromark;
			
			
			for(int i = 0; i < other.elements(); i++){
				
				if(queue[compare1] != other.queue[compare2]){
					
					return false;
					
				}
				
				compare1++;
				compare2++;
				
				//Both if's are checking if the Queue elements are continuing at the beginning of the array
				if(compare1 == queue.length){
					
					compare1 = 0;
					
				}
				
				if(compare2 == other.queue.length){
					
					compare2 = 0;
					
				}
				
			}
		}else{
			
			return false;
			
		}
		
		return true;
		
	}
		
	
	

	/**
     * Checks if an element is in the queue or not.
     * 
     * @param val - the search value
     * @return true if the element val exists in the queue; false otherwise. 
     */
	public boolean search(int val) { 
		
		int element = zeromark;
		
		for(int i = 0;i<counter;i++){
			
			if(queue[element] == val){
				
				return true;	
				
			}
			
			element++;
			
			if(element == queue.length){
				
				element = 0;
				
			}
			
		}
		
		return false;
		
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
	 * Enqueues all elements from another queue at the end of this one. The elements of the other queue are not changed!
	 * 
	 * @param other - the other Queue added to this one
	 * @return false, if the size of this queue isn'b big enough;.true, if all elements 
	 * were successfully enqueued.
	 */
	public boolean enqueue(Queue other) { 
		
		int element = other.zeromark;
		
		if(elements() + other.elements() <= size()){
			
			for(int i = 0; i < other.elements();i++){
				
				queue[pointer] = other.queue[element];
				pointer ++;
				element++;
				counter++;
				
				if(pointer == queue.length){
		    		
		    		pointer = 0;
		    		
		    	}
				
				if(element == other.queue.length){
		    		
		    		pointer = 0;
		    		
		    	}
	    	
				
			}
			
			return true;
			
		}else{
			
			return false;
			
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
	 * 
	 *  (not sure if it had to be deleted or not?)
	 
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
		
	}*/
	
	/**
	 * Returns a string representation of the queue. 
	 * 
	 * @return output - all Elements in the Queue are in FIFO Order displayed
	 */
	public String toString() { 
		
		StringBuilder output = new StringBuilder();
		int element = zeromark;
		
		if(counter != 0){
			
			output.append("This Queue contains: ");
			
			for(int i = 0;i<counter;i++){
				
				output.append(queue[element]);
				
				element ++;
				
				if(element == queue.length){
					
					element = 0;
					
				}
				
				
				if((i+1) != counter){
					
					output.append(", ");

				}else{
					
					output.append("");
					
				}
				
			}
			
		}else{
			
			output.append("This Queue is Empty!");
			
		}
		
		return output.toString();
		
	}
		
}
	
