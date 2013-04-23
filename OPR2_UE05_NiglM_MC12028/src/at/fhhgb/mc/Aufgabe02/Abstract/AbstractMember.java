package at.fhhgb.mc.Aufgabe02.Abstract;

public abstract class AbstractMember implements Comparable<AbstractMember>{
	
	private double income;
	private double costs;
	private String name;
	
	public AbstractMember(String name,double income,double costs){
		this.name = name;
		this.income = income;
		this.costs = costs;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setIncome(double income){
		this.income = income;
	}
	
	public double getIncome(){
		return income;
	}
	
	public void setCosts(double costs){
		this.costs = costs;
	}
	
	public double getCosts(){
		return costs;
	}

	public double getSurplus(){
		return income - costs;
	}
	
	public int compareTo(AbstractMember m){
		if(this.getSurplus() > m.getSurplus()){
			return 1;
		}else if(this.getSurplus() < m.getSurplus()){
			return -1;
		}else{
			if(this.getName().compareTo(m.getName()) > 1){
				return 1;
			}else{
				return -1;
			}
		}
	}
		
	public abstract String toString(boolean ascending);
	
}
