/**
 * Trivial JUnit tests for Quadratic sorts lab assignment.
 *
 * @author Paul Hatalsky
 * @version 11/10/2016 Developed for CPE 103 Lab 10 
 */
import static org.junit.Assert.*;
import org.junit.*;
import java.lang.reflect.*;
import java.util.Random;
import java.util.Arrays;
import org.junit.runners.MethodSorters;
import org.junit.rules.*;
import org.junit.runner.Description;
import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class QuadraticSortsSampleTests
{
   @Test
   public void test01_bubbleSort1_sort() 
   {
      Integer[] array = new Integer[] {10, 5};
      QuadraticSorts.bubbleSort1(array);
      assertEquals(array[0], new Integer(5));
      assertEquals(array[1], new Integer(10));
   }
   @Test
   public void test02_bubbleSort2_sort() 
   {
      String[] array = new String[] {"World", "Hello"};
      QuadraticSorts.bubbleSort2(array);
      assertEquals(array[0], "Hello");
      assertEquals(array[1], "World");
   }
   @Test
   public void test03_insertionSort_sort() 
   {
      Integer[] array = new Integer[] {10, 5};
      QuadraticSorts.insertionSort(array);
      assertEquals(array[0], new Integer(5));
      assertEquals(array[1], new Integer(10));
   }
   @Test
   public void test04_selectionSort_sort() 
   {
      Integer[] array = new Integer[] {10, 5};
      QuadraticSorts.selectionSort(array);
      assertEquals(array[0], new Integer(5));
      assertEquals(array[1], new Integer(10));
   }
} 