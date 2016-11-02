import java.util.Date;

/*
 * class SinglyLinkedList is an object-oriented version of a 
 * SinglyLinkedList class that was used to help introduce 
 * singly linked-lists.
 *
 * @creator gdt
 * @created 02016.10.14
 */

class Node {

   // instance variables...
   private Object item;
   private Node next;

   // constructor... 
   public Node(Object x) { item = x; next = null; }

   // getter/setter methods...
   public Object getItem() { return item; }
   public Node getNext() { return next; }
   public void setItem(Object item) { this.item = item; }
   public void setNext(Node n) { next = n; }

   // return a String object representation of "this" Node object...
   public String toString() {
      return item + " (next is " + (next == null ? "" : "not ") + "null)";
   }

}

/*
 * class SinglyLinkedList is not a complete class (i.e. there are
 * missing methods). The class was primarily created to support
 * the Queue data structure (see get1st() and delete1st()).
 *
 * @assignment: implement delete(), insert(), search() methods

 */
public class SinglyLinkedList {

   private Node head = null;     // nth(1) is the head Node object
   // private Node tail = null;  // for more efficient adds (if needed)
   private int size = 0;         // size == 0 implies empty linked-list

   /*
    * add Node object to the end of "this" linked-list
    * and return "this" linked-list object...
    */
   public SinglyLinkedList add(Object item) {
      size++;
      Node n = new Node(item);
      if (head == null) 
         head = n; 
      else {
         Node t = head;
         while (t.getNext() != null) 
            t = t.getNext();
         t.setNext(n);
      }
      return this;
   }

   /*
    * prints "this" linked-list starting at the Node object parameter
    * and returns "this" linked-list object...
    */
   public SinglyLinkedList print(Node n) {
      while (n != null) {
         System.out.println("\t" + n.getItem()); 
         n = n.getNext();
      }
      return this;
   }

   /*
    * prints "this" linked-list using recursion starting at the Node object 
    * parameter and returns "this" linked-list object...
    */
   public SinglyLinkedList print_r(Node n) {
      if (n == null) return this;
      System.out.println("\t" + n.getItem()); 
      return print_r(n.getNext());   
   }

   /*
    * starting with the Node object parameter, returns the nth 
    * Node object in "this" linked-list object... 
    */
   public Node nth(Node t, int n) {
      if (t == null) return null;
      if (n == 1) return t; 
      return nth(t.getNext(), n - 1);
   }

   /*
    * starting with the head Node object, returns the nth 
    * Node object in "this" linked-list object... 
    */
   public Node nth(int n) { return nth(head, n); }

   // return the number of items in "this" linked-list...
   public int getSize() { return size; }

   // return the head Node for "this" linked-list...
   public Node getHead() { return head; }

   // set the size of "this" linked-list to zero...
   public void clear() { size = 0; head = null; }

   // removes the first Node object from "this" linked-list...
   public void delete1st() {
      if (size <= 0) return;
      head = head.getNext();
      size--;
   }

   // returns the first item from this "this" linked-list...
   public Object get1st() {
      if (head == null) return null;
      return head.getItem();
   }

   /*
    * test class SinglyLinkedList...
    */
   public static void main(String[] argv) {

      SinglyLinkedList list = new SinglyLinkedList();

      // test add method...
      list.add("singly linked-list")
          .add(new Date())
          .add(new Double(Math.PI))
          .add(new Character('J'))
          .add(new StringBuffer("initial size = ")
                            .append(list.size + 1));

      // test print and print_r methods...
      System.out.println("print from head: ");              
      list.print(list.head);
      System.out.println("print from head.next: ");         
      list.print(list.head.getNext());
      System.out.println("print from head.next.next: ");    
      list.print(list.head.getNext().getNext());
      System.out.println("print from head recursive: ");
      list.print_r(list.head);

      // test nth method...
      for (int n = 0, limit = list.size + 1; n <= limit; n++) {
         Node x = list.nth(n);
         System.out.println("nth(head," + n + "): " +
                            (x == null ? "not found" : x.getItem()));
      }

      /*
      Node y = list.nth(2);
      System.out.println(y);
      y = list.nth(y, 4);
      System.out.println(y);
      */

      list.delete1st();
      System.out.println("after delete1st():");
      list.print(list.head);

   }

}

class Queue extends SinglyLinkedList{

	// MAKE SURE TO RE-IMPLEMENT isEmpty and isFull!
	//
	//
	
	private final int DEFAULT_CAPACITY = 8;
	private int capacity;
	
	public Queue(){
		this.capacity = DEFAULT_CAPACITY;
	}

	public Queue(int cap) {
		this.capacity = cap;
	}

	public Queue enqueue(Object elem) throws IllegalStateException {
		if (getSize() >= this.capacity){
			throw new IllegalStateException();
		} else {
			add(elem);
			return this;
		}
	}

	public Object dequeue() throws NoSuchElementException{
		if (getSize() <= 0) {
			throw new NoSuchElementException();
		}

		Object retrieved = get1st();
		delete1st();

		return retrieved;
	}

	public Object front() throws NoSuchElementException{
		if (getSize() <= 0) {
			throw new NoSuchElementException();
		}	

		Object retrieved = get1st();
		return retrieved;
	}

	public int getCapacity(){
		return this.capacity;
	}

	public void setCapacity(int newcapacity) throws IllegalArgumentException{
		if (newcapacity < 0) {
			throw new IllegalArgumentException();
		}

		if (newcapacity < this.capacity && getSize() > newcapacity){
			// Truncate stuff
		}

		
	}

	public int size(){
		return getSize();
	}

	public boolean isEmpty(){
		if (getSize() == 0){
			return true;
		} else { return false; }
	}

	public boolean isFull(){
		if (getSize() == this.capacity){
			return true;
		} else { return false; }
	}

	public String toString(){
		return String hi = "toString yet to be implemented";
	}

}

/*
 *

print from head: 
   singly linked-list
   Sat Oct 15 05:23:50 MST 2016
   3.141592653589793
   J
   initial size = 5
print from head.next: 
   Sat Oct 15 05:23:50 MST 2016
   3.141592653589793
   J
   initial size = 5
print from head.next.next: 
   3.141592653589793
   J
   initial size = 5
print from head recursive: 
   singly linked-list
   Sat Oct 15 05:23:50 MST 2016
   3.141592653589793
   J
   initial size = 5
nth(head,0): not found
nth(head,1): singly linked-list
nth(head,2): Sat Oct 15 05:23:50 MST 2016
nth(head,3): 3.141592653589793
nth(head,4): J
nth(head,5): initial size = 5
nth(head,6): not found
after delete1st():
   Sat Oct 15 05:23:50 MST 2016
   3.141592653589793
   J
   initial size = 5

 *
 */
