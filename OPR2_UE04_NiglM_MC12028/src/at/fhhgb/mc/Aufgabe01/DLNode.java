package at.fhhgb.mc.Aufgabe01;

/**
 * DLNode Class represents a Node of a DoubleLinked List. The Node contains a value and 
 * the next and previous node of the List.
 * 
 * @author Michael Nigl
 *
 */
public class DLNode {

	private DLNode next;
	
	private DLNode prev;
	
	private int val;
	
	private DoubleLinkedList list;

	
	public DoubleLinkedList getList() {
		return list;
	}

	public void setList(DoubleLinkedList list) {
		this.list = list.clone();
		val = Integer.MIN_VALUE;
	}

	/**
	 * Gets the next list node
	 * 
	 * @return next - next list node
	 */
	public DLNode getNext() {
		return next;
	}
	
	/**
	 * Sets the next list node
	 * 
	 * @param next - next list node
	 */
	public void setNext(DLNode next) {
		this.next = next;
	}
	
	/**
	 * Gets the previous list node
	 * 
	 * @return prev - previous list node
	 */
	public DLNode getPrev() {
		return prev;
	}

	/**
	 * Sets the previous list node
	 * 
	 * @param prev - previous list node
	 */
	public void setPrev(DLNode prev) {
		this.prev = prev;
	}

	/**
	 * Gets the Value of the list node
	 * 
	 * @return val - the value of this node
	 */
	public int getVal() {
		return val;
	}

	/**
	 * Sets the Value of this list node
	 * 
	 * @param val - the value of this node
	 */
	public void setVal(int val) {
		this.val = val;
		list = null;
	}	
	
	
}
