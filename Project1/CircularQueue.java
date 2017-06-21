/**
* This project implements an efficient circular array-based queue
* CircularQueue is a generic circular array implementation of SimpleQueue interface
* @author Daniel Shu
* @version Project 1 cpe103
*/

import java.util.NoSuchElementException;

public class CircularQueue<T> implements SimpleQueue<T> {
	//nested class
	public static class MyException extends RuntimeException {
		public MyException() {
			//empty constructor
		}

		public MyException(String s) {
			super(s); //RuntimeException constrcuts a new runtime exception with the specified detail message

		} //thrown to indicate you've had an exception in CircularQueue(int initialCapacity)

	}

	//Fields (no fewer than 4, no more than 5 fields)
	private T[] arr; //holds the elements in the queue
	private int back; //keeps track of the end of queue
	private int front; //keeps track of the front of queue
	public static final int INITIAL_LENGTH = 10; //has value of 10, used in CircularQueue() constructor
	private int size; //keeps track of size of queue (OPTIONAL) //does NOT give you position 

	//constructors
	//suppress unchecked cast warning compiler error
	@SuppressWarnings("unchecked")
	public CircularQueue() {
		arr = (T[]) new Object[INITIAL_LENGTH];
		back = 0;
		front = 0;
		size = 0;
	} //constructs empty queue with initial capacity given by INITIAL_LENGTH

	@SuppressWarnings("unchecked")
	public CircularQueue(int initialCapacity) {
		//throws CircularQueue.MyException if specified initial capacity is non-positive
		if (initialCapacity <= 0) {
			throw new MyException();
		}
		arr = (T[]) new Object[initialCapacity];
		back = 0;
		front = 0;
		size = 0;
	} //constructs an empty queue with the specified initial capacity

	public T dequeue() {

		if (size == 0) {
			throw new NoSuchElementException();
		}

		T temp = arr[front];
		arr[front] = null;

		if (front == arr.length - 1) { //if front is at the last position of the array
			front = 0;
		} else {
			front++;
		}

		size--; //decrement the size after dequeue
		return temp;

	} //Removes and returns the element at the front of the queue

	@SuppressWarnings("unchecked")
	public void enqueue(T element) {

		if (size == arr.length) { //if list is full
			//create new temporary array with double the length
			T[] arr2 = (T[]) new Object[arr.length * 2];
			//copy all existing elements fromt original list over
			for (int i = 0; i < arr.length; i++) { //front is only used to iterate through and wrap around the original list
				arr2[i] = arr[front];
				front++; //increment front to keep up with index i
				if (front == arr.length) { //if the front is greater than the size of original list, wrap around back to 0
					front = 0;
				}
			}

			front = 0; //set front to index 0
			back = arr.length; //set back to the last element + 1 of original list
			arr = arr2;	//set arr equal to the new temporary array
			arr[back] = element; //add the element to the back of the queue

		} else { //if list is not full

			if (size == 0) { //if list is empty, set back(which is front) equal to the new element
				front = 0;
				back = 0;
				arr[front] = element;
				arr[back] = element;

			} else if (back == arr.length - 1) { //if back is the last element in the array, but list isn't full
				back = 0;
				arr[back] = element; //add element to back by setting back index equal to new element
			
			} else {

				back++; //increment back
				arr[back] = element; //add element to back of queue

			} //end of inner else

		} //end of outer else

		size++; //increment the size after enqueue is called, unconditionally

	} //adds the specified element to the end of this queue, when method is called on full queue, the array will double in length to accomodate more elements

	public T peek() {

		if (size == 0) {
			throw new NoSuchElementException();
		}

		return arr[front];

	} //returns the element at the front of this queue (but does not remove it)

	public int size() {

		return size;

	} //returns the number of elements in this queue

	public Object[] unusualMethodForTestingPurposesOnly() {
	
		return arr;

	} //returns a reference to the private arr. This is


}
