package at.fhhgb.mc.Observable;

import java.util.Vector;

/**
 * An abstract class for Objects which are to be observed. With the methods here
 * are observer stored and called when there are changes.
 * 
 * @author Michael Nigl
 * @version 1.0
 * 
 * @param <T>
 *            the type of the Observerables
 */
public abstract class MyObservable<T> {

	private Vector<MyObserver<T>> m_observers;

	/**
	 * The constructor which initializes the Vector.
	 */
	public MyObservable() {
		m_observers = new Vector<MyObserver<T>>();
	}

	/**
	 * Adds a {@link MyObserver} instance to the list of observers, if not
	 * already contained. Every {@link MyObserver} in the list will be notified.
	 * 
	 * @param _obs
	 */
	public void addObserver(MyObserver<T> _obs) {
		if (!(m_observers.contains(_obs))) {
			m_observers.add(_obs);
		}
	}

	/**
	 * Tells each registered {@link MyObserver} that the state of the object has
	 * changed.
	 * 
	 * @param _param
	 *            An object which contains the modified data. Can be null.
	 */
	public void notifyObservers(T _param) {
		for (MyObserver<T> o : m_observers) {
			o.update(_param);
		}
	}
}
