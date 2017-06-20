/**
* Running time tests for QuadraticSorts
*
* @author Daniel Shu 
* @version Lab10 CPE103
*/

import java.util.*;

public class QuadraticSortsTime {

	public static void main(String[] args) {

		int arraySize = 100000;
		bubbleSort1Test(arraySize);
		bubbleSort2Test(arraySize);
		selectionSortTest(arraySize);
		insertionSortTest(arraySize);

	}

	private static void bubbleSort1Test(int arrSize) {

		Random rdm = new Random(10);
		Integer[] arr = new Integer[arrSize];
		for (int i = 0; i < arrSize; i++) {
			arr[i] = rdm.nextInt(1000);
		}
		long startTime = System.currentTimeMillis();
		QuadraticSorts.bubbleSort1(arr);	
		long endTime = System.currentTimeMillis();
		long timeTook = (endTime - startTime);
		System.out.println("Using bubbleSort1 for " + arrSize + " elements took " + timeTook + " ms.");
	}

	private static void bubbleSort2Test(int arrSize) {

		Random rdm = new Random(10);
		Integer[] arr = new Integer[arrSize];
		for (int i = 0; i < arrSize; i++) {
			arr[i] = rdm.nextInt(1000);
		}
		long startTime = System.currentTimeMillis();
		QuadraticSorts.bubbleSort2(arr);	
		long endTime = System.currentTimeMillis();
		long timeTook = (endTime - startTime);
		System.out.println("Using bubbleSort2 for " + arrSize + " elements took " + timeTook + " ms.");
	}

	private static void selectionSortTest(int arrSize) {

		Random rdm = new Random(10);
		Integer[] arr = new Integer[arrSize];
		for (int i = 0; i < arrSize; i++) {
			arr[i] = rdm.nextInt(1000);
		}
		long startTime = System.currentTimeMillis();
		QuadraticSorts.selectionSort(arr);	
		long endTime = System.currentTimeMillis();
		long timeTook = (endTime - startTime);
		System.out.println("Using selectionSort for " + arrSize + " elements took " + timeTook + " ms.");
	}

	private static void insertionSortTest(int arrSize) {

		Random rdm = new Random(10);
		Integer[] arr = new Integer[arrSize];
		for (int i = 0; i < arrSize; i++) {
			arr[i] = rdm.nextInt(1000);
		}
		long startTime = System.currentTimeMillis();
		QuadraticSorts.insertionSort(arr);	
		long endTime = System.currentTimeMillis();
		long timeTook = (endTime - startTime);
		System.out.println("Using insertionSort for " + arrSize + " elements took " + timeTook + " ms.");
	}
}