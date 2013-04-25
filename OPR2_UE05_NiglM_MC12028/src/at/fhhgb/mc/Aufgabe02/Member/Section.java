package at.fhhgb.mc.Aufgabe02.Member;

import at.fhhgb.mc.Aufgabe02.Abstract.AbstractMember;
import at.fhhgb.mc.Aufgabe02.Abstract.BinarySearchTree;

/**
 * This class represents a section which can store members and other subsections
 * in it. The elements are stored in a tree and are sorted by their money they
 * earn annually.
 * 
 * Elements can be inserted, removed and searched.
 * 
 * @author Michael Nigl
 * @version 1.0
 */
public class Section extends AbstractMember {

	private BinarySearchTree tree;

	/**
	 * The constructor initializes the section with it's name but no income and
	 * costs because it has no members at this point.
	 * 
	 * @param name
	 *            the name of the new section
	 */
	public Section(String name) {
		super(name, 0, 0);
	}

	/**
	 * Adds a new member into the tree. The condition is that this members name
	 * isn't already listed in this section. Furthermore the sections income and
	 * costs will be adjusted by the income and cost of its new member.
	 * 
	 * Member with the name "failfailfail" can't be inserted because there went
	 * something wrong with the name of that object
	 * 
	 * @param m
	 *            the new member which is to be inserted into the tree
	 * @return false if the member already existed or if there was no member in
	 *         the transfer parameter; true if the insertion was successful
	 */
	public boolean addMember(AbstractMember m) {
		if (m == null || ((AbstractMember) m).getName().equals("failfailfail") || this.getName().equals("failfailfail")) {
			return false;
		}
		if (tree == null) {
			tree = new BinarySearchTree();
			tree.insert(m);
			this.addIncome(m.getIncome());
			this.addCosts(m.getCosts());
			return true;
		} else {
			Comparable[] array = tree.toArray(true);
			for (int i = 0; i < array.length; i++) {
				if (((AbstractMember) array[i]).getName().equals(m.getName())) {
					return false;

				}

			}
			this.addIncome(m.getIncome());
			this.addCosts(m.getCosts());
			tree.insert(m);
			return true;
		}
	}

	/**
	 * Adds the income of the new member to the sections income.
	 * 
	 * @param income
	 *            the income which is added to the sections income
	 */
	private void addIncome(double income) {
		double result = getIncome() + income;
		super.setIncome(result);
	}

	/**
	 * Adds the costs of the new member to the sections income.
	 * 
	 * @param costs
	 *            the costs which is added to the sections costs
	 */
	private void addCosts(double costs) {
		double result = getCosts() + costs;
		super.setCosts(result);
	}

	/**
	 * Remobes the income of the new member frome the sections income.
	 * 
	 * @param income
	 *            the income which is removed to the sections income
	 */
	private void removeIncome(double income) {
		double result = getIncome() - income;
		super.setIncome(result);
	}

	/**
	 * Removes the costs of the new member to the sections income.
	 * 
	 * @param costs
	 *            the costs which is removed to the sections costs
	 */
	private void removeCosts(double costs) {
		double result = getCosts() - costs;
		super.setCosts(result);
	}

	/**
	 * Searches the section for a member by it's name and removes him if there's
	 * a match.
	 * 
	 * @param name
	 *            the member which is to be removed
	 * @return true if the member was found and deleted, false otherwise
	 */
	public boolean removeMember(String name) {

		if (tree == null || name == null) {
			return false;
		} else {
			Comparable[] array = tree.toArray(true);
			boolean check = false;
			int i = 0;

			while (i < array.length && check == false) {
				if (((AbstractMember) array[i]).getName().equals(name)) {
					check = true;
					i--;
				}
				i++;
			}

			if (check == false) {
				return false;
			} else {
				// removes the costs and income of the deleted member from the
				// section
				removeIncome(((AbstractMember) array[i]).getIncome());
				removeCosts(((AbstractMember) array[i]).getCosts());
				Comparable[] newTree = new Comparable[array.length - 1];
				for (int j = 0; j < newTree.length; j++) {
					if (j < i) {
						newTree[j] = array[j];
					} else {
						newTree[j] = array[j + 1];
					}
				}
				tree.balance(newTree);
				return true;
			}
		}
	}

	/**
	 * Searches the section for a member by it's name.
	 * 
	 * @param name
	 *            the member which is searched
	 * @return true if the member was found, false otherwise
	 */
	public boolean isMember(String name) {
		if (tree == null || name == null) {
			return false;
		} else {
			Comparable[] array = tree.toArray(true);

			for (int i = 0; i < array.length; i++) {
				if (((AbstractMember) array[i]).getName().equals(name)) {
					return true;
				}

			}

			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see at.fhhgb.mc.Aufgabe02.Abstract.AbstractMember#toString(boolean)
	 */
	public String toString(boolean ascending) {
		StringBuilder output = new StringBuilder();
		toString(output, ascending, this, 0);

		return output.toString();
	}

	/**
	 * A helping method for toString() of the section to make sure that all
	 * sections and it's subsections are printed properly. The members are
	 * sorted by their surplus they make annually.
	 * 
	 * A recursive algorithm calls this section and all its subsections and
	 * members for printing.
	 * 
	 * @param output
	 *            a StringBuilder where all the output is stored and printed
	 * @param ascending
	 *            true if the output is sorted ascending, false if the output is
	 *            sorted descending.
	 * @param s
	 *            the subsection which members are printed
	 * @param offset
	 *            counts the recursive to know how many indentations have to be
	 *            done
	 * @return the String representation of the section its subsections and its
	 *         members
	 */
	private int toString(StringBuilder output, boolean ascending, Section s,
			int offset) {
		Comparable[] array;
		// StringBuilder output = new StringBuilder();
		if (ascending == true) {
			array = s.tree.toArray(true);
		} else {
			array = s.tree.toArray(false);
		}
		StringBuilder tabulator = new StringBuilder();
		for (int i = 0; i < offset; i++) {
			tabulator.append("\t");
		}
		output.append(tabulator + "---------------------------------------"
				+ "\n");
		output.append(tabulator + "---------------------------------------"
				+ "\n");
		output.append(tabulator + s.getName() + " Club " + "\n");
		output.append(tabulator + "- has an income of: " + s.getIncome() + "\n");
		output.append(tabulator + "- has costs of: " + s.getCosts() + "\n");
		output.append(tabulator + "- earns: " + s.getSurplus() + " a year."
				+ "\n");
		output.append(tabulator + "- has the following Members: " + "\n");
		output.append(tabulator + "----------------------------" + "\n");
		output.append(tabulator + "----------------------------" + "\n");
		for (int i = 0; i < array.length; i++) {
			if (((AbstractMember) array[i]) instanceof Section) {
				offset += 1;
				toString(output, ascending, ((Section) array[i]), offset);
			} else {
				output.append(tabulator + "\t"
						+ ((AbstractMember) array[i]).toString(ascending)
						+ "\n");
			}
		}
		output.append(tabulator + "\t"
				+ "---------------------------------------" + "\n");
		output.append(tabulator + "\t"
				+ "---------------------------------------" + "\n");
		offset--;

		return offset;

	}
}
