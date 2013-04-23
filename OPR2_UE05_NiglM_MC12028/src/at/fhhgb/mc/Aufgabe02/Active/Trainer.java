package at.fhhgb.mc.Aufgabe02.Active;

import at.fhhgb.mc.Aufgabe02.Abstract.ActiveMember;


public class Trainer extends ActiveMember{

	public Trainer(String name,int aktivity){
		super(name,120,aktivity*40*12);
	}
	
	public String toString(boolean ascending){
		String check;
		if(getSurplus() >= 0){
			check = " earns";
		}else{
			check = " costs";
		}
		return "Trainer: "+getName()+check+" for the club.";
	}
	
}
