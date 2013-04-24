package at.fhhgb.mc.Aufgabe02.Member;

import at.fhhgb.mc.Aufgabe02.Abstract.AbstractMember;

/**
 * Implements a chair member Object where the kompetence of the member
 * determines the costs and the income.
 * 
 * @author Michael Nigl
 * @version 1.0
 */
public class ChairMember extends AbstractMember {

	private int competence;

	/**
	 * The constructor of the chair member which implements the name and the
	 * competence.
	 * 
	 * @param name
	 *            the name of the new member
	 * @param competence
	 *            the competence of the member which determines the costs and
	 *            the income
	 */
	public ChairMember(String name, int kompetence) {
		super(name, 100 * kompetence, 20 * kompetence);
		this.competence = kompetence;
	}

	/**
	 * Determines the competence of an chair member of the section. This value
	 * of activity affects the costs and the income the chair member has for the
	 * section.
	 * 
	 * If the value is below 0 it's adjusted to 0 and if it's higher than 10
	 * it's reduced to 10.
	 * 
	 * @param competence
	 *            the competence of the chair member
	 */
	public void setKompetenz(int competence) {
		if (competence < 0) {
			this.competence = 0;
		} else if (competence > 10) {
			this.competence = 10;
		} else {
			this.competence = competence;
		}

		setIncome(100 * competence);
		setCosts(20 * competence);

	}

	public int getKompetenz() {
		return competence;
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
		output.append("ChairMember: " + getName() + check + getSurplus()
				+ " for the club.");
		return output.toString();
	}
}
