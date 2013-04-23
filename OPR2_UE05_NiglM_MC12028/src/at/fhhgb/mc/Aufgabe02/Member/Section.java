package at.fhhgb.mc.Aufgabe02.Member;

import at.fhhgb.mc.Aufgabe02.Abstract.AbstractMember;
import at.fhhgb.mc.Aufgabe02.Abstract.BinarySearchTree;


public class Section extends AbstractMember{
	
	private BinarySearchTree tree;
	
	public Section(String name){
		super(name,0,0);
	}
	
	public boolean addMember(AbstractMember m){
		if(m == null){
			return false;
		}
		if(tree == null){
			tree = new BinarySearchTree();
			tree.insert(m);
			return true;
		}else{
			Comparable[] array = tree.toArray(true);
			for(int i = 0; i < array.length;i++){
		//		if (array instanceof AbstractMember[]) {
					if( ((AbstractMember) array[i]).getName().equals(m.getName())){
						return false;
					}
					
			//	}
					
			}
			
			tree.insert(m);
			return true;
		}
	}
	
	
	public boolean removeMember(String name){
		
		if(tree == null || name == null){
			return false;
		}else{
			Comparable[] array = tree.toArray(true);
			boolean check = false;
			int i = 0;
			
			while(i < array.length && check == false){
				if (array instanceof AbstractMember[]) {
					if( ((AbstractMember) array[i]).getName().equals(name)){
						check = true;
						i--;
					}
				}
				i++;
			}
			
			if(check==false){
				return false;
			}else{
				Comparable[] newTree = new Comparable[array.length-1];
				for(int j = 0; j < newTree.length;j++){
					if(j<i){
						newTree[j] = array[j];
					}else{
						newTree[j] = array[j+1];
					}
				}
				
				tree.balance(newTree);
				return true;
				
			}
			
		}
	}
	
	public boolean isMember(String name){
		if(tree == null || name == null){
			return false;
		}else{
			Comparable[] array = tree.toArray(true);
			
			for(int i = 0; i < array.length;i++){
				if (array instanceof AbstractMember[]) {
					if( ((AbstractMember) array[i]).getName().equals(name)){
						return true;
					}
				}
			}
			
			return false;
		}
	}
	
	public String toString(boolean ascending){
		Comparable[] array;
		StringBuilder output = new StringBuilder();
		if(ascending == true){
			array = tree.toArray(true);
		}else{
			array = tree.toArray(false);
		}
		
		output.append(" "+"The Club "+this.getName()+" earns the amount of: "+this.getSurplus()+"\n");
		output.append(" "+"It has the following Members: "+"\n");
		
		for(int i = 0; i < array.length;i++){
			if (array instanceof AbstractMember[]) {
				output.append(" "+((AbstractMember) array[i]).toString());
			}
		}
		
		return output.toString();
		
	}
	
}
