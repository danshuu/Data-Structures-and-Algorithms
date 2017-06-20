import java.util.Arrays;
import java.util.Random;

public class Lab10 {

	public static void main(String[] args) {
//		Random rdm = new Random(0);
//		for (int i = 0; i < 10; i++) {
//			System.out.println(rdm.nextInt(100));
//		}
		Integer[] intArray = {1, 2, 3, 4, 5};
		insertionSort(intArray);
		for (int i = 0; i < intArray.length; i++) {
			System.out.println(intArray[i]);
		}
//		
		
//		Integer y = 5;
//		System.out.println(incrementVar(y));
//		System.out.println("After incrementing, y is " + y);
//		
//		int[] ints = {5,6,7,8,9};
//		changeArrayFirstElement(ints);
//		System.out.println("After calling the function, ints[0] is " + ints[0]);
	}

//	   public static <T extends Comparable<? super T>> void insertionSort(T[] array){
//		      int length = array.length;
//		      T temp;
//		      for (int i = 1; i < length; i++){
//		         temp = array[i];
//		         int j = i-1;
//		         while (j >= 0 && array[j].compareTo(temp) > 0){
//		            array[j+1] = array[j];
//		            j--;
//		         }
//		         array[j+1] = temp;
//		      }
//		   }
	
	public static <T extends Comparable<? super T>> void insertionSort(T[] array) {
	    int length = array.length;
	    T temp;
	    for (int i = 1; i < length; i++) { //start of unsorted
	        temp = array[i]; //save the element
	        int j = i-1;
	        while (temp.compareTo(array[j]) < 0 && j >= 0) { // while temp is less than array[j]
	        	System.out.println("entered the while loop. NOT"); //O(N)
	            array[j+1] = array[j]; 
	            j--;
	        } //end of while
	        array[j+1] = temp; //as soon as temp is greater than array[j], set array[j] equal to temp
	    }
	}
	
	public static <T extends Comparable<? super T>> void selectionSort(Integer[] array) {
		
		for (int i = 0; i < array.length-1; i++) {
			int tempIndex = i;
			Integer minimum = array[i];
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
    
	public static <T extends Comparable<? super T>> void bubbleSort1(T[] array) {
		T temp;
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
	public static int incrementVar(Integer x) {
		x = x + 1;
		return x; //returns a copy of x
	}

	public static void changeArrayFirstElement(int[] arr) {
		arr[0] = -100;
	}
}
