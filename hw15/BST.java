/*
 * This program has added extended functionality to the BST class, such as
 * a level traversal, implementing min and max methods, implementing delete methods
 * implementation of a queue that supports BST nodes, implementation of a find method
 * and a few more modifications.
 *
 * I apologize for the delete code, I know it's gross but it works for every case.
 * 
 * @Creator Tanner Boysun
 * @Created 12/11/2016
 * @Credit GDT for original BST program.
 *
 * class BST implements a Binary Search Tree (BST) that is used 
 * to demonstrate traversal algorithms.
 *
 * @creator gdt
 * @created 02016.11.13
 */


import java.util.ArrayList;
public class BST {

	public Node root;
	public int nodecnt;

	public BST() { root = null; nodecnt = 0; }

	public BST inOrderTraversal(Node node) {
		if (root == null) return this;
		if (node == null) node = root;
		if (node.left != null) 
			inOrderTraversal(node.left);
		node.visit(); 
		if (node.right != null) 
			inOrderTraversal(node.right);
		return this;
	}

	public BST preOrderTraversal(Node node) {
		if (root == null) return this;
		if (node == null) node = root;
		node.visit(); 
		if (node.left != null) 
			preOrderTraversal(node.left);
		if (node.right != null) 
			preOrderTraversal(node.right);
		return this;
	}

	public BST postOrderTraversal(Node node) {
		if (root == null) return this;
		if (node == null) node = root;
		if (node.left != null) 
			postOrderTraversal(node.left);
		if (node.right != null) 
			postOrderTraversal(node.right);
		node.visit(); 
		return this;
	}

	public BST levelOrderTraversal(Node node) {
		Queue q = new Queue();

		q.enqueue(this.root);

		while(!q.isEmpty()){
			Node cur = q.dequeue();
			cur.visit();	
			if (cur.left != null)
				q.enqueue(cur.left);
		}

		/*

		 * the algorithm...
		 * + instantiate a queue
		 * + enqueue root node
		 * + while queue not empty
		 *   - node = dequeue
		 *   - visit node (print)
		 *   - enqueue node's children (left then right)
		 */









		return this;
	}

	public BST insert(int key) {
		if (root == null) {
			root = new Node(key, null);
			nodecnt++;
			return this;
		}
		return insert(key, root);
	}

	public BST insert(int key, Node parent) {
		if (key == parent.key) return this;
		nodecnt++;
		if (key < parent.key) {
			if (parent.left == null) {
				parent.left = new Node(key, parent);
				return this;
			}
			return insert(key, parent.left);
		} 
		if (parent.right == null) {
			parent.right = new Node(key, parent);
			return this;
		}
		return insert(key, parent.right);
	}

	// delete parameter key if found... always returns this 
	//
	public BST delete(int key) {

		// Welcome to the ugliest method i've ever written, but it
		// works for all cases!

		Node sub = find(key);
		if (sub == null) {
			return this;
		}

		if (sub.parent == null){

			if (sub.left == null && sub.right == null){
				this.root = null;
				return this;
			}

			if (sub.left == null){
				root = sub.right;
				sub.right.parent = null;
				sub.right = null;
				return this;

			} else if (sub.right == null){
				root = sub.left;
				sub.left.parent = null;
				sub.left = null;
				return this;
			}

			if (sub.left != null && sub.right != null){
				root = sub.left;
				sub.right.parent = sub.left;
				sub.left.right = sub.right;
				sub.left.parent = null;
				sub.parent = null;
				return this;
			}

			Node replace;
			if (sub.left != null)
				replace = max(sub.left);
			else 
				replace = min(sub.right);


			if (replace.parent.left != null && replace.parent.left.key == replace.key)
				replace.parent.left = null;
			else{
				replace.parent.right = null;
				root = replace;
				replace.left = sub.left;
				replace.right = sub.right;
				sub.right = null;
				sub.left = null;
				replace.left.parent = replace;
				replace.right.parent = replace;
				replace.parent = null;

				return this;
			}
		}

		// I know this looks ugly, sorry :(
		if (sub.left == null && sub.right == null){
			if (sub.parent.left != null && sub.parent.left.key == sub.key)
				sub.parent.left = null;
			else
				sub.parent.right = null;
			return this;
		}else	if (sub.left == null || sub.right == null){
			if (sub.left == null){

				if	(sub.parent.left.key == sub.key){
					sub.parent.left = sub.right;
					sub.right.parent = sub.parent;
				}else {
					sub.parent.right = sub.right;
					sub.right.parent = sub.parent;
				}

			} else {

				if (sub.parent.left.key == sub.key){
					sub.parent.left = sub.left;
					sub.left.parent = sub.parent;
				} else {
					sub.parent.right = sub.left;
					sub.left.parent = sub.parent;
				}
			}
			return this;
		} else if (sub.left != null && sub.right != null){
			Node max = max(sub.left);
			if (max.parent.left.key == max.key){
				max.parent.left = null;
				max.parent = sub.parent;
			} else {
				max.parent.right = null;
				max.parent = sub.parent;
			}
			if (sub.parent.left.key == sub.key)
				sub.parent.left = max;

			else
				sub.parent.right = max;

			return this;

		} else {
			System.out.println("There was a problem with delete");
			return this;
		}
	}
	public Node find(int key) {
		if (root == null) return null;
		return find(key, root);
	}

	// begin search for parameter key starting at parameter n...
	// returns null if key not found
	//

	public Node find(int key, Node n) {

		if (key == n.key)
			return n;	
		if (key > n.key && n.right != null)
			return find(key, n.right);
		else if (key < n.key && n.left != null) 
			return find(key, n.left);
		else if (n.left == null && n.right == null && n.key != key)
			return null;
		return n;
	}



	// begin search for minimum starting with parameter n...
	//
	public Node min(Node n) {
		if (n == null)
			n = root;
		if (n.left != null){
			n = n.left;
			return min(n);
		}
		return n;
	}

	// begin search for maximum starting with parameter n...
	//
	public Node max(Node n) {
		if (n == null)
			n = root;
		if (n.right != null){
			n = n.right;
			return max(n);
		}
		return n;
	}


	/*
	 * BST.main(String[] argv) is used to test class BST
	 */


	public static void main(String[] argv) {

		int[] a = { 30, 20, 40, 18, 25, 24, 27, 23, 21, 22, 29, 35, 42 };

		// testing delete...
		for (int i = 0; i < a.length; i++)
			delete(init(a), a[i]);

		// testing min and max...
		BST tree = init(a);
		System.out.println("min = " + tree.min(tree.root).key +
				"; max = " + tree.max(tree.root).key);

		// testing find...
		int[] f = { a[0], a[a.length-1], 205, a[a.length/2] };
		for (int i = 0; i < f.length; i++)
			System.out.println("find(" + f[i] + "): " + 
					((tree.find(f[i]) == null) ? 
					 "not found" : "found"));

		// testing level-order traversal...
		System.out.println("\nlevel-order traversal:");  
		tree.levelOrderTraversal(null);

		// testing deleting/traversal small trees (1, 2, 3 nodes)...
		deleteSmallTrees();

	}

	static BST init(int[] a) {
		BST tree = new BST();
		System.out.print("\ninputs: ");
		for (int i = 0; i < a.length; i++) {
			tree.insert(a[i]);
			System.out.print(a[i] + " ");
		}
		System.out.println();
		return tree;
	}

	static void delete(BST tree, int key) {
		tree.preOrderTraversal(null);
		System.out.println("\ndelete(" + key + ")...");
		tree.delete(key);
		tree.preOrderTraversal(null);
	}

	static void deleteSmallTrees() {

		BST t = new BST();
		System.out.println("\ninputs: 10");
		t.insert(10);
		t.levelOrderTraversal(null);
		System.out.println("\ndelete(10)...");
		t.delete(10);
		if (t.root != null) {
			System.out.println("\t??? there should be no traversal");
			t.levelOrderTraversal(null);
		} else
			System.out.println("\tempty tree (no traversal)");

		t = new BST();
		System.out.println("\ninputs: 10 5");
		t.insert(10);
		t.insert(5);
		t.inOrderTraversal(null);
		System.out.println("\ndelete(10)...");
		t.delete(10);
		t.inOrderTraversal(null);

		t = new BST();
		System.out.println("\ninputs: 10 15");
		t.insert(10);
		t.insert(15);
		t.inOrderTraversal(null);
		System.out.println("\ndelete(10)...");
		t.delete(10);
		t.inOrderTraversal(null);

		t = new BST();
		System.out.println("\ninputs: 10 15 5");
		t.insert(10);
		t.insert(15);
		t.insert(5);
		t.inOrderTraversal(null);
		System.out.println("\ndelete(10)...");
		t.delete(10);
		t.inOrderTraversal(null);

	}

	static void printTraversals(BST tree) {
		System.out.println("\nin-order:");    
		tree.inOrderTraversal(null);

		System.out.println("\npre-order traversal:");   
		tree.preOrderTraversal(null);

		System.out.println("\npost-order traversal:");  
		tree.postOrderTraversal(null); 

		System.out.println("\nlevel-order traversal:");  
		tree.levelOrderTraversal(null); 
	}
}

class Node {

	public int key; 
	public Node parent;
	public Node left;
	public Node right;

	public Node(int k, Node p) { 
		this(k, p, null, null);
	}

	public Node(int k, Node p, Node l, Node r) { 
		key = k; 
		parent = p;
		right = r; 
		left = l;
	}

	public void visit() { 
		System.out.print("\t" + key);
		if (parent == null) 
			System.out.print(" (root  node)");
		else
			System.out.print(" (parent: " + parent.key + ")"); 
		System.out.print(" left: ");
		if (left == null) System.out.print("na");
		else System.out.print(left.key);
		System.out.print("; right: ");
		if (right == null) System.out.println("na");
		else System.out.println(right.key);
	}
}

class Queue {
	private ArrayList<Node> list;
	public Queue(int capacity){
		list = new ArrayList<Node>(capacity);
	}

	public Queue(){
		list = new ArrayList<Node>(5);
	}

	public void enqueue(Node item){
		list.add(item);
	}

	public Node dequeue(){
		Node rv = list.get(0);
		list.remove(0);
		return rv;
	}

	public boolean isEmpty(){
		return list.isEmpty();
	}
}


