package at.fhhgb.mc.Aufgabe02.Abstract;

/**
 * All sections and members inherit the methods of this class. It's the skeletal
 * structure of the whole section and member administration.
 * 
 * All values of the member (income, costs, name) are stored here.
 * 
 * @author Michael Nigl
 * @version 1.1
 */
public abstract class AbstractMember implements Comparable<AbstractMember> {

	private double income;
	private double costs;
	private String name;

	/**
	 * This Constructor is called by every extending class in the packed for
	 * initializing the name, income and costs.
	 * 
	 * @param name
	 *            the name of the section or the member or failfailfail if the
	 *            name was null
	 * @param income
	 *            the money the member earns or the money the section has
	 *            because of its members
	 * @param costs
	 *            the money a member cost or the money all members cost a
	 *            section
	 * @throws NullPointerException
	 *             if name is null
	 */
	public AbstractMember(String name, double income, double costs)
			throws NullPointerException {
		if (name == null) {
			throw new NullPointerException("The new Member has no name!");
		} else {
			this.name = name;
		}
		this.income = income;
		this.costs = costs;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public double getIncome() {
		return income;
	}

	public void setCosts(double costs) {
		this.costs = costs;
	}

	public double getCosts() {
		return costs;
	}

	public double getSurplus() {
		return income - costs;
	}

	/**
	 * The compare method used to compare different Member Objects for correct
	 * sorting into the tree.
	 * 
	 * @param m
	 *            the AbstractMember to be compared with this one
	 * @return 1 if this Objects value is bigger, -1 if this value is smaller
	 * @throws NullPointerException
	 *             if m is null
	 */
	public int compareTo(AbstractMember m) throws NullPointerException {

		if (m == null) {
			throw new NullPointerException(
					"No valid comparable in the transfer parameter!");
		} else if (this.getSurplus() > m.getSurplus()) {
			return 1;
		} else if (this.getSurplus() < m.getSurplus()) {
			return -1;
		} else {
			if (this.getName().compareTo(m.getName()) > 1) {
				return 1;
			} else {
				return -1;
			}
		}
	}

	/**
	 * Prints the Member or the Section with all it's Members hierarchically
	 * below it.
	 * 
	 * @param ascending
	 *            true of the Members of the different Section are sorted
	 *            ascending by their surplus, false otherwise
	 * @return a String representation of the Section and Members
	 */
	public abstract String toString(boolean ascending);

}
