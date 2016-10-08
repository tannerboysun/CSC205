
import java.util.ArrayList;
/*
 *
 *
 *
 *
 *
 */


public class Set{
	
	private int capacity;
	private ArrayList<Object> list;
	
	/*=============
	 * Constructors
	 *///==========


	public Set(){
		this.capacity = 32;
		list = new ArrayList<Object>(this.capacity);
	}

	
	public Set(int capacity){
		this.capacity = capacity;
		list = new ArrayList<Object>(this.capacity);
	}

	
	
	/*==============
	 *
	 *///===========
	
	boolean isMember(Object element){
		if( this.list.contains(element)){
			return true;
		} else {
			return false;
		}	
	}

	boolean isEmpty(){

		return this.list.isEmpty();

	}

	boolean isSubset(Set other){
			
		if (this.intersection(other).equals(this)){
			return true;
		} else {
			return false;
		}
	}

	int size(){
		return this.list.size();
	}

	int capacity(){
		return this.capacity;
	}
	
	Set union(Set other){
		return this;
	}

	Set intersection(Set other){

		int maxSize = this.size();
		Set comparison = new Set(maxSize);

		for (int i = 0; i < other.size(); i++){
			Object cur = other.retrieve(i);
			if (this.isMember(cur)) {
				comparison.add(cur);
			}
			
		}

		return comparison;
	}

	Set difference(Set other){
		return this;
	}

	void add(Object element){
		if (this.capacity == this.size() && !(this.isMember(element))){
			this.list.ensureCapacity(this.capacity + 1);
			this.list.add(element);
			this.capacity += 1;
		} else {
			if (!(this.isMember(element)))
				this.list.add(element);
		}
	}

	boolean remove(Object element){
		if (this.isMember(element)){
			this.list.remove(element);
			return true;
		} else {
			return false;
		}
	}	

	void clear(){
		this.list.clear();
	}

	Object retrieve(int index){
		return this.list.get(index);
	}




	boolean equals(Set other){
		Set large;
		Set small;
		if (this.size() >= other.size()){
			large = this;
			small = other;
		} else {
			large = other;
			small = this;
		}

		for (int i = 0; i < large.size(); i++){
			if (!(small.isMember(large.retrieve(i)))){
				return false;
			}
		}

		return true;
	}
	
	public String toString(){
		String str = "{ ";
		boolean isFirst = true;
		for (int i = 0; i < this.size(); i++){
			if (isFirst){
				str += this.retrieve(i);
				isFirst = false;
			} else {
				str += ", " + this.retrieve(i);
			}


		}

		str += " }";

		return str;
	}


	public static void main(String[] argv){

		Set Emp = new Set();

		System.out.println("Is the Set Emp Empty? " + Emp.isEmpty());
		Emp.add(2);
		System.out.println("What about now? " + Emp.isEmpty());

		Set Nums = new Set(2);
		Nums.add(1);
		Nums.add(2);

		System.out.println("Test of the toString method: " + Nums);

		Set Tums = new Set(4);
		Tums.add(3);
		Tums.add(2);
		Tums.add(1);

		String HI = "HELLO";
		System.out.println("Is HI a member of Nums? " + Nums.isMember(HI)); 
		System.out.println("What is the current size of Nums? " + Nums.size());
		Nums.add(4);
		System.out.println("What is the new size of Nums? " + Nums.size());
		// Test of Anti-Dupes
		Nums.add(4);
		System.out.println("There should be no dupes " + Nums);

		System.out.println("Intersection between Nums and Tums " + Nums.intersection(Tums));	

		System.out.print(Nums + " Testing Clear ");
		Nums.clear();
		System.out.println(Nums);

		Nums.add(2);
		Nums.add(4);
		Nums.add(5);

		System.out.print(Nums + " Testing Remove " );
		Nums.remove(5);
		System.out.println(Nums);

		System.out.print(Nums + " Testing Remove Failure: " );
		if (!Nums.remove(5)){
			System.out.print(" Failure ");	
		}
		System.out.println(Nums);

		System.out.println("The capacity for Nums is " + Nums.capacity());

		System.out.println("Does Nums equal Tums? " + Nums.equals(Tums));
		Nums.clear();
		Nums.add(3);
		Nums.add(1);
		Nums.add(2);

		System.out.println("Does Nums equal Tums now? " + Nums.equals(Tums));

		Nums.add(4);
		Nums.add(Tums);

		System.out.println("Does Nums Subnet Tums" );


	}

}
