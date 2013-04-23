package at.fhhgb.mc.Aufgabe02.Member;

import at.fhhgb.mc.Aufgabe02.Abstract.AbstractMember;


public class ChairMember extends AbstractMember{
	
	public ChairMember(String name, int kompetenz){
		super(name,100*kompetenz,20*kompetenz);
	}
	
	public String toString(boolean ascending){
		String check;
		if(getSurplus() >= 0){
			check = " earns ";
		}else{
			check = " costs ";
		}
		StringBuilder output = new StringBuilder();
		output.append("ChairMember: "+getName()+check+getSurplus()+" for the club.");
		return output.toString();
	}
}
