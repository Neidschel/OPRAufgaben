package at.fhhgb.mc.Aufgabe02;

import at.fhhgb.mc.Aufgabe01.*;

/**
 * 
 * 
 * @author Michael Nigl
 * @version 1.0
 */
public class SortableList extends RandomAccessDoubleLinkedList implements
		Sortable {

	
	
	/* (non-Javadoc)
	 * @see at.fhhgb.mc.Aufgabe02.Sortable#insertSorted(java.lang.Comparable, boolean)
	 */
	public void insertSorted(Comparable value, boolean ascending) {

		if (head == null) {
			pushFront(value);
		} else {
				DLNode n = head;
				int i = 0;
				while (n != null) {
					if(ascending){
					if (n.getVal().compareTo(value) >= 0) {
						try {
							insertAt(i, value);
						} catch (InvalidAccessException ex) {
							ex.printStackTrace();
						}

						return;

					} else {
						i++;
						n = n.getNext();
					}
					}else{
						if (n.getVal().compareTo(value) <= 0) {
							try {
								insertAt(i, value);
							} catch (InvalidAccessException ex) {
								ex.printStackTrace();
							}

							return;

						} else {
							i++;
							n = n.getNext();
						}
						
					}
				}
				pushBack(value);
			}

	}

	/* (non-Javadoc)
	 * @see at.fhhgb.mc.Aufgabe02.Sortable#sortAscending()
	 */
	public Sortable sortAscending() {
		SortableList sortedAsc = new SortableList();
		DLNode n = head;
		while (n != null) {
			if(n.getVal()!=null){
				sortedAsc.insertSorted(n.getVal(), true);
			}
			n = n.getNext();
		}
		return sortedAsc;
	}


	/* (non-Javadoc)
	 * @see at.fhhgb.mc.Aufgabe02.Sortable#sortDescending()
	 */
	public Sortable sortDescending() {
		SortableList sortedDesc = new SortableList();
		DLNode n = head;
		while (n != null) {
			if(n.getVal()!=null){
				sortedDesc.insertSorted(n.getVal(), false);
			}
			n = n.getNext();
		}
		return sortedDesc;
	}

}
