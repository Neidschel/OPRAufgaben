package at.fhhgb.mc.Observable;

/**
 * An interface for an Object which is used as an Observer to handle changes of
 * the objects it observes.
 * 
 * @author Michael Nigl
 * @version 1.0
 * 
 * @param <T>
 *            the type of the observable object which the observer has to use
 */
public interface MyObserver<T> {
	/**
	 * Callback which is invoked, whenever a concrete {@link MyObservable} has
	 * changed its data
	 * 
	 * @param _param
	 *            Each {@link MyObservable} will pass the data that has changed
	 *            as parameter. Can be null!
	 */
	public void update(T _param);
}
