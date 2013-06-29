package at.fhhgb.mc.interfaces;

import at.fhhgb.mc.Aufgabe01.InvalidAccessException;

/**
 * An iterator Interface which provides Methods to go through all elements in a
 * collection.
 * 
 * @author Michael Nigl
 * @version 1.0
 * @param <T>
 *            the generic type all elements in that collection are supposed to
 *            have
 */
public interface Iterator<T> {

	/**
	 * Checks if the collection has yet reached its end
	 * 
	 * @return true if the collection has another element after that one, false otherwise
	 */
	public boolean hasNext();
	
	/**
	 * Checks if the collection has yet reached its beginning
	 * 
	 * @return true if the collection has another element before that one, false otherwise
	 */
	public boolean hasPrevious();

	/**
	 * Saves the current element for the return statement and increments the
	 * reference after that.
	 * 
	 * @return the current element before incrementing
	 * @throws InvalidAccessException
	 *             is thrown if the method is called at the end of the list
	 */
	public T next() throws InvalidAccessException;

	/**
	 * Saves the current element for the return statement and decrements the
	 * reference after that.
	 * 
	 * @return the current element before decrementing
	 * @throws InvalidAccessException
	 *             is thrown if the method is called at the beginning of the
	 *             list
	 */
	public T previous() throws InvalidAccessException;

	/**
	 * Removes an element from the list.
	 * 
	 * @throws InvalidAccessException
	 */
	public void remove() throws InvalidAccessException;
	
	/**
	 * Gives the current element.
	 * 
	 * @return the current element before decrementing
	 * @throws InvalidAccessException
	 *             is thrown if the method is called at the beginning of the
	 *             list
	 */
	public T current() throws InvalidAccessException;
}
