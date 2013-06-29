package at.fhhgb.mc.Aufgabe01;


/**
 * This class is a functional representation of a Double Linked List. A DDL is List where every Node 
 * has pointers to the next and previous element in the list. Elements can be put in and removed from
 * the front and the back of the list. 
 * Furthermore all elements can be deleted and the order of all Elements can be reversed.
 * 
 * Other lists can be added at the end and the front of this one. Furthermore it's possible to compare
 * this list with another one and the list can be searched for containing values.
 * 
 * A String representation has been added to display every Node and it's containing element.
 * 
 * Every Node can contain a list instead of an Integer value. But it's not possible for a node
 * to contain both.
 * Most of the methods are rewritten in a recursive algorithm to address lists which are saved into nodes.
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
	public DoubleLinkedList() { 
		
		head = null;
		tail = null;
		
	}
	
	/**
	* This constructor initializes this list with another list.
	*/
	public DoubleLinkedList(DoubleLinkedList other) { 
		
		DoubleLinkedList dll = other.clone();
		
		head = dll.head;
		tail = dll.tail;
		
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
	* Deinitializes the object
	*/
	protected void finalize() { 
		
		head = null;
		tail = null;
		
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
	 * Adds a list at the front of the linked list.
	 * 
	 * @param other - the list which is added at the front of this one
	 */
	public void pushFront(DoubleLinkedList other) { 
		
		DLNode n = new DLNode();
		n = other.head;
		
		DLNode h = new DLNode();
		h.setVal(n.getVal());
		h.setNext(n.getNext());
		h.setPrev(n.getPrev());
		
		while(n!=null){
			
			DLNode p = new DLNode();
			p.setVal(n.getVal());
			p.setNext(n.getNext());
			p.setPrev(n.getPrev());
			n = n.getNext();
			
			if(n==null && head != null){
				
				p.setNext(head);
				head.setPrev(p);
				head = h;
				
				
			}
			
		}
	
		if(head == null){
		
			head = other.head;
			tail = other.tail;
		}
		
	}
	
	/**
	 * Adds another list to the first element of the first linked list if there's an Integer
	 * value in the head node. If there's a list the new list will be saved as the first node 
	 * of a sub list. (Repeated till the first element of a list contains an Integer value)
	 * 
	 * @param list - the list which is saved into a node of this list
	 */
	public void pushFrontRecursive(DoubleLinkedList list) { 
		

		if(head == null){
			
			DLNode n = new DLNode();
			n.setList(list.clone());
			head = n;
			tail = n;
			
		}else{
			
			if(head.getVal() != Integer.MIN_VALUE){
				
				DLNode n = new DLNode();
				n.setList(list);
				n.setNext(head);
				head.setPrev(n);
				head = n;
			}else{
				
				head.getList().pushFrontRecursive(list);
				
			}
			
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
	 * Adds a list at the back of the linked list.
	 * 
	 * @param other - the list which is added at the end of this one
	 */
	public void pushBack(DoubleLinkedList other) { 
		
		DLNode n = new DLNode();
		n = other.head;
		tail.setNext(n);
		n.setPrev(tail);
		
		while(n!=null){
			
			DLNode p = new DLNode();
			p.setVal(n.getVal());
			p.setNext(n.getNext());
			p.setPrev(n.getPrev());
			n = n.getNext();
			
			if(n==null){
				
				tail = p;
				
				
			}
			
		}
	
		if(head == null){
		
			head = other.head;
			tail = other.tail;
		}
		
	}
	
	/**
	 * Adds another list to the last element of the first linked list if there's an Integer
	 * value in the tail node. If there's a list, the new list will be saved as the last node 
	 * of a sub list. (Repeated till the last element of a list contains an Integer value)
	 * 
	 * @param list - the list which is saved into a node of this list
	 */
	public void pushBackRecursive(DoubleLinkedList list) { 
	    	  
		
		if(head == null){
			
			DLNode n = new DLNode();
			n.setList(list.clone());
			head = n;
			tail = n;
			
		}else{
			if(tail.getVal() != Integer.MIN_VALUE){
				
				DLNode n = new DLNode();
				n.setList(list.clone());
				tail.setNext(n);
				n.setPrev(tail);
				tail = n;
			
			}else{
				
				tail.getList().pushBackRecursive(list);
				
			}
			
		}
		
	    	  
	}
	
	/**
	* Clones this DoubleLinkedList instance
	* 
	* @return dll - an exact copy of this list
	*/
	public DoubleLinkedList clone() { 
		
		DoubleLinkedList dll = new DoubleLinkedList();
		
		DLNode n = new DLNode();
		n = head;
		
		while(n!=null){
			
			DLNode p = new DLNode();
			if(n.getVal()==Integer.MIN_VALUE){
				
				p.setList(n.getList().clone());
				
			}else{
				
				p.setVal(n.getVal());
				
			}
			
			p.setNext(n.getNext());
			p.setPrev(n.getPrev());
			n = n.getNext();
			
		}
		
		dll.head = head;
		dll.tail = tail;
		
		return dll;
	}
	
	
	/** 
	 * Removes and returns the front element of the linked list. 
	 * Returns Integer.MIN_VALUE if empty
	 * 
	 * @return val - the removed value at the front of the list
	 */
	public int popFront() { 
		
		int val = 0;
		
		if(head == null){
			
			val = Integer.MIN_VALUE;
			
		}else if(head.getVal() != Integer.MIN_VALUE){
			
			val = head.getVal();
			head = head.getNext();
			
			//needed to catch an NullPointerException if only one element is in the list
			if(head != null){
				head.setPrev(null);
			}else{
				
				tail = null;
				
			}
			
		}else{
			
			return head.getList().popFront();
			
		}
		
		return val;	
		
	}
	
	/** 
	 * Returns the front element of the list without removing it. 
	 * Returns Integer.MIN_VALUE if empty
	 * 
	 * @return val -  the value at the front of the list
	 */
	public int peekFront() { 
		
	int val = 0;
		
		if(head == null){
			
			val = Integer.MIN_VALUE;
			
		}else if(head.getVal() != Integer.MIN_VALUE){
			
			val = head.getVal();
			
		}else{
			
			return head.getList().peekFront();
			
		}
		
		return val;	
		
	}
		
	/** 
	 * Removes and returns the element from the back of the linked list. 
	 * Returns Integer.MIN_VALUE if empty
	 * 
	 * @return val - the removed value at the back of the list
	 */
	public int popBack() {
		
		int val = 0;
		
		if(head == null){
			
			val = Integer.MIN_VALUE;
			
		}else if(tail.getVal() != Integer.MIN_VALUE){
			
			val = tail.getVal();
			tail = tail.getPrev();
			
			if(tail!=null){
				tail.setNext(null);
			}
			
		}else{
			
			return tail.getList().popBack();
			
		}
		
		return val;	
		
		
	}
		
	/** 
	 * Returns the element at the back of the list without removing it. 
	 * Returns Integer.MIN_VALUE if empty 
	 * 		
	 * @return val - the value at the back of the list
	 */
	public int peekBack() { 
		
		int val = 0;
		
		if(head == null){
			
			val = Integer.MIN_VALUE;
			
		}else if(tail.getVal() != Integer.MIN_VALUE){
			
			val = tail.getVal();
		
		}else{
			
			return tail.getList().peekBack();
			
		}
		
		return val;
		
		
	}
	
	/**
	 * Checks if two lists are identical.
	 * 
	 * @param other - the other list compared with this one
	 * @return - true if the other list is equal to this one, false otherwise
	 */
	public boolean equals(DoubleLinkedList other) { 
		
		DLNode n = head;
		DLNode p = other.head;
		
		while(n!=null && p!=null){
			
			if(n.getVal() != Integer.MIN_VALUE){
				
				if(n.getVal() != p.getVal()){
					
					return false;
				
				}else{
					
					n = n.getNext();
					p = p.getNext();
					
				}
				
			}else{
				
				if(n.getVal()==p.getVal()){
					
					if(n.getList().equals(p.getList())==false){
						
						return false;
						
					}else{
						
						n = n.getNext();
						p = p.getNext();
						
					}
					
				}else{
					
					return false;
					
				}		
				
			}
			
		}
		
		if(n == null && p == null){
			
			return true;
			
		}else{
			
			return false;
			
		}

		
	}
	
	/**
	 * Searches the list for an value and checks if it exists.
	 * 
	 * @param val - the value which is searched in the list
	 * @return - true if the element val exists in the list, false otherwise
	 */
	public boolean search(int val) { 
		
		DLNode n = head;
		boolean check = false;
		
		while(n!=null){
					
			if(n.getVal() == Integer.MIN_VALUE){
				
				check = n.getList().search(val);
				
			}else{
				if(n.getVal() == val){
					
					check = true;
				
				}else{
					
					n = n.getNext();
					
				}
			}
			
			if(check==true){
				
				return check;
				
			}
			
		}
		
		return check;
		
	}
	
	/** 
	 * Returns the number of elements in the double linked list 
	 * 
	 * @return counter - the number of nodes in the list.
	 */
	public int elements() { 
		int counter = 0;
			
			DLNode n = head;
			//int counter = 0;
			while(n!=null){
				
				if(n.getVal() == Integer.MIN_VALUE){
					
					counter += n.getList().elements();

				}
				
				n = n.getNext();
				counter++;
				
			}
			
		return counter;
		
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
	
	
	/** 
	 * Returns a string representation of every Node of the entire list.
	 * Every sub level of a list is represented by on additional tabulator 
	 * formating.
	 * 
	 * @return output - a String representation of every Node
	 */
	public String toString() { 
		
		
		return toString(head,0);
	}
	
	private String toString(DLNode text,int level) { 
		
		StringBuilder output = new StringBuilder();
		if(text != null){
			
			DLNode n = text;
			int counter = 1;			
			
			while(n!=null){					
									
					if(level!=0){
						for(int i = 0; i < level;i++){
							
							output.append("\t");
							
						}
					}
					
					if(n.getVal() != Integer.MIN_VALUE){
						
						
						output.append("Node "+counter+" contains the Value "+n.getVal());
						
					}else{
						
						output.append("Node "+counter+" contains following List:"+"\n");
						output.append(toString(n.getList().head,level+1));

					}
				

				n = n.getNext();
				
				if(n!=null){
					output.append("\n");
					
				}
				
				
				counter++;
				
			}
		
		}else{
			
			output.append("No Nodes in that list!");
			
		}
		//output.append("\n");

		return output.toString();
		
	}
	
}
