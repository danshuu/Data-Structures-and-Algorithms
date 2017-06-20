/**
* Write 3 classes that implement 3 different algorithms for calculating hash codes for String objects.
* 2 of the algorithms are provided and you will develop a third to your own design. 
* You will then develop several methods that analyse the performance of each hashing algorithm
* A file of 178689 words is provided for you to use in this analysis. 
* Finally, because it is best to use hash tables with sizes that are prime numbers, you will also develop a couple of functions to help you find prime numbers
* HashTools is a class containing various static methods for evaluating hashing algorithms
*
* @author Daniel Shu
* @version Lab9 CPE103
*/

import java.util.*;

public class HashTools {

	public static <T> int collisions(List<T> list, int tableSize, Hashable<T> hashable) {
		int collisions = 0;
		tableSize = PrimeTools.nextPrime(tableSize);
		boolean[] boo = new boolean[tableSize]; //creates a boolean array of tableSize with all false initially
		for (int i = 0; i < list.size(); i++) {
			int pos = hashable.hash(list.get(i)) % tableSize;
			pos = Math.abs(pos); //because hash may be negative
			if (boo[pos]) { //if its already true, there will be a collision
				collisions++;
			} else {
				boo[pos] = true;
			}
		}

		return collisions;

	} //determines the number of hash code collisions in the specified case
	//it is best to use hash tables with sizes that are prime numbers

	public static <T> int maxCollisions(List<T> list, int tableSize, Hashable<T> hashable) {

		tableSize = PrimeTools.nextPrime(tableSize);
		int[] ints = new int[tableSize]; //creates a int array of tableSize with all 0 initially
		for (int i = 0; i < list.size(); i++) {
			int pos = hashable.hash(list.get(i)) % tableSize;
			pos = Math.abs(pos);
			ints[pos]++;
		}
		Arrays.sort(ints); //sorts the array into ascending order
		return ints[ints.length-1]; //last element in list is max

	} //determines the max number of items that hash to a single location in the specified case.
	//i.e. there could be 100 collisions total but not all 100 will occur in the same location of the hash table.
	//this method returns the largest number of items that hashed to the same location

	public static <T> double avgChainLength(List<T> list, int tableSize, Hashable<T> hashable) {
		// int encounters = 0;
		int spotsFilled = 0;
		tableSize = PrimeTools.nextPrime(tableSize);
		boolean[] boo = new boolean[tableSize]; //creates a boolean array of tableSize with all false initially
		for (int i = 0; i < list.size(); i++) {
			int pos = hashable.hash(list.get(i)) % tableSize;
			pos = Math.abs(pos); 
			// if (boo[pos]) { //if its already true, there will be a collision
			// 	encounters++;
			// } 
			if (!boo[pos]) { //if encounter is false
				boo[pos] = true; //make it true
				// encounters++;
				spotsFilled++;
			}
		}

		return (double)list.size()/(double)spotsFilled;
	} //determines the average number of elements that have been hashed to each spot in the hash table, ignoring spots that have no items hashed to them
	//this will be the # of elements in the list divided by the number of hash table cells used
	//if separate chaining were to be used, this would be the average chain length

	public static <T> int unused(List<T> list, int tableSize, Hashable<T> hashable) {
		int spotsFilled = 0;
		tableSize = PrimeTools.nextPrime(tableSize);
		boolean[] boo = new boolean[tableSize]; //creates a boolean array of tableSize with all false initially
		for (int i = 0; i < list.size(); i++) {
			int pos = hashable.hash(list.get(i)) % tableSize;
			pos = Math.abs(pos);

			if (!boo[pos]) { //if encounter is false
				boo[pos] = true; //make it true
				spotsFilled++;
			}
		}

		return (tableSize - spotsFilled);
	} //determines the number of unused hash table cells that occur in the specified case

}