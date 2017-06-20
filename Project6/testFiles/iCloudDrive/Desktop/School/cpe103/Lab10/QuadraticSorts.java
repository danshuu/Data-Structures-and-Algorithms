/**
* In this lab, you will implement 2 variations of the bubble sort algorithm, 1 insertion sort algorithm, and 1 selection sort algorithm
* The performance of these sorting algorithms will be timed for specific numbers of inputs using System.currentTimeMillis().
* Based on these observations, you will calculate for how long the algorithms would take with much larger specific sizes of input.
* Finally, report your observations and calculations in a text file that you will hand in along with your source code
* The QuadraticSorts class contains various O(n^2) sorting algorithms
* @author Daniel Shu
* @version Lab 10 CPE103
*/

public class QuadraticSorts {

	public static <T extends Comparable<? super T>> void bubbleSort1(T[] array) {
		T temp;
		//loops through as many times as possible (bad algorithm)
		for (int i = 0; i < array.length; i++) {
			for (int j = 1; j < array.length; j++) {
				if (array[j-1].compareTo(array[j]) > 0) {
					temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
				}
			}
		}
	} //sorts specified array into ascending order using the first (slowest) of the 3 bubble sort variations

	public static <T extends Comparable<? super T>> void bubbleSort2(T[] array) {
		T temp;
		boolean iSwap = true;
		int arrLength = array.length;
		while (iSwap) {
			iSwap = false;
			for (int j = 1; j < arrLength; j++) {
				if (array[j-1].compareTo(array[j]) > 0) {
					temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
					iSwap = true;
				}
			}
			arrLength--;
		}

	} //sorts specified array into ascending order using the second (faster) of the 2 optimised bubble sort variations

	public static <T extends Comparable<? super T>> void insertionSort(T[] array){
      	T temp;
      	for (int i = 1; i < array.length; i++){
         	temp = array[i];
         	int j = i-1;
         	while (j >= 0 && array[j].compareTo(temp) > 0){
            	array[j+1] = array[j];
	            j--;
         	}
         	array[j+1] = temp;
      	}
   	}	

	public static <T extends Comparable<? super T>> void selectionSort(T[] array) {
		for (int i = 0; i < array.length-1; i++) {
			int tempIndex = i;
			T minimum = array[i];
			for (int j = i+1; j < array.length; j++) { //find minimum
				if (array[j].compareTo(minimum) < 0) { //if element is smaller than minimum
					minimum = array[j];
					tempIndex = j;
				}
			}
			array[tempIndex] = array[i];
			array[i] = minimum;
		}
	}
}