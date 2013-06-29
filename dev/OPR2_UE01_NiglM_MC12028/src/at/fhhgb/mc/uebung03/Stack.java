package at.fhhgb.mc.uebung03;

/**
 * This class generates a Stack Object and is a rework from the first stack class in the
 * package "at.fhhgb.mc.uebung01" with additional methods.
 * 
 * The Stack can be filled with Integer values and works with the LIFO 
 * (last in first out) concept. 
 * 
 * It's possible to display the elements and the size of the Stack.
 * 
 * Stacks can now be merged and cloned.
 * 
 * Furthermore the Stack can be searched for containing elements.
 * 
 * 
 * @author Michael Nigl
 * @version 1.0
 *
 */
public class Stack{
	
	private int[] stack;
	private int pointer = 0;
	private int value;
	
	
	/**
	 * * Constructor initializes stack with a standard size.
	 */
	public Stack() { 
		
		stack = new int[20]; //default size
		
	}
	/**
	 * Constructor initializes stack with the given size. 
	 * 
	 * @param size - the number of elements the stack can contain
	 */ 
	public Stack(int size) { 
		
		if(size <= 0){
	    	
    		stack = new int[20]; //default size
    	
    	}else{
    		
    		stack = new int[size];
    	
    	}
		
	}
	/**
	 * Constructor initializes stack with another Stack. Size and containing elements of the 
	 * other Stacks are copied.
	 * 
	 * @param other - the other Stack used for initializing
	 */
	public Stack(Stack other) { 
		
		stack = new int[other.size()];
		
		for(int i = 0; i < other.elements(); i++){
			
			stack[i] = other.stack[i];
			
		}
		
	}
	/**
	* Sets the stack array to null;
	* This method is usually automatically used by the GarbageCollection if an Object is removed.
	*/
	protected void finalize() { 
		
		stack = null;
		
	}
	
	

	/**
	 * Clones this Stack instance and returns an exact COPY. 
	 * 
	 * @return - st2, an exact copy of the stack
	 */
	public Stack clone() { 
		
		Stack st2 = new Stack(this.size());
		st2.push(this);
		
		return st2;
		
	}
	
	/**
	 * Compares the Stacks of this and another Stack Object. The Stack is equal if 
	 * the containing elements are the same on the same position. Maximum size of both Stacks doesn't matter.
	 * 
	 * @param other - another Stack Object for comparison.
	 * @return false, if there are different elements;.true, if all elements are the same on the same positions
	 */
	public boolean equals(Stack other) {
		
		if(elements() == other.elements()){
			for(int i = 0; i < other.elements(); i++){
				
				if(stack[i] != other.stack[i]){
					
					return false;
				}
				
			}
		}else{
			
			return false;
			
		}
		
		return true;
		
	}

	
	
	  /**
     * Clears all elements from the stack by resetting the position of the pointer.
     */
    public void clear() { 
    	
    	pointer = 0;
    	
    }
    
    /**
     * Pushes an element onto the stack
     * 
     * @param val - Is the new value pushed on the next empty place on the stack
     * @return - true, if val was successfully pushed onto the stack; false, if the stack is full
     */
    public boolean push(int val) { 
    	
    
    	
    	if(pointer == stack.length){
    		
    		return false;
    		
    	}else{
    		
    		stack[pointer] = val;
        	
        	pointer++;
        	
        	return true;
    		
    	}
    	
    }
    
    
	/**
	 * Pushes all elements from another stack onto this one. The elements of the other stack are not changed!
	 * 
	 * @param other - the other Stack added to this one
	 * @return false, if the size of this stack isn'b big enough;.true, if all elements 
	 * were successfully pushed.
	 */
	public boolean push(Stack other) {
		
		if(elements() + other.elements() <= size()){
		
			for(int i = 0; i < other.elements();i++){
				
				stack[pointer] = other.stack[i];
				pointer ++;
				
			}
			
			return true;
			
		}else{
			
			return false;
			
		}
		
		
	}
    
    /** 
     * Returns the top element of the stack and removes 
     * 
     * @return value - the removed element of the stack, or IntegerMinValue if the Stack is empty
     */
    public int pop(){ 
    	
    	
    	if(pointer != 0){
    		
	    	pointer--;
	    	value = stack[pointer];
    	
	    }else{
			
			value = Integer.MIN_VALUE;
			
		}
	
    	
    	return value;
    }
    
    /** 
     * Returns the top element of the stack without removing it
     * 
     * @return value - the top element of the stack, or IntegerMinValue if the Stack is empty
     */
    public int peek(){ 
    	if(pointer != 0){
    		
    		value = stack[pointer-1];
    	
    	}else{
    		
    		value = Integer.MIN_VALUE;
    		
    	}
    	
    	return value;
    }
    
    /** 
     * Returns the number of elements in the stack 
     * 
     * @return value - the number of elements in the stack
     */
    public int elements(){ 
    	
    	value = pointer;
    	
    	return value;
    	
    }
    
    /** 
     * Returns the maximum size of the stack 
     * 
     * @return value - the number of elements the stack can contain
     */
    public int size(){ 
    	
    	value = stack.length;
    	
    	return value;
    	
    }
    
    /**
     * Checks if an element is in the Stack or not.
     * 
     * @param val - the search value
     * @return true if the element val exists in the stack; false otherwise. 
     */
	public boolean search(int val) { 
		
		for(int i = 0;i<pointer;i++){
						
			if(stack[i] == val){
				
				return true;	
				
			}
			
		}
		
		return false;
		
	}
	
	/**
	 * Returns a string representation of the stack. 
	 * 
	 * @return output - all Elements of the Stack are in LIFO Order displayed
	 */
	public String toString() { 
		
		StringBuilder output = new StringBuilder();
		
		if(pointer != 0){
		
			output.append("This Stack contains: ");
			
			for(int i = pointer-1;i >= 0;i--){
				
				output.append(stack[i]);
				
				if(i != 0){
					
					output.append(", ");
				
				}
			
			
				
			}
		}else{
			
			output.append("This Stack is Empty!");
			
		}
		
		return output.toString();
		
	}
	
	
}
