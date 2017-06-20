
public class Lab11 {

	public static void main(String[] args) {
		int[] arr = new int[25];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr.length - i;
		}	
		shellsort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}	
	}

	 public static <T extends Comparable<? super T>> void shell(T[] array) {
	      int[] gapArr = {128,64,32,16,8,4,2,1};
	      int i;
	      int j;
	      T temp;
	      for (int gap : gapArr) {
	        for (i = gap; i < array.length; i++) {
	          temp = array[i];
	          for (j = i; j >= gap && temp.compareTo(array[j - gap]) < 0; j -= gap) {
	            array[j] = array[j - gap];
	          }
	          array[j] = temp;
	        }
	      }
	    }   

	   //You must calculate additional values using the given formula. Calculate enough addional values necessary to optimize the sort for the maximum observed array size specified by the assignment.
	   //Formula: 2^k - 1
	   public static <T extends Comparable<? super T>> void hibbard(T[] array) {
	      int[] gapArr = {255,127,63,31,15,7,3,1}; //add two remaining gaps
	      int i;
	      int j;
	      T temp;
	      for (int gap : gapArr) {
	        for (i = gap; i < array.length; i++) {
	          temp = array[i];
	          for (j = i; j >= gap && temp.compareTo(array[j - gap]) < 0; j -= gap) {
	            array[j] = array[j - gap];
	          }
	          array[j] = temp;
	        }
	      }
	   }

	   //you must calculate the remaining three using the given formula
	   //Formula: 4^k+3*2^(k-1)+1
	   public static <T extends Comparable<? super T>> void sedgewick(T[] array) {
	      int[] gapArr = {16577,4193,1073,281,77,23,8,1}; //add three remaining gapArr
	      int i;
	      int j;
	      T temp;
	      for (int gap : gapArr) {
	        for (i = gap; i < array.length; i++) {
	          temp = array[i];
	          for (j = i; j >= gap && temp.compareTo(array[j - gap]) < 0; j -= gap) {
	            array[j] = array[j - gap];
	          }
	          array[j] = temp;
	        }
	      }
	   }

	   public static <T extends Comparable<? super T>> void heapSort(T[] array) {
	      PriorityQueue.sort(array, array.length);
	   }
	   }
