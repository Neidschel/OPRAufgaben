package at.fhhgb.mc.Aufgabe02.Active;

import at.fhhgb.mc.Aufgabe02.Abstract.ActiveMember;


public class AmateurAthlete extends ActiveMember{

	public AmateurAthlete(String name,int aktivity){
		super(name,120,aktivity*2.5*12);
	}
	
	public String toString(boolean ascending){
		String check;
		if(getSurplus() >= 0){
			check = " earns";
		}else{
			check = " costs";
		}
		return "AmateurAthlete: "+getName()+check+" for the club.";
	}
	
}
