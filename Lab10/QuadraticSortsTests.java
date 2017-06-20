/**
* Junit tests for QuadraticSorts
*
* @author Daniel Shu 
* @version Lab10 CPE103
*/

import org.junit.*;
import static org.junit.Assert.*;


public class QuadraticSortsTests {

	@Test 
	public void bubbleSort1Test() {
		Integer[] intArray = {10, 20, 12, 15, 5, 16, 25, 30};
		QuadraticSorts.bubbleSort1(intArray);
		Integer[] sortedArray = {5, 10, 12, 15, 16, 20, 25, 30};
		for (int i = 0; i < intArray.length; i++) {
			assertEquals(intArray[i], sortedArray[i]);
		}
	}

	@Test 
	public void bubbleSort1Test2() {
		Integer[] intArray = {16, 8, 5, 3, 18, 20, 30, 50, 5};
		QuadraticSorts.bubbleSort1(intArray);
		Integer[] sortedArray = {3, 5, 5, 8, 16, 18, 20, 30, 50};
		for (int i = 0; i < intArray.length; i++) {
			assertEquals(intArray[i], sortedArray[i]);
		}
	}

	@Test 
	public void bubbleSort1Test3() {
		Integer[] intArray = {100};
		QuadraticSorts.bubbleSort1(intArray);
		Integer[] sortedArray = {100};
		for (int i = 0; i < intArray.length; i++) {
			assertEquals(intArray[i], sortedArray[i]);
		}
	}

	@Test 
	public void bubbleSort2Test() {
		Integer[] intArray = {10, 20, 12, 15, 5, 16, 25, 30};
		QuadraticSorts.bubbleSort2(intArray);
		Integer[] sortedArray = {5, 10, 12, 15, 16, 20, 25, 30};
		for (int i = 0; i < intArray.length; i++) {
			assertEquals(intArray[i], sortedArray[i]);
		}
	}

	@Test 
	public void bubbleSort2Test2() {
		Integer[] intArray = {16, 8, 5, 3, 18, 20, 30, 50, 5};
		QuadraticSorts.bubbleSort2(intArray);
		Integer[] sortedArray = {3, 5, 5, 8, 16, 18, 20, 30, 50};
		for (int i = 0; i < intArray.length; i++) {
			assertEquals(intArray[i], sortedArray[i]);
		}
	}

	@Test 
	public void bubbleSort2Test3() {
		Integer[] intArray = {100};
		QuadraticSorts.bubbleSort2(intArray);
		Integer[] sortedArray = {100};
		for (int i = 0; i < intArray.length; i++) {
			assertEquals(intArray[i], sortedArray[i]);
		}
	}

	@Test 
	public void insertionSortTest() {
		Integer[] intArray = {10, 20, 12, 15, 5, 16, 25, 30};
		QuadraticSorts.insertionSort(intArray);
		Integer[] sortedArray = {5, 10, 12, 15, 16, 20, 25, 30};
		for (int i = 0; i < intArray.length; i++) {
			assertEquals(intArray[i], sortedArray[i]);
		}
	}

	@Test 
	public void insertionSortTest2() {
		Integer[] intArray = {16, 8, 5, 3, 18, 20, 30, 50, 5};
		QuadraticSorts.insertionSort(intArray);
		Integer[] sortedArray = {3, 5, 5, 8, 16, 18, 20, 30, 50};
		for (int i = 0; i < intArray.length; i++) {
			assertEquals(intArray[i], sortedArray[i]);
		}
	}

	@Test 
	public void insertionSortTest3() {
		Integer[] intArray = {100};
		QuadraticSorts.insertionSort(intArray);
		Integer[] sortedArray = {100};
		for (int i = 0; i < intArray.length; i++) {
			assertEquals(intArray[i], sortedArray[i]);
		}
	}

	@Test 
	public void selectionSortTest() {
		Integer[] intArray = {10, 20, 12, 15, 5, 16, 25, 30};
		QuadraticSorts.selectionSort(intArray);
		Integer[] sortedArray = {5, 10, 12, 15, 16, 20, 25, 30};
		for (int i = 0; i < intArray.length; i++) {
			assertEquals(intArray[i], sortedArray[i]);
		}
	}

	@Test 
	public void selectionSortTest2() {
		Integer[] intArray = {16, 8, 5, 3, 18, 20, 30, 50, 5};
		QuadraticSorts.selectionSort(intArray);
		Integer[] sortedArray = {3, 5, 5, 8, 16, 18, 20, 30, 50};
		for (int i = 0; i < intArray.length; i++) {
			assertEquals(intArray[i], sortedArray[i]);
		}
	}

	@Test 
	public void selectionSortTest3() {
		Integer[] intArray = {100};
		QuadraticSorts.selectionSort(intArray);
		Integer[] sortedArray = {100};
		for (int i = 0; i < intArray.length; i++) {
			assertEquals(intArray[i], sortedArray[i]);
		}
	}
}