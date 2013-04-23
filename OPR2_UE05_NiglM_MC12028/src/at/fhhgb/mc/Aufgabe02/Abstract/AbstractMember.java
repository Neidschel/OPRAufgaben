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
	
	public String getName(){
		return name;
	}
	
	public double getIncome(){
		return income;
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
