package project5;

import java.util.*;

public class BasicLinkedList<E> implements BasicList<E> {
	//no more than 3 instance variables
	//do not use iterators in solution to methods of BasicLinkedList
	//write a private inner class that implements the BasicListIterator 
	//interface to support the iterator() and basicListIterator() methods
	private Node head;
	private Node tail;
	private int size;

	// *********** start of class BasicLinkedList **************
	public BasicLinkedList() {

		size = 0;
	//constructs an empty basiclinkedlist
	}

	public void add(E element) { //difference between E and Element?
		//adds specified element to logical end of list
		Node newNode = new Node(element); //creates a new node with a value of element

		if (head == null || tail == null) {
			head = newNode;
			tail = newNode;
			size++;
		} else if (size == 1) {
			tail.next = newNode;
			tail = head.next;
			tail.previous = head;
			size++;
		} else { 
			Node temp = tail;
			tail.next = newNode;
			tail = newNode;
			tail.previous = temp;
			size++;
		} //end of else

	}

	public void add(int index, E element) {
		//adds specified element at specified index of list
		//allows adding to first index beyond end of list
		//throws java.lang.IndexOutOfBoundsException
		//utilize the iterator to traverse the linkedlist till I find it 
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index out of bounds.");
		}

		Node newNode = new Node(element);

		if (index == 0) {

			Node temp = head;
			head.previous = newNode;
			head = newNode;
			head.next = temp;
			
			size++;
		
		} else if (index == size) {

			Node temp = tail;
			tail.next = newNode;
			tail = newNode;
			tail.previous = temp;

			size++;

		} else {

			Node temp = head; //start iterating from head

			for (int i = 0; i < index; i++) {
				temp = temp.next;
			}

			temp.previous.next = newNode;
			newNode.next = temp;
			newNode.previous = temp.previous;
			temp.previous = newNode;

			size++;
		} // end of else
	}

	public BasicListIterator<E> basicListIterator() { 
		//returns a reference to a BasicListIterator over elements in this
		//list in the proper sequence (first to last order)
		BasicListIterator<E> bli = new BasicLinkedListIterator();
		return bli;
		}

	public void clear() {
		//clears the list of its contents
		//make head and tail null
		head = null;
		tail = null;
		size = 0;
	}

	public boolean contains(E element) {
		//determines if list contains specified element or not
		//using elements equals method
		//if iterating through, finds it, return true
		Node temp = head;
		for (int i = 0; i < size; i++) {
			if (temp.element == element) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

	public E get(int index) {
		//returns a reference to the element at the specified index
		//iterate through, find the index's node's element and return it
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds.");
		}

		if (index == 0) {
			return head.element;
		}

		Node temp = head;

		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}

		return temp.element;
	}

	public int indexOf(E element) {
		//using the provided element's equals method, return the index of the first element
		//in the list that is equal to the provided element, if any
		Node temp = head;
		int index = 0;

		for (int i = 0; i < size; i++) {

			if (temp.element == null && element == null) {
				return index;
			}

			if (temp.element.equals(element)) { //use .equals over ==
				return index;
			}

			temp = temp.next; //iterate through nodes
			index++; //increase index

		}

		throw new NoSuchElementException("Element not found in list");
	}

	public java.util.Iterator<E> iterator() {
		//returns reference to java.util.iterator over elements of this list
		//returns an iterator over the elements of this list
		Iterator<E> it = new BasicLinkedListIterator();
		return it;
		//whats the point of this?
	}

	public E remove(int index) {
		//removes and returns the specified element from the list
		//throws java.lang.IndexOutOfBoundsExcpetion when index is negative or past logical end of list
		//just link the first to third and third to first, rather than making middle one null

		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds.");
		}

		Node temp = head;
		Node tempEnd = tail;
		E storeElement;
		// if (head == null || tail == null) {
		// 	throw new NullPointerException();
		// }

		if (index == 0) {
			storeElement = head.element;
			head = head.next;
			temp = null; //cut off the original head
			size--;
			return storeElement;
		}

		//check if index is last element of the list

		if (index == size - 1) {
			storeElement = tail.element;
			tail = tail.previous;
//			tempEnd = null;
			size--;
			return storeElement;
		}

		for (int i = 0; i < index; i++) {
			temp = temp.next;
		} //iterates the node to the specified index
		// if (temp == null) {
		// 	throw new NullPointerException();
		// }


		storeElement = temp.element;
		temp.previous.next = temp.next; //cut off connection
		temp.next.previous = temp.previous;
		size--;

		return storeElement;

	}

	public E set(int index, E element) {
		//replaces the element at the specified index with the specified element
		//iterate through, find the index and reset the value of the element to the specified one.
		//return the replaced element
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds.");
		}

		Node temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next; //set the temp node equal to the node at the specified index
		}
		Node store = temp;
		temp.element = element; //set the element at the temp node equal to the specified element
		return store.element;
	}

	public int size() {
		//returns the number of elements currently in the list
		return size;

	}

	private class Node {

		private E element;
		private Node next;
		private Node previous;

		//constructor
		public Node(E element) {

			this.element = element;
			this.next = null;
			this.previous = null;

		}

	}

	private class BasicLinkedListIterator implements BasicListIterator<E>{
		//instance variable
		Node node;
		//hasNext, next, and remove all are inherited from interface 
		//Methods
		public boolean hasPrevious() {
			//returns true if the iterator has a previous element
			return node.previous != null;

			}

		public E previous() {
			//returns the previous element and moves the iterator backward one position with O(1) performance
			if (hasPrevious()) {
				return node.previous.element;
			} else {
				throw new NoSuchElementException();
			}

		}

		public boolean hasNext() {

			return node.next != null;

		}

		public E next() {

			if (hasNext()) {
				return node.next.element;
			} else {
				throw new NoSuchElementException("Element not found in list");
			}

		}

		public void remove() { //void? whats the point of this?

			throw new UnsupportedOperationException("");

		}

	}
	
}