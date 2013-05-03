package at.fhhgb.mc.Aufgabe02.Active;

import at.fhhgb.mc.Aufgabe02.Abstract.*;
import at.fhhgb.mc.Aufgabe02.Abstract.ValueException;

/**
 * Implements a Trainer Object where the activity of the trainer determines the
 * costs.
 * 
 * @author Michael Nigl
 * @version 1.1
 */
public class Trainer extends ActiveMember {

	/**
	 * The constructor of the trainer which implements the name and the
	 * activity.
	 * 
	 * @param name
	 *            the name of the new member
	 * @param aktivity
	 *            the activity of the member which determines the costs
	 * @throws ValueException
	 *             if the activity isn't in the valid range of 0-10
	 */
	public Trainer(String name, int aktivity) throws ValueException {
		super(name, 120, aktivity * 40 * 12);
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
		setCosts(getActivity() * 40 * 12);
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
		output.append("Trainer: " + getName() + check + getSurplus()
				+ " for the club.");
		return output.toString();
	}

}
