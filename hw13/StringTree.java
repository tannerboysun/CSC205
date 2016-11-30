import java.io.*;
import java.util.*;

/*
 * A "tree" is a collection of nodes.  Each node contains data, along 
 * with two links:  a left subtree link and a right subtree link. 
 * This program implements a binary tree.
 *
 * @creator gdt
 * @created ???
 * @version 02016.11.01
 * @caveat  Instance variables are public to minimize implementation
 *          details (they should be private). 
 *
 */

class Node {

	public String word; 
	public Node left; 
	public Node right;
	public Node parent;
	public int level;
	public Node(String w) { 
		word = w; 
		left = null;
		right = null;
	}

};

public class StringTree {

	private static Node root; 

	public StringTree() { root = null; }
	public int numOfNodes = 0;
	public int height = 0;
	public void add(String item) {  

		Node spot = find(root, item);
		if (spot != null && spot.word.equals(item))
			return;   //dups not allowed...
		numOfNodes++;
		Node node = new Node(item);   //create a new Node object

		/*
		 * find()  returned "spot" where new Node should be inserted...
		 * if spot is null, then that implies an empty tree and the new Node 
		 * becomes the root of our tree; otherwise, determine if the new Node 
		 * goes to the left or to the right...
		 */


		if (spot == null) { 
			root = node; 
			root.level = height;
			return; 
		}
		if (item.compareTo(spot.word) < 0){
			spot.left = node;
			node.parent = spot;

		}else{ 
			spot.right = node;
			node.parent = spot;
		}

		if (node.parent != null){ 	
			node.level = node.parent.level + 1;

			if (node.level > this.height)
				height = node.level;

		}
	}
	public static Node min(Node cur){
		if (cur == null)
			cur = root;
		if (cur.left != null){
			cur = cur.left;
		return min(cur);
		}
		return cur;
	}

	public static Node max(Node cur){
		if (cur == null)
			cur = root;
		if (cur.right != null){
			cur = cur.right;
			return max(cur);
		}
		return cur;
	}
	/*
	 * If received pointer is null, then begin printing from the root.
	 * Traverse all the left subtrees followed by the right subtrees.
	 */
	public static void print(Node ptr) {
		if (ptr == null) 
			ptr = root;
		if (ptr.left != null) 
			print(ptr.left);

		if (ptr.level == 0){
			System.out.println(ptr.word + "(level " + ptr.level + "; root node)");
		} else {
			System.out.println(ptr.word + "(level " + ptr.level + "; child of " + ptr.parent.word + ")"); 
		}

		if (ptr.right != null) 
			print(ptr.right);
	}

	/*
	 * Received Node pointer is spot where word search should begin.
	 * If null, then tree is empty.  If searching for a word greater
	 * than the "spot" word, then search right subtree; otherwise, if
	 * key word less than "spot" word, then search left subtree.
	 */
	public Node find(Node spot, String item) {

		if (spot == null) 
			return null;   //empty tree
		if (item.compareTo(spot.word) > 0) {
			if (spot.right == null) 
				return spot;
			return find(spot.right, item);
		}
		if (item.compareTo(spot.word) < 0) {
			if (spot.left == null) 
				return spot;
			return find(spot.left, item);
		}
		return spot;
	}

	/*
	 * Read in a file and split the file into tokens.  Each token is 
	 * stored in a tree object.  Print the contents of the tree forwards 
	 * and backwards.
	 */
	public static void main(String[] argv) {

		String[] words = {
			"let", "the", "programmer", "be", "many",
			"and", "the", "managers", "few", "then",
			"all", "will", "be", "productive" };

		String[] letters = { "A", "D", "G", "J", "M", "N", "B", "C" };

		plant("word tree", words);
		plant("letter tree", letters);
	}

	static void plant(String heading, String[] data) {

		StringTree tree = new StringTree();

		System.out.print("inputs: ");
		for (int i = 0; i < data.length; i++) {
			tree.add(data[i]);
			System.out.print(data[i] + " ");
		}
		System.out.println("\nbegin " + heading + "...");
		tree.print(null); 
		System.out.println("end " + heading + "... #nodes = " + tree.numOfNodes + "; height = " + tree.height + ";" +
				" min = " + tree.min(null).word + "; max = " + tree.max(null).word + "\n");
	}
}
