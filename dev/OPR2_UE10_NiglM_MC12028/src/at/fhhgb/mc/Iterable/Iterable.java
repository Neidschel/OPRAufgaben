package at.fhhgb.mc.Iterable;

/**
 * This interface provides a method which retourns an iterator.
 * 
 * @author Michael Nigl
 * @version 1.0
 * @param <T>
 *            the generic type all elements in that iterator are supposed to
 *            have
 */
public interface Iterable<T> {

	/**
	 * Creates an instance of an Iterator which references the first element of
	 * the item collection
	 * 
	 * @return the iterator Object
	 */
	public Iterator<T> iterator();
}
