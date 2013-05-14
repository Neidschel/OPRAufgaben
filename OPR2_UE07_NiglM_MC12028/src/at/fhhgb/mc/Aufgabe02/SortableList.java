package at.fhhgb.mc.Aufgabe02;

import at.fhhgb.mc.Aufgabe01.*;

/**
 * This class implements the Sortable interface and provides a list where
 * elements can ascending and descending inserted. Furthermore it's possible to
 * sort all elements in the list any time.
 * 
 * @author Michael Nigl
 * @version 1.0
 */
public class SortableList extends RandomAccessDoubleLinkedList implements
		Sortable {

	/*
	 * (non-Javadoc)
	 * 
	 * @see at.fhhgb.mc.Aufgabe02.Sortable#insertSorted(java.lang.Comparable,
	 * boolean)
	 */
	public void insertSorted(Comparable value, boolean ascending)
			throws ValueException, InvalidAccessException  {

		if (head == null) {

			pushFront(value);

		} else if (tail != null && !isComparable(value, tail.getVal())) {
			throw new ValueException("Invalid Comparable used!", value.toString());
		} else {
			DLNode n = head;
			int i = 0;
			while (n != null) {
				if (ascending) {
					if (n.getVal().compareTo(value) >= 0) {
							insertAt(i, value);
					

						return;

					} else {
						i++;
						n = n.getNext();
					}
				} else {
					if (n.getVal().compareTo(value) <= 0) {

						insertAt(i, value);
					

						return;

					} else {
						i++;
						n = n.getNext();
					}

				}
			}

			try {
				pushBack(value);
			} catch (ValueException ex) {
				System.out.println(ex.getMessage());
			}

		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see at.fhhgb.mc.Aufgabe02.Sortable#sortAscending()
	 */
	public Sortable sortAscending() {
		SortableList sortedAsc = new SortableList();
		DLNode n = head;
		while (n != null) {
			// dummy nodes are discarded

			if (n.getVal() != null) {
				try {
					sortedAsc.insertSorted(n.getVal(), true);
				} catch (ValueException ex) {
					ex.printStackTrace();
				} catch (InvalidAccessException e) {
					
					e.printStackTrace();
				}
			}
			n = n.getNext();
		}
		return sortedAsc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see at.fhhgb.mc.Aufgabe02.Sortable#sortDescending()
	 */
	public Sortable sortDescending() {
		SortableList sortedDesc = new SortableList();
		DLNode n = head;
		while (n != null) {
			// dummy nodes are discarded
			if (n.getVal() != null) {
				try {
					sortedDesc.insertSorted(n.getVal(), false);
				} catch (ValueException ex) {
					ex.printStackTrace();
				}catch (InvalidAccessException e) {
					
					e.printStackTrace();
				}
			}
			n = n.getNext();
		}
		return sortedDesc;
	}

}
