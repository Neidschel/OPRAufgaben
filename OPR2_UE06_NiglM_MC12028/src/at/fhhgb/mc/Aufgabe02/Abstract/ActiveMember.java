package at.fhhgb.mc.Aufgabe02.Abstract;

/**
 * An abstract class for the active members mainly used to store the activity
 * value which determines their costs.
 * 
 * @author Michael Nigl
 * @version 1.0
 */
public abstract class ActiveMember extends AbstractMember {

	private int activity;

	/**
	 * The constructor of the ActiveMember class which transfers the transfer
	 * parameters from the active member classes to the AbstractMember class.
	 * 
	 * @param name
	 *            the name of the member
	 * @param income
	 *            the income of the member
	 * @param costs
	 *            the costs of the member
	 */
	public ActiveMember(String name, double income, double costs) {
		super(name, income, costs);
	}

	/**
	 * Determines the activity of an active member of the section. This value of
	 * activity affects the costs the active member has for the section.
	 * 
	 * If the value is below 0 it's adjusted to 0 and if it's higher than 10
	 * it's reduced to 10.
	 * 
	 * @param activity
	 *            the activity of the active member
	 * @throws ValueException
	 *             if the activity isn't in the valid range of 0-10
	 */
	public void setActivity(int activity) throws ValueException {
		if (activity < 0 || activity > 10) {
			throw new ValueException(
					"The activity wasn't in the valid range of 0-10.", activity);
		} else {
			this.activity = activity;
		}
	}

	public int getActivity() {
		return activity;
	}

}
