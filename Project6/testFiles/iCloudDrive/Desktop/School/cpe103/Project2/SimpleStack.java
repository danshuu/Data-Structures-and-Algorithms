/**
* Simple Stack interface
* 
* @author Daniel Shu
* @version Project 2 CPE103
*/

public interface SimpleStack<T> {
	
	T peek(); //returns the element on top of this stack (but does not remove it)

	T pop(); //removes and returns the element at the top of this stack

	void push(T element); //adds the specified element to the top of the stack

	int size(); //returns the number of elements in this stack

}