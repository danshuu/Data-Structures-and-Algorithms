//Johnnie Baba
//CPE 103-07

import org.junit.*;
import static org.junit.Assert.*;

import java.util.Random;

public class ShellSortsTests {

   public <T extends Comparable<? super T>> boolean sorted(T[] array){
      int n = array.length;
      for ( int i = 0; i < n-1; i++) {
        assertTrue(array[i].compareTo(array[i+1]) <= 0);
      }
      return true;
   }

      
   @Test
   public void testShell(){
      Integer[] array = new Integer []{12,8,16,1,5};
      ShellSorts.shell(array);
      assertTrue(sorted(array));
   }

   @Test
   public void testHibbard(){
      Integer[] array = new Integer []{121,90,126,101,589};
      ShellSorts.hibbard(array);
      assertTrue(sorted(array));
   }
   
   @Test
   public void testSedgwick(){
      Integer[] array = new Integer []{41,8,69,1,55};
      ShellSorts.sedgewick(array);
      assertTrue(sorted(array));
   }
   
   @Test
   public void testPQSort(){
      Integer[] array = new Integer []{21,19,16,1,5};
      ShellSorts.heapSort(array);
      assertTrue(sorted(array));
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
      assertTrue(sorted(array));
      
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
      assertTrue(sorted(array));
      
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
      assertTrue(sorted(array));
      
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
      assertTrue(sorted(array));
      
   }
}