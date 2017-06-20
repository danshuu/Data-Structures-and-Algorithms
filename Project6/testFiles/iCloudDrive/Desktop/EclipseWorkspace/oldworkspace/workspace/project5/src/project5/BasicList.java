package project5;

public interface BasicList<E> extends Iterable<E> {
	//what is E? E is any type of element
	//interface, so no 

	// methods
	void add(E element);
	//adds specified element to logical end of list


	void add(int index, E element);
	//adds specified element at specified index of list
	//allows adding to first index beyond end of list
	//throws java.lang.IndexOutOfBoundsException


	BasicListIterator<E> basicListIterator(); 
	//returns a reference to a BasicListIterator over elements in this
	//list in the proper sequence (first to last order)


	void clear();
	//clears the list of its contents


	boolean contains(E element);
	//determines if list contains specified element or not
	//using elements equals method


	E get(int index);
	//returns a reference to the element at the specified index


	int indexOf(E element);
	//using the provided element's equals method, return the index of the first element
	//in the list that is equal to the provided element, if any


	java.util.Iterator<E> iterator();
	//returns reference to java.util.iterator over elements of this list
	//returns an iterator over the elements of this list
	//???


	E remove(int index);
	//removes and returns the specified elememt from the list
	//how will this method be utilized? if you use it wont it just return the element?
	//throws java.lang.IndexOutOfBoundsExcpetion when index is negative or past logical end of list
	

	E set(int index, E element);
	//replaces the element at the specified index with the specified element


	int size();
	//returns the number of elements currently in the list
	
}