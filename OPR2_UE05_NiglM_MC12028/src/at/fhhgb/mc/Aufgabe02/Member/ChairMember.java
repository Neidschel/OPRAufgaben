package at.fhhgb.mc.Aufgabe02.Member;

import at.fhhgb.mc.Aufgabe02.Abstract.AbstractMember;


public class ChairMember extends AbstractMember{
	private int kompetence;
	
	public ChairMember(String name, int kompetence){
		super(name,100*kompetence,20*kompetence);
		this.kompetence = kompetence;
	}
	
	public void setKompetenz(int kompetence){
		if(kompetence < 0){
			this.kompetence = 0;
		}else if(kompetence > 10){
			this.kompetence = 10;
		}else{
			this.kompetence = kompetence;
		}
		
		setIncome(100*kompetence);
		setCosts(20*kompetence);
		
	}
	
	public int getKompetenz(){
		return kompetence;
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
