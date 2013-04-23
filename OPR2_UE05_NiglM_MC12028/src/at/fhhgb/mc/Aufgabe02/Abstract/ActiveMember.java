package at.fhhgb.mc.Aufgabe02.Abstract;

public abstract class ActiveMember extends AbstractMember{
	
	private int activity;
	
	public ActiveMember(String name,double income,double costs){
		super(name,income,costs);
	}
	
	public void setActivity(int activity){
		if(activity < 0){
			this.activity = 0;
		}else if(activity > 10){
			this.activity = 10;
		}else{
			this.activity = activity;
		}
	}
	
	public int getActivity(){
		return activity;
	}
	
}
