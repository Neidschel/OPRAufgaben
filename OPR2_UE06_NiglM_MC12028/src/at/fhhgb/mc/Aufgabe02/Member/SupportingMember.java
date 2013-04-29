package at.fhhgb.mc.Aufgabe02.Member;

import at.fhhgb.mc.Aufgabe02.Abstract.AbstractMember;

/**
 * Implements a supporting member Object. This member has a income of 100 and costs of
 * 20 per year.
 * 
 * @author Michael Nigl
 * @version 1.0
 */
public class SupportingMember extends AbstractMember{

	/**
	 * The constructor of the supporting member which implements the name.
	 * 
	 * @param name
	 *            the name of the new member
	 */
	public SupportingMember(String name){
		super(name,100,15.0);
	}
	
	
	/* (non-Javadoc)
	 * @see at.fhhgb.mc.Aufgabe02.Abstract.AbstractMember#toString(boolean)
	 */
	public String toString(boolean ascending){
		String check;
		if(getSurplus() >= 0){
			check = " earns ";
		}else{
			check = " costs ";
		}
		StringBuilder output = new StringBuilder();
		output.append("SupportingMember "+getName()+check+getSurplus()+" for the club.");
		return output.toString();
	}
}
