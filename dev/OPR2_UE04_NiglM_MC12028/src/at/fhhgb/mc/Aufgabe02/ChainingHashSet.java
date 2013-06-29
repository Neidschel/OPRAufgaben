package at.fhhgb.mc.Aufgabe02;

/**
 * This class is a representation of a hashtable. The table is stored in an 
 * array where on every index a RandomAccessDoubleLinkedList is stored. 
 * 
 * If an value should be put into the table, it's hashValue is calculated and
 * put into the calculated overflow list. 
 * 
 * @author Michael Nigl
 * @version 1.0
 */
public class ChainingHashSet {

	//Array which stores overflow lists that are indexed by the hash code of their elements.
	private RandomAccessDoubleLinkedList[] array;
	
	/**
	 * Constructor Initializes an empty hashtable with the given number of overflow lists.
	 * 
	 * @param indexSize - the number of overflow lists in the hashtable
	 */
	public ChainingHashSet(int indexSize) { 
	
		if(indexSize > 0){
			
			array = new RandomAccessDoubleLinkedList[indexSize];
			
		}else{
			//default size if an invalid size is used
			array = new RandomAccessDoubleLinkedList[10];
			
		}
		
	}
	
	/**
	 * Getter Method do test inizialized size
	 * 
	 * @return - the array
	 */
	public int getNumberOfLists(){
		
		return array.length;
	}
	
	/**
	 * Inserts a new element val into the hashtable.
	 * Hashcode = val % array.length 
	 *	
	 * The element will only be inserted if it wasn't already in any list
	 * in the hashtable.
	 * 
	 * @param val - the value to be inserted into the hashtable
	 * @return - true if the element didn't exist and was inserted, false otherwise
	 */
	public boolean insert (int val) { 
		
		int hash = Math.abs(val%array.length);
		
		if(array[hash]==null){
			
			array[hash] = new RandomAccessDoubleLinkedList();
			
		}
		
		if(array[hash].contains(val)==true){
			
			return false;
			
		}else{
			
			array[hash].pushBack(val);
			return true;
			
		}
		
	}
	
	/**
	 * Checks if a value is already stored in any list in the hashtable.
	 * 
	 * @param val - the searched element in the list
	 * @return - true if the given value is already stored in the hashtable, false otherwise.
	 */
	public boolean contains (int val) { 
		
		int hash = Math.abs(val%array.length);
		if(array[hash].contains(val)==true){
			
			return true;
			
		}else{
			
			return false;
			
		}
		
	}
	
	/**
	 * Removes an element if it exists in the hashtable.
	 * 
	 * @param val - the value which is searched to be removed
	 * @return - true if the element was found and removed, false otherwise
	 */
	public boolean remove (int val) { 
		
		int hash = Math.abs(val%array.length);
		if(array[hash].removeAll(val)==true){
			
			return true;
			
		}else{
			
			return false;
			
		}
		
	}
	
	/**
	 * Counts the amount of values, which are stored in the same overflow list.
	 * 
	 * Note: This includes dummy elements, because it is searched for elements and not
	 * values.
	 * 
	 * @param hashVal - the hashlist which elements are counted
	 * @return - the number of elements stored in the list or INTEGER.Min_Value if there
	 * are no elements
	 */
	public int getOverflowCount(int hashVal) { 
		
		if(hashVal < 0){
			
			return Integer.MIN_VALUE;
			
		}else if(hashVal > array.length-1 || array[hashVal]==null){
			
			return Integer.MIN_VALUE;
			
		}else{
		
			return array[Math.abs(hashVal)].elements();
			
		}
		
	}
	
	/**
	 * Counts the amount of elements in the hashtable in all of the overflow lists.
	 * 
	 * Note: This includes dummy elements, because it is searched for elements and not
	 * values.
	 * 
	 * @return the number of elements in all lists.
	 */
	public int elements() { 
		
		int count = 0;
		
		for(int i = 0;i < array.length;i++){
			
			if(array[i]!=null){
				count += array[i].elements();
			}
			
			
		}
		
		return count;
		
	}

}