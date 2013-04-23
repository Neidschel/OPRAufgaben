package at.fhhgb.mc.Aufgabe02.Member;

import at.fhhgb.mc.Aufgabe02.Abstract.AbstractMember;


public class HonoraryMember extends AbstractMember{

	public HonoraryMember(String name){
		super(name,0,20.0);
	}
	
	public String toString(boolean ascending){
		String check;
		if(getSurplus() >= 0){
			check = " earns";
		}else{
			check = " costs";
		}
		return "HonoraryMember: "+getName()+check+" for the club.";
	}
	
}
