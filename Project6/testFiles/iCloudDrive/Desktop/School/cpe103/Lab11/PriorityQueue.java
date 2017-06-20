/**
 * PriorityQueue
 * In this assignment, you will implement a binary heap-based priority queue. Recall that a binary heap is an array-based implementation and that binary 
 * heaps allow you to enqueue and dequeue items in a priority queue in O(logn) time. Your priority queue will support both minimum and maximum 
 * priorities by allowing the user of the priority queue to specify which ordering they would like at construction. 
 * PriorityQueue must have exactly two private fields: 
 * A reference to an ArrayList<T>. This is where you will store your binary heap. 
 * A boolean to keep track of whether the queue is a minimum queue (where the minimum value is at the top of the heap) or a maximum queue (where the maximum value is at the top of the heap). 
 * PriorityQueue may not have any non-private methods other than those specified (in the documentation). 
 * @author Daniel Shu
 * @version CPE 103 Project 3
 */

import java.util.*;

// A priority queue based on a binary heap. A priority queue does not permit null elements. 
// The front of this queue may be either the least element of the greatest element depending on the construction.

public class PriorityQueue<T extends Comparable<? super T>> implements SimpleQueue<T> {

	//Fields
	//A reference to an ArrayList<T>. This is where you will store your binary heap. 
	//A boolean to keep track of whether the queue is a minimum queue (where the minimum value is at the top of the heap) or a maximum queue (where the maximum value is at the top of the heap). 	
	private ArrayList<T> queue;
	private boolean isMax;

	//Constructors
	public PriorityQueue() {
		queue = new ArrayList<T>();
		this.isMax = false;
		queue.add(null); //adds a null element to the start of the list so that the PQ starts at index 1 (rule of binary heap)

	} //creates a minimum PriorityQueue

	public PriorityQueue(boolean isMax) {
		queue = new ArrayList<T>();
		this.isMax = isMax;
		queue.add(null); //adds a null element to the start of the list so that the PQ starts at index 1 (rule of binary heap)
	} //creates a Maximum PriorityQueue when isMax is true; otherwise a minimum queue

	public PriorityQueue(T[] arr, int size) {
		queue = new ArrayList<T>();
		this.isMax = false;
		queue.add(null); //adds a null element to the start of the list so that the PQ starts at index 1 (rule of binary heap)
		for (int i = 0; i < size; i++) {
			this.enqueue(arr[i]);
		}
	} //creates a minimum PriorityQueue containing the elements in the specified array
	//The array is NOT a binary heap; this constructor will build a priority queue with these values

	public PriorityQueue(T[] arr, int size, boolean isMax) {
		queue = new ArrayList<T>();
		this.isMax = isMax;
		queue.add(null); //adds a null element to the start of the list so that the PQ starts at index 1 (rule of binary heap)
		for (int i = 0; i < size; i++) {
			this.enqueue(arr[i]);
		}
	} //creates a PriorityQueue containing the elements in the specified array
	//The array is NOT a binary heap; this constructor will build a priority queue with these values
	//creates a Maximum PriorityQueue when isMax is true; otherwise a minimum queue
	
	//Methods
	//DONT use swap method for this, as it will significantly slow down efficiency
	public T dequeue() {

		if (size() <= 0) {
			throw new NoSuchElementException();
		}
		//save the root element but don't remove it just yet
		int originalSize = size(); //also equal to the index of last element of the current list before dequeueing
		T rootElement = queue.get(1); //1 is the root

		if(size() <= 1) { // if size of pq is already 0 or 1, then just return the root that was removed
			queue.remove(1);
			return rootElement;
		} else { //if the pq has at least 2 elements
			//remove last item from heap and see if removed item can be inserted
			boolean notDone = true; // for while loop
			T removedElement = queue.remove(size()); //removes last element
			// queue.add(1, removedElement); //add the removed element into the hole

			int holeIndex = 1; //starts at rootindex
			int childIndex; //either child, but will be modified later

			String priority; //flag for isMax
			if (isMax) {
				priority = "max"; //representing maximum PQ
			} else {
				priority = "min"; //representing minimum PQ
			}

			if (size() == 1) {
				queue.set(holeIndex, removedElement);
				return rootElement;
			}
			switch (priority) {
				//holeIndex * 2 is the left child
				//holeIndex * 2 + 1 is the right child
				case "min": 
				//has to have at least 1 child if it gets through the first size if statement
					if ((holeIndex*2)+1 >= originalSize) { //if the hole only has a left child
						childIndex = holeIndex*2;
					} else { //if hole has 2 children
							//find the lesser child index
						if (queue.get(holeIndex*2).compareTo(queue.get((holeIndex*2) + 1)) <= 0) {
							childIndex = holeIndex*2;
						} else {
							childIndex = (holeIndex*2) + 1;
						}
					}	
					//start percolating and swapping
					// while (childIndex < originalSize) {
					while (notDone) {
						if (removedElement.compareTo(queue.get(holeIndex)) <= 0) {
							queue.set(holeIndex, removedElement);
							notDone = false;
							break;
						} else {
							//set the element in the hole as the childIndex element
							queue.set(holeIndex, queue.get(childIndex)); //put the lesser of the left and right children in the spot you just tried and see if the removed value can be inserted into the new "hole"
							//check if removed element is smaller than current element at hole
							if (removedElement.compareTo(queue.get(holeIndex)) <= 0) {
								queue.set(holeIndex, removedElement);
								notDone = false;
								break;
							} // end of if

							holeIndex = childIndex; //reset the holeIndex
							//check if the new child Index would be greater than the original size of queue so we can break out if the hole already has no children, or if it has one child, then set that as the new child
							if (holeIndex*2 >= originalSize) {
								queue.set(holeIndex, removedElement);
								return rootElement; //return root element if the hole now has no children
							} else if ((holeIndex*2)+1 >= originalSize) { //if the hole only has a left child
								childIndex = holeIndex*2;
							} else { //if hole has 2 children
									//find the lesser child index
								if (queue.get(holeIndex*2).compareTo(queue.get((holeIndex*2) + 1)) <= 0) { //if left child is less than right child
									childIndex = holeIndex*2;
								} else {
									childIndex = (holeIndex*2) + 1;
								}
							}
						}
					} //end of while loop

				return rootElement;
			// break; 
				case "max": 
					if ((holeIndex*2)+1 >= originalSize) { //if the hole only has a left child
						childIndex = holeIndex*2;
					} else { //if hole has 2 children
							//find the greater child index
						if (queue.get(holeIndex*2).compareTo(queue.get((holeIndex*2) + 1)) >= 0) {
							childIndex = holeIndex*2;
						} else {
							childIndex = (holeIndex*2) + 1;
						}
					}	
					//start percolating and swapping
					// while (childIndex < originalSize) {
					while (notDone) {
						if (removedElement.compareTo(queue.get(holeIndex)) >= 0) {
							queue.set(holeIndex, removedElement);
							notDone = false;
							break;
						} else {
							//set the element in the hole as the childIndex element
							queue.set(holeIndex, queue.get(childIndex)); //put the lesser of the left and right children in the spot you just tried and see if the removed value can be inserted into the new "hole"
							//check if removed element is smaller than current element at hole
							if (removedElement.compareTo(queue.get(holeIndex)) >= 0) {
							queue.set(holeIndex, removedElement);
							notDone = false;
							break;
							} // end of if

							holeIndex = childIndex; //reset the holeIndex
							//check if the new child Index would be greater than the original size of queue so we can break out if the hole already has no children, or if it has one child, then set that as the new child
							if (holeIndex*2 >= originalSize) {
								queue.set(holeIndex, removedElement);
								return rootElement; //return root element if the hole now has no children
							} else if ((holeIndex*2)+1 >= originalSize) { //if the hole only has a left child
								childIndex = holeIndex*2;
							} else { //if hole has 2 children
									//find the lesser child index
								if (queue.get(holeIndex*2).compareTo(queue.get((holeIndex*2) + 1)) >= 0) { //if left child is less than right child
									childIndex = holeIndex*2;
								} else {
									childIndex = (holeIndex*2) + 1;
								}
							}
							//reset the childIndex to the lesser child
						}
					} //end of while loop
				return rootElement; //return the root that was removed
			} //end of switch
		} //end of first else 

		return rootElement;

	} //removes and returns the element at the front of this queue
	//throws nosuchelementexception if queue is empty
	/* 
	1. Save the item at the root of the binary heap for eventual return.
	2. Remove the last item from the heap; since you are dequeuing an element this value shouldn't be here any more or you would violate the structure property of a binary heap 
	   (it must be a complete binary tree). See if this removed item can be inserted into the "hole" you just created at the root without violating the order property. 
	   If it can, then you're done!
	3. If not done, then put the lesser of the left and right children in the spot you just tried and see if the removed value can be inserted into the new "hole" you just created without violating the order property. 
	   If it can, then you're done!
	4. If not done, repeat step 3, percolating down through the heap until you find the first place the removed value can go without violating the order property. 
	   Be careful if/when you get down towards the bottom of the heap; not all nodes have 2 children! If you get to such a node, you will have to modify the approach slightly or risk bad behaviours! 
	   This would be an excellent test case for you to develop (among others)!
	5. Return the saved item (formerly at the top of the heap).
	*/

	public void enqueue(T element) {

		int elementIndex = queue.size(); //index you want to add to
		int parentIndex = elementIndex/2;

		queue.add(element); //add the element 
		//set the index of the element and the parent so you can compare them

		//to be utilized for the switch statement
		String priority; //flag for isMax
		if (isMax) {
			priority = "max"; //representing maximum PQ
		} else {
			priority = "min"; //representing minimum PQ
		}
		switch (priority) {
			//if it is minimum priority queue
			case "min":
				if (queue.size() > 1) { //if it goes in here, then the root is already set
					while (parentIndex >= 1) { //if the element is less than its parent, the order property doesn't hold, so swap them
						if (element.compareTo(queue.get(parentIndex)) < 0) {
							Collections.swap(queue,parentIndex,elementIndex);
							elementIndex = parentIndex;
							parentIndex = elementIndex/2;
						} else { //meaning the element doesn't violate the order property
							break; //break breaks out of all looops
						} //end of else
					} //end of while
				} 
				break; //break for the case
			//if it is maximum priority queue
			case "max": 

				if (queue.size() > 1) { //if it goes in here, then the root is already set

					while (parentIndex >= 1) { //if the element is less than its parent, the order property doesn't hold, so swap them
						if (element.compareTo(queue.get(parentIndex)) > 0) {
							Collections.swap(queue,parentIndex,elementIndex);
							elementIndex = parentIndex;
							parentIndex = elementIndex/2;
						} else { //meaning the element doesn't violate the order property
							break;
						}
					} 
				} 
				break; //break for the case
		}

		// System.out.println("After enqueue: size = " + queue.size());

	} //adds the specified element to the end of this queue
	/*
	1. See if the element can be added to the end of the heap without violating the order property of a binary heap. If it can, then you're done!
	2. If not done, then move the parent element to the spot you just tried and see if the element can go where the parent was without violating the order property. If it can, then you're done!
	3. If not done, repeat step 2, percolating up through the heap until you find the first place the value can go without violating the order property. Be careful if/when you make it to the root of the heap!
	*/

	public T peek() {

		if (size() <= 0) {
			throw new NoSuchElementException();
		} 

		return queue.get(1); //return the second elemenet in the queue (which is the front since index 0 is null)

	} //returns the element at the front of this queue (but does not remove it)

	public int size() {

		return queue.size() - 1; //not counting first element which is null

	} //returns the number of elements in this queue

	public static <E extends Comparable<? super E>> void sort(E[] arr, int size) {

		PriorityQueue<E> newPQ = new PriorityQueue<E>();
		//enqueue all items into PQ
		for (int i = 0; i < size; i++) {
			newPQ.enqueue(arr[i]);
		}
		//dequeue all items back to array
		for (int j = 0; j < size; j++) {
			arr[j] = newPQ.dequeue();
		}

	} //sorts the specified array into ascending order

	public static <E extends Comparable<? super E>> E kth(E[] arr, int size, int k) {
		//use SMALLEST pq necessary
		PriorityQueue<E> pqKth = new PriorityQueue<E>();
		int n = size;

		if (k < n - k + 1) { //if k is smaller
			//use minimum heap
			//enqueue first k elements
			for (int i = 0; i < k; i++) {
				pqKth.enqueue(arr[i]);
			}

			for (int i = k; i < n; i++) {
				if (arr[i].compareTo(pqKth.peek()) > 0) {//if the element from the un-enqueued part of array is larger than the front of the queue
					//dequeue and enqueue
					pqKth.dequeue();
					pqKth.enqueue(arr[i]); //this will most likely stay near the bottom, until the loop is done. unless k was 1 and arr[i] was the largest element
				}
			}

		} else { //if k is bigger/equal
			//use max heap for n - k + 1 elements
			pqKth.isMax = true;
			for (int i = 0; i < n - k + 1; i++) {
				pqKth.enqueue(arr[i]);
			} 

			for (int i = n - k + 1; i < n; i++) {
				if (arr[i].compareTo(pqKth.peek()) < 0) {
					pqKth.dequeue();
					pqKth.enqueue(arr[i]); //will most likely stay near the bottom
				}
			}

		}

		return pqKth.peek(); //return the element at the front of the queue

	} //finds the kth largest element in the specified array
	//specs say you don't have to throw any specific exceptions for this method
	/* Basic algorithm:
	Enqueue the first k or N–k+1 elements from the array, whichever is smaller.
	* Use a minimum heap if you will enqueue k elements. 
	* Use a maximum heap if you will enqueue N – k + 1 elements 
	Compare each of the remaining elements in the array to the value at the front of the PriorityQueue as follows: 
	* If you enqueued k elements, you want to dequeue when the element from the array is larger than the element at the front of the queue and then enqueue the element from the array. 
	* If you enqueue N - k + 1 elements, you want to dequeue when the element from the array is smaller than the element at the front of the queue and then enqueue the element from the array. 
	* When you're done, the kth largest element should be the element at the front of the queue; you should return it. 
	*/

} //end of PQ class

	//***not part of specs; made for testing purposes***

	// public T get(int index) {

	// 	return queue.get(index+1); //skips the null element

	// } //for testing the driver purposes only

	// public T remove(int index) {

	// 	return queue.remove(index+1); //skips the null element

	// } //for testing the driver purposes only

