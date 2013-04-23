package at.fhhgb.mc.Aufgabe02.Member;

import at.fhhgb.mc.Aufgabe02.Abstract.AbstractMember;


public class SupportingMember extends AbstractMember{

	public SupportingMember(String name){
		super(name,100,15.0);
	}
	
	public String toString(boolean ascending){
		String check;
		if(getSurplus() >= 0){
			check = " earns ";
		}else{
			check = " costs ";
		}
		StringBuilder output = new StringBuilder();
		output.append("SupportingMember "+getName()+check+getSurplus()+" for the club.");
		return output.toString();
	}
}