package at.fhhgb.mc.Aufgabe02.Active;

import at.fhhgb.mc.Aufgabe02.Abstract.ActiveMember;

/**
 * Implements an AmateurAthlete member Object where the activity of the member
 * determines the costs.
 * 
 * @author Michael Nigl
 * @version 1.0
 */
public class AmateurAthlete extends ActiveMember {

	/**
	 * The constructor of the AmateurAthlete which implements the name and the
	 * activity.
	 * 
	 * @param name
	 *            the name of the new member
	 * @param aktivity
	 *            the activity of the member which determines the costs
	 */
	public AmateurAthlete(String name, int aktivity) {
		super(name, 120, aktivity * 2.5 * 12);
	}

	/**
	 * Overwrites the Costs of the AbstractMember because the activity value has
	 * to be considered.
	 * 
	 * @param activity
	 *            the activity value of the active member
	 */
	public void setCosts(int activity) {
		setActivity(activity);
		super.setCosts(getActivity() * 2.5 * 12);
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
		output.append("AmateurAthlete: " + getName() + check + getSurplus()
				+ " for the club.");
		return output.toString();
	}

}
