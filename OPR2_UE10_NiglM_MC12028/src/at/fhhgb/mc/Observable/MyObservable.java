package at.fhhgb.mc.Observable;

import java.util.Vector;

public abstract class MyObservable<T> {

	private Vector<MyObserver<T>> m_observers;

	public MyObservable() {

	}

	/**
	 * Adds a {@link MyObserver} instance to the list of observers, if not
	 * already contained. * Every {@link MyObserver} in the list will be
	 * notified.
	 * 
	 * @param _obs
	 */
	public void addObserver(MyObserver<T> _obs) {

	}

	/**
	 * Tells each registered {@link MyObserver} that the state of the object has
	 * changed. * @param _param An object which contains the modified data. Can
	 * be null.
	 */
	public void notifyObservers(T _param) {

	}
}
