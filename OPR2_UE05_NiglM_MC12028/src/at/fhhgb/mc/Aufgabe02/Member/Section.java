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
	 * @param m
	 *            the new member which is to be inserted into the tree
	 * @return false if the member already existed or if there was no member in
	 *         the transfer paramether; true if the insertion was successful
	 */
	public boolean addMember(AbstractMember m) {
		if (m == null) {
			return false;
		}
		if (tree == null) {
			tree = new BinarySearchTree();
			tree.insert(m);
			this.setIncome(m.getIncome());
			this.setCosts(m.getCosts());
			return true;
		} else {
			Comparable[] array = tree.toArray(true);
			for (int i = 0; i < array.length; i++) {
				if (array instanceof AbstractMember[]) {
					if (((AbstractMember) array[i]).getName().equals(
							m.getName())) {
						return false;
					}

				}

			}
			this.setIncome(m.getIncome());
			this.setCosts(m.getCosts());
			tree.insert(m);
			return true;
		}
	}

	/**
	 * Overwrites the Income of the AbstractMember class to make sure the new
	 * member values are added instead of replaced.
	 * 
	 * @param income
	 *            the income which is added to the sections income
	 */
	public void setIncome(double income) {
		double result = getIncome() + income;
		super.setIncome(result);
	}

	/**
	 * Overwrites the Costs of the AbstractMember class to make sure the new
	 * member values are added instead of replaced.
	 * 
	 * @param costs
	 *            the costs which is added to the sections costs
	 */
	public void setCosts(double costs) {
		double result = getCosts() + costs;
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
				if (array instanceof AbstractMember[]) {
					if (((AbstractMember) array[i]).getName().equals(name)) {
						check = true;
						i--;
					}
				}
				i++;
			}

			if (check == false) {
				return false;
			} else {
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
				if (array instanceof AbstractMember[]) {
					if (((AbstractMember) array[i]).getName().equals(name)) {
						return true;
					}
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
		output.append(tabulator + "---------------------------------------"
				+ "\n");
		output.append(tabulator + "---------------------------------------"
				+ "\n");
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
		output.append(tabulator + "---------------------------------------"
				+ "\n");
		output.append(tabulator + "---------------------------------------"
				+ "\n");
		offset--;

		return offset;

	}
}
