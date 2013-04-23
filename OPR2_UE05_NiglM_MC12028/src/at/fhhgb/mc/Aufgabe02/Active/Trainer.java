package at.fhhgb.mc.Aufgabe02.Active;

import at.fhhgb.mc.Aufgabe02.Abstract.ActiveMember;


public class Trainer extends ActiveMember{

	public Trainer(String name,int aktivity){
		super(name,120,aktivity*40*12);
	}
	
	public void setCosts(int activity){
		setActivity(activity);
		super.setCosts(getActivity()*40*12);
	}
	
	public String toString(boolean ascending){
		String check;
		if(getSurplus() >= 0){
			check = " earns ";
		}else{
			check = " costs ";
		}
		StringBuilder output = new StringBuilder();
		output.append("Trainer: "+getName()+check+getSurplus()+" for the club.");
		return output.toString();
	}
	
}
