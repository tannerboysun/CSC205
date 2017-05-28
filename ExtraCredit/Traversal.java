/* This program will do an in-order traversal without using recursion.
 * 
 * @Creator Tanner Boysun
 * @Created 11/22/2016
 * @Version 1.1
 * 
 * Original credit for the Node Class, and BST Class to GDT. (GDT Is my Professor)
 */

import java.util.ArrayList;

/* The following program is a custom made Stack class */
/* It's simplicity makes it appealing to this program */



// =========== //
// Class Stack //
// =========== //

class Stack {
	private ArrayList<Node> stack; 
	private final int DEFAULT_CAPACITY = 5;

	public Stack(){
		stack = new ArrayList<Node>(DEFAULT_CAPACITY);
	}

	public Stack(int Capacity){
		stack = new ArrayList<Node>(Capacity);
	}

	public boolean Push(Node item){
		return stack.add(item);
	}

	public Node Pop(){
		int size = stack.size();
		if (size > 0) {
			Node popped = stack.get(size - 1);
			stack.remove(size - 1);
			return popped;
		} else {
			return null;
		}
	}

	public boolean isEmpty(){
		if (!(stack.size() > 0)){
			return true;
		} else {
			return false;
		}
	}

}

// ========== //
// Node Class //
// ========== //

/* This code was borrowed from GDT in order to create a Binary Search Tree
 * The only thing modified in the Node class is the visited variable
 */

class Node {

	boolean visited = false;
	int key; 
	Node left;
	Node right;

	public Node(int k) { 
		this(k, null, null); 
	}

	public Node(int k, Node l, Node r) { 
		key = k; 
		right = r; 
		left = l;
	}

	public void visit() { 
		System.out.println("\t" + key);
		this.visited = true;

	}

	public String toString(){
		String str = new String("Key: " + key);
		return str;
	}
}

// ========= //
// BST Class //
// ========= //

/* This code was borrowed from GDT in order to implement a Binary Search Tree
 * The Traversals were taken out of the program because they are irrelevant to the 
 * purpose of this application. Although the code from this program can be used to
 * create non recursive traversal for the original BST class.
 */



class BST {

	public Node root;

	public BST() { root = null; }

	public BST insert(int key) {
		if (root == null) {
			root = new Node(key);
			return this;
		}
		return insert(key, root);
	}

	public BST insert(int key, Node parent) {
		if (key == parent.key) return this;
		if (key < parent.key) {
			if (parent.left == null) {
				parent.left = new Node(key);
				return this;
			}
			return insert(key, parent.left);
		} 
		if (parent.right == null) {
			parent.right = new Node(key);
			return this;
		}
		return insert(key, parent.right);
	}
}
// =============== //
// Traversal Class //
// =============== //

public class Traversal {

	// These methods not only consider a node nonexistant if it's null
	// but also if it has been visited.

	public static boolean hasLeft(Node current){
		return (current.left != null && !(current.left.visited));
		}

	public static boolean hasRight(Node current){
		return (current.right != null && !(current.right.visited));
	}


	public static void main(String[] argv){

		Stack parents = new Stack();

		BST tree = new BST();

		int[] a = { 5, 2, 4, 1, 3};
		System.out.println("inputs: ");
		for (int i = 0; i < a.length; i++) {
			tree.insert(a[i]);
			System.out.println("\t" + a[i]);
		}

		Node root = tree.root; 
		System.out.println("Tree Sorted in Order:");

		// ===============================================================
		// THIS IS THE TRAVERSAL, It's small enough to fit in your viewer!
		// No Recursion!
		// ===============================================================

		do {
			if (!hasLeft(root) && hasRight(root)){
				root.visit();
				parents.Push(root);
				root = root.right;
			} else if (!hasLeft(root) && !hasRight(root)){
				// Double checking to make sure the node hasn't already been visited
				if (!(root.visited)){
					root.visit();
				}
				if (!parents.isEmpty()) {
					root = parents.Pop();
				}
			} else if (hasLeft(root)){
				parents.Push(root);
				root = root.left;
			}

		} while (!parents.isEmpty() || !root.visited || (hasLeft(root) || hasRight(root)));
		// While the Parents Stack has stuff and the root has a left or a right node

		// End of the Program
	}
}

