/**
* SimpleLinkedQueue is an implementation of the LinkedList. It utilizes the front and ends of a queue to add/remove nodes to a list
* 
* @Author Daniel Shu
* @version Lab2 CPE103
*/

import java.io.*; //for IndexOutOfBoundsException (not used)
import java.util.*; //for NoSuchElementException

public class SimpleLinkedQueue<T> implements SimpleQueue<T> {

	private Node front;

	private Node end;

	private int size;

	private class Node {

		private Node next;
		private Node previous;
		private T element;

		public Node(T element) {
			//initiate the variables
			//next and previous should start at null
			this.element = element;
			this.next = null;
			this.previous = null;

		} //creates the node class to be used throughout this lab

	}

	public SimpleLinkedQueue() {

		size = 0;

		//dummy nodes
		front = new Node(null);
		end = new Node(null);

		front.next = end;
		end.previous = front;

	} //constructor


	public T dequeue() {

		if (size == 0) {

			throw new NoSuchElementException("No such element");

		} //throw exception if the list is empty

		T storeElement = front.next.element;
		Node temp = front.next.next; //temp starts at the second element

		front.next = temp; //connect front and second element
		temp.previous = front;

		size--;

		return storeElement;

	} //removes and returns the element at the front of this queue


	public void enqueue(T element) {

		Node newElement = new Node(element); //create the new node

		Node temp = end.previous;

		temp.next = newElement;
		newElement.previous = temp;
		end.previous = newElement;
		newElement.next = end;

		size++;

	} //adds the specified element to the end of this queue


	public T peek() {

		if (size == 0) {

			throw new NoSuchElementException("No such element");

		} //throw exception if the list is empty

		return front.next.element;

	} //returns the element at the front of this queue (but does not remove it)

	public int size() { //returns the number of elements in this queue

		return size;

	}

}