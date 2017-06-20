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

		if (head == null || tail == null || size == 0) {

			head = newNode;
			tail = newNode;

			size++;

		} else if (size == 1) {

			tail.next = newNode;
			tail = newNode;
			head.next = tail;
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

		if (size == 0 && index == 0) {

			head = newNode;
			tail = newNode;
			size++;

		} else if (index == size) {

			Node temp = tail;
			tail.next = newNode;
			tail = newNode;
			tail.previous = temp;

			size++;

		} else {
			//check of all other conditions
			//if index is 0, then 

			if (index == 0) {

				Node temp = head;
				head.previous = newNode;
				head = newNode;
				head.next = temp;
				
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

				// if (index == size - 1) {
				// 	tail = tail.next;
				// 	tail.previous = newNode;
				// }
				//*** unnecesary because tail does not change when a node is added right before the tail.

				size++;

			} // end of second else
		} // end of first else
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

	public E remove(int index) {
		//removes and returns the specified element from the list
		//throws java.lang.IndexOutOfBoundsExcpetion when index is negative or past logical end of list
		//just link the first to third and third to first, rather than making middle one null

		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds.");
		}

		Node temp = head;
		// Node tempEnd = tail;
		E storeElement;

		if (size == 1 && index == 0) {
			storeElement = head.element;
			head = null;
			tail = null;
			size--;
			return storeElement;
		}

		if (index == 0) {
			storeElement = head.element;
			head = head.next;
			head.previous = null; //cut off the original head
			size--;
			return storeElement;
		}

		//check if index is last element of the list

		if (index == size - 1) {
			storeElement = tail.element;
			tail = tail.previous;
			tail.next = null;
			// tempEnd = null;
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

		if (index == 0 && size == 1) {
			E storeElement = head.element;		
			head.element = element;
			tail.element = element;
			return storeElement;
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

	public BasicListIterator<E> basicListIterator() { 
		//returns a reference to a BasicListIterator over elements in this
		//list in the proper sequence (first to last order)
		BasicListIterator<E> bli = new BasicLinkedListIterator();
		return bli;

	}

	public Iterator<E> iterator() {
		//returns reference to java.util.iterator over elements of this list
		//returns an iterator over the elements of this list
		Iterator<E> it = new BasicLinkedListIterator();
		return it;
		//whats the point of this?
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
		//hasNext, next, and remove all are inherited from interface 
		//Methods

		private Node pointer;
		// private int tracker = 0;

		//if list is empty, previous and next should throw exception
		//if list has one element, hasPrevious and hasNext should return false
		//if node is at end of list, hasNext should be false
		//if list is empty, hasPrevious and hasNext should be false
		//can the node be null, and still have a next? wb a previous?

		public boolean hasPrevious() {
			//returns true if the iterator has a previous element
			return pointer != null;

		}

		public E previous() {
			//returns the previous element and moves the iterator backward one position with O(1) performance
			if (!hasPrevious()) {
				throw new NoSuchElementException("No previous in list.");
			}
			// if (pointer == tail) {
			// 	return pointer.previous.element;
			// }
			E temp = pointer.element;
			pointer = pointer.previous;

			return temp;

		}

		public boolean hasNext() {
			if (pointer == null) {
				return head != null; // when head doesn't equal null, return true
			}
			return pointer.next != null;

		}

		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException("No next in list.");
			}
			//but its never going to reach this if statement since it hasNext has to be true
			//if has next is true, node isnt going to be null.
			else if (pointer == null) {
				pointer = head;
			} 
			else {
				pointer = pointer.next;
			}

			// tracker++;

			return pointer.element;
		}
		public void remove() { //void? whats the point of this?

			throw new UnsupportedOperationException();

		}

	}
	
}