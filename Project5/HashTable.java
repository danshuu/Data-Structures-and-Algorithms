/**
* HashTable is an interface
* A simplified HashTable ADT
* 
* @author Daniel Shu
* @version Project 5 CPE103
*/

public interface HashTable<T> {

	T add(T element); //adds the specified element to this table if an empty spot can be found

	boolean contains(T element); //returns true if this table contains the specified elements

	boolean isEmpty(); //returns true if this table contains no elements

	double loadFactor(); //returns the current load factor of the hash table

	boolean remove(T element); //removes the specified element from this table if it is present

	int size(); //returns number of elements in this table

	int tableSize(); //returns the hash table size

}
