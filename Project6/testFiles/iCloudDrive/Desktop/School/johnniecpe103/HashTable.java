//Johnnie Baba
//CPE 103-07
//Assignment 5
public interface HashTable<T> {
   boolean add(T element);
   //Adds the specified element to this table if it is not already present.
   
   boolean contains(T element);
   //Returns true is this table contains the specified elements.
   
   boolean isEmpty();
   //Returns true if this table contains no elements.
   
   double loadFactor();
   //Returns the current load factor of the hash table.
  
   boolean remove(T element);
   //Removes the specified element from this table if it is present.
   
   int size();
   //Returns the number of elements in this table.
   
   int tableSize();
   //Returns the hash table size.
}
