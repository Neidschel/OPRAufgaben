package at.fhhgb.mc.Aufgabe01;

public class ValueException extends Exception{
	
	public ValueException (String _msg, int _whichVal){
		super(_msg+" The Exception was thrown while the value "+_whichVal+" was used!");
	}
	
	public ValueException (String _msg, Comparable _whichVal){
		super(_msg+" The Exception was thrown while the value "+_whichVal.toString()+" was used!");
	}

}
