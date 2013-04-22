package at.fhhgb.mc.Aufgabe02.Abstract;

public abstract class Member {
	
	private double income;
	private double costs;
	private double surplus;
	
	public Member(double income,double costs,double surplus){
		this.income = income;
		this.costs = costs;
		this.surplus = surplus;
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
		
	public abstract String toString(boolean ascending);
	
}
