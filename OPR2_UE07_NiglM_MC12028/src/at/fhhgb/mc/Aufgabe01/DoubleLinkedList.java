package at.fhhgb.mc.Aufgabe01;

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
 * @version 1.1
 */

public class DoubleLinkedList {

	// Pointer to the first and last element of the list
	protected DLNode head, tail;

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
	 */
	public DoubleLinkedList(DoubleLinkedList other) {

		if (other != null) {
			DLNode n = new DLNode();
			n = other.head;

			while (n != null) {

				DLNode p = new DLNode();
				p.setVal(n.getVal());
				p.setNext(n.getNext());
				p.setPrev(n.getPrev());
				n = n.getNext();

			}

			head = other.head;
			tail = other.tail;
		} else {

			head = null;
			tail = null;

		}

	}

	/**
	 * Clears all elements from the linked list. All Pointer and the head and
	 * tail are set to null.
	 */
	public void clear() {
		DLNode p;
		p = head;

		while (p != null) {

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
	 * Adds an element at the front of the linked list. Therefore is a new Node
	 * object created.
	 * 
	 * @param val
	 *            - the value for the new Node object
	 */
	public void pushFront(Comparable val) {

		DLNode n = new DLNode();
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
	 */
	public void pushFront(DoubleLinkedList other) {

		DLNode n = new DLNode();
		n = other.head;

		while (n != null) {

			DLNode p = new DLNode();
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
	 */
	public void pushBack(Comparable val) {

		DLNode n = new DLNode();
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
	 */
	public void pushBack(DoubleLinkedList other) {

		DLNode n = new DLNode();
		n = other.head;
		tail.setNext(n);
		n.setPrev(tail);

		while (n != null) {

			DLNode p = new DLNode();
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
	public DoubleLinkedList clone() {

		DoubleLinkedList dll = new DoubleLinkedList(this);

		return dll;
	}

	/**
	 * Removes and returns the front element of the linked list. Returns
	 * Integer.MIN_VALUE if empty
	 * 
	 * @return val - the removed value at the front of the list
	 * @throws InvalidAccessException
	 *             Exception is thrown when the Method is used on an empty List
	 */
	public Comparable popFront() throws InvalidAccessException {

		if (head == null) {

			throw new InvalidAccessException("Can't pop on an empty Stack");

		} else {

			Comparable val = head.getVal();
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
	 * Returns the front element of the list without removing it. Returns
	 * Integer.MIN_VALUE if empty
	 * 
	 * @return val - the value at the front of the list
	 * @throws InvalidAccessException
	 *             Exception is thrown when the Method is used on an empty List
	 */
	public Comparable peekFront() throws InvalidAccessException {

		if (head == null) {

			throw new InvalidAccessException("Can't peek on an empty Stack");

		} else {

			Comparable val = head.getVal();
			return val;

		}

	}

	/**
	 * Removes and returns the element from the back of the linked list. Returns
	 * Integer.MIN_VALUE if empty
	 * 
	 * @return val - the removed value at the back of the list
	 * @throws InvalidAccessException
	 *             Exception is thrown when the Method is used on an empty List
	 */
	public Comparable popBack() throws InvalidAccessException {

		if (head == null) {

			throw new InvalidAccessException("Can't pop on an empty Stack");

		} else {

			Comparable val = tail.getVal();
		
			tail = tail.getPrev();

			if (tail != null) {
				tail.setNext(null);
			}else{
				head = null;
			}
			return val;

		}

	}

	/**
	 * Returns the element at the back of the list without removing it. Returns
	 * Integer.MIN_VALUE if empty
	 * 
	 * @return val - the value at the back of the list
	 * @throws InvalidAccessException
	 *             Exception is thrown when the Method is used on an empty List
	 */
	public Comparable peekBack() throws InvalidAccessException {

		if (head == null) {

			throw new InvalidAccessException("Can't peek on an empty Stack");

		} else {

			Comparable val = tail.getVal();
			return val;

		}

	}

	/**
	 * Checks if two lists are identical.
	 * 
	 * @param other
	 *            - the other list compared with this one
	 * @return - true if the other list is equal to this one, false otherwise
	 */
	public boolean equals(DoubleLinkedList other) {

		DLNode n = head;
		DLNode p = other.head;

		while (n != null && p != null) {

			if (n.getVal().compareTo(p.getVal()) != 0) {

				return false;

			} else {

				n = n.getNext();
				p = p.getNext();

			}

		}

		if (n == null && p == null) {

			return true;

		} else {

			return false;

		}

	}

	/**
	 * Searches the list for an value and checks if it exists.
	 * 
	 * @param val
	 *            - the value which is searched in the list
	 * @return - true if the element val exists in the list, false otherwise
	 */
	public boolean search(Comparable val) {

		DLNode n = head;

		while (n != null) {
			if (n.getVal() == null) {
				n = n.getNext();
			} else {
				if (n.getVal().compareTo(val) == 0) {

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

			DLNode n = head;
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

			DLNode n = head;
			DLNode p = tail;
			DLNode h = p;

			while (p != null) {

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
	 * 
	 * @return output - a String representation of every Node
	 */
	public String toString() {

		StringBuilder output = new StringBuilder();
		if (head != null) {
			DLNode n = head;
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

}
