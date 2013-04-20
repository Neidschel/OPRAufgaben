package at.fhhgb.mc.Aufgabe01;

/**
 * This class represents a binary search tree where numbers can be searched 
 * with a binary concept. 
 * Following conditions have to be met here:
 * - Every node left of the current node can only contain a smaller 
 * number than the one saved in the current node
 * - Every node right of the current node can only contain a higher 
 * number than the one saved in the current node
 * - There are no duplicates allowed. (One value can only be once
 * in the tree)
 * 
 * This is not an optimal binary search tree.
 * 
 * Most of the functions are using a recursive algorithm to from the top
 * to the bottom of the tree.
 * 
 * @author Michael Nigl
 * @version 1.0
 *
 */
public class BinarySearchTree{

	/** Inner class for the binary tree node. **/
	protected class BinaryTreeNode {
		
		public BinaryTreeNode left; 
		public BinaryTreeNode right; 
		public Comparable data;
		
		public BinaryTreeNode (Comparable _data) { 
			
			data = _data;
			left = null; 
			right = null;
			
		} 
	}
	
	/** Root node of the tree. **/
	protected BinaryTreeNode root; 	
	
	/** Number of elements stored in the tree. */
	protected int size;
	
	/**
	 * Inserts the given element. Duplicate elements are not allowed. 
	 * 
	 * @param elem - value of the element to be inserted
	 * @return - true if insertion was successful; false otherwise.
	 */
	public boolean insert(Comparable elem) { 
		
		if(root == null){
			
			root = new BinaryTreeNode(elem);
			size++;
			return true;
		
		}else{
			
			return insert(root,elem);
			
		}
		
	}
	
	/**
	 * Helping Method for insert. Determines the location for the new element in the tree.
	 * Duplicate elements are not allowed. 
	 * 
	 * @param node - variable which is recursive used to go through the tree from
	 * the top to the bottom; it represents a node of the tree
	 * @param elem - value of the element to be inserted
	 * @return - true if insertion was successful; false otherwise.
	 */
	private boolean insert(BinaryTreeNode node,Comparable elem) { 
		
		if(node.data.compareTo(elem)>0){
			
			if(node.left != null){
					
				return insert(node.left,elem);
					
			}else{
				

				node.left = new BinaryTreeNode(elem);
				size++;
				return true;
					
			}
			
			
			
		}else if(node.data.compareTo(elem) < 0){
			
			if(node.right != null){
				
				return insert(node.right,elem);
					
			}else{
				

				node.right = new BinaryTreeNode(elem);
				size++;
				return true;
					
			}
			
		}else{
			
			return false;
			
		}
		
	
	}
	
	/**
	 * Searches for the element with the given key. (There can only be one because
	 * no duplicates are allowed.) 
	 * 
	 * @param key - the value which is searched in the tree
	 * @return - true if the value could be found, false otherwise. 
	 */
	public boolean find (Comparable key) { 
		
		if(root == null){
			
			return false;
		
		}else if(root.data.compareTo(key) == 0){
			
			return true;
			
		}else{
			
			return find(root,key);
			
		}
		
	}
	
	/**
	 * Helping Method for find. Determines if the element is in the tree.
	 * 
	 * @param node - variable which is recursive used to go through the tree from
	 * the top to the bottom; it represents a node of the tree
	 * @param key - value of the searched element
	 * @return - true if the value could be found, false otherwise. 
	 */
	private boolean find(BinaryTreeNode node,Comparable key) { 
		
			if(node.data.compareTo(key) > 0){
				
				if(node.left != null){
						
					return find(node.left,key);
						
				}else{
					
					return false;
						
				}
				
				
				
			}else if(node.data.compareTo(key) < 0){
				
				if(node.right != null){
					
					return find(node.right,key);
						
				}else{
					
	
					return false;
						
				}
				
			}else{
				
				return true;
				
			}
		
	}
	
	/**
	 * Removes the element with the given key if it is in the tree.
	 * 
	 * @param key - the value which is searched and removed in the tree
	 * @return - true if the key could be found and was removed, false otherwise.
	 */
	public boolean remove (Comparable key) { 
		
		if(root == null){
			
			return false;
		
		}else{
			
			if(root.data.compareTo(key) == 0){
				
				if(root.left == null && root.right == null){
					
					root = null;
					
				}else if(root.left == null){
					
					root = root.right;
					
				}else if(root.right == null){
					
					root = root.left;
					
				}else{
					
					BinaryTreeNode tmp = root.left;
					root = root.right;
					
					//inserts the remaining elements which aren't attached to the tree
					//anymore into the tree once again (root tree)
					removeNewNodeAttaching(tmp);			
					
				}
				
				size--;
				return true;
					
			}else{

				return remove(root,null,key);
				
			}
			
		}
		
	}
	
	/**
	 * Helping Method for remove. Determines if the element is in the tree and 
	 * removes it, if it is found. 
	 * 
	 * @param node - variable which is recursive used to go through the tree from
	 * the top to the bottom; it represents a node of the tree
	 * @param head - the node from the previous recursive step. It's needed to connect
	 * the head to a different node if the key was found in the actual node. 
	 * @param key - value of the element to be removed
	 * @return - true if the key could be found and was removed, false otherwise.
	 */
	private boolean remove (BinaryTreeNode node,BinaryTreeNode head,Comparable key) { 
		
		if(node.data.compareTo(key) > 0){
			
			if(node.left != null){
					
				return remove(node.left,node,key);
					
			}else{
				
				return false;
					
			}
			
			
			
		}else if(node.data.compareTo(key) < 0){
			
			if(node.right != null){
				
				return remove(node.right,node,key);
					
			}else{
				

				return false;
					
			}
			
		}else{
			
			if(node.left == null && node.right == null){
				
				node = null;
				
			
			}else{
				
				if(node.left == null){
					
					if(head.data.compareTo(node.right.data) > 0){
						
						head.left = node.right;
						
					}else{
						
						head.right = node.right;
						
					}				
					
				}else if(node.right == null){
					
					if(head.data.compareTo(node.left.data) > 0){
						
						head.left = node.left;
						
					}else{
						
						head.right = node.left;
						
					}
					
				}else{
				
					BinaryTreeNode tmp = node.left;
					if(head.data.compareTo(node.right.data) > 0){
						
						head.left = node.right;
						
					}else{
						
						head.right = node.right;
						
					}
					
					//inserts the remaining elements which aren't attached to the tree
					//anymore into the tree once again (root tree)
					removeNewNodeAttaching(tmp);
										
				}
				
			}
			
			size--;
			return true;
			
		}
		
	}
	
	/**
	 * Another helping method for remove. It inserts the values from node and all nodes
	 * which are hierarchically below it once more into the tree. (the root tree)
	 * 
	 * @param node - variable which is recursive used to go through the tree from
	 * the top to the bottom; it represents a node of the tree
	 */
	private void removeNewNodeAttaching(BinaryTreeNode node) { 
		
		if(node.left != null){
			
			removeNewNodeAttaching(node.left);
			
		}
			
		if(node.right != null){
				
			removeNewNodeAttaching(node.right);
				
		}
		
		Comparable val = node.data;
		
		//deletes the node and inserts its value once again
		node = null;
		size--;
		insert(val);
				
	}
	
	/**
	 * Returns the number of elements stored in the tree. 
	 * 
	 * @return size - the number of elements in the tree
	 */
	public int size () { 
		
		return size;
		
	}


	/**
	 * Saves the elements of the tree in ascending or descending into an array.
	 * 
	 * @param ascending - true if its ordered ascending; false if its ordered descending
	 * @return elements - the array containing the numbers
	 */
	public Comparable[] toArray (boolean ascending) {
		
		Comparable[] elements = new Comparable[size];
		int offset = 0;
		if(root==null){
			
			return null;
			
		}else{
			
			toArray(elements,ascending,offset,root);
			
		}
		
		return elements;
		
	}
	
	/**
	 * Helping Method for toArray. Determines the elements in the tree 
	 * saves on element after another into the array.
	 * 
	 * @param elements - the array containing the numbers
	 * @param ascending - true if its ordered ascending; false if its ordered descending
	 * @param offset - a helping variable which is used to determine the index where to 
	 * save the next value into the array
	 * @param node - variable which is recursive used to go through the tree from
	 * the top to the bottom; it represents a node of the tree
	 * @return offset - returns the index for the next insert
	 */
	private int toArray (Comparable[] elements,boolean ascending,int offset,BinaryTreeNode node) {
		
		if(ascending == true){
			
			if(node.left != null){
				
				offset = toArray(elements, ascending,offset,node.left);
				
			}
			
			elements[offset] = node.data;
			offset++;
			
			if(node.right != null){
					
				offset = toArray(elements, ascending,offset,node.right);
					
			}
			
			return offset;
				
			
			
		}else{
				

			if(node.right != null){
				
				offset = toArray(elements, ascending,offset,node.right);
				
			}
				
			elements[offset] = node.data;
			offset++;
				
			if(node.left != null){
					
				offset = toArray(elements, ascending,offset,node.left);
					
			}
			
			return offset;
			
			
		}
		
		
	}
	
	
	/**
	 * Searches for the element with the highest value in the tree
	 * 
	 * @return - the highest value of the tree or INTEGER.MAX_VALUE if there are
	 * no elements inside the tree
	 */
	public Comparable max () { 
		
		if(root == null){
			
			return Integer.MAX_VALUE;
		
		}else if(root.right == null){
			
			return root.data;
			
		}else{
			
			return max(root);
			
		}
		
	}
	
	/**
	 * Helping Method for max. Determines which is the element with the
	 * highest value in the tree.
	 * 
	 * @param node - variable which is recursive used to go through the tree from
	 * the top to the bottom; it represents a node of the tree
	 * @return - the highest value of the tree
	 */
	private Comparable max(BinaryTreeNode node) { 
		
		if(node.right != null){
			
			return max(node.right);
			
		}else{
			
			return node.data;
			
		}
		
	}
	
	
	/**
	 * Searches for the element with the lowest value in the tree
	 * 
	 * @return - the lowest value of the tree or INTEGER.MIN_VALUE if there are
	 * no elements inside the tree
	 */
	public Comparable min() { 
		
		if(root == null){
			
			return Integer.MIN_VALUE;
		
		}else if(root.left == null){
			
			return root.data;
			
		}else{
			
			return min(root);
			
		}
		
	}
	
	/**
	 * Helping Method for min. Determines which is the element with the
	 * lowest value in the tree.
	 * 
	 * @param node - variable which is recursive used to go through the tree from
	 * the top to the bottom; it represents a node of the tree
	 * @return - the lowest value of the tree
	 */
	private Comparable min(BinaryTreeNode node) { 
		
		if(node.left != null){
			
			return min(node.left);
			
		}else{
			
			return node.data;
			
		}
		
	}
	
	
	/**
	 * Represents the tree in a human readable form. 
	 * 
	 * @return output2 - the tree represented as String
	 */
	public String toString() { 
		
		int depth = getDepth(root);
		String[][] tree;
			
		StringBuilder output = new StringBuilder();
		
		if(depth == -1){
			
			return "This Tree is empty!";
			
		}else{
			
			//Array for positions of the tree values
			tree = new String[(depth+1)][(int)Math.pow(2, (depth+1))-1];
			
			int spaces = (""+max()).length();
			
			//fills the array with spaces
			for(int i = 0;i < tree.length;i++){
				
				for(int j = 0;j < tree[i].length;j++){
					tree[i][j] = " ";
					
					if(spaces > 1){
						for(int k = 0; k < spaces-1;k++){
						
							tree[i][j] = " "+tree[i][j];
						
						}
					}
					
				}				
				
			}
			
			int[] position = {0,0};
						
			toString(root,tree,position,spaces);
			
		}
		
		//adds the array to a StringBuilder
		for(int i = 0;i < tree.length;i++){
			
			for(int j = 0;j < tree[i].length;j++){
				
				output.append(tree[i][j]);
				
			}
			output.append("\n");
		}
				
		return output.toString();
		
	}
	
	/**
	 * Determines the depth of the tree
	 * 
	 * @param node - variable which is recursive used to go through the tree from
	 * the top to the bottom; it represents a node of the tree
	 * @return - the tree depth or -1 of there is no tree
	 */
	private int getDepth(BinaryTreeNode node) { 
		int depthLeft, depthRight;
		
		if (node==null){ 
			
			return -1;
			
		}
		
		depthLeft = getDepth(node.left); 
		depthRight = getDepth(node.right); 
		
		if (depthLeft>depthRight){
		
			return depthLeft+1;
		
		}
			return depthRight+1;
	}
	
	
	/**
	 * Helping Method for String. Determines which element is printed on 
	 * which position for the output
	 * 
	 * @param node - variable which is recursive used to go through the tree from
	 * the top to the bottom; it represents a node of the tree
	 * @param tree - a multidimensional Array where the positions for the tree
	 * elements are saved
	 * @param position - saves the index for the recursive depth and the index for
	 * the next element to write into "tree"
	 * @param spaces - used to center the numbers if it hasn't the length of the
	 * highest number in the tree
	 * @return position - returns the index for the next insert
	 */
	private int[] toString(BinaryTreeNode node,String[][] tree,int[] position,int spaces) { 
	
		
		if(node.left != null){
			
			position[0]++;
			position = toString(node.left, tree, position,spaces);
			
		}
		
		tree[position[0]][position[1]] = ""+node.data;
		
		//positions the number in the middle
		if(tree[position[0]][position[1]].length() != spaces){
			
			int range = spaces-tree[position[0]][position[1]].length();
			
			for(int k = 0; k < range;k++){
				
				if((k%2)==0){
					
					tree[position[0]][position[1]] = " "+tree[position[0]][position[1]];
					
				}else{

					tree[position[0]][position[1]] = tree[position[0]][position[1]]+" ";

				}
			
			}
			
		}
			
		
		position[1]++;
		
		if(node.right != null){
			position[0]++;
			position = toString(node.right, tree, position,spaces);
				
		}
		
		position[0]--;
		return position;
				
	}

	
}
