/**
* Shell Sort Practice
*
* @author Daniel Shu
* @version CPE 103 Lab 11
*/

import java.util.Arrays;

public class ShellSortsPractice { 

   //You must calculate additional values using the given formula. Calculate enough addional values necessary to optimize the sort for the maximum observed array size specified by the assignment.
   //Formula: 2^k
  public static <T extends Comparable<? super T>> void shell(T[] array) {
      int[] gapArr = {128,64,32,16,8,4,2,1};
      int gap;
      int i;
      int j;
      T temp;
      for (gap : gapArr) {
        for (i = gap; i < array.length; i++) {
          temp = a[i];
          for (j = i; j >= gap && temp.compareTo(a[j - gap]) < 0; j -= gap) {
            a[j] = a[j - gap];
          }
          a[j] = temp;
        }
      }
    }   

   //You must calculate additional values using the given formula. Calculate enough addional values necessary to optimize the sort for the maximum observed array size specified by the assignment.
   //Formula: 2^k - 1
   public static <T extends Comparable<? super T>> void hibbard(T[] array) {
      int[] gapArr = {255,127,63,31,15,7,3,1}; //add two remaining gaps
      int gap;
      int i;
      int j;
      T temp;
      for (gap : gapArr) {
        for (i = gap; i < array.length; i++) {
          temp = a[i];
          for (j = i; j >= gap && temp.compareTo(a[j - gap]) < 0; j -= gap) {
            a[j] = a[j - gap];
          }
          a[j] = temp;
        }
      }
   }

   //you must calculate the remaining three using the given formula
   //Formula: 4^k+3*2^(k-1)+1
   public static <T extends Comparable<? super T>> void sedgewick(T[] array) {
      int[] gapArr = {16577,4193,1073,281,77,23,8,1}; //add three remaining gapArr
      int gap;
      int i;
      int j;
      T temp;
      for (gap : gapArr) {
        for (i = gap; i < array.length; i++) {
          temp = a[i];
          for (j = i; j >= gap && temp.compareTo(a[j - gap]) < 0; j -= gap) {
            a[j] = a[j - gap];
          }
          a[j] = temp;
        }
      }
   }

   public static <T extends Comparable<? super T>> void heapSort(T[] array) {
      PriorityQueue.sort(array, array.length);
   }
}

