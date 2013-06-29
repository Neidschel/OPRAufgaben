package at.fhhgb.mc.uebung01;

/**
 * This class generates a Stack Object.
 * 
 * The Stack can be filled with Integer values and works with the LIFO 
 * (last in first out) concept. 
 * It's possible to display the elements and the size of the Stack.
 * 
 * @author Michael Nigl
 * @version 1.0
 *
 */
public class Stack {
    
	private int[] stack;
	private int pointer = 0;
	private int value;
	
	/** 
	 * Initializes the stack instance 
	 *  
	 * @param size - the number of elements the Stack can contain
	 */
    public void initStack(int size) { 
    	
    	if(size <= 0){
    	
    		stack = new int[20]; //default size
    	
    	}else{
    		
    		stack = new int[size];
    	
    	}
    	
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
     * Prints all elements in the stack in the LIFO order. 
     * Empty message if there are no elements. 
     */
    public void print(){ 
    	
    	if(pointer!=0){
    	
	    	System.out.println("This Stack contains following elements: ");
	    			
	    	for(int i = pointer-1;i >= 0;i--){
	    				
	    		System.out.print(stack[i]);
	    				
	    		if(i != 0){
	    					
	       			System.out.print(", ");
	
	   			}else{
	    					
					System.out.println("");
	    					
	   			}
	    				
	    	}	
    	}else{
    		
    		System.out.println("This Stack is empty!");
    		
    	}
    			
    	
    }
}
