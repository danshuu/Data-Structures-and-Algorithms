/**
 * JUnit tests for BST assignment.
 *
 * @author Paul Hatalsky
 * @version 2/17/2017 Developed for CPE 103 Lab07 
 */
import static org.junit.Assert.*;
import org.junit.*;
import java.lang.reflect.*;
import java.util.NoSuchElementException;
import java.util.*;
import org.junit.runners.MethodSorters;
import org.junit.rules.*;
import org.junit.runner.Description;
import static org.hamcrest.CoreMatchers.*;
import java.util.concurrent.TimeUnit;
import java.io.*;
import java.lang.annotation.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BSTSampleTests {
   private static int globalSize = 1000000;
   private static BST<Integer> globalBst = new BST<Integer>();
   private static TreeMap<Integer, Object> globalTreeMap = new TreeMap<Integer, Object>(); 
   private static Integer[] globalInts = new Integer[globalSize];
   private static Set<Integer> globalKeys;

   @Rule
   public TestRule watcher = new TestWatcher() {
      protected void starting(Description description) {
         System.out.printf("\b\bStarting: %-60s", description.getMethodName());
      }
   };
   @Rule
   public Stopwatch sw = new Stopwatch() {
      String s;
      protected void finished(long nanos, Description description) {
         System.out.println(s);
      }
      protected void succeeded(long nanos, Description description) {
         s = " Passed" + " (" + runtime(TimeUnit.MILLISECONDS) + " ms)";
      }
      protected void failed(long nanos, Throwable e, Description description) {
         s = " FAILED" + " (" + runtime(TimeUnit.MILLISECONDS) + " ms)";
      }
   };

   @Test
   public void test03_insertContains() { // points = 5 
      BST<Integer> bst = new BST<Integer>();
      int[] values = new int[] {99, -4, 167, 139, 55, -89, 13, 78, 128, 119};

      for (int i = 0; i < values.length; i++) {
         bst.insert(values[i]);

         assertEquals(i + 1, bst.size());

         for (int j = 0; j <= i; j++) {
            assertTrue(bst.contains(values[j]));
            assertFalse(bst.contains(values[j] - 1));
            assertFalse(bst.contains(values[j] + 1));
         }
      }
   }
   
   @Test
   public void test04_minimum() { // points = 5 
      BST<Integer> bst = new BST<Integer>();
      int[] values = new int[] {99, -4, 167, 139, 55, -89, 13, 78, 178, 174};
      
      for (int i = 0; i < values.length; i++) {
         bst.insert(values[i]);
      }
      assertEquals((Integer)(-89), bst.minimum());
      assertEquals((Integer)178, bst.maximum());
   }

   @Test
   public void test06_toSortedList() { // points = 5 
      BST<Integer> bst = new BST<Integer>();
      int[] values = new int[] {99, -4, 167, 139, 55, -89, 13, 78, 178, 174};
      
      for (int i = 0; i < values.length; i++) {
         bst.insert(values[i]);
      }

      ArrayList<Integer> list = new ArrayList<Integer>();
      bst.toSortedList(list);

      int[] expected = new int[] {-89, -4, 13, 55, 78, 99, 139, 167, 174, 178};

      for (int i = 0; i < values.length; i++) {
         assertEquals((Integer)expected[i], list.get(i));
      }
   }
   
  
   /////////////////////////////////////////////////////////////////////////////
   // New tests for Lab 8
   /////////////////////////////////////////////////////////////////////////////
    
   @Test
   public void test18_removeListOfThreeCompleteTree() // points = 5
   {
      BST<Integer> bst = new BST<Integer>();

      // Root, root, root... 
      bst.insert(88);
      bst.insert(77);
      bst.insert(99);

      bst.remove(77);
      assertTrue(bst.size() == 2);
      assertFalse(bst.contains(77));
      assertTrue(bst.contains(88));
      assertTrue(bst.contains(99));
   }

   @Test
   public void test23_treeHeightRandomBig() // points = 2
   {
      BST<Integer> bst = makeTree(makeRandomArray(1000, -387));
      assertTrue(bst.treeHeight() == 20);
   }
   
   @Test
   public void test26_internalPathLengthVariousGreaterThanOneElement() // points = 2
   {
      BST<Integer> bst = new BST<Integer>();

      // one Left
      bst.insert(88);
      bst.insert(77);
      assertTrue(bst.internalPathLength() == 1);

      // two left
      bst.insert(55);
      assertTrue(bst.internalPathLength() == 3);
   }

   private int[] makeRandomArray(int size, int seed)
   {
      int[] array = new int[size];
      Random rand = new Random(seed);

      for (int i = 0; i < size; i++)
      {
         array[i] = rand.nextInt();
      }

      return array;
   }

   private BST<Integer> makeTree(int[] array)
   {
      BST<Integer> bst = new BST<Integer>();

      for (int i = 0; i < array.length; i++)
      {
         bst.insert(array[i]);
      }

      return bst;
   }
} 
