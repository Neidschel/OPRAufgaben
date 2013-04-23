package at.fhhgb.mc.Aufgabe02.Member;

import at.fhhgb.mc.Aufgabe02.Abstract.AbstractMember;
import at.fhhgb.mc.Aufgabe02.Abstract.BinarySearchTree;

public class Section extends AbstractMember {

	private BinarySearchTree tree;

	/**
	 * The constructor initializes the section with it's name but no income and
	 * costs because it has no members at this point.
	 * 
	 * @param name the name of the new section
	 */
	public Section(String name) {
		super(name, 0, 0);
	}
	
	
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
	 * 
	 */
	public void setIncome(double income) {
		double result = getIncome() + income;
		super.setIncome(result);
	}

	public void setCosts(double costs) {
		double result = getCosts() + costs;
		super.setCosts(result);
	}

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

	public String toString(boolean ascending) {
		StringBuilder output = new StringBuilder();
		toString(output, ascending, this, 0);

		return output.toString();
	}

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
