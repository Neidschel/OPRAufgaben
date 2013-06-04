package at.fhhgb.mc.Aufgabe01;

import at.fhhgb.mc.interfaces.Iterator;

/**
 * This class is a functional representation of a Double Linked List. A DDL is
 * List where every Node has pointers to the next and previous element in the
 * list. Elements can be put in and removed from the front and the back of the
 * list. Furthermore all elements can be deleted and the order of all Elements
 * can be reversed.
 * 
 * Other lists can be added at the end and the front of this one. Furthermore
 * it's possible to compare this list with another one and the list can be
 * searched for containing values.
 * 
 * A String representation has been added to display every Node and it's
 * containing element.
 * 
 * @author Michael Nigl
 * @version 1.2
 * @param <T>
 *            the generic type all nodes in that list are supposed to have
 */

public class DoubleLinkedList<T> implements
		at.fhhgb.mc.interfaces.Iterable<T> {

	private class ListIterator implements Iterator<T> {
		DLNode<T> iterNode;

		/**
		 * Constructor which sets the first element to the head for the
		 * iteration
		 */
		public ListIterator() {
			iterNode = head;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see at.fhhgb.mc.interfaces.Iterator#hasNext()
		 */
		@Override
		public boolean hasNext() {
			if (iterNode == null) {
				return false;
			}else{ 
				return true;
			}
		}
		
		/* (non-Javadoc)
		 * @see at.fhhgb.mc.interfaces.Iterator#hasPrevious()
		 */
		public boolean hasPrevious() {
			if (iterNode == null) {
				return false;
			}else{ 
				return true;
			}
		}
		
		/*
		 * (non-Javadoc)
		 * 
		 * @see at.fhhgb.mc.interfaces.Iterator#next()
		 */
		@Override
		public T next() throws InvalidAccessException {
			if (iterNode == null) {
				throw new InvalidAccessException("No next element to iterate!");
			} else {
				T value = iterNode.getVal(); 
				iterNode = iterNode.getNext();
				return value;
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see at.fhhgb.mc.interfaces.Iterator#previous()
		 */
		@Override
		public T previous() throws InvalidAccessException {
			if (iterNode == null) {
				throw new InvalidAccessException(
						"No previous element to iterate!");
			} else {
				T value = iterNode.getVal();
				iterNode = iterNode.getPrev();
				return value;
			}
		}
		
		/* (non-Javadoc)
		 * @see at.fhhgb.mc.interfaces.Iterator#remove()
		 */
		public void remove() throws InvalidAccessException{
			removeOne(iterNode);
		}

		/* (non-Javadoc)
		 * @see at.fhhgb.mc.interfaces.Iterator#current()
		 */
		@Override
		public T current() throws InvalidAccessException {
			return iterNode.getVal();
		}
		
	}

	// Pointer to the first and last element of the list
	protected DLNode<T> head, tail;

	/**
	 * Initializes the double linked list instance. By setting head and tail to
	 * null.
	 */
	public DoubleLinkedList() {

		head = null;
		tail = null;

	}

	/**
	 * This constructor initializes this list with another list.
	 * 
	 * @throws NullPointerException
	 *             is thrown when the other list is null
	 */
	public DoubleLinkedList(DoubleLinkedList<T> other)
			throws NullPointerException {

		if (other != null) {
			DLNode<T> n = new DLNode<T>();
			n = other.head;

			while (n != null) {

				DLNode<T> p = new DLNode<T>();
				p.setVal(n.getVal());
				p.setNext(n.getNext());
				p.setPrev(n.getPrev());
				n = n.getNext();

			}

			head = other.head;
			tail = other.tail;
		} else {

			throw new NullPointerException("No other list!");

		}

	}
	
	private void removeOne(DLNode<T> node) throws InvalidAccessException{
		
		if(node.getPrev()==null){
			popFront();
		}else if(node.getNext()==null){
			popBack();
		}else{
			node.getPrev().setNext(node.getNext());
			node.getNext().setPrev(node.getPrev());
		}
	}

	/**
	 * Clears all elements from the linked list. All Pointer and the head and
	 * tail are set to null.
	 */
	public void clear() {
		DLNode<T> p;
		p = head;

		while (p != null) {

			DLNode<T> tmp = new DLNode<T>();
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
	 * Adds an element at the front of the linked list. Therefore is a new Node
	 * object created.
	 * 
	 * @param val
	 *            - the value for the new Node object
	 * @throws ValueException
	 *             Exception is thrown if the elements in the list are not
	 *             Comparable with the new one
	 * @throws NullPointerException
	 *             Exception is thrown if the transfer parameter is null
	 */
	public void pushFront(T val) {

		if (val == null) {
			throw new NullPointerException(
					"Null at pushFront in the transfer parameter!");
		}
		DLNode<T> n = new DLNode<T>();
		n.setVal(val);

		if (head == null) {

			head = n;
			tail = n;

		} else {
			n.setNext(head);
			head.setPrev(n);
			head = n;

		}

	}

	/**
	 * Adds a list at the front of the linked list.
	 * 
	 * @param other
	 *            - the list which is added at the front of this one
	 * @throws ValueException
	 *             Exception is thrown if the elements in the list are not
	 *             Comparable with the new list
	 * @throws NullPointerException
	 *             Exception is thrown if the transfer parameter is null
	 */
	public void pushFront(DoubleLinkedList<T> other) {

		if (other == null) {
			throw new NullPointerException(
					"Null at pushFront DLL in the transfer parameter!");
		}

		DLNode<T> n = new DLNode<T>();
		n = other.head;

		while (n != null) {

			DLNode<T> p = new DLNode<T>();
			p.setVal(n.getVal());
			p.setNext(n.getNext());
			p.setPrev(n.getPrev());
			n = n.getNext();

			if (n == null && head != null) {

				p.setNext(head);
				head.setPrev(other.tail);
				head = other.head;

			}

		}

		if (head == null) {

			head = other.head;
			tail = other.tail;
		}

	}

	/**
	 * Adds an element at the back of the linked list. Therefore is a new Node
	 * object created.
	 * 
	 * @param val
	 *            - the value for the new Node object
	 * @throws ValueException
	 *             Exception is thrown if the elements in the list are not
	 *             Comparable with the new one
	 * @throws NullPointerException
	 *             Exception is thrown if the transfer parameter is null
	 */
	public void pushBack(T val) {

		if (val == null) {
			throw new NullPointerException(
					"Null at pushBack in the transfer parameter!");
		}

		DLNode<T> n = new DLNode<T>();
		n.setVal(val);

		if (head == null) {

			head = n;
			tail = n;

		} else {
			tail.setNext(n);
			n.setPrev(tail);
			tail = n;
		}

	}

	/**
	 * Adds a list at the back of the linked list.
	 * 
	 * @param other
	 *            - the list which is added at the end of this one
	 * @throws ValueException
	 *             Exception is thrown if the elements in the list are not
	 *             Comparable with the new list
	 * @throws NullPointerException
	 *             Exception is thrown if the transfer parameter is null
	 */
	public void pushBack(DoubleLinkedList<T> other) {

		if (other == null) {
			throw new NullPointerException(
					"Null at pushBack DLL in the transfer parameter!");
		}

		DLNode<T> n = new DLNode<T>();
		n = other.head;
		tail.setNext(n);
		n.setPrev(tail);

		while (n != null) {

			DLNode<T> p = new DLNode<T>();
			p.setVal(n.getVal());
			p.setNext(n.getNext());
			p.setPrev(n.getPrev());
			n = n.getNext();

			if (n == null) {

				tail = p;

			}

		}

		if (head == null) {

			head = other.head;
			tail = other.tail;
		}

	}

	/**
	 * Clones this DoubleLinkedList instance
	 * 
	 * @return dll - an exact copy of this list
	 */
	public DoubleLinkedList<T> clone() {

		DoubleLinkedList<T> dll = new DoubleLinkedList<T>(this);

		return dll;
	}

	/**
	 * Removes and returns the front element of the linked list.
	 * 
	 * @return val - the removed value at the front of the list
	 * @throws InvalidAccessException
	 *             Exception is thrown when the Method is used on an empty List
	 */
	public T popFront() throws InvalidAccessException {

		if (head == null) {

			throw new InvalidAccessException("Can't pop on an empty Stack");

		} else {

			T val = head.getVal();
			head = head.getNext();

			// needed to catch an NullPointerException if only
			if (head != null) {
				head.setPrev(null);
			} else {

				tail = null;

			}

			return val;

		}

	}

	/**
	 * Returns the front element of the list without removing it.
	 * 
	 * @return val - the value at the front of the list
	 * @throws InvalidAccessException
	 *             Exception is thrown when the Method is used on an empty List
	 */
	public T peekFront() throws InvalidAccessException {

		if (head == null) {

			throw new InvalidAccessException("Can't peek on an empty Stack");

		} else {

			T val = head.getVal();
			return val;

		}

	}

	/**
	 * Removes and returns the element from the back of the linked list.
	 * 
	 * @return val - the removed value at the back of the list
	 * @throws InvalidAccessException
	 *             Exception is thrown when the Method is used on an empty List
	 */
	public T popBack() throws InvalidAccessException {

		if (head == null) {

			throw new InvalidAccessException("Can't pop on an empty Stack");

		} else {

			T val = tail.getVal();

			tail = tail.getPrev();

			if (tail != null) {
				tail.setNext(null);
			} else {
				head = null;
			}
			if (tail != null && tail.getVal() == null) {
				popBack();
			}
			return val;

		}

	}

	/**
	 * Returns the element at the back of the list without removing it.
	 * 
	 * @return val - the value at the back of the list
	 * @throws InvalidAccessException
	 *             Exception is thrown when the Method is used on an empty List
	 */
	public T peekBack() throws InvalidAccessException {

		if (head == null) {

			throw new InvalidAccessException("Can't peek on an empty Stack");

		} else {

			T val = tail.getVal();
			return val;

		}

	}

	
	/**
	 * Searches the list for an value and checks if it exists.
	 * 
	 * @param val
	 *            - the value which is searched in the list
	 * @return - true if the element val exists in the list, false otherwise
	 * @throws NullPointerException
	 *             Exception is thrown if the transfer parameter is null
	 * @throws ValueException
	 *             Exception is thrown if the transfer parameter is not
	 *             Comparable
	 */
	public boolean search(T val) {

		if (val == null) {
			throw new NullPointerException(
					"Null at search in the transfer parameter!");
		}

		DLNode<T> n = head;

		while (n != null) {
			if (n.getVal() == null) {
				n = n.getNext();
			} else {
				if (n.getVal().equals(val)) {

					return true;

				} else {

					n = n.getNext();

				}
			}

		}

		return false;

	}

	/**
	 * Returns the number of elements in the double linked list
	 * 
	 * @return counter - the number of nodes in the list.
	 */
	public int elements() {

		if (head == null) {

			return 0;

		} else {

			DLNode<T> n = head;
			int counter = 0;
			while (n != null) {

				n = n.getNext();
				counter++;

			}

			return counter;

		}

	}

	/**
	 * Reverses the order of all elements in the list.
	 */
	public void reverse() {

		if (head != null) {

			DLNode<T> n = head;
			DLNode<T> p = tail;
			DLNode<T> h = p;

			while (p != null) {

				DLNode<T> tmp = new DLNode<T>();
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
	 * 
	 * @return output - a String representation of every Node
	 */
	public String toString() {

		StringBuilder output = new StringBuilder();
		if (head != null) {
			DLNode<T> n = head;
			int counter = 0;
			while (n != null) {

				if (n.getVal() == null) {
					output.append("Node " + counter + " is a Dummy!");
				} else {
					output.append("Node " + counter + " contains the Value "
							+ n.getVal().toString());
				}
				n = n.getNext();

				output.append("\n");

				counter++;

			}

		} else {

			output.append("No Nodes in that list!");

		}

		return output.toString();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see at.fhhgb.mc.interfaces.Iterable#iterator()
	 */
	@Override
	public Iterator<T> iterator() {
		ListIterator iter = new ListIterator();
		return iter;
	}

}
