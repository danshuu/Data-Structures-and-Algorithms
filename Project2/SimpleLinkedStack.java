/**
* SimpleLinkedStack is a generic singly-linked implementation of the SimpleStack interface
* SimpleLinkedStack must have exactly 2 private fields: a reference to a private inner class representing nodes and an int to keep track of stack size
*
* @author Daniel Shu
* @version Project 2 CPE103
*/

import java.util.NoSuchElementException;

public class SimpleLinkedStack<T> implements SimpleStack<T> {

	private int size; //keeps track of the size of the Stack
	private Node top; //top of the stack

	//Constructors
	public SimpleLinkedStack() {
		size = 0;
		top = new Node(null);

	} //constructs an empty stack

	//Methods
	public T peek() {

		if (size == 0) {
			throw new NoSuchElementException();
		} //throw if empty

		return top.element;

	} //returns the element on top of this stack (but does not remove it)

	public T pop() {

		if (size == 0) {
			throw new NoSuchElementException();
		} //throw if empty

		T temp = top.element; //stores the top element;

		if (size == 1) { //check for size of 1
			top = new Node(null);
		} else {
			top = top.next; //sets the top equal to the next node
		}

		size--;
		return temp; //returns the original top's element

	} //removes and returns the element at the top of this stack

	public void push(T element) {

		if (size == 0) {
			top.element = element;
			size++;
		} else {
			Node newNode = new Node(element); //creates the new node containing the element			
			newNode.next = top; //set newNode's next equal to the top of the stack
			top = newNode; //set the top equal to the new Node, since it's now linked to the original top
			size++;
		}

	} //adds the specified element to the top of the stack

	public int size() {

		return size;

	} //returns the number of elements in this stack

	private class Node {

		private Node next;
		private T element;

		public Node(T element) {

			this.element = element;
			this.next = null; 

		}

	} //must have 2 fields: reference to another node, and a reference to an element in the stack

}