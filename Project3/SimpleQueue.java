/**
* Interface of SimpleQueue, which is a implementation of the LinkedList
*
* @Author Daniel Shu
* @version Lab2 CPE103
*/

public interface SimpleQueue<T> {
	
	T dequeue(); //removes and returns the element at the front of this queue

	void enqueue(T element); //adds the specified element to the end of this queue

	T peek(); //returns the element at the front of this queue (but does not remove it)

	int size(); //returns the number of elements in this queue

}