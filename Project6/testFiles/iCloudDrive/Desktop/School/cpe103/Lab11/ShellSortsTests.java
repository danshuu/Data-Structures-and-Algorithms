/**
* Shell Sort 
*
* @author Daniel Shu
* @version CPE 103 Lab 11
*/

import org.junit.*;
import static org.junit.Assert.*;

import java.util.Random;

public class ShellSortsTests {

   private <T extends Comparable<? super T>> boolean isSorted(T[] array){
      int n = array.length;
      for (int i = 0; i < n-1; i++) {
        if (array[i].compareTo(array[i+1]) > 0) {
         return false;
        }
      }
      return true;
   }

      
   @Test
   public void ShellTest(){
      Integer[] array = new Integer[] {12,8,146,1,5};
      ShellSorts.shell(array);
      assertTrue(isSorted(array));
   }

   @Test
   public void HibbardTest(){
      Integer[] array = new Integer[] {444,90,126,101,123};
      ShellSorts.hibbard(array);
      assertTrue(isSorted(array));
   }
   
   @Test
   public void SedgwickTest(){
      Integer[] array = new Integer[] {41,48,269,1,55};
      ShellSorts.sedgewick(array);
      assertTrue(isSorted(array));
   }
   
   @Test
   public void PQSortTest(){
      Integer[] array = new Integer[] {121,19,416,1,11};
      ShellSorts.heapSort(array);
      assertTrue(isSorted(array));
   }
   
   @Test
   public void complexTest0(){
      int size = 2500;
      Integer[] array = new Integer[size];
      Random rand = new Random(-9999);
      for (int i = 0; i < size; i++) {
         array[i] = rand.nextInt();
      }
      ShellSorts.shell(array);
      assertTrue(isSorted(array));
      
   }
   
   @Test
   public void complexTest1(){
      int size = 2500;
      Integer[] array = new Integer[size];
      Random rand = new Random(-9999);
      for (int i = 0; i < size; i++) {
         array[i] = rand.nextInt();
      }
      ShellSorts.sedgewick(array);
      assertTrue(isSorted(array));
      
   }
   
   @Test
   public void complexTest2(){
      int size = 2500;
      Integer[] array = new Integer[size];
      Random rand = new Random(-9999);
      for (int i = 0; i < size; i++) {
         array[i] = rand.nextInt();
      }
      ShellSorts.hibbard(array);
      assertTrue(isSorted(array));
      
   }
   
   @Test
   public void complexTest3(){
      int size = 2500;
      Integer[] array = new Integer[size];
      Random rand = new Random(-9999);
      for (int i = 0; i < size; i++) {
         array[i] = rand.nextInt();
      }
      ShellSorts.heapSort(array);
      assertTrue(isSorted(array));
      
   }
}