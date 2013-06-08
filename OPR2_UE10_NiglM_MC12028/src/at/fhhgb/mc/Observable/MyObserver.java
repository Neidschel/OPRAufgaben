package at.fhhgb.mc.Observable;

public interface MyObserver<T> {
	/**
	* Callback which is invoked, whenever a concrete {@link MyObservable} has * changed its data
	*
	* @param _param
	* Each {@link MyObservable} will pass the data that has changed * as parameter. Can be null!
	*/
	public void update(T _param);
}
