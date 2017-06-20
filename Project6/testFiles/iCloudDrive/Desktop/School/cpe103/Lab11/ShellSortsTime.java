/**
* Running time tests for ShellSorts
*
* @author Daniel Shu 
* @version Lab11 CPE103
*/

import java.util.*;

public class ShellSortsTime {

	public static void main(String[] args) {

		int arraySize = 1000000;
		int randomInteger = 100000;
		shellTest(arraySize, randomInteger);
		hibbardTest(arraySize, randomInteger);
		sedgewickTest(arraySize, randomInteger);
		heapSortTest(arraySize, randomInteger);

	}

	private static void shellTest(int arrSize, int randomInteger) {

		Random rdm = new Random(10);
		Integer[] arr = new Integer[arrSize];
		for (int i = 0; i < arrSize; i++) {
			arr[i] = rdm.nextInt(randomInteger);
		}
		long startTime = System.currentTimeMillis();
		ShellSorts.shell(arr);	
		long endTime = System.currentTimeMillis();
		long timeTook = (endTime - startTime);
		System.out.println("Using shellTest for " + arrSize + " elements took " + timeTook + " ms.");
	}

	private static void hibbardTest(int arrSize, int randomInteger) {

		Random rdm = new Random(10);
		Integer[] arr = new Integer[arrSize];
		for (int i = 0; i < arrSize; i++) {
			arr[i] = rdm.nextInt(randomInteger);
		}
		long startTime = System.currentTimeMillis();
		ShellSorts.hibbard(arr);	
		long endTime = System.currentTimeMillis();
		long timeTook = (endTime - startTime);
		System.out.println("Using hibbardTest for " + arrSize + " elements took " + timeTook + " ms.");
	}

	private static void sedgewickTest(int arrSize, int randomInteger) {

		Random rdm = new Random(10);
		Integer[] arr = new Integer[arrSize];
		for (int i = 0; i < arrSize; i++) {
			arr[i] = rdm.nextInt(randomInteger);
		}
		long startTime = System.currentTimeMillis();
		ShellSorts.sedgewick(arr);	
		long endTime = System.currentTimeMillis();
		long timeTook = (endTime - startTime);
		System.out.println("Using sedgewickTest for " + arrSize + " elements took " + timeTook + " ms.");
	}

	private static void heapSortTest(int arrSize, int randomInteger) {

		Random rdm = new Random(10);
		Integer[] arr = new Integer[arrSize];
		for (int i = 0; i < arrSize; i++) {
			arr[i] = rdm.nextInt(randomInteger);
		}
		long startTime = System.currentTimeMillis();
		ShellSorts.heapSort(arr);	
		long endTime = System.currentTimeMillis();
		long timeTook = (endTime - startTime);
		System.out.println("Using heapSortTest for " + arrSize + " elements took " + timeTook + " ms.");
	}
}