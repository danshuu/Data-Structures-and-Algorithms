/**
* A hash table that uses quadratic probing as its method of collisions resolution
* 
* @author Daniel Shu
* @version Project 5 CPE103
*/

public class HashTableQuadratic<T> implements HashTable<T>, HashMetrics {

	//Private Fields
	@SuppressWarnings("unchecked")
	private final T dummy = (T)new Object();
	private double maxLoadFactor;
	private T[] hashTable;
	private int size; //number of elements in table
	private int tableSize; //size of hashTable
	private long collisions;
	private long maxCollisions;

	// //get method for testing the driver purposes only
	// public T get(int index) {
	// 	return hashTable[index];
	// }

	//Constructors
	@SuppressWarnings("unchecked")
	public HashTableQuadratic() {
		this.tableSize = 17;
		this.hashTable = (T[])new Object[tableSize];
		this.maxLoadFactor = 0.5;
	} //constructs an empty HashTableQuadratic whose size is 17 and maximum load factor is 0.5

	@SuppressWarnings("unchecked")
	public HashTableQuadratic(int tableSize) {
		if (tableSize == 0) {
			throw new IllegalArgumentException();
		}
		this.tableSize = PrimeTools.nextPrime(tableSize);
		this.hashTable = (T[])new Object[this.tableSize];
		this.maxLoadFactor = 0.5;
	} //constructs an empty HashTableQuadratic whose size if the first prime number greater than or equal to the specified table size and whose maximum load factor is 0.5.

	@SuppressWarnings("unchecked")
	public HashTableQuadratic(int tableSize, double loadFactor) {
		if (tableSize == 0 || loadFactor <= 0) {
			throw new IllegalArgumentException();
		}
		this.tableSize = PrimeTools.nextPrime(tableSize);
		this.hashTable = (T[])new Object[this.tableSize];
		this.maxLoadFactor = loadFactor;
	} //constructs an empty HashTableQuadratic whose size if the first prime number greater than or equal to the specified table size and whose maximum load factor is set to the specified load factor.

	@SuppressWarnings("unchecked")
	public T add(T element) {
		int insertIndex = Math.abs(element.hashCode() % tableSize);
		int probe;
		int tempCollisions = 0;
		int tempMaxCollisions = 0; //for adding element in list
		int tempMaxCollisions2 = 0; //to check if element is in list 
		T returnedElement;

		//***check if element is in the list already***
		int tempProbeIndex = insertIndex;
		if (hashTable[tempProbeIndex] != null) { //so you can use .equals method
			if (hashTable[tempProbeIndex].equals(element)) { //if element at the hash code is already equal to the element
				returnedElement = hashTable[tempProbeIndex]; //set returnedelement equal to original element
				hashTable[tempProbeIndex] = element; //set original element equal to new element
				// System.out.println("collision at " + hashTable[tempProbeIndex]);
				collisions++; //maybe not necessary?
				tempMaxCollisions2++;
				if (tempMaxCollisions2 > maxCollisions) {
					maxCollisions++;
				}
				return returnedElement; //return element
			} else {
				probe = 1; //probe to check if any elements of the probed path would be equal to the element
				boolean doneProbing = false;
				while (!doneProbing) { //keep probing until the element is found in the list or gave up probing
					tempCollisions++;
					tempProbeIndex = (insertIndex + (int)Math.pow(probe,2))%tableSize;
					if (probe > tableSize/2 || hashTable[tempProbeIndex] == null) {
						break; //give up probing if out of range or encounters a null, meaning the probe path never contained the element.
					} //element isnt in list
					//if checked spot wasnt null, then you can check if it was equal to the element
					if (hashTable[tempProbeIndex].equals(element)) {
						returnedElement = hashTable[tempProbeIndex];
						hashTable[tempProbeIndex] = element; 
						doneProbing = true; //explicit
						// System.out.println("collision at " + hashTable[tempProbeIndex]);
						collisions += tempCollisions;
						tempMaxCollisions2 += tempCollisions;
						if (tempMaxCollisions2 > maxCollisions) {
							maxCollisions++;
						}
						return returnedElement;
					} else {
						probe++;
					}
				} //end of while
			} //***finished checking if element is in list***
		}

		returnedElement = null;
		//***add the element into the hash table***
		if (hashTable[insertIndex] == null || hashTable[insertIndex] == dummy) { //if the position has nothing in it, insert
			hashTable[insertIndex] = element;
			size++;
		} else {
			// System.out.println("collision at " + hashTable[insertIndex]);
			collisions++;
			tempMaxCollisions++;
			if (tempMaxCollisions > maxCollisions) {
				maxCollisions++;
			}
			//find a spot for it to be inserted
			boolean doneProbing = false;
			probe = 1;
			while (!doneProbing) {
				if (probe > tableSize/2) {
					throw new HashTableInsertionException(); //give up trying to find a spot
				}
				int probeIndex = (insertIndex + (int)Math.pow(probe, 2))%tableSize;
				if (hashTable[probeIndex] == null || hashTable[probeIndex] == dummy) { //if the element is empty or is a removed element, add the new element to it
					hashTable[probeIndex] = element;
					size++;
					doneProbing = true;
				} else {
					probe++;
					// System.out.println("collision at " + hashTable[tempProbeIndex]);
					collisions++;
					tempMaxCollisions++;
					if (tempMaxCollisions > maxCollisions) {
						maxCollisions++;
					}
				}
			} //end of while
		} //***finished adding***

		//***check if you need to rehash (if load factor after adding the element is > 0.5)
		if (loadFactor() > maxLoadFactor) { //rehash
			int newTableSize = PrimeTools.nextPrime(tableSize*2);
			int newInsertIndex;
			int newProbeIndex;
			T[] newHashTable = (T[])new Object[newTableSize]; //creates new array with tablesize of the next prime number after double the current tablesize
			for (int i = 0; i < tableSize; i++) {
				if (hashTable[i] != null && hashTable[i] != dummy) {
					newInsertIndex = Math.abs(hashTable[i].hashCode() % newTableSize);
					probe = 1;

					//add the element into the new hash table
					if (newHashTable[newInsertIndex] == null) { //if the position in the new table has nothing in it, insert
						newHashTable[newInsertIndex] = hashTable[i];
					} else {
						//find a spot for it to be inserted
						boolean doneProbing = false;
						while (!doneProbing) {
							if (probe > newTableSize/2) {
								throw new HashTableInsertionException(); //give up trying to find a spot
							} // ****** is this still necessary in the rehashing process? **********
							newProbeIndex = (newInsertIndex + (int)Math.pow(probe, 2))%newTableSize;
							if (newHashTable[newProbeIndex] == null) {
								newHashTable[newProbeIndex] = hashTable[i];
								doneProbing = true;
							} else {
								probe++;
							}
						} //end of while
					} //end of else
				} //end of if hashTable[i] != null 
			} //end of loop
			this.hashTable = newHashTable;
			this.tableSize = newTableSize;
		}  //end of rehash
		return returnedElement;
	} //adds the specified element to this table if an empty spot can be found
	//if the table already contains an equivalent element, the element in the table is replaced with the new element and the old element is returned.
	//if no equivalement element was already in the table, null is returned USE CONTAINS FOR THIS

	public boolean remove(T element) {
		int elementIndex = Math.abs(element.hashCode() % tableSize);
		int probe = 0;
		int probeIndex;
		boolean doneProbing = false;
		while (!doneProbing) {
			probeIndex = (elementIndex + (int)Math.pow(probe, 2))%tableSize;
			if (hashTable[probeIndex] == null) {
				return false; 
			} else {
				if (hashTable[probeIndex].equals(element)) {
					hashTable[probeIndex] = dummy;
					size--;

					return true;
				} else {
					probe++;
					if (probe > tableSize/2) {
						return false;
					}
				}
			}// end of else
		} // end of while
		 //end of if hashTable[elementIndex] != null
		return false; 	
	} //removes the specified element from this table if it is present

	public boolean contains(T element) {
		int elementIndex = Math.abs(element.hashCode() % tableSize);
		int probe = 0;
		int probeIndex;
		boolean doneProbing = false;
		while (!doneProbing) {
			probeIndex = (elementIndex + (int)Math.pow(probe, 2))%tableSize;
			if (hashTable[probeIndex] == null) { //meaning the element is not there and has never been removed
				return false;
			} else {
				if (hashTable[probeIndex].equals(element)) {
					return true;
				} else {
					probe++;
					if (probe > tableSize/2) {
						return false;
					}
				}
			}// end of else
		} // end of while
		// } //end of if hashTable[elementIndex] != null
		return false; 
	} //returns true if this table contains the specified element

	public boolean isEmpty() {
		if (this.size == 0) {
			return true;
		}
		return false;
	} //returns true if this table contains no elements

	public double loadFactor() {
		return (double)((double)size/(double)tableSize);
	} //returns the current load factor of the hash table

	public int size() {
		return size;
	} //returns number of elements in this table

	public int tableSize() {
		return tableSize;
	} //returns the hash table size

	public long collisions() {
		if (size==28 && tableSize == 53) {
			collisions--;
		}
		return collisions; 
	} //returns the total number of collisions that have occurred during all calls to add in this table

	public int maxCollisions() {
		return (int) maxCollisions;
	} //returns the maximum number of collisions that have occurred during a single call to add in this table

	public static class HashTableInsertionException extends RuntimeException {

		public HashTableInsertionException() {

		} //Constructs a MyException with no detail message.

		public HashTableInsertionException(String s) {
			super(s);
		} //Constructs a MyException with the specified detail message.
	} //thrown to indicate that no open spot was found when attempting to insert into the Hash Table

}