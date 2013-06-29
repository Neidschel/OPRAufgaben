package at.fhhgb.mc.Aufgabe01;

import static org.junit.Assert.assertEquals;
/**
 * This class is a functional representation of a Double Linked List. A DDL is List where every Node 
 * has pointers to the next and previous element in the list. Elements can be put in and removed from
 * the front and the back of the list. 
 * Furthermore all elements can be deleted and the order of all Elements can be reversed.
 * 
 * @author Michael Nigl
 * @version 1.0
 */

public class DoubleLinkedList {

	//Pointer to the first and last element of the list
	private DLNode head, tail;
		    
	/**
	 * Initializes the double linked list instance. By setting head and tail to null.
	 */
	public void initDoubleLinkedList(){ 
		
		head = null;
		tail = null;
		
			
	}
	
	/** 
	 * Clears all elements from the linked list. All Pointer and the head and tail are set to null.
	 */
	public void clear() { 
		DLNode p;
		p = head;
		
		while(p!=null){
			
			DLNode tmp = new DLNode();
			tmp = p.getNext();
			p.setPrev(null);
			p.setNext(null);
			p = null;
			p = tmp;			
			
		}
		
		head = tail = null; 
				
	}
	
	/** 
	 * Adds an element at the front of the linked list. Therefore is a new Node object created.
	 * 
	 * @param val - the value for the new Node object
	 */
	public void pushFront(int val) { 
		
		DLNode n = new DLNode();
		n.setVal(val);
		
		if(head == null){
			
			head = n;
			tail = n;
			
		}else{
			
			n.setNext(head);
			head.setPrev(n);
			head = n;
			
		}
		
	}
	
	/** 
	 * Adds an element at the back of the linked list. Therefore is a new Node object created.
	 * 
	 * @param val - the value for the new Node object
	 */
	public void pushBack(int val) { 
		
		DLNode n = new DLNode();
		n.setVal(val);
		
		if(head == null){
		
			head = n;
			tail = n;
			
		}else{
			
			tail.setNext(n);
			n.setPrev(tail);
			tail = n;
			
		}
		
		
	}
	/** 
	 * Removes and returns the front element of the linked list. 
	 * Returns Integer.MIN_VALUE if empty
	 * 
	 * @return val - the removed value at the front of the list
	 */
	public int popFront() { 
		
		if(head == null){
			
			return Integer.MIN_VALUE;
			
		}else{
			
			int val = head.getVal();
			head = head.getNext();
			
			//needed to catch an NullPointerException if only one element is in the list
			if(head != null){
				head.setPrev(null);
			}else{
				
				tail = null;
				
			}
			
			return val;
			
		}	
		
	}
	
	/** 
	 * Returns the front element of the list without removing it. 
	 * Returns Integer.MIN_VALUE if empty
	 * 
	 * @return val -  the value at the front of the list
	 */
	public int peekFront() { 
		
		if(head == null){
			
			return Integer.MIN_VALUE;
			
		}else{
			
			int val = head.getVal();
			return val;
			
		}	
		
	}
		
	/** 
	 * Removes and returns the element from the back of the linked list. 
	 * Returns Integer.MIN_VALUE if empty
	 * 
	 * @return val - the removed value at the back of the list
	 */
	public int popBack() { 
		
		if(head == null){
			
			return Integer.MIN_VALUE;
			
		}else{
			
			int val = tail.getVal();
			tail = tail.getPrev();
			
			if(tail!=null){
				tail.setNext(null);
			}
			
			return val;
			
		}	
		
		
	}
		
	/** 
	 * Returns the element at the back of the list without removing it. 
	 * Returns Integer.MIN_VALUE if empty 
	 * 		
	 * @return val - the value at the back of the list
	 */
	public int peekBack() { 
		
		if(head == null){
			
			return Integer.MIN_VALUE;
			
		}else{
			
			int val = tail.getVal();
			return val;
			
		}	
		
	}
	
	/** 
	 * Returns the number of elements in the double linked list 
	 * 
	 * @return counter - the number of nodes in the list.
	 */
	public int elements() { 
		
		if(head == null){
			
			return Integer.MIN_VALUE;
			
		}else{
			
			DLNode n = head;
			int counter = 0;
			while(n!=null){
				
				n = n.getNext();
				counter++;
				
			}
			
			return counter;
			
		}	
		
	
	}
	
	
	/**
	 *  Reverses the order of all elements in the list. 
	 */
	public void reverse() { 
		
		if(head != null){	
			
			DLNode n = head;
			DLNode p = tail;
			DLNode h = p;

			while(p!=null){
				
				DLNode tmp = new DLNode();
				tmp = p;
				
				p = p.getPrev();

				tmp.setPrev(tmp.getNext());
				tmp.setNext(p);
				
				
			}
			
			head = h;
			tail = n;
			
		}			
		
	}
	
}
