/**
* This lab creates linked lists with a dummy head and tail so the dummynodes are technically not a part of the list. 
* Every node added will be added between the headdummy and taildummy
* @author Daniel Shu
* @version Lab 1 CPE 103
*/

import java.io.*;

public class SimpleLinkedList<T> implements SimpleList<T> {

	private Node head;
	private Node tail;
	private int size;

	public SimpleLinkedList() {

		size = 0;
		//node references initialised to non-null values, meaning the nodes are
		//linked but may have no value. i.e. null element
		//dummy nodes:
		head = new Node(null);
		tail = new Node(null);

		head.next = tail;
		tail.previous = head;

	}

	public void add(int index, T element) {
	//Inserts the specified element at the specified position in this list.
	//Shifts the element currently at that position (if any) and any subsequent elements 
	//to the right (adds one to their indices)
	//throw indexoutofboundsexception if index < 0 or > list.length
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}

		Node newNode = new Node(element); //newNode responsible for inserting/adding the new node to the list at specified index

		Node temp;//start a temporary node at the head/tail so you can iterate to the specified index or add at the end

		temp = head.next; //starts at the "first element of the list" since head doesn't count

		for (int i = 0; i < index; i++) {
			temp = temp.next;
			//iterate till index - 1
			//then the temp will be at the index since temp = temp.next
		}

		temp.previous.next = newNode;
		newNode.previous = temp.previous;
		newNode.next = temp;
		temp.previous = newNode;

		size++;

	} //end of add with index method

	public void add(T element){
	//appends the specified element to the end of this list. Allows null element to be added to the list
	//***must have O(1) performance***
		Node newNode = new Node(element); //create the node to add at end of list
		Node temp; //to store an element for use when disconnect/connecting a node

		temp = tail;
		temp.previous.next = newNode;
		newNode.next = temp;
		newNode.previous = temp.previous;
		temp.previous = newNode;

		size++;

	} //end of add method

	public T get(int index) {
	//returns the element at the specified position in this list
	//throw indexoutofboundsexception if index < 0 or > list.length
		if (index < 0 || index >= size) {//can't get an element with index larger than size
			throw new IndexOutOfBoundsException("Index out of bounds");
		}

		Node temp = head.next; //starts are head.next because thats the first node of the list

		for (int i = 0; i < index; i++) { //iterate

			temp = temp.next;

		}

		return temp.element; //returns the element at the given node

	} //end of get method


	public T remove(int index) {
	//removes the element at the specified position in the list
	//throw indexoutofboundsexception if index < 0 or >= size of list
		Node temp; //declare a temp node so you can remove whatever node you want and fill the gaps
		T storeElement;

		if (index < 0 || index >= size) { //can't remove an element with index larger than size
			throw new IndexOutOfBoundsException("Index out of bounds");
		}

		temp = head.next; //initiate at head so you can iterate through to specified index

		for (int i = 0; i < index; i++) {

			temp = temp.next;

		}

		storeElement = temp.element;
		temp.next.previous = temp.previous;
		temp.previous.next = temp.next;
		// temp = null; unnecessary because its a local var that will cease to exist after the method returns

		size--;
		return storeElement;

	} //end of remove method

	public int size() {
	//returns the number of elements in this list (ones added by the user)
	//***must have O(1) performance*** 
		return size;

	} //end of size method

	private class Node {
		//private classes in the cases that the class is only going to be used in one other class
		private Node next;
		private Node previous;
		private T element;

		public Node(T element) {

			this.element = element;
			this.next = null;
			this.previous = null;

		}

	}


}