package at.fhhgb.mc.Aufgabe02.Member;

import at.fhhgb.mc.Aufgabe02.Abstract.*;

/**
 * Implements a chair member Object where the kompetence of the member
 * determines the costs and the income.
 * 
 * @author Michael Nigl
 * @version 1.1
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
	 * @throws ValueException
	 *             if the activity isn't in the valid range of 0-10
	 */
	public ChairMember(String name, int competence) throws ValueException {
		super(name, 100 * competence, 20 * competence);
		setCompetence(competence);

		this.competence = competence;
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
	 * @throws ValueException
	 *             if the activity isn't in the valid range of 0-10
	 */
	public void setCompetence(int competence) throws ValueException {
		if (competence < 0 || competence > 10) {
			throw new ValueException(
					"The competance wasn't in the valid range of 0-10.",
					competence);
		} else {
			this.competence = competence;
		}

		setIncome(100 * this.competence);
		setCosts(20 * this.competence);

	}

	public int getCompetence() {
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
