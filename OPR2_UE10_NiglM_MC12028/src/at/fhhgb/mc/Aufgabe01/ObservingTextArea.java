package at.fhhgb.mc.Aufgabe01;

import java.awt.TextArea;

import at.fhhgb.mc.Observable.MyObserver;

/**
 * This TextArea is the Observer of this application which changes the text displayed if any changes
 * have been notified to the Observer.
 * 
 * @author Michael Nigl
 * @version 1.0
 * 
 * @param <T>
 *            the type of Input the TextArea uses
 */
public class ObservingTextArea<T> extends TextArea implements MyObserver<T> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see at.fhhgb.mc.Observable.MyObserver#update(java.lang.Object)
	 */
	@Override
	public void update(T _param) {
		this.append("" + _param + "\n");
	}

}
