//Johnnie Baba
//CPE 103-07
//Lab 01
//Description: This program is an interface for the user to create a linked list to do the following: 
//add nodes,add nodes in certain places, get the size of the list, and get a node at any index in the linked list

public interface SimpleList<T> {
   
	void add(T element);
	//Appends the specified element to the end of this list.
	void add(int index, T element);
	//Inserts the specified element at the specified position in this list.
	T get(int index);
	//Returns the element at the specified position in this list.
	T remove(int index);
	//Removes the element at the specified index in this list.
	int size();
	//Returns the number of elements in this list (elements that have been added by the creator/user of the list).
	
}
