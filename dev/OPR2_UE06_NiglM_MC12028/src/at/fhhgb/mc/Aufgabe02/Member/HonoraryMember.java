package at.fhhgb.mc.Aufgabe02.Member;

import at.fhhgb.mc.Aufgabe02.Abstract.AbstractMember;

/**
 * Implements a honorary member Object. This member has no income and costs of
 * 20 per year.
 * 
 * @author Michael Nigl
 * @version 1.0
 */
public class HonoraryMember extends AbstractMember {
	
	/**
	 * The constructor of the honorary member which implements the name.
	 * 
	 * @param name
	 *            the name of the new member
	 */
	public HonoraryMember(String name) {
		super(name, 0, 20.0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see at.fhhgb.mc.Aufgabe02.Abstract.AbstractMember#toString(boolean)
	 */
	public String toString(boolean ascending) {
		String check;
		if (getSurplus() >= 0) {
			check = " earns ";
		} else {
			check = " costs ";
		}
		StringBuilder output = new StringBuilder();
		output.append("HonoraryMember: " + getName() + check + getSurplus()
				+ " for the club.");
		return output.toString();
	}

}
