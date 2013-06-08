package at.fhhgb.mc.Aufgabe01;

import java.awt.TextArea;

import at.fhhgb.mc.Observable.MyObserver;

public class ObservingTextArea<T> extends TextArea implements MyObserver<T>{
	
	PeriodicFileReader pfr;
	public ObservingTextArea(PeriodicFileReader pfr) {
		 this.pfr = pfr;
	}

	@Override
	public void update(T _param) {
		// TODO Auto-generated method stub
		this.append(""+_param);
	}
}
