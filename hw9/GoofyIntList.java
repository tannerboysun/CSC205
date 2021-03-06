/*


 * This java application is a (very crude) modification of Goofy Int List.
 * This was modified by:
 *
 * @modifier Tanner Boysun
 * @modified 10/30/16
 *
 * Original credit given to gdt for the original abstract class.
 *
 *
 * This Java application is a goofy (crude) implementation
 * of a List data structure.
 *
 * @creator gdt
 * @created 02016.10.09
 * @edu Created for a csc205 assignment at SCC.
 * @see http://azfoo.net/gdt/csc205/assignments/goofyintlist.html
 */



public abstract class GoofyIntList {

	public static int LIST_SEARCH_NOT_FOUND = -1;
	public static int LIST_DFLT_CAPACITY = 8;

	private int[] data;
	private int whence;      // current index into data (cursor)
	private int size;        // # of elements in data
	private int capacity;    // max # of elements storable in data

	public GoofyIntList() { this(LIST_DFLT_CAPACITY); }

	public GoofyIntList(int cap) { 
		if (cap < 0) cap = LIST_DFLT_CAPACITY;
		capacity = cap; 
		data = new int[cap];
		whence = 0;
		size = 0;
	}

	public GoofyIntList(GoofyIntList list) {
		// This is a copy constructor.
		capacity = list.capacity;
		data = new int[capacity];
		whence = 0;
		size = list.size;
		for (int i = 0; i < size; i++)
			data[i] = list.data[i];
	}

	public boolean isEmpty() { return size == 0; }
	public boolean isFull() { return size == capacity; }
	public int getSize() { return size; }
	public int getWhence() { return whence; }
	public int getCapacity() { return capacity; }
	public GoofyIntList gotoHead() { whence = 0; return this; }
	public GoofyIntList gotoTail() { 
		if (size > 0)
			whence = size - 1; 
		return this; 
	}
	public GoofyIntList peek() {
		System.out.print("@whence=" + whence + ": " + get() + "; "); 
		return this; 
	}
	public int get() { 
		return data[whence]; 
	}

	public GoofyIntList move(int spots) { 
		int x = whence + spots;
		if (x < size && x >= 0)
			whence = x;
		return this; 
	}

	public int search(int x, int start_i) { 
		for (int i = start_i; i < size; i++)
			if (data[i] == x) 
				return i; 
		return LIST_SEARCH_NOT_FOUND;
	}

	public GoofyIntList add(int x) throws GoofyIntListException {
		if (size == capacity) 
			throw new GoofyIntListException();
		whence = size;
		data[whence] = x;
		size++;
		return this;
	}

	public String toString() {
		String s = "";
		if (size == 0) return s;
		int limit = size;
		for (int i = 0; i < limit; i++)
			s += data[i] + ",";
		return (s += data[limit]);
	}

	public abstract GoofyIntList front();  // alias for gotoHead()
	public abstract GoofyIntList back();   // alias for gotoTail()
	public abstract int search(int x);     // alias for search(x, 0)

	// see specification for details...
	public abstract GoofyIntList insert(int x, boolean before) 
		throws GoofyIntListException;

	// see specification for details...
	public abstract int get(int index) 
		throws GoofyIntListException;

	// see specification for details...
	public abstract GoofyIntList delete();

	public int[] getData(){
		return data;
	}

	public void setData(int[] info){
		this.data = info;
	}

	public void setWhence(int when){
		this.whence = when;
	}

	public static void main(String[] argv) {

		MyGoofyIntList l1 = new MyGoofyIntList();
		try {
			l1.add(2).add(3).add(4).add(5).add(6);
		} catch(GoofyIntListException e) { /*ignore*/ }

		System.out.println("l1: " + l1);
		int whence = l1.getWhence();
		System.out.println("l1: whence = " + whence + "; size = " + l1.getSize() 
				+ "; capacity = " + l1.getCapacity());
		int x = l1.get();
		System.out.println("l1: get(" + whence + ") = " + x); 
		try {
			x = l1.get(whence);
		} catch(GoofyIntListException e) {
			System.out.println("l1: safe get(" + whence + x + ") worked!");
		}
		System.out.print("l1: ");
		l1.gotoHead().peek().gotoTail().peek().gotoHead().peek();
		System.out.println();

		System.out.print("l1: ");
		l1.move(2).peek();
		System.out.println();
		System.out.print("l1: whence = " + l1.getWhence()); 
		l1.move(5);
		System.out.println(" (before invalid move); whence = " + 
				l1.getWhence() + " (after)"); 

		int y = 3;
		x = l1.search(y);
		if (x == LIST_SEARCH_NOT_FOUND) 
			System.out.print("l1: " + y + " not found");
		else
			System.out.print("l1: " + y + " found at index = " + x);
		System.out.println(" (search started at index 0)");
		int z = x + 1;
		x = l1.search(y, z);
		if (x == LIST_SEARCH_NOT_FOUND) 
			System.out.print("l1: " + y + " not found");
		else
			System.out.print("l1: " + y + " found at index = " + x);
		System.out.println(" (search started at index " + z + ")");

		y = -3;
		x = l1.search(y);
		if (x == LIST_SEARCH_NOT_FOUND) 
			System.out.print("l1: " + y + " not found");
		else
			System.out.print("l1: " + y + " found at index = " + x);
		System.out.println(" (search started at index 0)");

		System.out.println("--------");
		MyGoofyIntList l2 = new MyGoofyIntList(1);
		System.out.println("l2: " + l2 + (l2.isEmpty() ? "(empty)" : ""));
		try {
			l2.add(0).add(0);
		} catch(GoofyIntListException e) { 
			System.out.println("l2: add() failed because list is full");
			System.out.println("l2: whence = " + l2.getWhence() + 
					"; size = " + l2.getSize() + 
					"; capacity = " + l2.getCapacity());
		}

		System.out.println("--------");
		MyGoofyIntList l3 = new MyGoofyIntList(l1);
		System.out.print("l3: " + l3 + " (");
		if (l3.isFull()) System.out.print("not ");
		System.out.println("full)");

		try {
			System.out.println("Whence " + l1.getWhence());
			System.out.println(l1);
			l1.insert(1, false);
			System.out.println(l1);
			System.out.println(l1.getCapacity());
			l1.delete();
			System.out.println(l1);
		} catch(GoofyIntListException f) {
			System.out.println("EXCEPTION CAUGHT");
		}

	}
}


class MyGoofyIntList extends GoofyIntList {

	public MyGoofyIntList(int capacity){
		super(capacity);
	}

	public MyGoofyIntList(){
		super();
	}

	public MyGoofyIntList(MyGoofyIntList another_GoofyIntList_object){
		super(another_GoofyIntList_object);
	}

	public GoofyIntList front(){
		return gotoHead();
	}

	public GoofyIntList back(){
		return gotoTail();
	}

	public int search(int x){
		return search(x, 0);
	}

	// Implemented

	public int get(int index) throws GoofyIntListException{
		int[] info = getData();
		if (!(index > (info.length-1)) && !(index < 0) ){
			return info[index];
		} else {

			throw new GoofyIntListException();
		}


	}

	public MyGoofyIntList insert(int x, boolean before) throws GoofyIntListException{

		int[] info = getData();
		int whence = getWhence();
		int[] fin = new int[info.length];

		if (!isFull() && !(whence == 0) && !(whence == info.length)){
			for (int i = 0; i < info.length; i++){
				if ( i >= whence ) {

					if (i == whence) {

						if (before) {
							fin[i] = x;
						} else {
							fin[i] = info[i];
						}
					} else {

						if (!before && (i == whence + 1)){
							fin[i] = x;
							setWhence(whence + 1);
						} else {

							fin[i] = info[i - 1];

						}
					}

				} else {

					fin[i] = info[i];

				}
			}
			
			setData(fin);
			return this;

		} else {
			throw new GoofyIntListException();
		}
	}

	public MyGoofyIntList delete(){
		
		int[] info = getData();
		int whence = getWhence();
		int[] fin = new int[info.length];
		
		if (!isEmpty()){
	
			for (int i = 0; i < info.length -1; i++){
				if ( i >= whence ) {
					fin[i] = info[i + 1];
				} else {
					fin[i] = info[i];
				}
			}
			
			setData(fin);
			return this;
		} else {
			return this;
		}

	}





}

class GoofyIntListException extends Exception {
	public GoofyIntListException() { }
}
