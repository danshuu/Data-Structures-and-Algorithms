/**
* This program creates the BinaryHeap
* Several static methods that work with arrays of Comparable references are implemented
* One method, isHeap, will be very useful in solving parentOf, leftChildOf, and rightChildOf
* Check conditions and throw exceptions in the proper order
*
* @author Daniel Shu
* @version Lab5 CPE103
*/

import java.util.NoSuchElementException;

public class BinaryHeapUtilities {
	//No constructor
	//ASSUME ALL SPOTS IN THE ARRAY OF SIZE N CONTAIN VALID DATA ELEMENTS
	//meaning you don't have to check the array for null values if you correctly use the size parameter
	public static int height(int size) {

		if (size <= 0) {
			throw new IllegalArgumentException();
		}

		return (int)(Math.log(size) / Math.log(2)); 
		//java doesn't provide an arbitrary base logarithm, even though it provides a log10() for base-10 algorithms
		
	} //calculates the height of the heap given its size

	public static <T extends Comparable<? super T>> boolean isHeap(T[] heap, int size) {

		if (size <= 0) {
			return false;
		} //if empty heap, it will not be a heap *** ask to make sure **************************

		//*****What was the reason that we have to start at index 1 and skip index 0 again? ***
		for (int i = size; i > 1; i--) { //checks to see if its greater than its parent, excludes 1 because its the root

			if (heap[i].compareTo(heap[i/2]) < 0) {
				return false;
			} //if the child is smaller than its parent, return false bc binary heaps must be in ascending order from parent to child
			//better than checking if parent is bigger than child, because parent may not have a child so it may cause issues

		} //returns false if parent is greater than left child or right child

		return true; //return true otherwise

	} //checks to see if data in the specified array meets the heap order property for binary heaps. The heap order property requires all children
	//must be greater than or equal to their parent. A precondition (requirement the caller must meet) is that the first value is at index 1.
	//An empty heap will have a size of zero and a non-empty heap's size is also its last valid index
	//returns true if size is positive AND the array of elements meet the order property required for binary heaps; false otherwise

	public static <T extends Comparable<? super T>> T parentOf(int index, T[] heap, int size) {

		if (index <= 0 || index > size) {
			throw new IndexOutOfBoundsException();
		} //if index <= 0 or index is greater than size, throw exception (first check)

		if (index / 2 <= 0) {
			//heap[index / 2] == null || (this was added in the if statement but taken out)
			throw new NoSuchElementException();
		} //if specified element doesn't have a parent (second check)

		if (!isHeap(heap, size)) {
			throw new IllegalArgumentException();
		} //if not heap, throw exception (third check)

		return heap[index/2];

	} //returns the parent of the specified element


	public static <T extends Comparable<? super T>> T leftChildOf(int index, T[] heap, int size) {

		if (index <= 0 || index > size) {
			throw new IndexOutOfBoundsException();
		} //if index <= 0 or index is greater than size, throw exception

		if ((index * 2) > size) {
			throw new NoSuchElementException();
		} //if specified element doesn't have a left-child

		if (!isHeap(heap, size)) {
			throw new IllegalArgumentException();
		} //if not heap, throw exception

		return heap[index * 2];

	} //returns the left-child of the specified element 

	public static <T extends Comparable<? super T>> T rightChildOf(int index, T[] heap, int size) {

		if (index <= 0 || index > size) {
			throw new IndexOutOfBoundsException();
		} //if index <= 0 or index is greater than size, throw exception

		if ((index * 2) + 1 > size) {
			throw new NoSuchElementException();
		} //if specified element doesn't have a right-child

		if (!isHeap(heap, size)) {
			throw new IllegalArgumentException();
		} //if not heap, throw exception

		return heap[(index * 2) + 1];

	} //returns the right-child of the specified element

	//A heap with a non-positive size is not considered a valid heap	


} //array-based