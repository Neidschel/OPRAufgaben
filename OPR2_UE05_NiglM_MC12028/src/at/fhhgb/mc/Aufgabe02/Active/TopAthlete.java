package at.fhhgb.mc.Aufgabe02.Active;

import at.fhhgb.mc.Aufgabe02.Abstract.ActiveMember;


public class TopAthlete extends ActiveMember{

	public TopAthlete(String name,int aktivity){
		super(name,120,aktivity*5*12);
	}
	
	public String toString(boolean ascending){
		String check;
		if(getSurplus() >= 0){
			check = " earns";
		}else{
			check = " costs";
		}
		return "TopAthlete: "+getName()+check+" for the club.";
	}
	
}	
