/**
* Generic array-based implementation of SimpleStack
* Has exzctly 2 private instance variables: an array type T to hold stack values, and a single int value to keep track of size
* A stack adds/removes elements to/from the "top"
* @author Daniel Shu
* @version Lab3 cpe103
*/

import java.util.NoSuchElementException;

public class SimpleArrayStack<T> implements SimpleStack<T> {
	
	private T[] arr;
	private int size;

	@SuppressWarnings("unchecked")
	public SimpleArrayStack() {

		arr = (T[])new Object[10];
		size = 0;

	} //one constructor that creates an empty stack with array of capacity 10 and size 0

	public T peek() { 

		if (size == 0) {
			throw new NoSuchElementException();
		}

		return arr[size-1];

	} //returns the element on top of this stack (but does not remove it)

	public T pop() {

		if (size == 0) {
			throw new NoSuchElementException();
		}
		T temp = arr[size-1];
		arr[size-1] = null;
		size--;

		return temp;

	} //removes and returns the element at the top of this stack

	@SuppressWarnings("unchecked")
	public void push(T element) {

		if (size == arr.length) { //if array is full when trying to push (if size = 10) 
			//create new array with double the initial capacity
			T[] arr2 = (T[])new Object[arr.length * 2];
			//copy all elements over to new array
			for (int i = 0; i < arr.length; i++) {
				arr2[i] = arr[i];
			}
			arr = arr2;	//set old array equal to new array
			arr[size] = element; //add new element to the array if
			size++; 

		} else {

			arr[size] = element;
			size++;

		}

	} //adds the specified element to the top of the deck

	public int size() {

		return size;

	} //returns the number of elements in this stack

	public int capacity() {

		return arr.length;

	}

}