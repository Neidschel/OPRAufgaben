package at.fhhgb.mc.Aufgabe02;

/**
 * This Interface offers sorting algorithms for Comparable Objects. The insert
 * of a new Object can be done ascending or descending and the entire List
 * can be sorted.
 * 
 * Note: The list is always accessed from head to tail. That means the list is
 * always sorted ascending and descending starting from the head.
 * 
 * @author Michael Nigl
 * @version 1.0
 */
public interface Sortable {

	/**
	 * Inserts an element sorted into a list. If the insert is ascending it will
	 * be inserted before the first element which has a higher value than this
	 * one. If the insert is descending it will be inserted before the first
	 * element which has a lower value than this one.
	 * 
	 * @param _value
	 *            the Combarable Object which will be inserted into the list
	 * @param _ascending
	 *            true if the insert is ascending, false if the insert is
	 *            descending
	 */
	public void insertSorted(Comparable _value, boolean _ascending);

	/**
	 * Sorts all elements in a list in an ascending order
	 * 
	 * @return the list ascending sorted
	 */
	public Sortable sortAscending();

	/**
	 * Sorts all elements in a list in a descending order
	 * 
	 * @return the list descending sorted
	 */
	public Sortable sortDescending();

}
