package at.fhhgb.mc.Aufgabe02.Active;

import at.fhhgb.mc.Aufgabe02.Abstract.ActiveMember;
import at.fhhgb.mc.Aufgabe02.Abstract.ValueException;

/**
 * Implements an TopAthlete member Object where the activity of the member
 * determines the costs.
 * 
 * @author Michael Nigl
 * @version 1.1
 */
public class TopAthlete extends ActiveMember {

	/**
	 * The constructor of the TopAthlete which implements the name and the
	 * activity.
	 * 
	 * @param name
	 *            the name of the new member
	 * @param aktivity
	 *            the activity of the member which determines the costs
	 * @throws ValueException
	 *             if the activity isn't in the valid range of 0-10
	 */
	public TopAthlete(String name, int aktivity) throws ValueException {
		super(name, 120, aktivity * 5 * 12);
		setActivity(aktivity);
	}

	/**
	 * Overwrites the setActivity of the ActiveMember to determine the new
	 * costs.
	 * 
	 * @param activity
	 *            the activity value of the active member
	 * @throws ValueException
	 *             if the activity isn't in the valid range of 0-10
	 */
	public void setActivity(int activity) throws ValueException {
		super.setActivity(activity);
		setCosts(getActivity() * 5 * 12);
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
		output.append("TopAthlete: " + getName() + check + getSurplus()
				+ " for the club.");
		return output.toString();
	}

}
