public interface SimpleList<T> {
	
	void add(int index, T element);
	//Inserts the specified element at the specified position in this list.
	//Shifts the element currently at that position (if any) and any subsequent elements to the right
	//(adds one to their indices)

	void add(T element);
	//appends the specified element to the end of this list. Allows null element to be added to the list
	//throw indexoutofboundsexception if index < 0 or > list.length
	//***must have O(1) performance***

	T get(int index);
	//returns the element at the specified position in this list
	//throw indexoutofboundsexception if index < 0 or > list.length

	T remove(int index);
	//removes the element at the specified position in the list
	//throw indexoutofboundsexception if index < 0 or > list.length

	int size();
	//returns the number of elements in this list (ones added by the user)
	//***must have O(1) performance***

}