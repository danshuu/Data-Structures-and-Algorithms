/**
* Simple Stack interface
* @author Daniel Shu
* @version Lab3 cpe103
*/

public interface SimpleStack<T> {
	
	T peek(); //returns the element on top of this stack (but does not remove it)

	T pop(); //removes and returns the element at the top of this stack

	void push(T element); //adds the specified element to the top of the deck

	int size(); //returns the number of elements in this stack
}