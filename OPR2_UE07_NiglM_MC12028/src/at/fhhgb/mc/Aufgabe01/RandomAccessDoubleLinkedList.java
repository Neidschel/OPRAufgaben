package at.fhhgb.mc.Aufgabe01;

/**
 * The RandomAccessDoubleLinkedList is an extension of the DoubleLinkedList. Now
 * elements can be inserted and removed anywhere in the list instead of the
 * front and the back like it was before.
 * 
 * If elements are inserted at an bigger index than the lists size, then the
 * list will be filled with dummy nodes till the given index.
 * 
 * @author Michael Nigl
 * @version 1.2
 */
public class RandomAccessDoubleLinkedList extends DoubleLinkedList {

	/**
	 * Initializes an empty list by calling the empty constructor of DLL.
	 */
	public RandomAccessDoubleLinkedList() {

		super();

	}

	/**
	 * Copy constructor which initializes the list with another list. By calling
	 * the Constructor of DLL where another list where another list can be given
	 * as transfer parameter
	 * 
	 * @param other
	 *            - the other list which is added to this one
	 */
	public RandomAccessDoubleLinkedList(RandomAccessDoubleLinkedList other) {

		super(other);

	}

	/**
	 * Inserts a new element with value val at the given index. If the index is
	 * larger than the current size, the list is padded with uninitialized
	 * DLNodes.
	 * 
	 * Note: The index starts at "0". So the first element in the list is called
	 * with the index 0.
	 * 
	 * @param index
	 *            - the position where the new element is added into the list
	 * @param val
	 *            - the value of new element
	 * @throws InvalidAccessException
	 *             Exception is thrown when the index is invalid
	 * @throws ValueException
	 *             Exception is thrown when the value is not Comparable
	 * @throws NullPointerException
	 *             Exception is thrown when the Comparable is null
	 */
	public void insertAt(int index, Comparable val)
			throws InvalidAccessException, ValueException {

		if (index < 0) {
			throw new InvalidAccessException("Invalid index used");
		} else if (val == null) {
			throw new NullPointerException("Comparable is null at insertAt");
		} else if (tail != null && !isComparable(val, tail.getVal())) {
			throw new ValueException("Invalid Comparable used!", val.toString());
		} else {
			DLNode n = new DLNode();
			int compare = elements();

			if (compare == Integer.MIN_VALUE) {
				compare = 0;
			}

			if (compare < index) {

				int dummy_count = index - compare;

				if (head == null) {

					head = n;
					tail = n;
					dummy_count--;

				} else {

					n = tail;

				}

				int i = 1;
				while (i <= dummy_count) {

					DLNode node = new DLNode();
					n.setNext(node);
					node.setPrev(n);
					tail = node;
					n = n.getNext();

					i++;

				}

				pushBack(val);

			} else {

				if (head == null) {

					pushFront(val);

				} else {

					int i = 0;
					n = head;
					while (i <= index) {

						if (i == index) {

							if (index == 0) {

								pushFront(val);

							} else if (elements() == index) {

								pushBack(val);

							} else if (n.isInitialized() == false) {

								n.setVal(val);

							} else {

								DLNode node = new DLNode();
								node.setVal(val);
								n.getPrev().setNext(node);
								node.setPrev(n.getPrev());
								node.setNext(n);
								n.setPrev(node);

							}
							i++;

						} else {

							i++;
							n = n.getNext();

						}
					}

				}

			}
		}

	}

	/**
	 * Checks if an element with the searched value exists in the list.
	 * 
	 * @param val
	 *            - the searched value
	 * @return - true if an element with the given value exists, false
	 *         otherwise.
	 * @throws ValueException
	 *             Exception is thrown from search
	 */

	public boolean contains(Comparable val) throws ValueException {

		return search(val);

	}

	/**
	 * Removes an element at the given index.
	 * 
	 * @param index
	 *            - the index of the element to be removed
	 * @return false is returned if index > list's, true otherwise.
	 * @throws InvalidAccessException
	 *             Exception is thrown when the index is invalid or the list is
	 *             empty
	 */
	public boolean removeAt(int index) throws InvalidAccessException {

		if (elements() < index || index < 0) {

			throw new InvalidAccessException("Invalid index used");

		} else {

			if (head == null) {

				throw new InvalidAccessException(
						"Can't search in an empty list");

			} else {

				int i = 0;
				DLNode n = head;
				while (i <= index && n != null) {
					if (i == index) {
						if (n.isInitialized() == false) {
							return false;
						}
						if (n.getPrev() == null) {

							try {
								popFront();
							} catch (InvalidAccessException ex) {
								System.out.println(ex.getMessage());
								ex.printStackTrace();
							}

							i++;

						} else if (n.getNext() == null) {
							try {
								popBack();
								while (tail != null && tail.getVal() == null) {
									popBack();
								}
							} catch (InvalidAccessException ex) {
								System.out.println(ex.getMessage());
								ex.printStackTrace();
							}

							i++;

						} else {
							n.getPrev().setNext(n.getNext());
							n.getNext().setPrev(n.getPrev());
							n = null;
							i++;
						}
					} else {
						i++;
						n = n.getNext();
					}
				}
				return true;
			}

		}

	}

	/**
	 * Removes all elements with the given value.
	 * 
	 * @param val
	 *            - the value to be removed
	 * @return - true if at least one element of the value was found and
	 *         removed, false otherwise
	 * @throws ValueException
	 *             Exception is thrown if val is not Comparable with the list
	 */
	public boolean removeAll(Comparable val) throws ValueException {

		if (val == null) {
			throw new NullPointerException("Comparable is null at removeAll");
		}else if (head == null) {
			return false;
		}else if (tail != null && !isComparable(val, tail.getVal())) {
			throw new ValueException("Invalid Comparable used!", val.toString());
		} else {
			boolean found = false;
			DLNode n = head;

			while (n != null) {
				if (n.getVal() != null) {
					if (n.getVal().compareTo(val) == 0) {

						if (n.getPrev() == null) {
							head = n.getNext();
							n.getNext().setPrev(null);
						} else if (n.getNext() == null) {
							tail = n.getPrev();
							n.getPrev().setNext(null);

						} else {
							n.getPrev().setNext(n.getNext());
							n.getNext().setPrev(n.getPrev());
						}
						found = true;
					}
				}

				if (n.getNext() == null) {
					while (tail.getVal() == null) {
						try {
							popBack();
						} catch (InvalidAccessException ex) {
							break;
						}
					}
				}

				n = n.getNext();

			}

			return found;

		}
	}

	/**
	 * Returns the integer value at a given index.
	 * 
	 * @param index
	 *            - the index of the element which's value is of interest
	 * @return - the value or Integer.MIN_VALUE if index > list's size
	 * @throws InvalidAccessException
	 *             Exception is thrown when the index is invalid or the list is
	 *             empty
	 */
	public Comparable elementAt(int index) throws InvalidAccessException {

		if (elements() <= index || index < 0) {

			throw new InvalidAccessException("Invalid index used");

		} else {

			if (head == null) {

				throw new InvalidAccessException(
						"Can't search in an empty list");

			} else {

				int i = 0;
				DLNode n = head;
				while (i <= index && n != null) {

					if (i == index) {

						break;

					} else {

						i++;
						n = n.getNext();

					}

				}

				return n.getVal();

			}

		}

	}
}